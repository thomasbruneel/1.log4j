import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;


public class Main {
    static Logger myLogger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws FileNotFoundException {
        Config config = new Gson().fromJson(new FileReader("./config.json"), Config.class);
        System.out.println(config.getInputFolderPath());
        myLogger.info("hello");

    }
}
