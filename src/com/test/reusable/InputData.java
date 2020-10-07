package com.test.reusable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InputData {

	static String filePath="./testdata/testdata.xlsx";

	//*Read data from testdata.xlsx file
	public static String getValue(String sheet, String columnName, int rowNumber) throws EncryptedDocumentException, InvalidFormatException, IOException {

		String value = null;
		String result = null;
		try
		{

			DataFormatter formatter = new DataFormatter();
			Workbook wb = WorkbookFactory.create(new FileInputStream((new File(filePath))));

			int columnMax = wb.getSheet(sheet).getRow(0).getLastCellNum();

			for(int i = 0; i < columnMax; i++)
			{

				value = formatter.formatCellValue(wb.getSheet(sheet).getRow(0).getCell(i));
				if(columnName.equals(value))
				{
					result = formatter.formatCellValue(wb.getSheet(sheet).getRow(rowNumber).getCell(i));
					break;
				}
			}

		}

		catch(FileNotFoundException e)
		{

		}

		return result;
	}

}
