package org.example;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class PrintAllHandler extends DefaultHandler {
    private StringBuilder currentValue = new StringBuilder();
    List<Book> result = new ArrayList<>();
    Book currentBook;

    @Override
    public void startDocument() {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() {
        System.out.println("End Document");
    }

    @Override
    public void startElement(
            String uri,
            String localName,
            String qName,
            Attributes attributes) {

        currentValue.setLength(0);

        if (qName.equalsIgnoreCase("book")) {
            // get tag's attribute by name
            currentBook = new Book();

            String id = attributes.getValue("id");
            currentBook.setId(id);
        }

    }

    @Override
    public void endElement(String uri,
                           String localName,
                           String qName) {

//        System.out.printf("End Element : %s%n", qName);

        if (qName.equalsIgnoreCase("author")) {

            currentBook.setAuthor(currentValue.toString());
        }

        if (qName.equalsIgnoreCase("title")) {
            currentBook.setTitle(currentValue.toString());
        }

        if (qName.equalsIgnoreCase("genre")) {
            currentBook.setGenre(currentValue.toString());
        }

        if (qName.equalsIgnoreCase("price")) {
            currentBook.setPrice(currentValue.toString());
        }

        if (qName.equalsIgnoreCase("publish_date")) {
            currentBook.setPublish_date(currentValue.toString());
        }

        if (qName.equalsIgnoreCase("description")) {
            currentBook.setDescription(currentValue.toString());
            result.add(currentBook);
        }

    }

    // http://www.saxproject.org/apidoc/org/xml/sax/ContentHandler.html#characters%28char%5B%5D,%20int,%20int%29
    // SAX parsers may return all contiguous character data in a single chunk,
    // or they may split it into several chunks
    @Override
    public void characters(char ch[], int start, int length) {

        // The characters() method can be called multiple times for a single text node.
        // Some values may missing if assign to a new string

        // avoid doing this
        // value = new String(ch, start, length);

        // better append it, works for single or multiple calls
        currentValue.append(ch, start, length);

    }

    public List<Book> getResult(){
        return result;
    }
}
