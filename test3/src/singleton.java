

public class singleton {

	public static void main(String[] args) {
		chocolateBoiler pp=chocolateBoiler.getInstance();
		pp.fill();
		pp.boil();
		pp.drain();

	}

}
