package com.notenet.NoteNet;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;
public class FileReader {
    public static String readFile(String path) throws IOException {
        Scanner scanner = new Scanner(Paths.get(path), StandardCharsets.UTF_8);
        String content = scanner.useDelimiter("\\A").next();
        scanner.close();
        return content;
    }
}
