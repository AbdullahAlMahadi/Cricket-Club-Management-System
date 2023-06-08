package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class ManagerFrame extends JFrame implements ActionListener
{
	private JLabel ManagerId, ManagerName, ManagerEmail, ManagerSalary,ManagerPhone;
	private JTextField ManagerIdTF, ManagerNameTF, ManagerEmailTF, ManagerSalaryTF,ManagerPhoneTF;
	JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, logoutBtn,backBtn;
	private JPanel panel;
	private JTable ManagerTable;
	private JScrollPane ManagerTableSP;
	private Color color ;
	private User user;
	private ManagerRepo mr;
	private UserRepo ur;
	
	
	public ManagerFrame(User user)
	{
		super("Manager Frame");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		mr= new ManagerRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		color = new Color(255,248,220);
		panel.setBackground(color);
		
		String data[][] = {{"", "", "", "",""}};
		
		String head[] = {"Id", "Name", "Email","Salary","Phone"};
		
		ManagerTable = new JTable(data,head);
		ManagerTableSP = new JScrollPane(ManagerTable);
		ManagerTableSP.setBounds(10, 10, 780, 150);
		ManagerTable.setEnabled(false);
		panel.add(ManagerTableSP);
		
		ManagerId = new JLabel("ID :");
		ManagerId.setBounds(10,200,100,30);
		panel.add(ManagerId);
		
		ManagerIdTF = new JTextField();
		ManagerIdTF.setBounds(70,200,100,30);
		panel.add(ManagerIdTF);
		
		ManagerName = new JLabel("Name :");
		ManagerName.setBounds(10,250,100,30);
		panel.add(ManagerName);
		
		ManagerNameTF = new JTextField();
		ManagerNameTF.setBounds(70,250,100,30);
		panel.add(ManagerNameTF);
		
		
		
		ManagerSalary = new JLabel("Salary: ");
		ManagerSalary.setBounds(10,300,100,30);
		panel.add(ManagerSalary);
		
		ManagerSalaryTF = new JTextField();
		ManagerSalaryTF.setBounds(70,300,100,30);
		panel.add(ManagerSalaryTF);
		
		ManagerEmail = new JLabel("Email: ");
		ManagerEmail.setBounds(10,350,100,30);
		panel.add(ManagerEmail);
		
		ManagerEmailTF = new JTextField();
		ManagerEmailTF.setBounds(70,350,100,30);
		panel.add(ManagerEmailTF);
		
		
		ManagerPhone = new JLabel("Phone: ");
		ManagerPhone.setBounds(200,200,100,30);
		panel.add(ManagerPhone);
		
		ManagerPhoneTF = new JTextField();
		ManagerPhoneTF.setBounds(260,200,100,30);
		panel.add(ManagerPhoneTF);
		
		
		
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
			
			if(!ManagerIdTF.getText().equals("") || !ManagerIdTF.getText().equals(null))
			{
				Manager m = mr.searchManager(ManagerIdTF.getText());
				if(m!= null)
				{
					ManagerNameTF.setText(m.getManagerName());
					ManagerEmailTF.setText(m.getEmail());
					ManagerPhoneTF.setText(Integer.toString(m.getPhone()));
					ManagerSalaryTF.setText(m.getSalary()+"");
					
					
					ManagerIdTF.setEnabled(false);
					ManagerNameTF.setEnabled(true);
					ManagerEmailTF.setEnabled(true);
					ManagerSalaryTF.setEnabled(true);
					ManagerPhoneTF.setEnabled(true);
					
					
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
			Manager m = new Manager();
			User u = new User();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			m.setManagerId(ManagerIdTF.getText());
			m.setManagerName(ManagerNameTF.getText());
			m.setEmail(ManagerEmailTF.getText());
			m.setPhone(Integer.parseInt(ManagerPhoneTF.getText()));
			m.setSalary(Double.parseDouble(ManagerSalaryTF.getText()));
			
			
			u.setUserId(ManagerIdTF.getText());
			u.setPassword(x+"");
			u.setStatus(0);
			
			
			mr.insertInDB(m);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+ManagerIdTF.getText()+"and Password: "+x);
			
			ManagerIdTF.setText("");
			ManagerNameTF.setText("");
			ManagerEmailTF.setText("");
			ManagerPhoneTF.setText("");
			ManagerSalaryTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			ManagerIdTF.setText("");
			ManagerNameTF.setText("");
			ManagerEmailTF.setText("");
			ManagerPhoneTF.setText("");
			ManagerSalaryTF.setText("");
			ManagerIdTF.setEnabled(true);
			
			
			
			if(this.user.getStatus()==0)
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
			Manager m = new Manager();
			
			m.setManagerId(ManagerIdTF.getText());
			m.setManagerName(ManagerNameTF.getText());
			m.setEmail(ManagerEmailTF.getText());
			m.setPhone(Integer.parseInt(ManagerPhoneTF.getText()));
			m.setSalary(Double.parseDouble(ManagerSalaryTF.getText()));
			
			mr.updateInDB(m);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			ManagerIdTF.setText("");
			ManagerNameTF.setText("");
			ManagerEmailTF.setText("");
			ManagerPhoneTF.setText("");
			ManagerSalaryTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			ManagerIdTF.setEnabled(true);
			ManagerNameTF.setEnabled(true);
			ManagerEmailTF.setEnabled(true);
			ManagerPhoneTF.setEnabled(true);
			ManagerSalaryTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			mr.deleteFromDB(ManagerIdTF.getText());
			ur.deleteUser(ManagerIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			ManagerIdTF.setText("");
			ManagerNameTF.setText("");
			ManagerEmailTF.setText("");
			ManagerPhoneTF.setText("");
			ManagerSalaryTF.setText("");
			
			ManagerIdTF.setEnabled(true);
			ManagerNameTF.setEnabled(true);
			ManagerEmailTF.setEnabled(true);
			ManagerPhoneTF.setEnabled(true);
			ManagerSalaryTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = mr.getAllManager();
			String head[] = {"Id", "Name", "Email","Phone", "Salary"};
			
			panel.remove(ManagerTableSP);
			
			ManagerTable = new JTable(data,head);
			ManagerTable.setEnabled(false);
			ManagerTableSP = new JScrollPane(ManagerTable);
			ManagerTableSP.setBounds(10, 10, 780, 150);
			panel.add(ManagerTableSP);
			
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