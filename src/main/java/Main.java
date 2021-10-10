import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    static Logger myLogger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        initInputFolder();
        myLogger.info("hello");

    }

    private static void initInputFolder() throws IOException {
        Config config = new Gson().fromJson(new FileReader("./config.json"), Config.class);
        Files.createDirectories(Paths.get(config.getInputFolderPath()));


    }
}
