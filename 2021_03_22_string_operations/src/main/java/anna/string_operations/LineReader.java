package anna.string_operations;

import anna.string_operations.service.StringHandler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.io.*;

public class LineReader implements ApplicationRunner {

    private final String filename;
    private final StringHandler handler;


    public LineReader(@Value("${anna.string_operations.input.file.path}") String filename, StringHandler handler) {
        this.filename = filename;
        this.handler = handler;
    }

    @Override
    public void run(ApplicationArguments args) {

        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((line = br.readLine()) != null) {

                handler.handleString(line);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
