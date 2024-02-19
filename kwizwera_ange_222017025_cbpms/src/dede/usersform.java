package dede;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class usersform implements ActionListener{
	
	JFrame frame;//user_id,username,password,user_type;
	JLabel user_id_lb=new JLabel("user_id");
	JLabel username_lb=new JLabel("username");
	JLabel password_lb=new JLabel("password");
	JLabel user_type_lb=new JLabel("user_type");
	
	JTextField user_id_txf=new JTextField();
	JTextField username_txf=new JTextField();
	JTextField  password_txf=new JTextField();
	JTextField  user_type_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public usersform(){
		createForm();
	    }
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
	}
	
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("USERS FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.cyan);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		user_id_lb.setBounds(10,10,130,30);
		username_lb.setBounds(10,50,150,30);
		password_lb.setBounds(10,90,200,30);
		user_type_lb.setBounds(10,130,150,30);
		
		user_id_txf.setBounds(250,10,190,30);
		username_txf.setBounds(250,50,190,30);
		password_txf.setBounds(250,90,190,30);
		user_type_txf.setBounds(250,130,190,30);
		
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
		user_id_lb.setFont(font);
		username_lb.setFont(font);
		password_lb.setFont(font);
		user_type_lb.setFont(font);
		
		user_id_txf.setFont(font);
		username_txf.setFont(font);
		password_txf.setFont(font);
		user_type_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(user_id_lb);
		frame.add(username_lb);
		frame.add(password_lb);
		frame.add(user_type_lb);
		
		frame.add(user_id_txf);
		frame.add(username_txf);
		frame.add(password_txf);
		frame.add(user_type_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
        frame.add(table);
		ActionEvent ();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		users sr=new users();
		if(e.getSource()==insert_btn) {
			sr.setusername(username_txf.getText());
			sr.setpassword(password_txf.getText());
			sr.setuser_type(user_type_txf.getText());
			sr.insertData();
			
		}
		
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("user_Id");
            model.addColumn("username");
            model.addColumn("password");
            model.addColumn("user_type");
           
            ResultSet resultSet =users.viewData();
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
			int id=Integer.parseInt(user_id_txf.getText());
			sr.setusername(username_txf.getText());
			sr.setpassword(password_txf.getText());
			sr.setuser_type(user_type_txf.getText());
			sr.update(id);
	    }
	  else {
			int id=Integer.parseInt(user_id_txf.getText());
			sr.delete(id);}

	  }	
		
	public static void main(String[] args) {
		usersform usersForm= new usersform();
		System.out.println(usersForm);

	}



}
