package log;

public interface MyLog {
	
	/**
	 * this method will be called to stop the running application and exit it
	 */
	public void stop ();
	
	/**
	 * 
	 * @return the directory where the logs will be saved
	 */
	public String getLogDirectory ();
}
