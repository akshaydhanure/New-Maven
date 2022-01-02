package UTILITY;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
public static String getDataFromExcel(int rowNum, int colNum) throws EncryptedDocumentException, IOException
{
	FileInputStream Myfile=new FileInputStream("D:\\Akshay-Software testing\\Folder.xlsx");
	Sheet sh = WorkbookFactory.create(Myfile).getSheet("Sheet5");
	String value = sh.getRow(rowNum).getCell(colNum).getStringCellValue();
	return value;
}

public static void CaptureScreen(WebDriver driver, int TCID) throws IOException 
{
	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File desti = new File("D:\\Akshay-Software testing\\Screenshots\\TestID"+TCID+".png");
	FileHandler.copy(source, desti);
}

}
