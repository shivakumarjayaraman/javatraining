package inheritance;

public class Company {
	public static void main(String [] args) {
		Person phb = new Manager("Pointy Haired Boss");
		// Manager m = new Person("Dilbert");
		
		// Type casts .. 
		Manager m2 = (Manager) phb;
		
		// Woo .. What do you think is gonna happen now ? 
		// Developer d = (Developer) phb;

		
		Person []people = new Person[] {
		  new Developer("Linus", "C"),
		  new Developer("Guido", "Python"),
		  new Manager("Shiva")
		};
		
		// polymorphism
		for (Person p : people) {
			p.doWork();
			p.relax();
			System.out.println("-----");
		}
		
		
		// Equals versus ==
		Developer d1 = new Developer("Torvalds", "C");
		Developer d2 = new Developer("Torvalds", "C");
		
		System.out.println(d1 == d2);
		System.out.println(d1.equals(d2));
		System.out.println(d1.hashCode() + ", " + d2.hashCode());
		
		System.out.println(d1);
	}
}
