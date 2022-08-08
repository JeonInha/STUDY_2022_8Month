package signUp;

public class Test {
	
	public static void main(String[] args) {
	AccManagerDaoImpl ad = new AccManagerDaoImpl();
	Account ac = ad.readAccount("inha123");
	System.out.println(ac.getUser_num());
	}
}
