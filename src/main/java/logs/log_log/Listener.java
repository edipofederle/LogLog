package logs.log_log;

/**
 * @author elf
 *
 *Example of listener implementation
 *<PRE>
 *public String message() {
 *	return "["+LogLogData.printLog()+"]";
 *}
 * </PRE>
 */
public interface Listener {
    public String message();
}
