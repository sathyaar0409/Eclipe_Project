package com.actiTimeProject.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	/**
	 * 
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String getPropertyValue(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./data/Actitime.property");
		Properties p = new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
	}
	/**
	 * 
	 * @param Sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
		public String getExcelvalue(String Sheetname,int row, int cell) throws EncryptedDocumentException, IOException {
			FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
			Workbook wb= WorkbookFactory.create(fis);
			String value=wb.getSheet(Sheetname).getRow(row).getCell(cell).getStringCellValue();
			return value;
		}
		public void setExcelvalue(String value, String sheetname, int row, int cell) throws EncryptedDocumentException, IOException {
			FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
			Workbook wb= WorkbookFactory.create(fis);
			wb.getSheet(sheetname).getRow(row).getCell(cell).setCellValue(value);
			FileOutputStream fos=new FileOutputStream("./data/testscript.xlsx");
			wb.write(fos);
			wb.close();
		}

}
