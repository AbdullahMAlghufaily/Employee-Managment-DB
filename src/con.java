
import java.sql.*;
import java.util.Scanner;
import java.io.*;
public class con {

	public static void displaybeforeandafter() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/IS230PROJECT" , "root" , "user1122");

		Statement stmt = con.createStatement();

	ResultSet result = null;
	result = stmt.executeQuery("SELECT * FROM EMPLOYEES");
	while(result.next()) {
		System.out.println("-----------------------------------");
		System.out.println("Employee name : " + result.getString("Name")+ "\t");
		System.out.println("Employee ID : " + result.getInt("EmployeeID")+ "\t");
		System.out.println("Employee salary : " + result.getInt("Salary")+ "\t");
		System.out.println("-----------------------------------");

	}
	}
	public static void main(String[] args) throws SQLException {
		
			Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/IS230PROJECT" , "root" , "user1122");
		
		System.out.println("Successful connection to the database ");
		System.out.println();
		System.out.println();


		Statement statement = con.createStatement();
		int operation;
		String ques;

do {
		Scanner input = new Scanner(System.in);
		System.out.println("Choose on option ");
		System.out.println("1) Insert a new employee ");
		System.out.println("2) Display all the employees ");
		System.out.println("3) Give yearly raises ");
		System.out.println("4) Exit ");
		operation = input.nextInt();
		if(operation == 4)
			break;
		if(operation == 1) {
			try {	
				do {
			System.out.println("Inserting a new employee");
			System.out.println("Employee name: ");
			Scanner empname = new Scanner(System.in);
			String name = empname.nextLine();
			System.out.println("EmployeeID: ");
			Scanner empid = new Scanner(System.in);
			int id = empid.nextInt();
			System.out.println("Salary:");
			Scanner sal = new Scanner(System.in);
			int salary = sal.nextInt();
			System.out.println("Sales:");
			Scanner sales = new Scanner(System.in);
			int saales = sales.nextInt();
			String sql = "INSERT INTO EMPLOYEES ( Name , EmployeeID , Salary , Sales) " + " VALUES ( '" + name + "' , " + id + " , " + salary + " , " + saales + " ) ";
			Statement smt = con.createStatement();
			smt.executeUpdate(sql);
		System.out.print("Insert another record (Y/N) ? : ");
		Scanner record = new Scanner(System.in);
		    ques = record.nextLine();
		
			}
			while(ques.equalsIgnoreCase("y"));	
			}
			catch(SQLException e) {
				e.printStackTrace();
			}

	}
		if(operation == 2) {
			ResultSet result = null;
			result = statement.executeQuery("SELECT * FROM EMPLOYEES");
			while(result.next()) {
				System.out.println("-----------------------------------");
				System.out.println("Employee name : " + result.getString("Name")+ "\t");
				System.out.println("Employee ID : " + result.getInt("EmployeeID")+ "\t");
				System.out.println("Employee salary : " + result.getInt("Salary")+ "\t");
				System.out.println("Employee sales " +result.getInt("Sales")+ "\t");
				System.out.println("-----------------------------------");

			}
			
		}
		if(operation == 3) {
			Scanner inp = new Scanner(System.in);
			System.out.println("Enter amount of sales goal");
			int amount = inp.nextInt();
			ResultSet result = null;
			result = statement.executeQuery("SELECT * FROM EMPLOYEES");
			int id;
			int salary;
			int sales;
			System.out.println();
			System.out.println();
			System.out.println("Before alteration"); 
			
			
			while(result.next()) {
				System.out.println("-----------------------------------");
				System.out.println("Employee name : " + result.getString("Name")+ "\t");
				System.out.println("Employee ID : " + result.getInt("EmployeeID")+ "\t");
				System.out.println("Employee salary : " + result.getInt("Salary")+ "\t");
				System.out.println("-----------------------------------");
				id = result.getInt("EmployeeID");
				salary = result.getInt("Salary");
				sales = result.getInt("Sales");
				double increase = 0;
				
			
			if(amount == sales || sales>amount)
				increase = salary + (salary*0.1);
			else if (sales < amount)
				increase = salary + (salary*0.05);
			statement.executeUpdate("UPDATE EMPLOYEES SET Salary = " + increase + "WHERE EmployeeID = " + id + ";"  );

		}
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("After alteration");
			System.out.println();
			System.out.println();
			System.out.println();
			displaybeforeandafter() ;
		
} 
}
while(operation != 4);
System.out.println("Thank you");

}
}



