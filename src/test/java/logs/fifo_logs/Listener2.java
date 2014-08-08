package logs.fifo_logs;

import logs.fifo_logs.LogLogData;
import logs.fifo_logs.Listener;

/**
 * 
 * @author elf
 *
 */
public class Listener2 implements Listener {

    public String message() {
	return ">"+LogLogData.printLog();
    }
}
