package org.example;

import org.json.simple.JSONObject;

import javax.swing.*;
import java.io.*;
import java.util.List;

public class JSONBuilder implements FileBuilder{
    @Override
    public void build(List<Book> l) throws IOException {
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.showSaveDialog(null);
        System.out.println(f.getCurrentDirectory());
        FileWriter file = new FileWriter(f.getCurrentDirectory()+"\\resultFile.json");
        JSONObject outer = new JSONObject();
        for (Book i:l){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", i.getId());
            jsonObject.put("author", i.getAuthor());
            jsonObject.put("title", i.getTitle());
            jsonObject.put("genre", i.getGenre());
            jsonObject.put("price", i.getPrice());
            jsonObject.put("publish_date", i.getPublish_date());
            jsonObject.put("description", i.getDescription());
            outer.put(i.getId(), jsonObject);
        }
        file.write(outer.toString());
        file.close();
    }
}
