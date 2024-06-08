package demowebshop.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

/**
 * @author ANU
 */
public class ReadExcel {
	
	@Test
	public String getSingleData(String sheetName,int rowNum,int colNum)
	{
		
		FileInputStream fis = null;
		Workbook wb = null;
		
		try {
			
			fis=new FileInputStream("./src/test/resources/dws_Excel.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			wb= WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet=wb.getSheet(sheetName);
		//Row row=sheet.getRow(rowNum);
		//Cell cell=row.getCell(colNum);
		String data=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return data;
	}
	
	@Test
	public Object[][] getMultipleData(String sheetName)
	{
		
		FileInputStream fis = null;
		Workbook wb = null;
		
		try {
			
			fis=new FileInputStream("./src/test/resources/dws_Excel.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			wb= WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException |IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Sheet sheet=wb.getSheet(sheetName);
		int rowCount= sheet.getPhysicalNumberOfRows();
		int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] data=new Object[rowCount-1][cellCount];
		
		for (int i=1;i<rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
	
	public static void main(String[] args) {
		
		ReadExcel read=new ReadExcel();
		Object [][] data=read.getMultipleData("LoginTest");
		
		for (int i=0;i<data.length;i++)
		{
			for(int j=0;j<2;j++)
			{
				System.out.println(data[i][j]);
			}
		}
	}

}
