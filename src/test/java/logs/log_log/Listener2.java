package logs.log_log;

import logs.log_log.Listener;
import logs.log_log.LogLogData;

/**
 * 
 * @author elf
 *
 */
public class Listener2 implements Listener {

    public void message() {
	System.out.println(">"+LogLogData.printLog());
    }
}
