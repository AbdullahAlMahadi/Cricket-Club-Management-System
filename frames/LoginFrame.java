package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import entity.*;
import repository.*;

public class LoginFrame extends JFrame implements ActionListener, MouseListener
{
	JLabel title, userLabel, passLabel;
	JTextField userTF;
	JPasswordField passPF;
	JButton loginBtn, exitBtn, regBtn, showPassBtn;
	Color color ;
	JPanel panel;
	
	public LoginFrame()
	{
		super("Club Management - Login Window");
		
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		color = new Color(240,255,255);
		panel.setBackground(color);
		
		Font myFont = new Font("Cambria", Font.ITALIC | Font.BOLD, 30);
		Font mytext = new Font("Cambria", Font.ITALIC | Font.BOLD, 15);
		
		title = new JLabel("Cricket Club Management System");
		title.setBounds(160, 5, 700, 100);
		title.setFont(myFont);
		panel.add(title);
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(300, 100, 60, 30);
		userLabel.setFont(mytext);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(380, 100, 100, 30);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(300, 150, 100, 30);
		passLabel.setFont(mytext);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(380, 150, 100, 30);
		passPF.setEchoChar('*');
		panel.add(passPF);
		
		
		
		showPassBtn = new JButton("<>");
		showPassBtn.setBounds(485,155,60,20);
		color = new Color(204,241,250);
		showPassBtn.setBackground(color);
		showPassBtn.addMouseListener(this);
		panel.add(showPassBtn);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(300, 200, 80, 30);
		color = new Color(115,220,44);
		loginBtn.setBackground(color);
		loginBtn.addActionListener(this);
		loginBtn.addMouseListener(this);
		panel.add(loginBtn);
		
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(400, 200, 80, 30);
		color = new Color(255,102,102);
		exitBtn.setBackground(color);
		exitBtn.addActionListener(this);
		exitBtn.addMouseListener(this);
		panel.add(exitBtn);
		
		regBtn = new JButton("Registration");
		regBtn.setBounds(300, 250, 180, 30);
		color = new Color(255,204,153);
		regBtn.setBackground(color);
		regBtn.addActionListener(this);
		regBtn.addMouseListener(this);
		panel.add(regBtn);
		
		
		this.add(panel);
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loginBtn.getText()))
		{
			UserRepo ur = new UserRepo();
			User user = ur.getUser(userTF.getText(), passPF.getText());
			
			if(user != null)
			{
				if(user.getStatus() == 0 )
				{
					ManagerHome mh = new ManagerHome(user);
					mh.setVisible(true);
					this.setVisible(false);
				}
				else if(user.getStatus() == 1)
				{
					CoachHome ch = new CoachHome(user);
					ch.setVisible(true);
					this.setVisible(false);
				}
				else if(user.getStatus() == 2)
				{
					PlayerHome ph = new PlayerHome(user);
					ph.setVisible(true);
					this.setVisible(false);
				}
				else{}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Invaild Id or Password");
			}
			
		}
		else if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		
		else if(command.equals(regBtn.getText()))
		{
			RegistrationFrame rf = new RegistrationFrame();
			rf.setVisible(true);
			this.setVisible(false);
		}
		else{}
		
	}
	

	
	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
	{
		
		if(me.getSource() == loginBtn)
		{
			loginBtn.setBackground(color = new Color(95,134,243));
			loginBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== exitBtn)
		{
			exitBtn.setBackground(Color.RED);
			exitBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== regBtn)
		{
			regBtn.setBackground(color = new Color(255,153,51));
			regBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== showPassBtn)
		{
			showPassBtn.setBackground(color = new Color(160,160,160));
			showPassBtn.setForeground(Color.BLACK);
		}
		
		
		else{}
		
	}
	public void mouseExited(MouseEvent me)
	{
		
		if(me.getSource() == loginBtn)
		{
			loginBtn.setBackground(color = new Color(115,220,44));
			loginBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== exitBtn)
		{
			exitBtn.setBackground(color = new Color(255,102,102));
			exitBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== regBtn)
		{
			regBtn.setBackground(color = new Color(255,204,153));
			regBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()== showPassBtn)
		{
			showPassBtn.setBackground(color = new Color(204,241,250));
			showPassBtn.setForeground(Color.BLACK);
		}
		
		else{}
		
	}
	
	public void mousePressed(MouseEvent me)
	{
		passPF.setEchoChar((char)0);
	}
	public void mouseReleased(MouseEvent me)
	{
		passPF.setEchoChar('*');
	}
	
}