package michel;

public class Michel {
	public static void main(String[] args) {
		new Michel().nossa().delicia().nossa().delicia();
	}
	Michel nossa(){
		System.out.println("Nossa, nossa");
		Michel.ai();
		return this;
	}
	Michel delicia(){
		System.out.println("Del�cia, del�cia");
		Michel.ai();
		return this;
	}
	static void ai(){
		System.out.println("Assim voc� me mata\n"
		+ "Ai, se eu te pego\n"
		+ "Ai, ai se eu te pego\n");
	}
}
