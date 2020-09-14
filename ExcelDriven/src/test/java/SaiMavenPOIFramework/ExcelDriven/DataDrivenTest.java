package SaiMavenPOIFramework.ExcelDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTest {

	public ArrayList<String> getData(String testSheetName, String testCaseName) throws IOException {
		FileInputStream fis = new FileInputStream("D://Book1.xslx");
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		int noOfSheets = workBook.getNumberOfSheets();
		ArrayList<String> a = new ArrayList<String>();
		for (int i = 0; i < noOfSheets; i++) {

			if (workBook.getSheetName(i).equalsIgnoreCase(testSheetName)) {
				XSSFSheet sheet = workBook.getSheetAt(i);

				// accessing rows after getting access of the sheet
				Iterator<Row> row = sheet.iterator();
				Row firstRow = row.next();
				Iterator<Cell> ce = firstRow.cellIterator();
				int k = 0;
				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("testcases")) {
						column = k;

					}
					k++;
				}
				System.out.println(column);

				while (row.hasNext()) {
					Row r = row.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							Cell c = cv.next();
							if (c.getCellTypeEnum() == CellType.STRING) {
								a.add(c.getStringCellValue());
							} else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					}
				}

			}
		}
		return a;
	}

}
