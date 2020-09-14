package SaiMavenPOIFramework.ExcelDriven;

import java.io.IOException;
import java.util.ArrayList;

public class DataDrivenObjectTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		DataDrivenTest ddt = new DataDrivenTest();

		ArrayList<String> data = ddt.getData("testcases", "purchase");
		for (String cellData : data) {
			System.out.println(cellData);
		}
	}

}
