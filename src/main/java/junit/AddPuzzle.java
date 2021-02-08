package junit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Cryptarithmetic problems ..
 * Example :
 * 
 *    S E N D  +
 *    M O R E
 * -----------
 *  M O N E Y
 * -----------
 * 
 *
 */
public class AddPuzzle {
	private String first;
	private String second;
	private String third;
	
	private List<Character> variables = new ArrayList<>();
	private static final int [] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	
	AddPuzzle(String first, String second, String third) {
		this.first = first.toLowerCase();
		this.second = second.toLowerCase();
		this.third = third.toLowerCase();
		
		this.variables = collectUniqueLetters(first, second, third);
	}

	
	
	public List<Character> getVariables() {
		return Collections.unmodifiableList(variables);
	}
	
	public String toString() {
		return getSolution();
	}
	
	public String getSolution() {
		Map<Character, Integer> solution = new HashMap<>();
		
		if (valid(solution)) {
			return makeSolutionString(solution);
		}
		
		return "No Solution";
	}

	private String makeSolutionString(Map<Character, Integer> solution) {
		return makeString(first, solution) + " + " +
			   makeString(second, solution) + " = " + 
				makeString(third, solution);
	}
	
	

	private boolean valid(Map<Character, Integer> solution) {
		if (!checkAssignmentsUnique(solution)) {
			return false;
		}

		if (allVariablesAssigned(solution)) {
			//System.out.println(assignments);
			return (getValue(first, solution) + getValue(second, solution) == getValue(third, solution));
		}
		
		if (solution.size() < variables.size()) {
			return assignAnotherVariableAndCheck(solution);
		}
		
		return false;
	}

	private boolean assignAnotherVariableAndCheck(Map<Character, Integer> solution) {
		List<Character>unassigned = new ArrayList<>(variables);
		unassigned.removeAll(solution.keySet());
		Character nextChar = unassigned.get(0);
		
		for (int i : digits) {
			// first char cant be 0
			if (nextChar == first.charAt(0) || nextChar == second.charAt(0) || nextChar == third.charAt(0)) {
				if (i == 0) continue;
			}
			solution.put(nextChar, i);
			boolean check = valid (solution);
			if (check) return true;
		}
		solution.remove(nextChar);
		return false;
	}

	private boolean allVariablesAssigned(Map<Character, Integer> solution) {
		return solution.size() == variables.size();
	}

	private boolean checkAssignmentsUnique(Map<Character, Integer> solution) {
		return solution.keySet().size() == new HashSet<Integer>(solution.values()).size();
	}

	static List<Character> collectUniqueLetters(String first, String second, String third) {
		Stream<Character> vars = Stream.concat(
			Stream.concat(
				first.codePoints().mapToObj(s->new Character((char) s)).map(Character::toLowerCase),
				second.codePoints().mapToObj(s->new Character((char) s)).map(Character::toLowerCase)),
				third.codePoints().mapToObj(s->new Character((char) s)).map(Character::toLowerCase));
		
		return new ArrayList<>(vars.collect(Collectors.toSet()));
	}
	
	static int getValue(String str, Map<Character, Integer> solution) {
		int val = 0;
		
		for (int i = 0; i < str.length(); i++) {
			val = val * 10 + solution.get(str.charAt(i));
		}
		return val;
	}
	
	static String makeString(String s, Map<Character, Integer> solution) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			sb.append(solution.get(s.charAt(i)));
		}
		
		return sb.toString();
	}
	
}
