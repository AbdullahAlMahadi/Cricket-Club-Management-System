package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class CoachFrame extends JFrame implements ActionListener
{
	private JLabel CoachId, CoachName, CoachEmail, CoachSalary,CoachPhone;
	private JTextField CoachIdTF, CoachNameTF, CoachEmailTF, CoachSalaryTF,CoachPhoneTF;
	JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, logoutBtn, backBtn;
	private JPanel panel;
	private JTable CoachTable;
	private JScrollPane CoachTableSP;
	private Color color ;
	private User user;
	private CoachRepo cr;
	private UserRepo ur;
	
	
	public CoachFrame(User user)
	{
		super("CoachFrame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		cr= new CoachRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		color = new Color(255,248,220);
		panel.setBackground(color);
		
		String data[][] = {{"", "", "", "",""}};
		
		String head[] = {"Id", "Name", "Email","Salary","Phone"};
		
		CoachTable = new JTable(data,head);
		CoachTableSP = new JScrollPane(CoachTable);
		CoachTableSP.setBounds(10, 10, 780, 150);
		CoachTable.setEnabled(false);
		panel.add(CoachTableSP);
		
		CoachId = new JLabel("ID :");
		CoachId.setBounds(10,200,100,30);
		panel.add(CoachId);
		
		CoachIdTF = new JTextField();
		CoachIdTF.setBounds(70,200,100,30);
		panel.add(CoachIdTF);
		
		CoachName = new JLabel("Name :");
		CoachName.setBounds(10,250,100,30);
		panel.add(CoachName);
		
		CoachNameTF = new JTextField();
		CoachNameTF.setBounds(70,250,100,30);
		panel.add(CoachNameTF);
		
		
		
		CoachSalary = new JLabel("Salary: ");
		CoachSalary.setBounds(10,300,100,30);
		panel.add(CoachSalary);
		
		CoachSalaryTF = new JTextField();
		CoachSalaryTF.setBounds(70,300,100,30);
		panel.add(CoachSalaryTF);
		
		CoachEmail = new JLabel("Email: ");
		CoachEmail.setBounds(10,350,100,30);
		panel.add(CoachEmail);
		
		CoachEmailTF = new JTextField();
		CoachEmailTF.setBounds(70,350,100,30);
		panel.add(CoachEmailTF);
		
		
		CoachPhone = new JLabel("Phone: ");
		CoachPhone.setBounds(200,200,100,30);
		panel.add(CoachPhone);
		
		CoachPhoneTF = new JTextField();
		CoachPhoneTF.setBounds(260,200,100,30);
		panel.add(CoachPhoneTF);
		
		
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(440,200,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(540,200,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(540,250,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(440,250,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(490,300,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(700,170,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		logoutBtn = new JButton("Log Out");
		logoutBtn.setBounds(700, 370, 80, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(580, 370, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			if(!CoachIdTF.getText().equals("") || !CoachIdTF.getText().equals(null))
			{
				Coach c = cr.searchCoach(CoachIdTF.getText());
				if(c!= null)
				{
					CoachNameTF.setText(c.getCoachName());
					CoachEmailTF.setText(c.getEmail());
					CoachPhoneTF.setText(c.getPhone()+"");
					CoachSalaryTF.setText(c.getSalary()+"");
					
					
					CoachIdTF.setEnabled(false);
					CoachNameTF.setEnabled(true);
					CoachEmailTF.setEnabled(true);
					CoachSalaryTF.setEnabled(true);
					CoachPhoneTF.setEnabled(true);
					
				
					if(this.user.getStatus()==0)
					{
						updateBtn.setEnabled(true);
						deleteBtn.setEnabled(true);
						refreshBtn.setEnabled(true);
						insertBtn.setEnabled(false);
						loadBtn.setEnabled(false);
					}
					else
					{
						updateBtn.setEnabled(false);
						deleteBtn.setEnabled(false);
						refreshBtn.setEnabled(true);
						insertBtn.setEnabled(false);
						loadBtn.setEnabled(false);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			Coach c = new Coach();
			User u = new User();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			c.setCoachId(CoachIdTF.getText());
			c.setCoachName(CoachNameTF.getText());
			c.setEmail(CoachEmailTF.getText());
			c.setPhone(Integer.parseInt(CoachPhoneTF.getText()));
			c.setSalary(Double.parseDouble(CoachSalaryTF.getText()));
			
			
			u.setUserId(CoachIdTF.getText());
			u.setPassword(x+"");
			u.setStatus(1);

			
			cr.insertInDB(c);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+CoachIdTF.getText()+"and Password: "+x);
			
			CoachIdTF.setText("");
			CoachNameTF.setText("");
			CoachEmailTF.setText("");
			CoachPhoneTF.setText("");
			CoachSalaryTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			
			CoachIdTF.setText("");
			CoachNameTF.setText("");
			CoachEmailTF.setText("");
			CoachPhoneTF.setText("");
			CoachSalaryTF.setText("");
			CoachIdTF.setEnabled(true);
			
			if(this.user.getStatus()==0||this.user.getStatus()==1)
			{
				loadBtn.setEnabled(true);
				insertBtn.setEnabled(true);
				updateBtn.setEnabled(false);
				deleteBtn.setEnabled(false);
				refreshBtn.setEnabled(false);

			}
			else
			{
				updateBtn.setEnabled(false);
				deleteBtn.setEnabled(false);
				refreshBtn.setEnabled(true);
				insertBtn.setEnabled(false);
				loadBtn.setEnabled(true);
			}
			
			
		}
		else if(command.equals(updateBtn.getText()))
		{
			Coach c = new Coach();
			
			c.setCoachId(CoachIdTF.getText());
			c.setCoachName(CoachNameTF.getText());
			c.setEmail(CoachEmailTF.getText());
			c.setPhone(Integer.parseInt(CoachPhoneTF.getText()));
			c.setSalary(Double.parseDouble(CoachSalaryTF.getText()));
			
			cr.updateInDB(c);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			CoachIdTF.setText("");
			CoachNameTF.setText("");
			CoachEmailTF.setText("");
			CoachPhoneTF.setText("");
			CoachSalaryTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			CoachIdTF.setEnabled(true);
			CoachNameTF.setEnabled(true);
			CoachEmailTF.setEnabled(true);
			CoachPhoneTF.setEnabled(true);
			CoachSalaryTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			cr.deleteFromDB(CoachIdTF.getText());
			ur.deleteUser(CoachIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			CoachIdTF.setText("");
			CoachNameTF.setText("");
			CoachEmailTF.setText("");
			CoachPhoneTF.setText("");
			CoachSalaryTF.setText("");
			
			CoachIdTF.setEnabled(true);
			CoachNameTF.setEnabled(true);
			CoachEmailTF.setEnabled(true);
			CoachPhoneTF.setEnabled(true);
			CoachSalaryTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = cr.getAllCoach();
			String head[] = {"Id", "Name", "Email","Phone", "Salary"};
			
			panel.remove(CoachTableSP);
			
			CoachTable = new JTable(data,head);
			CoachTable.setEnabled(false);
			CoachTableSP = new JScrollPane(CoachTable);
			CoachTableSP.setBounds(10, 10, 780, 150);
			panel.add(CoachTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		else if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		
		else if(command.equals(backBtn.getText()))
		{
			if(user.getStatus()==0)
			{
				ManagerHome mh = new ManagerHome(user);
				mh.setVisible(true);
				this.setVisible(false);
			}
			else if(user.getStatus()==1)
			{
				CoachHome ch = new CoachHome(user);
				ch.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				PlayerHome ph = new PlayerHome(user);
				ph.setVisible(true);
				this.setVisible(false);
			}
		}
		
		
		else{}
		
	}
	
}