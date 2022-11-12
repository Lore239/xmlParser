package org.example;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class TXTBuilder implements FileBuilder {
    @Override
    public void build(List<Book> l) throws FileNotFoundException, UnsupportedEncodingException {
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.showSaveDialog(null);
        System.out.println(f.getCurrentDirectory());
        PrintWriter writer = new PrintWriter(f.getCurrentDirectory()+"\\resultFile.txt", "UTF-8");

        for (Book i:l){
            writer.println(i.toString());
        }
        writer.close();

    }
}
