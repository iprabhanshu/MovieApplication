
public class Time {
	
	private int hour, minute;
	
	public Time(int h, int m) {
		hour = h;
		minute = m;
	}
	
	public String toString() {
		return "" +hour+":"+minute;
	}

	public void reset(int h, int m) {
		hour=h;
		minute=m;
	}
}
