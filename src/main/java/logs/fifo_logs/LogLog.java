package logs.fifo_logs;

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
    
    public void putLog(String message){
	LogLogData.addLog(message);
	
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
