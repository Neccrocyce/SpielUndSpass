package log;

public interface MyLog {
	
	/**
	 * this method will be called to stop the running application and exit it
	 */
	public void stop ();
	
	/**
	 * this method will be called when the logs cannot be written to a file
	 * @param msg
	 */
	public void sendErrMsg (String msg);
	
	/**
	 * this method will be called any time something is logged.
	 * @param msg
	 */
	public void sendLog (String msg);
}
