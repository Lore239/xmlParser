package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class SWINGBuilder implements FileBuilder{
    private JTextArea textArea = new JTextArea();
    @Override
    public void build(List<Book> l) throws IOException {
        JFrame f = new JFrame("Titolo");
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        for( Book i:l){
            textArea.append(i.toString());
            textArea.append("\n");
        }

        f.add(scrollPane);
        f.setSize(400,400);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




    }
}
