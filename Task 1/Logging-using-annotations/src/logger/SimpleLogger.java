package logger;

import annotations.LogLevel;

public class SimpleLogger {

    public static void log(LogLevel.Level level, String message) {
        String prefix = "[" + level + "]";
        System.out.println(prefix + " " + message);
    }

    public static void info(String message) {
        log(LogLevel.Level.INFO, message);
    }

    public static void debug(String message) {
        log(LogLevel.Level.DEBUG, message);
    }

    public static void warn(String message) {
        log(LogLevel.Level.WARN, message);
    }

    public static void error(String message) {
        log(LogLevel.Level.ERROR, message);
    }
}
