package org.example;


import javax.xml.transform.Templates;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface FileBuilder {
    void build(List<Book> l) throws IOException;

}
