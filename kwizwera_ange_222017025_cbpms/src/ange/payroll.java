package ange;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class payroll {
	private int payroll_id;
	private String employee_id;
	private String pay_period_start_date;
	private String pay_period_end_date;
	public payroll() {
	    // Default constructor
	}
	public payroll(int payroll_id ,String employee_id,String pay_period_start_date,String  pay_period_end_date) {
		super();
		this. pay_period_end_date= pay_period_end_date;
		this. employee_id=employee_id;
		this. pay_period_start_date= pay_period_start_date;
		this. pay_period_end_date= pay_period_end_date;
	}
	public int getpayroll_id() {
		return payroll_id;
	}
	public void setpayroll_id(int payroll_id) {
		this.payroll_id = payroll_id;
	}
	public String getemployee_id() {
		return employee_id;
	}
	public void setemployee_id(String employee_id) {
		this.employee_id =employee_id;
	}
	public String getpay_period_start_date() {
		return pay_period_start_date;
	}
	public void setpay_period_start_date(String pay_period_start_date) {
		this.pay_period_start_date = pay_period_start_date;
	}
	public String getpay_period_end_date() {
		return  pay_period_end_date;
	}
	public void setpay_period_end_date(String pay_period_end_date ) {
		this. pay_period_end_date = pay_period_end_date;
	}
	public void makeconnection() {
	}

    	public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/kwizera _ ange_cloudbasedpayrollmanagementsystem";
	    String user = "222017025";
	    String password = "222017025";

	    // SQL query to insert data
	    String sql = "INSERT INTO Payroll (employee_id, pay_period_start_date, pay_period_end_date) VALUES (?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this. employee_id);
	       preparedStatement.setString(2, this. pay_period_start_date);
	       preparedStatement.setString(3, this. pay_period_end_date);
	       
	        
	        // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}
	 
	
    public static ResultSet viewData() {
        String host = "jdbc:mysql://localhost/kwizera _ ange_cloudbasedpayrollmanagementsystem";
        String user = "222017025";
        String password = "222017025";

        String sql = "SELECT * FROM payroll";

        try {
            Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
public void update(int inputpayroll_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/kwizera _ ange_cloudbasedpayrollmanagementsystem";
	    String user = "222017025";
	    String password = "222017025";

	    // SQL query to update data
	    String sql = "UPDATE payroll SET  employee_id= ?, pay_period_start_date= ?, pay_period_end_date = ? WHERE  payroll_id = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  stm.setString(1, this.getemployee_id());
	          stm.setString(2, this.getpay_period_start_date());
	          stm.setString(3, this.getpay_period_end_date()); // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(4, inputpayroll_id);
	       
	        // Execute the update
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputpayroll_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/kwizera _ ange_cloudbasedpayrollmanagementsystem";
	    String user = "222017025";
	    String password = "222017025";

	    // SQL query to delete data
	    String sql = "DELETE FROM Payroll WHERE  Payroll_Id = ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputpayroll_id); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
	
	

