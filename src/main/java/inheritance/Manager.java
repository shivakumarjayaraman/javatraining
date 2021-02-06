package inheritance;

public class Manager extends Person {

	public Manager(String name) {
		super(name);
	}
	
//	public String whoAmI() {
//		return "Martian";
//	}

	@Override
	public void doWork() {
		System.out.println(getName() + " is attending meetings :( :( ");
	}

	@Override
	public String toString() {
		return "Manager [getName()=" + getName() + "]";
	}

	
	
}
