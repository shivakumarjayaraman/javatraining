package interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterfaceDemos {
	public static void main(String [] args) {
		Eatable e = Eatable.makeIcecream();
		e.eat();
		
		System.out.println(e instanceof Eatable);
		System.out.println(e instanceof Runnable);
		
		// Functional interfaces and higher order functions
		List<String> names = Arrays.asList("Shami", "Siraj", "Umesh", "Bumrah", "Ishant");
		names.sort((a, b) -> a.compareTo(b));
		System.out.println(names);
		names.sort((a, b) -> a.length() - b.length());
		System.out.println(names);
		
		List<String>copyOfNames = new ArrayList<String>();
		names.forEach(n -> copyOfNames.add(n));
		System.out.println(copyOfNames);
		copyOfNames.removeIf(s->s.length()>5);
		System.out.println(names);
		System.out.println(copyOfNames);
		
		// Anon classes and closures
		for (Eatable eat : makeEatables("Eggs", "Bacon", "Bread")) {
			eat.eat();
		}
		
	}
	
	static List<Eatable> makeEatables(String ...names) {
		List<Eatable> eats = new ArrayList<Eatable>();
		for (String name : names) {
			eats.add(new Eatable() {
				@Override
				public void eat() {
					System.out.println("Eating " + name);
				}	
			});
		}
		return eats;
	}
}
