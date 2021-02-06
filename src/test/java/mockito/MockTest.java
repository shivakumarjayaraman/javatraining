package mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import mockito.StockWatcher;

//@RunWith(MockitoJUnitRunner.class)
public class MockTest {
	@Mock
	StockWatcher watcher;
	
	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		
		when(watcher.getStock("CSCO")).thenReturn(287.5);
		when(watcher.getStock("ZOOM")).thenReturn(8.32, 7.5);
		when(watcher.getStock("GOOG")).
			thenThrow(new IllegalStateException("Dont like Goog"));
		
	}
	
	@Test
	public void testMock() {
		assertNotNull(watcher);
		verifyNoInteractions(watcher);
		
		assertEquals(287, watcher.getStock("CSCO"), 1.0);
		assertEquals(8.5, watcher.getStock("ZOOM"), 0.5);
		assertEquals(7.5, watcher.getStock("ZOOM"), 0);
		assertThrows(IllegalStateException.class, ()->watcher.getStock("GOOG"));
		
		//verify(watcher, times(2));
		
		verify(watcher, atLeast(1));
	}
}
