package exam.codereading.q4;

public class LeakyCup {
	private int maxVolume ;
	private int currentVolume ;
	private int dripSize ;
	public LeakyCup ( int maxVolume ) {
		this.maxVolume = maxVolume ;
		this.currentVolume = 0;
		this.dripSize = maxVolume / 10;
	}
	public int fill () {
		currentVolume = maxVolume ;
		return currentVolume ;
	}
	public int drip () {
		if( currentVolume > dripSize ) {
			currentVolume -= dripSize ;
		} else {
			currentVolume = 0;
		}
		return currentVolume ;
	}
	public int sip () {
		if( currentVolume > 2) {
			currentVolume -= 2;
		} else {
			currentVolume = 0;
		}
		return currentVolume ;
	}

	public static void main(String[] args) {
		//What will get printed?

		LeakyCup big = new LeakyCup(100);
		LeakyCup small = new LeakyCup(10);
		System.out.println (small.drip()); //0
		small.fill();
		System.out.println (small.sip()); //8
		System.out.println (small.drip()); //7
		big.fill ();
		for ( int i = 0; i < 2; i ++) {
			big.sip(); 
			big.drip();
		} 
		System.out.println (big.sip()); //74
		LeakyCup bigRef = big ;
		System.out.println (bigRef.drip()); //64
		small = big ;
		System.out.println (big.sip()); //62
		System.out.println (small.drip()); //52
		System.out.println (bigRef.drip()); //42
	}
}
