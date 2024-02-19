package kwizeraaa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


	public class employeeForm implements ActionListener{
		
		JFrame frame;//employee_id,firs_name,last _name,date_of_birth;
		JLabel employee_id_lb=new JLabel("Employee_id");
		JLabel first_name_lb=new JLabel("First|_name");
		JLabel last_name_lb=new JLabel("Last_name");
		JLabel date_of_birth_lb=new JLabel("Date_of_birth");
		
		JTextField employee_id_txf=new JTextField();
		JTextField first_name_txf=new JTextField();
		JTextField last_name_txf=new JTextField();
		JTextField date_of_birth_txf=new JTextField();
		
		JButton insert_btn=new JButton("INSERT");
		JButton read_btn=new JButton("VIEW");
		JButton update_btn=new JButton("UPDATE");
		JButton delete_btn=new JButton("DELETE");
		
		DefaultTableModel model = new DefaultTableModel();
	    JTable table = new JTable(model);

		
		Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
		int w=(int)screensize.getWidth();
		int h=(int)screensize.getHeight();
		public employeeForm(){
			createForm();
		    }
		private void ActionEvent() {
			insert_btn.addActionListener((ActionListener) this);
			read_btn.addActionListener((ActionListener) this);
			update_btn.addActionListener((ActionListener) this);
			delete_btn.addActionListener((ActionListener) this);
		}
		
		private void createForm() {
			frame=new JFrame();
			frame.setTitle("EMPLOYEES FORM");
			frame.setBounds(0, 0 , w / 2, h / 2);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setBackground(Color.red);
			frame.getContentPane().setLayout(null);
			frame.setResizable(true);
			frame.setVisible(true);
			
			setLocationandSize();
			}
		
		private void setLocationandSize() {
		    employee_id_lb.setBounds(10,10,130,30);
			first_name_lb.setBounds(10,50,150,30);
			last_name_lb.setBounds(10,90,200,30);
			date_of_birth_lb.setBounds(10,130,150,30);
			
			employee_id_txf.setBounds(250,10,190,30);
			first_name_txf.setBounds(250,50,190,30);
			last_name_txf.setBounds(250,90,190,30);
			date_of_birth_txf.setBounds(250,130,190,30);
			
			insert_btn.setBounds(10,220,85,30);
			read_btn.setBounds(100,220,85,30);
			update_btn.setBounds(190,220,85,30);
			delete_btn.setBounds(280,220,85,30);
			table.setBounds(500, 10, 600, 240);
			
			setFontforall();
			addcomponentforFrame();

			}
		
		private void setFontforall() {
			Font font=new Font("Georgia",Font.BOLD,18);
			employee_id_lb.setFont(font);
			first_name_lb.setFont(font);
			last_name_lb.setFont(font);
			date_of_birth_lb.setFont(font);
			
			
			employee_id_txf.setFont(font);
			first_name_txf.setFont(font);
			last_name_txf.setFont(font);
			date_of_birth_txf.setFont(font);
			
			Font fonti=new Font("Courier New",Font.ITALIC,10);
			insert_btn.setFont(fonti);
			read_btn.setFont(fonti);
			update_btn.setFont(fonti);
			delete_btn.setFont(fonti);
			}
		
		private void addcomponentforFrame() {
			frame.add(employee_id_lb);
			frame.add(first_name_lb);
			frame.add(last_name_lb);
			frame.add(date_of_birth_lb);
			
			frame.add(employee_id_txf);
			frame.add(first_name_txf);
			frame.add(last_name_txf);
			frame.add(date_of_birth_txf);
			
			frame.add(insert_btn);
			frame.add(read_btn);
			frame.add(update_btn);
			frame.add(delete_btn);
	        frame.add(table);
			ActionEvent ();
		}
		@Override
		      public void actionPerformed(ActionEvent e) {
			employee ml=new employee();
			if(e.getSource()==insert_btn) {
				
				ml.setFirst_name(first_name_txf.getText());
				ml.setLast_name(last_name_txf.getText());
				ml.setDate_of_birth(date_of_birth_txf.getText());
				ml.insertData();
				
			}
			
			else if (e.getSource() == read_btn) {
	            model.setColumnCount(0);
	            model.setRowCount(1);
	            model.addColumn("employee_id");
	            model.addColumn("first_name");
	            model.addColumn("last_name");
	            model.addColumn("date_of_birth");
	           
	            ResultSet resultSet =employee.viewData();
	            if (resultSet != null) {
	                try {
	                    while (resultSet.next()) {
	                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
	                                resultSet.getString(3), resultSet.getString(4)});
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                
	            }
	        } 
			}
	    else if (e.getSource()==update_btn) {
				int id=Integer.parseInt(employee_id_txf.getText());
				ml.setFirst_name(first_name_txf.getText());
				ml.setLast_name(first_name_txf.getText());
				ml.setDate_of_birth(date_of_birth_txf.getText());
				ml.update(id);
		    }
		  else {
				int id=Integer.parseInt(employee_id_txf.getText());
				ml.delete(id);
		  }
	            
			}	
		public static void main(String[] args) {
			employeeForm emplyeesform= new employeeForm();
			System.out.println(emplyeesform);

		}
		
		}






