
public class Movie extends ShowMovie {
	
	private Time movie_time;
	public Movie next;
	public Price tkt_price;
	public String noticket;
	public String amount;
	
	public Movie(String mov, int h, int m, int p) {
		super(mov);
		movie_time = new Time(h,m);
		tkt_price = new Price(p);
	}
	
	public String readTime() {
		return movie_time.toString();
	}
	
	public String readPrice() {
		return tkt_price.toString();
	}
	
	public void print() {
		System.out.println("["+super.readMovie() + " : " + movie_time + " : " + tkt_price + "]");
	}

}
