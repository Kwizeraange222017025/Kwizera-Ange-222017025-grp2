package marie;


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

public class taxform implements ActionListener{
	JFrame frame;//tax_id,tax_name,tax_rate,tax_category;
	JLabel tax_id_lb=new JLabel("tax_id");
	JLabel tax_name_lb=new JLabel("tax_name");
	JLabel tax_rate_lb=new JLabel("tax_rate");
	JLabel tax_category_lb=new JLabel("tax_category");
	
	JTextField tax_id_txf=new JTextField();
	JTextField tax_name_txf=new JTextField();
	JTextField tax_rate_txf=new JTextField();
	JTextField tax_category_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public taxform(){
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
		frame.setTitle("TAX FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.cyan);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		tax_id_lb.setBounds(10,10,130,30);
		tax_name_lb.setBounds(10,50,150,30);
		tax_rate_lb.setBounds(10,90,200,30);
		tax_category_lb.setBounds(10,130,150,30);
		
		tax_id_txf.setBounds(250,10,190,30);
		tax_name_txf.setBounds(250,50,190,30);
		tax_rate_txf.setBounds(250,90,190,30);
		tax_category_txf.setBounds(250,130,190,30);
		
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
		tax_id_lb.setFont(font);
		tax_name_lb.setFont(font);
		tax_rate_lb.setFont(font);
		tax_category_lb.setFont(font);
		
		tax_id_txf.setFont(font);
		tax_name_txf.setFont(font);
		tax_rate_txf.setFont(font);
		tax_category_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(tax_id_lb);
		frame.add(tax_name_lb);
		frame.add(tax_rate_lb);
		frame.add(tax_category_lb);
		
		frame.add(tax_id_txf);
		frame.add(tax_name_txf);
		frame.add(tax_rate_txf);
		frame.add(tax_category_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
        frame.add(table);
		ActionEvent ();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		tax tx=new tax();
		if(e.getSource()==insert_btn) {
			tx.setTax_name(tax_name_txf.getText());
			tx.setTax_rate(tax_rate_txf.getText());
			tx.setTax_category(tax_category_txf.getText());
			tx.insertData();
			
		}
		
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("tax_id");
            model.addColumn("tax_name");
            model.addColumn("tax_rate");
            model.addColumn("tax_category");
           
            ResultSet resultSet =tax.viewData();
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
			int id=Integer.parseInt(tax_id_txf.getText());
			tx.setTax_name(tax_name_txf.getText());
			tx.setTax_rate(tax_rate_txf.getText());
			tx.setTax_category(tax_category_txf.getText());
			tx.update(id);
	    }
	  else {
			int id=Integer.parseInt(tax_id_txf.getText());
			tx.delete(id);}

	  }	
		
	public static void main(String[] args) {
		taxform taxForm= new taxform();
		System.out.println(taxForm);
		
		
	}
	


}
