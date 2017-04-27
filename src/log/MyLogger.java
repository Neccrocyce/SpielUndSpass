package log;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyLogger {
	private static List<String[]> log = new ArrayList<>();
	private static int maxLogs = -1;
	private static String fileName = "Log";
	private static String directory = MyLogger.class.getResource("").getPath() + "logs";
	private static int rotations = -1;
	private static MyLog mainClass;	
	
	/**
	 * sets the values - has to be called first
	 * <pre>
	 * @param mainClass the class which implements MyLog.java
	 * @param maxLogs maximum number of logs to be saved
	 *        -1: infinite
	 *        default: -1
	 * @param rotations number of logFiles which will be saved before rotating 
	 *        -1: infinite
	 *        default -1
	 * @param directory directory where the logfiles will be saved
	 *        default ~/logs
	 * </pre>
	 */
	public static void setUp (MyLog mainClass, int maxLogs, int rotations, String directory) {
		MyLogger.mainClass = mainClass;
		MyLogger.maxLogs = maxLogs;
		MyLogger.rotations = rotations;		
		if (!directory.equals("")) {
			MyLogger.directory = directory;MyLogger.directory = directory;
		}
		fileName = mainClass.getClass().getSimpleName().toLowerCase();
	}
	
	public static void setUp (MyLog mainClass) {
		setUp(mainClass, -1, -1, "");
	}
	
	private static void logMissingMainClass () {
		logWarning("mainClass has not been set");
	}
	
	public static void logInfo (String msg) {
		log(new String[] {"INFO", msg});
	}
	
	public static void logWarning (String msg) {
		log(new String[] {"WARNING", msg});
	}
	
	public static void logError (String msg) {
		log(new String[] {"ERROR", msg});
	}
	
	/**
	 * logs critical errors and stops Bot
	 * @param msg
	 */
	public static void logCritical (String msg) {
		log(new String[] {"CRITICAL", msg});
		try {
			mainClass.stop();
		} catch (NullPointerException e) {
			log(new String[] {"CRITICAL", "Cannot stop application; mainClass has not been set yet"});
		}
	}
	
	private static void log (String[] entry) {
		if (mainClass == null) {
			logMissingMainClass();
		}
		log.add(entry);
		mainClass.sendLog(entry[0] + ": " + entry[1]);
		reduceLog();
		save();
	}
	
	private static void reduceLog () {
		while (maxLogs != -1 && log.size() > maxLogs) {
			log.remove(0);
		}
	}
	
	public static String getLogAll () {
		return getLog(true, true, true, true);
	}
	
	public static String getLog (boolean info, boolean warning, boolean error, boolean critical) {
		String content = "";
		for (String[] strings : log) {
			switch (strings[0]) {
			case "INFO":
				if (info) {
					content += strings[0] + ": " + strings[1] + "\n";
				}
				break;
			case "WARNING":
				if (warning) {
					content += strings[0] + ": " + strings[1] + "\n";
				}
				break;
			case "ERROR":
				if (error) {
					content += strings[0] + ": " + strings[1] + "\n";
				}
				break;
			case "CRITICAL":
				if (critical) {
					content += strings[0] + ": " + strings[1] + "\n";
				}
				break;
			}
		}
		return content;
	}
	
	private static void save () {
		if (!new File(directory).exists()) {
			new File(directory).mkdirs();
		}
		String logFile = directory + "/" + fileName + ".log";
		FileWriter w = null;
		try {
			if (new File(logFile).exists()) {
				Files.copy(new File(logFile).toPath(), new File(logFile + ".backup").toPath(),StandardCopyOption.REPLACE_EXISTING);
			}
			w = new FileWriter(logFile);
			String content = getLogAll();
			w.write(content, 0, content.length());
			w.close();
			new File(logFile + ".backup").delete();
		} catch (IOException e) {
			mainClass.sendErrMsg("ERROR: Cannot write logs to file");
			e.printStackTrace();
		} 
	}
	
	public static void load () {
		String logFile = directory + "/" + fileName + ".log";
		if (!new File(logFile).exists()) {
			return;
		}
		String in = "";
		FileReader r = null;
		Scanner s = null;
		try {
			r = new FileReader(logFile);
			s = new Scanner(r);
			s.useDelimiter("\\Z");
			in = s.next();
			s.close();
			
		} catch (IOException e) {
			mainClass.sendErrMsg("ERROR: Cannot load logfiles");
			return;
		}
		
		//split each line
		String obj[] = in.split(in.contains("\r") ? "\r\n" : "\n");
		
		for (String string : obj) {
			String level = string.split(": ")[0];
			log.add(new String[] {level, string.substring(level.length() + 2)});
		}
	}
	
	public static void rotate () {
		File[] files = new File(directory).listFiles(f -> f.getName().startsWith(fileName));
		for (int i = files.length; i > 0; i--) {
			files[i-1].renameTo(new File(directory + "/" + fileName + ".log." + i));
		}
		if (rotations != -1 && files.length > rotations) {
			files[files.length].delete();
		}
	}
}
