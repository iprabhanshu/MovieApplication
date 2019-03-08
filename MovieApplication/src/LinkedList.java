
public class LinkedList {

	private Movie head;
	private MovieBooking head2;
	public LinkedList() {
		head=null;
		head2=null;
	}
	
	public void insert(String s1, int h, int m, int p) {
		Movie temp = new Movie(s1,h,m,p);
		temp.next=head;
		head=temp;
	}
	
	public Movie readMovielist(int mv) {
		if(head==null || this.count()<mv)
			return null;
		Movie temp = head;
		int curr=1;
		while(curr!=mv) {
			curr++;
			temp=temp.next;
		}
		return temp;
	}
	
	public int count() {
		Movie temp=head;
		int res=0;
		while(temp!=null) {
			res++;
			temp=temp.next;
		}
		return res;
	}
	
	public String delete_first() {
		if(head==null)
			return null;
		String res=head.readMovie();
		head = head.next;
		return res;
	}
	
	public void delete_all() {
		head=null;
	}
	
	public void printlist() {
		Movie temp=head;
		System.out.println("\nList:");
		System.out.println("HEAD->");
		while(temp!=null) {
			temp.print();
			temp=temp.next;
		}
		System.out.println("NUll");
	}
	
	public void insertbl(String s1, int h, int m, int p, int uv1, int disp1) {
		MovieBooking temp1 = new MovieBooking(s1,h,m,p,uv1,disp1);
		temp1.next=head2;
		head2=temp1;
	}
	
	public void printlistbl() {
		MovieBooking temp1=head2;
		System.out.println("\nBooking List:");
		System.out.println("HEAD->");
		while(temp1!=null) {
			temp1.print1();
			temp1=temp1.next;
		}
		System.out.println("NUll");
	}
	
	
}
