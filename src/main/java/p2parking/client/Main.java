package p2parking.client;

public class Main {
	public static boolean main(String[] args) {
		try {
			new Remote(args[0], args[1]);
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
			return false;
		}
	}

}
