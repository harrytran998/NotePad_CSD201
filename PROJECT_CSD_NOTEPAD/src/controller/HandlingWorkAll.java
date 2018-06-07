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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import view.FindDialog;
import view.NotePadForm;

/**
 *
 * @author DemonsLight
 */
public class HandlingWorkAll {

    NotePadForm ntp;
    HanldingFile fileHandler;
    FindDialog findDlog;
    UndoManager undoManager;
    HanldingEdit editHandler;
    int lastIndex;

    public HandlingWorkAll(NotePadForm ntp, FindDialog findDlog) {
        this.ntp = ntp;
        this.findDlog = findDlog;
    }

    // <editor-fold defaultstate="collapsed" desc="File Handling">   
    private void fileHandling() {
        ntp.setVisible(true);
        ntp.getFileOpen().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileHandler.openFile();
            }
        });

        ntp.getFileNew().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileHandler.newFile();
            }
        });

        ntp.getFileExit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileHandler.comfirmSave()) {
                    System.exit(0);
                }
            }
        });

        ntp.getFileSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileHandler.saveFile();
            }
        });

        ntp.getFileSaveAs().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileHandler.saveAsFile();
            }
        });

        ntp.getFilePageSetUp().setEnabled(false);
        ntp.getFilePrint().setEnabled(false);
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Edit Handling"> 
    private void editFileHandling() {
        ntp.getEditUndo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                undoManager.undoText();
            }
        });

        ntp.getEditCut().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editHandler.Cut();
            }
        });

        ntp.getEditCopy().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editHandler.Copy();
            }
        });

        ntp.getEditPaste().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editHandler.Paste();
            }
        });

        ntp.getEditDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editHandler.Delete();
            }
        });

        ntp.getEditSelectAll().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editHandler.selectAll();
            }
        });

        ntp.getEditTime_DateNow().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dateNow = LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
                ntp.getTxtAria().insert(dateNow, ntp.getTxtAria().getSelectionStart());
            }
        });

        ntp.getEditUndo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        ntp.getEditFind().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editHandler.Find();
            }
        });

        ntp.getEditFindNext().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editHandler.Find();
            }
        });
        
        ntp.getEditReplace().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editHandler.
            }
        });

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Handling Find Dialog">  
    public void controllFindDialog() {
        findDlog.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findDlog.dispose();
            }
        });
        findDlog.getTfFind().addFocusListener(new FocusAdapter() {
            JTextArea temp = ntp.getTxtAria();

            @Override
            public void focusLost(FocusEvent e) {
                enableDisableButtons_Find();
            }

            private void enableDisableButtons_Find() {
                if (findDlog.getTfFind().getText().length() == 0) {
                    findDlog.getBtnFindNext().setEnabled(false);
                } else {
                    findDlog.getBtnFindNext().setEnabled(true);
                }
            }

            public void actionPerformed(ActionEvent ev) {
                if (ev.getSource() == findDlog.getBtnFindNext()) {
                    findNextWithSelection();
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
        });

    }
// </editor-fold>

    public static void main(String[] args) {
        HandlingWorkAll hdWork = new HandlingWorkAll(new NotePadForm(), new FindDialog(null, true));
        hdWork.fileHandling();
        hdWork.editFileHandling();
    }

}
