
public class TestGui {
	static LinkedList list=new LinkedList();
	
	public static void initial_MovieList() {
		list.insert("Deadpool",12,00,10);
		list.insert("Incidious",03,15,12);
		list.insert("Gravity",04,30,7);
		list.insert("Baywatch",05,00,15);	
	}
	
	public static void main(String[] args) {
		initial_MovieList();
		MyFrame f = new MyFrame(list);
	}

}
