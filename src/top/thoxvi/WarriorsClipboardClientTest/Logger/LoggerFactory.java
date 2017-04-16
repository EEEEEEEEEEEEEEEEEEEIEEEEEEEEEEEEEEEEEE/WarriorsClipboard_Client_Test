package top.thoxvi.WarriorsClipboardClientTest.Logger;

/**
 * Created by Thoxvi on 2017/4/15.
 */
public class LoggerFactory {
    private static final LoggerFactory logger = new LoggerFactory();
    private LoggerFactory() {
    }

    public static LoggerFactory getInstance() {
        return logger;
    }

    private <T extends ILog> T getLogger(Class<T> c) {
        T logger;
        try {
            logger=(T)Class.forName(c.getName()).newInstance();
            return logger;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ILog getLogger(){
        return getLogger(PrintlnLogger.class);
    }
}
