package ui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class TextChangesDocumentListener implements DocumentListener {
    private JTextField textField;
    private String result;

    public TextChangesDocumentListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        result = textField.getText();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        result = textField.getText();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        result = textField.getText();;
    }
}

