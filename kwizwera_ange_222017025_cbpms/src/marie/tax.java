package marie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class tax {
	private int tax_id;
	private String tax_name;
	private String tax_rate;
	private String tax_category;
	public tax() {
	    // Default constructor
	}
	public tax(int tax_id,String  tax_name,String tax_rate,String tax_category) {
		super();
		this. tax_id= tax_id;
		this. tax_name=tax_name;
		this. tax_rate= tax_rate;
		this.tax_category=tax_category;
	}
	
			public int getTax_id() {
		return tax_id;
	}
	public void setTax_id(int tax_id) {
		this.tax_id = tax_id;
	}
	public String getTax_name() {
		return tax_name;
	}
	public void setTax_name(String tax_name) {
		this.tax_name = tax_name;
	}
	public String getTax_rate() {
		return tax_rate;
	}
	public void setTax_rate(String tax_rate) {
		this.tax_rate = tax_rate;
	}
	public String getTax_category() {
		return tax_category;
	}
	public void setTax_category(String tax_category) {
		this.tax_category = tax_category;
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/kwizera _ ange_cloudbasedpayrollmanagementsystem";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO tax ( tax_name, tax_rate, tax_category) VALUES (?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.tax_name);
	       preparedStatement.setString(2, this. tax_rate);
	       preparedStatement.setString(3, this.tax_category);
	       
	        
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
        String user = "root";
        String password = "";

        String sql = "SELECT * FROM tax";

        try {
            Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
public void update(int inputtax_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/kwizera _ ange_cloudbasedpayrollmanagementsystem";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE tax SET tax_name= ?,tax_rate= ?,tax_category = ?  WHERE tax_id= ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  stm.setString(1, this.getTax_name());
	          stm.setString(2, this.getTax_name());
	          stm.setString(3, this.getTax_category()); // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(4, inputtax_id);
	       
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
	public void delete(int inputtax_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/kwizera _ ange_cloudbasedpayrollmanagementsystem";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "TAX FROM tax WHERE tax_Id = ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputtax_id); // Assuming there is a column named 'id' for the WHERE clause

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


