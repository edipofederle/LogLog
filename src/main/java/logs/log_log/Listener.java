package logs.log_log;

/**
 * @author elf
 *
 *Example of listener implementation
 *<PRE>
 *public void message() {
 *	return "["+LogLogData.printLog()+"]";
 *}
 * </PRE>
 */
public interface Listener {
    public void message();
}
