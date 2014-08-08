package logs.fifo_logs;

/**
 * 
 * @author elf
 *
 */
public class Listener1 implements Listener {

    public String message() {
	return "["+LogLogData.printLog()+"]";
    }

}
