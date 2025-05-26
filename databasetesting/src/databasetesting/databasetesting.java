package databasetesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class databasetesting {
	
	
	String Thewebsite = "https://smartbuy-me.com/account/register";
	
	WebDriver driver = new ChromeDriver();
	
	Connection con;
	Statement stmt;
	ResultSet res;
	int customerIndatabase;
	 String customeFrirstName;
	 String CustomerLastName;
	 String email;
	 String password;
	
	
	@BeforeTest
	public void mysreup() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","1234");
		driver.get(Thewebsite);
		driver.manage().window().maximize();
	}
	@Test (priority = 1 ,enabled = false)
	public void AddNewCustomer() throws SQLException{
		String query = "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, city, country, salesRepEmployeeNumber, creditLimit) VALUES (001, 'ABCCompany', 'Ali', 'Ahmad', '89641238', '123 Main St', 'Los Angeles', 'USA', 1370, 50000.00)";
		
		stmt = con.createStatement();
		int RowInserted = stmt.executeUpdate(query);
		System.out.println(RowInserted);
		
	}
	
	@Test(priority = 2,enabled = false)
	public void UpdateCustomer() throws SQLException{
		String query = "UPDATE customers SET contactLastName = 'Asad' WHERE customerNumber = 999";

		
		stmt = con.createStatement();
		int RowInserted = stmt.executeUpdate(query);
		System.out.println(RowInserted);
	}
	@Test(priority = 3, enabled = false)
	public void ReadCustomer() throws SQLException{
		
		String query = "Select * from customers WHERE customerNumber = 999";
		stmt = con.createStatement();
		res = stmt.executeQuery(query);
		
		while(res.next()) {
			
			 customerIndatabase = res.getInt("customerNumber");
			 customeFrirstName = res.getString("contactFirstName");
			 CustomerLastName = res.getString("contactLastName");
			 email = customeFrirstName+CustomerLastName+"@gmail.com";
			 password = "123@Passw0rd";
		}
		driver.findElement(By.id("customer[first_name]")).sendKeys(customeFrirstName);
		driver.findElement(By.id("customer[last_name]")).sendKeys(CustomerLastName);
		driver.findElement(By.id("customer[email]")).sendKeys(email);
		driver.findElement(By.id("customer[password]")).sendKeys(password);

	}
	
	@Test (priority = 4, enabled = true)
	public void DeleteQuery() throws SQLException {
		String query = "Delete from customesr WHERE customerNumber = 999";
		stmt = con.createStatement();
		res = stmt.executeQuery(query);
		System.out.println(res);
	}

}
