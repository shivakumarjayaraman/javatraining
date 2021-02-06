package junit;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import junit.AddPuzzle;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PuzzleTest {
	
	AddPuzzle p;
	
	
	@BeforeClass
	public static void entry() {
		System.out.println("**** Running PuzzleTest ****");
	}
	
	@Before
	public  void setUp() {
		System.out.println("In Before");
		p = new AddPuzzle("Send", "More", "Money");
		
	}

	@Test
	public void testNoOfVars() {
		assertEquals(8, p.getVariables().size());
	}
	
	
	//@Ignore
	@Test
	public void testSolution() {
		assertEquals("9567 + 1085 = 10652", p.getSolution());
	}
	
	@Test
	public void testCollectUniqueLetters() {
		List<Character> unique = AddPuzzle.collectUniqueLetters("Hello", "Jello", "Yellow");
		assertEquals(7, unique.size());
		assertEquals(unique.size(), new HashSet<>(unique).size());
	}
	
	@Test
	public void testGetValue() {	
		assertEquals(348, AddPuzzle.getValue("abc", new HashMap<Character, Integer>() {{
			this.put('a', 3);
			this.put('b', 4);
			this.put('c', 8);
		}}));
	}
	
	@Test
	public void testGetValueWithException() {	
		Assert.assertThrows(NullPointerException.class, ()->
				AddPuzzle.getValue("abc", new HashMap<Character, Integer>() {{
					this.put('a', 3);
					//this.put('b', 4);
					this.put('c', 8);
		}}));
	}
	
	@Test
	public void testOnlyIfSomeConditionIsTrue() {
		Assume.assumeTrue(filePresent("/tmp/foo"));
	}
	private boolean filePresent(String filename) {
		File f = new File(filename);
		return f.exists();
	}
	
	@Test
	public void testHamcrestMatchers() {
		List<Double> ages = Arrays.asList(23.0, 38.0, 42.5);
		assertThat(ages, hasItems(23.0, 38.0));
	}
	
	@Test 
	public void testJunk() {
		AddPuzzle ap = new AddPuzzle("ABC", "DEF", "GHIJ");
		System.out.println(ap);
	}
	
	@Ignore
	@Test(timeout=6000)
	public void testAndFailSlowCalls() {
		System.out.println("Going to sleep");
		try { Thread.sleep(5000); } catch (Exception e) {}
		System.out.println("Done sleeping");
	}

	@Test
	public void testAnother() {
		AddPuzzle p2 = new AddPuzzle("To", "Go", "Out");
		assertEquals("21 + 81 = 102", p2.toString());
		
		//p2 = new AddPuzzle("Kansas", "Ohio", "Oregon");
		//System.out.println(p2.getSolution());
	}
	
	@After
	public void tearDown() {
		System.out.println("In after");
	}
	
	@AfterClass
	public static void exit() {
		System.out.println("**** Done PuzzleTest ****");
	}

}
