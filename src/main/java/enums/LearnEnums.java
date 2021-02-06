package enums;

import java.util.Arrays;

public class LearnEnums {
	public static void main(String [] args) {
		Size s = Size.LARGE;
		System.out.println(s);
		
		Size s2 = Size.valueOf("SMALL");
		System.out.println(s2.getAbbrev());
		
		System.out.println(Arrays.asList(Size.values()));
		for (Size siz : Size.values()) {
			System.out.println(siz + "->" + siz.ordinal());
		}
		
		switch (s2) {
			case LARGE :
				System.out.println("Large");
				break;
			case SMALL :
				System.out.println("Small");
				break;
		}
		
		
				
	}
}
