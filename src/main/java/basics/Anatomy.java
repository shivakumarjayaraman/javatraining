package basics;

import java.util.Date;
import static java.lang.Math.*;

/**
 * 
 * A class that helps illustrate the anatomy of a Java class..
 * Contains a whole bunch of 'features' that let the trainer explain
 * many details of a Java class. 
 * 
 * 
 * @author shivjaya
 */
public class Anatomy {
	static {
		System.out.println("Class just got loaded");
	}
	
	// Helps keep a count .. Why should this be static ? 
	static int numberOfInstances = 0;
	 
	// Do you know what final means ? Try changing pi
	static final double pi = 3.14;  // static import for Math.* PI ..
	
	{
		//System.out.println("An initialization block ... ");
	}

	// Instance data .. How are they initialized.
	// An anatomy has a id and a name, and we track the creation time.
	private Date creationDate = new Date();
	private int anatomyId; 
	private String name;
	
	// Default Constructor (no-args cons)
	// Java will create one for you IF, you have no other cons in your class.
	public Anatomy() {
		this("Unknown");  // constructor chaining
		System.out.println(
				"The default constructor : " + anatomyId + 
				". Created on " + creationDate );
	}
	
	// Constructor that takes a name .. (The concept of overloading)
	public Anatomy(String name) {
		// There is a subtle problem here.. See if you can spot it ??
		// What if two instances are getting created at the same time. 
		Anatomy.numberOfInstances++; 
		
		this.anatomyId = Anatomy.numberOfInstances;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String newname) {
		this.name = newname;
	}
	
	public String toString() {
		return "Anatomy(" + this.anatomyId + ", " + this.name + ")";
	}
	
	
	public static void main(String [] args) {
		System.out.println("Inside the main method");
		
		// Primitive Types : 8 of them 
		byte b = 100;
		short s = 120;
		int i = 0;
		long l = 999;
		char c = 'a';
		
		float flocal = 1.2f;
		double dlocal = Anatomy.pi;
		
		boolean isJavaCool = true;
		
		
		System.out.println(l);
		
		Anatomy myInstance = new Anatomy();
		Anatomy anotherOne = new Anatomy();
		Anatomy aThirdOne = null;  
		
		System.out.println(Anatomy.numberOfInstances);
		
		// Illustrate basic calling conventions
		int x = 23;
		System.out.println("Before incrementing ... " + x);
		incrementAPrimitive(x);
		System.out.println("After incrementing ... " + x);
		
		Anatomy newOne = new Anatomy("Java");
		System.out.println(newOne);
		changeAnatomy(newOne);
		System.out.println(newOne);
		changeAnatomy(newOne, "Evil guy");
		System.out.println(newOne);
		
	}
	
	static void incrementAPrimitive(int x) {
		x += 1;
	}
	
	// Another example of overloading .. method has same name, but diff signatures
	// Can you overload if return type alone changes ? Try it out.. 
	static void changeAnatomy(Anatomy a) {
		a = new Anatomy("The Evil Guy");
	}
	
	static void changeAnatomy(Anatomy a, String newName) {
		a.setName(newName);
	}
	
	
}
