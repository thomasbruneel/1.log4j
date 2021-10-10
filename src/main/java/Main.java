import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class Main {
    static Logger myLogger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args){
        myLogger.info("hello");

    }
}
