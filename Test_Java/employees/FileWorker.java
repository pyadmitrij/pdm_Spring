package com.pdm.employees;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileWorker {

    public void printToFile(List<Employee> list, String fileName) throws IOException {

        FileWriter outputFile = new FileWriter(new File(fileName));

        for (Employee e : list) {
            outputFile.write(e.toString());
            outputFile.write('\n');
        }

        outputFile.close();
    }

    public void readerWithFile(String fileName) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        for(String line: lines){
            System.out.println(line);
        }

    }

    public void existsFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists())
            throw new FileNotFoundException(file.getName());
    }
}
