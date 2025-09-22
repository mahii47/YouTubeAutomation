package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtils {

    private static final String FILE_PATH = "YouTubeData.txt";

    
    public static void writeTitle(String title) {
        try {
            File file = new File(FILE_PATH);

           
            if (!file.exists()) {
                file.createNewFile();
            }

            // Overwrite the file with new title
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) { 
                writer.write("Video Title: " + title);
                writer.newLine();
                writer.write("-----------------------------------");
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeComments(List<String> commentText) {
        try {
            File file = new File(FILE_PATH);

            // Append comments after the title
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write("Comments:");
                writer.newLine();
                for (String comment : commentText) {
                    writer.write(comment);
                    writer.newLine();
                }
                writer.write("-----------------------------------");
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
