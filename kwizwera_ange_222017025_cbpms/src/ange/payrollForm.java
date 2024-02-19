package ange;

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


public class payrollForm implements ActionListener{
	JFrame frame;//payroll_id,employee_id,pay_period_start_time,pay_period_end_time;
	JLabel payroll_id_lb=new JLabel("payroll_id");
	JLabel employee_id_lb=new JLabel("employee_id");
	JLabel pay_period_start_date_lb=new JLabel("pay_period_start_date");
	JLabel pay_period_end_date_lb=new JLabel("pay_period_end_date");
	
	JTextField payroll_id_txf=new JTextField();
	JTextField  employee_id_txf=new JTextField();
	JTextField pay_period_start_date_txf=new JTextField();
	JTextField pay_period_end_date_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public payrollForm(){
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
		frame.setTitle("PAYROLL FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.cyan);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		payroll_id_lb.setBounds(10,10,130,30);
		employee_id_lb.setBounds(10,50,150,30);
		pay_period_start_date_lb.setBounds(10,90,200,30);
		pay_period_end_date_lb.setBounds(10,130,150,30);
		
		payroll_id_txf.setBounds(250,10,190,30);
		employee_id_txf.setBounds(250,50,190,30);
		pay_period_start_date_txf.setBounds(250,90,190,30);
		pay_period_end_date_txf.setBounds(250,130,190,30);
		
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
		payroll_id_lb.setFont(font);
		employee_id_lb.setFont(font);
		pay_period_start_date_lb.setFont(font);
		pay_period_end_date_lb.setFont(font);
		
		payroll_id_txf.setFont(font);
		employee_id_txf.setFont(font);
		pay_period_start_date_txf.setFont(font);
		pay_period_end_date_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(payroll_id_lb);
		frame.add(employee_id_lb);
		frame.add(pay_period_start_date_lb);
		frame.add(pay_period_end_date_lb);
		
		frame.add(payroll_id_txf);
		frame.add(employee_id_txf);
		frame.add(pay_period_start_date_txf);
		frame.add(pay_period_end_date_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
        frame.add(table);
		ActionEvent ();
	}

	@Override
	public void actionPerformed (ActionEvent e) {
		payroll pl=new payroll();
		if(e.getSource()==insert_btn) {
			pl.setemployee_id(employee_id_txf.getText());
			pl.setpay_period_start_date(pay_period_start_date_txf.getText());
			pl.setpay_period_end_date(pay_period_end_date_txf.getText());
			pl.insertData();
		}
			
		
		  else  if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("payroll_id");
            model.addColumn("employee_id");
            model.addColumn("pay_period_start_date");
            model.addColumn("pay_period_end_date");
           
            ResultSet resultSet =payroll.viewData();
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
			int id=Integer.parseInt(payroll_id_txf.getText());
			pl.setemployee_id(employee_id_txf.getText());
			pl.setpay_period_start_date(pay_period_start_date_txf.getText());
			pl.setpay_period_end_date(pay_period_end_date_txf.getText());
			pl.update(id);
	    }
	  else {
			int id=Integer.parseInt(payroll_id_txf.getText());
			pl.delete(id);}}

	 
		
	public static void main(String[] args) {
		payrollForm PayrollForm= new payrollForm();
		System.out.println(PayrollForm);
	

	}

	
	}


