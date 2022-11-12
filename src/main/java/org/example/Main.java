package org.example;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ParserConfigurationException, SAXException, IOException, InvocationTargetException, NoSuchMethodException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        PrintAllHandler handler = new PrintAllHandler();
        saxParser.parse("src/main/resources/catalogo_libri.xml", handler);

        List<Book> result = handler.getResult();
        FileBuilder impl = FabbricaFile.getInstance().creaFileBuilder();
        impl.build(result);

    }
}