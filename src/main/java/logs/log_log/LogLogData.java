package logs.log_log;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author elf
 *
 */
public class LogLogData {
    
    private static List<String> logs = new LinkedList<String>();
    
    public static String printLog(){
	return logs.get(0);
    }

    public static List<String> getLogs() {
	return Collections.unmodifiableList(logs);
    }

    public static void addLog(String message) {
	logs.add(message);
    }

    public static void clear() {
	logs.clear();
    }

    public static void remove() {
	logs.remove(0);
    }
}