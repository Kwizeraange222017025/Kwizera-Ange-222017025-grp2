package MENU;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import ange.payrollForm;
import dede.usersform;
import kwizeraaa.employeeForm;
import marie.taxform;
import rosine.timetrackingform;

public class menu extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu homeMenu;
    private JMenuItem employeeItem;
    private JMenuItem payrollItem;
    private JMenuItem taxItem;
    private JMenuItem timetrackingItem;
    private JMenuItem usersItem;
    private JMenuItem settingsItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
  

    public menu(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        homeMenu = new JMenu("Home");

        // Create menu items
        employeeItem = new JMenuItem("employee");
        employeeItem.addActionListener(this);
        payrollItem = new JMenuItem("payroll");
        payrollItem.addActionListener(this);
        taxItem = new JMenuItem("tax");
        taxItem.addActionListener(this);
        timetrackingItem = new JMenuItem("timetracking");
        timetrackingItem.addActionListener(this);
        usersItem = new JMenuItem("users");
        usersItem.addActionListener(this);
        settingsItem = new JMenuItem("Settings");
        settingsItem.addActionListener(this);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        homeMenu.add(employeeItem);
        homeMenu.add(payrollItem);
        homeMenu.add(taxItem);
        homeMenu.add(timetrackingItem);
        homeMenu.add(usersItem);
        homeMenu.addSeparator();
        homeMenu.add(settingsItem);
        homeMenu.addSeparator();
        homeMenu.add(logoutItem);

        // Add home menu to menu bar
        menuBar.add(homeMenu);

        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("Welcome " + loggedInUser + " to Dashboard");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == employeeItem) {
            JOptionPane.showMessageDialog(this, "Opening employee Form...");
            new employeeForm();
        } else if (e.getSource() == payrollItem) {
            JOptionPane.showMessageDialog(this, "Opening payroll Form...");
            new payrollForm();
        } else if (e.getSource() == taxItem) {
            JOptionPane.showMessageDialog(this, "Opening tax Form...");
            new taxform();
        } else if (e.getSource() == timetrackingItem) {
            JOptionPane.showMessageDialog(this, "Opening timetracking Form...");
            new timetrackingform();
        } else if (e.getSource() == usersItem) {
            JOptionPane.showMessageDialog(this, "Opening users Form...");
            new usersform();
        } else if (e.getSource() == settingsItem) {
            String newUsername = JOptionPane.showInputDialog(this, "Enter new username:");
            String newPassword = JOptionPane.showInputDialog(this, "Enter new password:");
            JOptionPane.showMessageDialog(this, "User registered successfully: " + newUsername);
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new menu("cloud based payroll management system"));
    }
}





