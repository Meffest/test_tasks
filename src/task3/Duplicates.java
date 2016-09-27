package task3;

import java.io.*;
import java.util.*;

/**
 * Created by andzh on 27.09.2016.
 */
public class Duplicates {
    public static boolean duplicatesWriter(File file1, File file2){
        String line;
        Map<String, Integer> duplicatesString = new TreeMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file1));
            FileWriter writer = new FileWriter(file2, true);

            while ((line = reader.readLine()) != null) {
                duplicatesString.put(line, duplicatesString.getOrDefault(line, 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : duplicatesString.entrySet()) {
                writer.write(entry.getKey() + " " + "[" + entry.getValue() + "]" + "\n");
                writer.flush();
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("filename");
        File file2 = new File("filename");

//        duplicatesWriter(file, file2);
        System.out.println(duplicatesWriter(file, file2));
    }
}
