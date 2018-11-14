
public class MovieBooking extends ShowMovie {

	private Time movie_time;
	public MovieBooking next;
	public Price tkt_price;
	public int no_of_ticket;
	public int amount;
	
	public MovieBooking(String mov, int h, int m, int p, int uv1, int disp1) {
		super(mov);
		movie_time = new Time(h,m);
		tkt_price = new Price(p);
		no_of_ticket = uv1;
		amount = disp1;
	}
	
	public String readTime() {
		return movie_time.toString();
	}
	
	public String readPrice() {
		return tkt_price.toString();
	}
	
	public void print1() {
		System.out.println("Movie : "+super.readMovie() + "\nMovie Time : " + movie_time + "\nPrice : " + tkt_price + "\nNumber of Ticket : " + no_of_ticket + "\nTotal Amount : " + amount);
	}
	
}
