package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

public class FabbricaFile {
    private static FabbricaFile inst = null;

    public static FabbricaFile getInstance() {
        if(inst == null){
            inst = new FabbricaFile();
        }
        return inst;
    }

    private String nomeClasse;

    private FabbricaFile() {
        nomeClasse = JOptionPane.showInputDialog("Nome dell'implementazione");
    }

    public FileBuilder creaFileBuilder() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return (FileBuilder) Class.forName("org.example." + nomeClasse).getDeclaredConstructor().newInstance();

    }
}
