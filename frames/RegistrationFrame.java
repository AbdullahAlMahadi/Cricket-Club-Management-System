package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class RegistrationFrame extends JFrame implements ActionListener
{
	private JLabel idLabel,passLabel,statusLabel;
	private JTextField idTF,statusTF;
	private JPasswordField passPF;
	private JButton creatBtn,backBtn;
	private JPanel panel;
	private Color color;
	
	private UserRepo ur;
	private User user;
	
	public RegistrationFrame()
	{
		super("Registration");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		color = new Color(216,191,216);
		panel.setBackground(color);
		
		
		idLabel = new JLabel("ID :");
		idLabel.setBounds(250, 80,50 ,50);
		panel.add(idLabel);
		
		idTF = new JTextField();
		idTF.setBounds(330,90,100,30);
		panel.add(idTF);
		
		passLabel = new JLabel("Password :");
		passLabel.setBounds(250, 140,100 ,50);
		panel.add(passLabel);
	
		
		passPF = new JPasswordField();
		passPF.setBounds(330,150,100,30);
		passPF.setEchoChar('*');
		panel.add(passPF);

		statusLabel = new JLabel("Status :");
		statusLabel.setBounds(250, 190,100 ,50);
		panel.add(statusLabel);
		
		
		statusTF = new JTextField();
		statusTF.setBounds(330,200,100,30);
		panel.add(statusTF);
		
		creatBtn = new JButton("Submit");
		creatBtn.setBounds(250,270,80,30);
		creatBtn.setBackground(Color.GREEN);
		creatBtn.addActionListener(this);
		panel.add(creatBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(350,270,80,30);
		backBtn.setBackground(Color.RED);
		backBtn.setForeground(Color.WHITE);
		backBtn.addActionListener(this);
		panel.add(backBtn);
	
		this.add(panel);
	
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		if(command.equals(creatBtn.getText()))
		{
			this.user = new User(idTF.getText(),passPF.getText(),Integer.parseInt(statusTF.getText()));

			ur.insertUser(this.user);

			JOptionPane.showMessageDialog(this, "created, Id: "+idTF.getText()+" and Password: "+passPF.getText());

			idTF.setText("");
			passPF.setText("");
			statusTF.setText("");
		}
		else if(command.equals(backBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}

	
}
