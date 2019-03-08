import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MyFrame extends JFrame implements ActionListener {

	private JButton b1 = new JButton("Guest Login"); 
	private JButton b2 = new JButton("Admin Login");
	private JTextField t1 = new JTextField("");
	private JTextField t2 = new JPasswordField("");
	private JLabel l1 = new JLabel("Movie Booking Application");
	private Panel p2 = new Panel();
	private int index = 0;
	LinkedList list=new LinkedList();
	
	public MyFrame(LinkedList list2) {
		this.list=list2;
		
		Container content = getContentPane();
		Font f=new Font("TimesRoman", Font.BOLD,20);
		getContentPane().setLayout(null);
		l1.setBounds(7, 5, 227, 27);
		l1.setFont(f);  
		content.add(l1);
		b2.setBounds(7, 191, 227, 31);
		getContentPane().add(b2);
		b1.setBounds(7, 35, 227, 31);
		getContentPane().add(b1);
		t2.setBounds(106, 147, 128, 31);
		getContentPane().add(t2);
		t1.setBounds(106, 98, 128, 31);
		getContentPane().add(t1);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(12, 105, 82, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(12, 154, 56, 16);
		getContentPane().add(lblNewLabel_1);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setSize(260,300);    
		setVisible(true);
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object target = e.getSource();
		if(target==b1) {
			GuestPage gp= new GuestPage(list);
			gp.setVisible(true);
			this.dispose();
		}
		if(target==b2) {
			String v1 = t1.getText();
			String v2 = t2.getText();
			if(v1.equals("admin") && v2.equals("admin")) {
				AdminPage page = new AdminPage(list);
				page.setVisible(true);
				JLabel la = new JLabel("Welcome : " + v1);
				page.getContentPane().add(la);
				this.dispose();
			}
			else {
				JOptionPane.showMessageDialog(this, "Invalid Credential","Error", JOptionPane.ERROR_MESSAGE);
				
			}
			
		}
	}
}
