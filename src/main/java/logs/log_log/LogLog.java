package logs.log_log;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author elf
 *
 */
public class LogLog {
    
    private boolean autoFlush = true;
    private List<Listener> listeners = new ArrayList<Listener>();
    
    /**
     * Simple message.
     * 
     * @param message
     */
    public void putLog(String message){
	LogLogData.addLog(message);
	
	if(autoFlush)
	    notifyListeners();
    }
    
    public void putLog(String message, Level level){
	LogLogData.addLog(message, level);
	
	if(autoFlush)
	    notifyListeners();
    }
    
    public void putLog(String message, Level level, String obj){
	LogLogData.addLog(message, level, obj);
	
	if(autoFlush)
	    notifyListeners();
    }
    
    private void notifyListeners() {
	for(Listener listener : listeners)
	    listener.message();
	
	if(autoFlush){LogLogData.remove();}
    }

    public void addListner(Listener listener){
	listeners.add(listener);
    }

    public void autoFlush(boolean b) {
	this.autoFlush = b;
    }

    public void flushLogs() {
	for(int i=0; i < LogLogData.getLogs().size(); i++)
	    for(Listener listener : listeners)
		listener.message();
	
	LogLogData.clear();
    }

}
