package com.learning.testng;


	import java.io.IOException;
	import java.time.Duration;

	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	public class ReadDataUsingExcel {
		public static WebDriver driver=null;
		
		
		@BeforeMethod
		public void launchBrowser()
		{
			try
			{
				driver= new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		
		@Test(dataProvider="excelData")
		public void searchTopic(String topic, String website) {
			driver.get("https://www.google.com");
			
			driver.findElement(By.name("q")).sendKeys(topic+website);
			
		}
		
		
		
		@DataProvider(name="excelData")
		public Object[][] readData() throws IOException
		{
			Object[][] data= null;
			XSSFWorkbook workbook=null;
			
			try
			{
				workbook = new XSSFWorkbook(System.getProperty("user.dir")+"\\excel\\testdata1.xlsx");
				XSSFSheet sheet= workbook.getSheet("topics");
				XSSFRow firstRow= sheet.getRow(0);

				//it will return no. of rows in excel
				int totalRows= sheet.getPhysicalNumberOfRows();
				
				//it will give us the no. of columns
				int totalColumns= firstRow.getPhysicalNumberOfCells();
				
				data= new Object[totalRows-1][totalColumns]; //data[4-1][2] --> data[3][2]
				
				for(int i=1; i<totalRows;i++)
				{
					for(int j=0;j<totalColumns;j++)
					{
						data[i-1][j]= sheet.getRow(i).getCell(j).getStringCellValue();
						
						/*
						 * data[0][0]= selenium
						 * data[0][1]=guvi
						 * 
						 * data[1][0]= java
						 * data[1][1]= javatpoint
						 * 
						 * data[2][0]= testng
						 * data[2][1]=guru99
						 */
						 
					}
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			finally
			{
				workbook.close();
			}
			return data;
		}

	}



