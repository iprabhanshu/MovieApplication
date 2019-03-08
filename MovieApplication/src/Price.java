
public class Price {

	private int mprice;
	
	Price(int p){
		mprice = p;
	}
	
	public String toString() {
		return ""+mprice;
	}
	
	public void reset(int p) {
		mprice = p;
	}
	
}
