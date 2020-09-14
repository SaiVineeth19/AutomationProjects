package jdbcSeleniumIntegration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JdbcConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\User\\Documents\\SOFTWARE\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		String host = "localhost";
		String port = "3306";
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/qaDbTest", "root", "root");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from qadbtest.EmployeeInfo where id = 1");
		while (rs.next()) {

			driver.get("https://login.salesforce.com/");

			driver.findElement(By.id("username")).sendKeys(rs.getString("name"));
			driver.findElement(By.id("password")).sendKeys(rs.getString("location"));
		}

	}

}
