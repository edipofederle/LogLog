package logs.fifo_logs;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author elf
 *
 */
public class LogLogTest {

    private LogLog ll;
    
    @Before
    public void setUp(){
	ll = new LogLog();
    }
    
    @After
    public void tearDown(){
	LogLogData.clear();
    }
    
    @Test
    public void whenLogAMessageListenerShouldBeCalled(){
	Listener1 listenerMock = mock(Listener1.class);
	
	ll.addListner(listenerMock);
	ll.putLog("log message here");
	
	verify(listenerMock, times(1)).message();
	assertTrue("should be empty", LogLogData.getLogs().isEmpty());
    }
    
    @Test
    public void whenLogTwoMessageListenerShouldBeCalledTwice(){
	Listener listenerMock = mock(Listener1.class);
	
	ll.addListner(listenerMock);
	ll.putLog("log message here");
	ll.putLog("log message here 2");
	
	verify(listenerMock, times(2)).message();
	assertTrue("should be empty", LogLogData.getLogs().isEmpty());
    }
    
    @Test
    public void logMessageWithTwoListeners(){
	Listener listenerMock1 = mock(Listener1.class);
	Listener listenerMock2 = mock(Listener2.class);
	
	ll.addListner(listenerMock1);
	ll.addListner(listenerMock2);
	
	ll.putLog("log message here");
	
	verify(listenerMock1, times(1)).message();
	verify(listenerMock2, times(1)).message();
	assertTrue("should be empty", LogLogData.getLogs().isEmpty());
    }
    
    @Test
    public void logMessageWithAutoFushFalse(){
	Listener listenerMock = mock(Listener1.class);
	
	ll.addListner(listenerMock);
	ll.autoFlush(false);
	ll.putLog("log message here");
	
	assertFalse("should NOT be empty", LogLogData.getLogs().isEmpty());
	
	ll.flushLogs();
	
	verify(listenerMock, times(1)).message();
	
	assertTrue("should be empty", LogLogData.getLogs().isEmpty());
    }
}
