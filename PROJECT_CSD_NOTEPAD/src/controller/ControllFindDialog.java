/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import view.FindDialog;
import view.NotePadForm;

/**
 *
 * @author DemonsLight
 */
public class ControllFindDialog {

    FindDialog findDlog;
    int lastIndex;
    NotePadForm ntp;
    JTextArea temp = ntp.getTxtAria();

    public void controll() {
        findDlog.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findDlog.dispose();
            }
        });

        findDlog.getTfFind().addFocusListener(new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                enableDisableButtons_Find();
            }

            public void actionPerformed(ActionEvent ev) {
                if (ev.getSource() == findDlog.getBtnFindNext()) {
                    findNextWithSelection();
                }
            }

        });
    }

    private void enableDisableButtons_Find() {
        if (findDlog.getTfFind().getText().length() == 0) {
            findDlog.getBtnFindNext().setEnabled(false);
        } else {
            findDlog.getBtnFindNext().setEnabled(true);
        }
    }

    private void findNextWithSelection() {

        int index = findNext();
        if (index != -1) {
            temp.setSelectionStart(index);
            temp.setSelectionEnd(index + findDlog.getTfFind().getText().length());
        } else {
            JOptionPane.showMessageDialog(findDlog,
                    "Can't find !" + "\"" + findDlog.getTfFind().getText() + "\"",
                    "Find", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private int findNext() {
        String s1 = temp.getText();
        String s2 = findDlog.getTfFind().getText();
        lastIndex = temp.getCaretPosition();
        int selStart = temp.getSelectionStart();
        int selEnd = temp.getSelectionEnd();
        if (findDlog.getRbtnUp().isSelected()) {
            if (selStart != selEnd) {
                lastIndex = selEnd - s2.length() - 1;
            }
            if (!findDlog.getChbxMatchCase().isSelected()) {
                lastIndex = s1.toUpperCase().lastIndexOf(s2.toUpperCase(), lastIndex);
            } else {
                lastIndex = s1.lastIndexOf(s2, lastIndex);
            }
        } else {
            if (selStart != selEnd) {
                lastIndex = selStart + 1;
            }
            if (!findDlog.getChbxMatchCase().isSelected()) {
                lastIndex = s1.toUpperCase().indexOf(s2.toUpperCase(), lastIndex);
            } else {
                lastIndex = s1.indexOf(s2, lastIndex);
            }
        }
        return lastIndex;
    }
}
