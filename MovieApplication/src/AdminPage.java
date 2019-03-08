import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends JFrame implements ActionListener{
	
	private JLabel l0 = new JLabel("Admin Section");
	private JLabel l1 = new JLabel("Movie");
	private JLabel l2 = new JLabel("Time");
	private JLabel l3 = new JLabel("Price");
	
	private JTextField t1 = new JTextField("");
	private JTextField t2 = new JTextField("");
	private JTextField t3 = new JTextField("");
	
	private JButton b1 = new JButton("Add Movie");
	private JButton b2 = new JButton("Delete All");
	private JButton b3 = new JButton("Show Bookings");
	private JButton b4 = new JButton("Delete First");
	private JButton b5 = new JButton("Current Movies");
	private JButton b6 = new JButton("Back");
	private JButton b8 = new JButton("First");
	private JButton b9 = new JButton("Next");
	
	private int index = 0;
	
	private LinkedList list;

	AdminPage(LinkedList list2){
		this.list=list2;
		setDefaultCloseOperation(javax.swing.
				   WindowConstants.DISPOSE_ON_CLOSE);
		
		Container cont = getContentPane();
		Font f = new Font("TimesRoman",Font.BOLD,20);
		getContentPane().setLayout(null);
		l0.setBounds(94, 13, 121, 27);
		l0.setFont(f);
		cont.add(l0);
		l1.setBounds(39, 63, 119, 25);
		getContentPane().add(l1);
		t1.setBounds(142, 63, 119, 25);
		getContentPane().add(t1);
		l2.setBounds(39, 101, 119, 25);
		getContentPane().add(l2);
		t2.setBounds(142, 101, 119, 25);
		getContentPane().add(t2);
		l3.setBounds(39, 139, 119, 25);
		getContentPane().add(l3);
		t3.setBounds(142, 139, 119, 25);
		getContentPane().add(t3);
		b1.setBounds(39, 189, 121, 25);
		getContentPane().add(b1);
		b2.setBounds(39, 268, 119, 25);
		getContentPane().add(b2);
		b3.setBounds(172, 227, 119, 25);
		getContentPane().add(b3);
		b4.setBounds(39, 227, 121, 25);
		getContentPane().add(b4);
		b5.setBounds(172, 189, 119, 25);
		getContentPane().add(b5);
		b8.setBounds(170, 268, 121, 25);
		getContentPane().add(b8);
		b9.setBounds(39, 306, 119, 25);
		getContentPane().add(b9);
		b6.setBounds(172, 306, 119, 25);
		getContentPane().add(b6);
		b6.addActionListener(this);
		b9.addActionListener(this);
		b8.addActionListener(this);
		b5.addActionListener(this);
		b4.addActionListener(this);
		b3.addActionListener(this);
		b2.addActionListener(this);
		
		b1.addActionListener(this);
		
		setSize(345,423);
		setVisible(true);
		
		setTitle("Admin Page");;
				  
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object target = e.getSource();
		if(target==b1) {
			String mov = t1.getText();
			String time = t2.getText();
			String p = t3.getText();
			int indexOf=time.indexOf(":");
			String part1=time.substring(0,indexOf);
			String part2=time.substring(indexOf+1);
			String part3=p.substring(0);
			int h1 = Integer.parseInt(part1);
			int m1 = Integer.parseInt(part2);
			int p1 = Integer.parseInt(part3);
			list.insert(mov,h1,m1,p1);
			JOptionPane.showMessageDialog(this, "Movie Added Successfully","Successfull", JOptionPane.INFORMATION_MESSAGE);
			t1.setText("");
			t2.setText("");
			t3.setText("");
		}
		
		if(target==b2) {
			list.delete_all();
			JOptionPane.showMessageDialog(this, "Movie Deleted Successfully","Deleted", JOptionPane.INFORMATION_MESSAGE);
			t1.setText("");
			t2.setText("");
			t3.setText("");
		}
		
		if(target==b3) {
			list.printlistbl();
		}
		
		if(target==b4) {
			list.delete_first();
		}
		
		if(target==b5) {
			list.printlist();	
		}
		
		if(target==b6) {
			MyFrame mf=new MyFrame(list);
			mf.setVisible(true);
			this.dispose();
					
		}
		
		
		if(target==b8) {
			if(list.count()==0)
				t1.setText("List is Empty");
			else {
				index=1;
				Movie current=list.readMovielist(index);
				t1.setText(current.readMovie());
				t2.setText(current.readTime());
				t3.setText(current.readPrice());
			}
		}
		
		if(target==b9) {
			if(index<list.count())
				index++;
			Movie current=list.readMovielist(index);
			t1.setText(current.readMovie());
			t2.setText(current.readTime());
			t3.setText(current.readPrice());
		}
		
	}
	

	
	

}
