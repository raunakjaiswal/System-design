
interface ILogger {
    void log(String msg);
}

class ErrorLogger implements ILogger {
    public void log(String msg) {
        System.out.println("ERROR : " + msg);
    }
}

class DebugLogger implements ILogger {
    public void log(String msg) {
        System.out.println("DEBUG : " + msg);
    }
}

class InfoLogger implements ILogger {
    public void log(String msg) {
        System.out.println("INFO : " + msg);
    }
}

class LoggerFactory {
    public ILogger getLogger(String loggerType) {
        if (loggerType == null)
            return null;

        switch (loggerType.toUpperCase()) {
            case "ERROR":
                return new ErrorLogger();
            case "DEBUG":
                return new DebugLogger();

            case "INFO":
                return new InfoLogger();
            default:
                throw new IllegalArgumentException("Invalid logger type: " + loggerType);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        LoggerFactory loggerFactory = new LoggerFactory();


        ILogger errorLogger = loggerFactory.getLogger("ERROR");
        errorLogger.log("This is an error message");

        ILogger debugLogger = loggerFactory.getLogger("DEBUG");
        debugLogger.log("This is a debug message");
    }
}