package interfaces;


public interface Eatable {
	final int CALORIE_LIMIT = 350;
	
	public void eat();
	
	public static Eatable makeCrunchyEatable() {
		return new Eatable() {
			public void eat() {
				System.out.println("Crunchy food");
			}
		};
	}
	
	public static Eatable makeIcecream() {
		return ()-> {System.out.println("Haagen Daaz"); };
	}
	
	
}
