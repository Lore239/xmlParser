package org.example;

import com.opencsv.CSVWriter;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVBuilder implements FileBuilder{
    @Override
    public void build(List<Book> l) throws IOException {
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.showSaveDialog(null);
        System.out.println(f.getCurrentDirectory());

        List<String[]> csvData = createCsvDataSimple(l);
        try (CSVWriter writer = new CSVWriter(new FileWriter(f.getCurrentDirectory()+"\\resultFile.csv"))) {
            writer.writeAll(csvData);
        }
    }

    private static List<String[]> createCsvDataSimple(List<Book> l) {
        String[] header = {"Id", "Author", "Title", "Genre", "Price", "Publish_date", "Description"};
        //String[] record1 = {"1", "first name", "address 1", "11111"};
        List<String[]> list = new ArrayList<>();
        list.add(header);

        for (Book i:l){
            String[] a = new String[header.length];
            a[0] = i.getId();
            a[1] = i.getAuthor();
            a[2] = i.getTitle();
            a[3] = i.getGenre();
            a[4] = i.getPrice();
            a[5] = i.getPublish_date();
            a[6] = i.getDescription();
            list.add(a);
        }

        return list;
    }
}
