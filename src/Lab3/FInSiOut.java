package Lab3;
import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class FInSiOut {
    // citire
    public static List<String> readLines(String fileName) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader citeste = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = citeste.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }



    // scriere
    public static void BagaInFisier(String fileName, List<String> content) {
        Path path = Paths.get(fileName);

        try (BufferedWriter scrie = Files.newBufferedWriter(path)) {
            for (String line : content) {
                scrie.write(line);
                scrie.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
