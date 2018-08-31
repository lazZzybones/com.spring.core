package example;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger{
    File file;

    public void init() throws IOException {
        if(file.canWrite()){

        }else{
            throw new IOException();
        }
    }

    FileEventLogger(String fileName){
        this.file = new File(fileName);
    }

    public void logEvent(Event event){
        try {
            FileUtils.writeStringToFile(file, event.toString() + "\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
