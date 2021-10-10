import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Main {
    static Logger myLogger = Logger.getLogger(Main.class.getName());
    private static String inputFolderName;

    public static void main(String[] args) throws IOException {
        myLogger.info("start");
        initInputFolder();
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                deleteFiles();
            }
        }, 0, 5, TimeUnit.SECONDS);

    }

    private static void initInputFolder() throws IOException {
        Config config = new Gson().fromJson(new FileReader("./config.json"), Config.class);
        inputFolderName=config.getInputFolderPath();
        Files.createDirectories(Paths.get(inputFolderName));
    }

    private static void deleteFiles() {
        File inputDir = new File(inputFolderName);
        for (File file : inputDir.listFiles()) {
            if(file.isFile()){
                myLogger.warn("deleted file : "+file.getName());
                file.delete();
            }

        }

    }


}
