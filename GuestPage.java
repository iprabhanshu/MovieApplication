import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class GuestPage extends JFrame implements ActionListener{

	private JLabel l0 = new JLabel("Guest Section");
	private JLabel l1 = new JLabel("Movies");
	private JLabel l2 = new JLabel("Show Times");
	private JLabel l3 = new JLabel("Price");
	private JLabel l4 = new JLabel("No of Tickets");
	private JLabel l5 = new JLabel("Total Amount");
	
	private JTextField t1 = new JTextField("");
	private JTextField t2 = new JTextField("");
	private JTextField t3 = new JTextField("");
	private JTextField t4 = new JTextField("");
	private JTextField t5 = new JTextField("");
	
	private JButton b1 = new JButton("Current Movies");
	private JButton b2 = new JButton("My Bookings");
	private JButton b3 = new JButton("Book Ticket");
	private JButton b5 = new JButton("Next");
	private JButton b6 = new JButton("Back");
	
	private int index = 0;
	
	public LinkedList list;
	
    GuestPage(LinkedList list2){
	this.list=list2;
	
	Container con = getContentPane();
	Font f = new Font("TimesRoman",Font.BOLD,20);
	getContentPane().setLayout(null);
	l0.setBounds(88, 13, 118, 27);
	l0.setFont(f);
	con.add(l0);
	l1.setBounds(28, 62, 119, 25);
	getContentPane().add(l1);
	t1.setBounds(144, 62, 119, 25);
	getContentPane().add(t1);
	l2.setBounds(28, 100, 119, 25);
	getContentPane().add(l2);
	t2.setBounds(145, 100, 119, 25);
	getContentPane().add(t2);
	l3.setBounds(28, 138, 119, 25);
	getContentPane().add(l3);
	t3.setBounds(145, 138, 119, 25);
	getContentPane().add(t3);
	l4.setBounds(28, 176, 119, 25);
	getContentPane().add(l4);
	t4.setBounds(145, 176, 118, 25);
	getContentPane().add(t4);
	l5.setBounds(28, 214, 88, 25);
	getContentPane().add(l5);
	t5.setBounds(145, 214, 118, 25);
	getContentPane().add(t5);
	b1.setBounds(28, 280, 119, 25);
	getContentPane().add(b1);
	b3.setBounds(170, 280, 118, 25);
	getContentPane().add(b3);
	b2.setBounds(170, 318, 118, 25);
	getContentPane().add(b2);
	b5.setBounds(28, 318, 118, 25);
	getContentPane().add(b5);
	b6.setBounds(28, 356, 260, 25);
	getContentPane().add(b6);
	b6.addActionListener(this);
	b5.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b1.addActionListener(this);
	
	t4.getDocument().addDocumentListener(new DocumentListener() {
		
		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub

		}
		
		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			String price = t3.getText();
			int disp = Integer.parseInt(price) * Integer.parseInt(t4.getText());
			t5.setText(String.valueOf(disp));
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
		
		}
	});
	setSize(337,463);
	setVisible(true);
}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Object target = e.getSource();
	if(target==b1) {
		list.printlist();
		Movie current = list.readMovielist(index+1);
		t1.setText(current.readMovie());
		t2.setText(current.readTime());
		t3.setText(current.readPrice());
	}
	
	if(target==b2) {
		list.printlistbl();
	}
	
	
	if(target==b3) {
		String mov = t1.getText();
		String time = t2.getText();
		String p = t3.getText();
		String uval = t4.getText();
		String dispamt = t5.getText();
		int indexOf=time.indexOf(":");
		String part1=time.substring(0,indexOf);
		String part2=time.substring(indexOf+1);
		String part3=p.substring(0);
		int h1 = Integer.parseInt(part1);
		int m1 = Integer.parseInt(part2);
		int p1 = Integer.parseInt(part3);
		int uv = Integer.parseInt(uval);
		int disp = Integer.parseInt(dispamt);
		list.insertbl(mov,h1,m1,p1,uv,disp);
		JOptionPane.showMessageDialog(this, "Booking Successfull","Done", JOptionPane.INFORMATION_MESSAGE);
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		
	}
	
	
	if(target==b5) {
		if(index<list.count())
			index++;
		Movie current = list.readMovielist(index);
		t1.setText(current.readMovie());
		t2.setText(current.readTime());
		t3.setText(current.readPrice());
	}
	
	if(target==b6) {
		//System.exit(0);
		MyFrame mf = new MyFrame(list);
		mf.setVisible(true);
		this.dispose();
	}
}

  public void initial() {
	  list.insert("Avengers", 2, 15, 8);
	  index=1;
  }

}
