package Exercises;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Exercise051 {
	

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		PreparedStatement prepareStatement = null;
		Scanner input = new Scanner(System.in);
		
		Exercise052 ex = new Exercise052();
		
		System.out.println("Enter first name: ");
		ex.setName(input.next());
		System.out.println("Enter last name: ");
		ex.setLastName(input.next());
		System.out.println("Enter phone number: ");
		ex.setPhone(input.nextInt());
		System.out.println("Enter email address: ");
		ex.setEmail(input.next());
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/my_first_database?user=root&password=");
			prepareStatement = conn.prepareStatement("INSERT INTO customers VALUES(default, ?, ?, ?, ?)");
			prepareStatement.setString(1, ex.getName());
			prepareStatement.setString(2, ex.getLastName());
			prepareStatement.setInt(3, ex.getPhone());
			prepareStatement.setString(4, ex.getEmail());
			
			prepareStatement.executeUpdate();

		
		} catch (SQLException e) {
			System.err.println(e);
		}
		finally {
			if (conn != null){
				conn.close();
			}
			
		}
		
		System.out.println("The following have been added to the database: " + ex.getName() + " " + ex.getLastName() + ", " + ex.getPhone() + ", " + ex.getEmail() + ".");
		
	}

}
