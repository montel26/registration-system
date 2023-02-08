//complete
package practice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SpringLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtMobileNum;
	private JTextField txtEmail;
	private JTextField txtUserName;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField txtPassword;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("NAME:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, contentPane);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ADDRESS:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 19, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("GENDER:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 30, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("EMAIL:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("USERNAME:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 28, SpringLayout.SOUTH, lblNewLabel_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("AGE:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 32, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNewLabel);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("MOBILE NO:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 25, SpringLayout.SOUTH, lblNewLabel_6);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 32, SpringLayout.SOUTH, lblNewLabel_5);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_6, 0, SpringLayout.WEST, lblNewLabel);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("PASSWORD:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 21, SpringLayout.SOUTH, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_7, 0, SpringLayout.WEST, lblNewLabel);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_7);
		
		JTextArea addressTxt = new JTextArea();
		sl_contentPane.putConstraint(SpringLayout.NORTH, addressTxt, 46, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, addressTxt, 6, SpringLayout.EAST, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, addressTxt, 87, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, addressTxt, 184, SpringLayout.EAST, lblNewLabel_1);
		contentPane.add(addressTxt);
		
		txtName = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtName, 0, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtName, 6, SpringLayout.EAST, lblNewLabel);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JRadioButton maleBtn = new JRadioButton("MALE:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, maleBtn, 0, SpringLayout.NORTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, maleBtn, 6, SpringLayout.EAST, lblNewLabel_2);
		contentPane.add(maleBtn);
		
		JRadioButton femaleBtn = new JRadioButton("FEMALE:");
		buttonGroup.add(femaleBtn);
		sl_contentPane.putConstraint(SpringLayout.WEST, femaleBtn, 15, SpringLayout.EAST, maleBtn);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, femaleBtn, 0, SpringLayout.SOUTH, maleBtn);
		contentPane.add(femaleBtn);
		
		txtAge = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, txtAge, 6, SpringLayout.EAST, lblNewLabel_5);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtAge, 0, SpringLayout.SOUTH, lblNewLabel_5);
		contentPane.add(txtAge);
		txtAge.setColumns(10);
		
		txtMobileNum = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtMobileNum, 0, SpringLayout.NORTH, lblNewLabel_6);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtMobileNum, 6, SpringLayout.EAST, lblNewLabel_6);
		contentPane.add(txtMobileNum);
		txtMobileNum.setColumns(10);
		
		txtEmail = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtEmail, 0, SpringLayout.NORTH, lblNewLabel_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtEmail, 13, SpringLayout.EAST, lblNewLabel_3);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtUserName = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, txtUserName, 6, SpringLayout.EAST, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtUserName, 0, SpringLayout.SOUTH, lblNewLabel_4);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtPassword, 21, SpringLayout.SOUTH, txtUserName);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtPassword, 6, SpringLayout.EAST, lblNewLabel_7);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtPassword, 41, SpringLayout.SOUTH, txtUserName);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtPassword, 127, SpringLayout.EAST, lblNewLabel_7);
		contentPane.add(txtPassword);
		
		JButton validate = new JButton("VALIDATE");
		validate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//load driver
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					//establish connection
					//pass protocol name
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "Doubleyouohohdee26");
					//? = placeholder for number of columns in table registration
					String query = "insert into registration values(?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, txtName.getText());
					ps.setString(2, addressTxt.getText());
					//male button //female button
					if(maleBtn.isSelected()) {
						ps.setString(3, maleBtn.getText());
					}else{
						ps.setString(3, femaleBtn.getText());
					}
					ps.setInt(4, Integer.parseInt(txtAge.getText()));
					ps.setInt(5,  Integer.parseInt(txtMobileNum.getText()));
					ps.setString(6, txtEmail.getText());
					ps.setString(7, txtUserName.getText());
					ps.setString(8, txtPassword.getText());
					
					int i = ps.executeUpdate(); //number of querys have been affected get stored in i variable.
					JOptionPane.showMessageDialog(validate, i +  " Record added successfully!");
					
					//close connection
					ps.close();
					con.close();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, validate, 21, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, validate, 0, SpringLayout.SOUTH, contentPane);
		contentPane.add(validate);
		
		JButton reset = new JButton("RESET");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");//going to clear text field
				addressTxt.setText("");
				txtAge.setText("");
				txtMobileNum.setText("");
				txtEmail.setText("");
				txtUserName.setText("");
				txtPassword.setText("");
				buttonGroup.clearSelection();
				
				
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, reset, 0, SpringLayout.NORTH, validate);
		sl_contentPane.putConstraint(SpringLayout.EAST, reset, -55, SpringLayout.EAST, contentPane);
		contentPane.add(reset);
		
			
	}
}
