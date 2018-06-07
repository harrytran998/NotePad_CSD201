/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.MenuDragMouseEvent;
import view.FindDialog;
import view.NotePadForm;
import model.ReplaceDialog;
import view.MyFileFilter;

/**
 *
 * @author DemonsLight
 */
public class HandlingWorkAll {
    // <editor-fold defaultstate="collapsed" desc="Properties">  

    JColorChooser backGrColor;
    JColorChooser fontColor;
    NotePadForm ntp;
    FindDialog findDlog;
    UndoManager undoManager;
    HanldingEdit editHandler;
    ReplaceDialog replaceDlog;
    private boolean saved, newFileFlag;
    private String fileName, appTitle = "Notto ♥";
    private File fileRef;
    private JFileChooser chooser;
    int lastIndex;

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public boolean isNewFileFlag() {
        return newFileFlag;
    }

    public void setNewFileFlag(boolean newFileFlag) {
        this.newFileFlag = newFileFlag;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAppTitle() {
        return appTitle;
    }

    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
    }

    public File getFileRef() {
        return fileRef;
    }

    public void setFileRef(File fileRef) {
        this.fileRef = fileRef;
    }

    public JFileChooser getChooser() {
        return chooser;
    }

    public void setChooser(JFileChooser chooser) {
        this.chooser = chooser;
    }

    public HandlingWorkAll(NotePadForm ntp) {
        this.ntp = ntp;
        saved = true;
        newFileFlag = true;
        fileName = "Untitled";
        fileRef = new File(fileName);
        this.ntp.setTitle(fileName + " - " + appTitle);
        chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new MyFileFilter(".java", "Java Source Files(*.java)"));
        chooser.addChoosableFileFilter(new MyFileFilter(".txt", "Text Files(*.txt)"));
        chooser.setCurrentDirectory(new File("."));
    }

    public HandlingWorkAll(NotePadForm ntp, FindDialog findDlog, ReplaceDialog re) {
        this.ntp = ntp;
        this.findDlog = findDlog;
        this.replaceDlog = re;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Handling File Methods">     
    void newFile() {
        if (!confirmSave()) {
            return;
        }

        this.ntp.getTxtAria().setText("");
        fileName = new String("Untitled");
        fileRef = new File(fileName);
        saved = true;
        newFileFlag = true;
        this.ntp.setTitle(fileName + " - " + appTitle);

    }

    boolean openFile(File temp) {
        FileInputStream fin = null;
        BufferedReader din = null;
        try {
            fin = new FileInputStream(temp);
            din = new BufferedReader(new InputStreamReader(fin));
            String str = " ";
            while (str != null) {
                str = din.readLine();
                if (str == null) {
                    break;
                }
                this.ntp.getTxtAria().append(str + "\n");
            }

        } catch (IOException ioe) {
            updateStatus(temp, false);
            return false;
        } finally {
            try {
                din.close();
                fin.close();
            } catch (IOException excp) {

            }
        }
        updateStatus(temp, true);
        this.ntp.getTxtAria().setCaretPosition(0);
        return true;
    }

    public void openFile() {
        if (!confirmSave()) {
            return;
        }
        File temp = null;
        do {
            if (chooser.showOpenDialog(this.ntp) != JFileChooser.APPROVE_OPTION) {
                return;
            }
            temp = chooser.getSelectedFile();
            if (temp.exists()) {
                break;
            }
            JOptionPane.showMessageDialog(this.ntp,
                    "<html>" + temp.getName() + "<br>file not found.<br>"
                    + "Please verify the correct file name was given.<html>",
                    "Open", JOptionPane.INFORMATION_MESSAGE);

        } while (true);
        this.ntp.getTxtAria().setText("");
        if (!openFile(temp)) {
            fileName = "Untitled";
            saved = true;
            this.ntp.setTitle(fileName + " - " + appTitle);
        }
        if (!temp.canWrite()) {
            newFileFlag = true;
        }
    }

    boolean saveFile(File temp) {
        FileWriter fout = null;
        try {
            fout = new FileWriter(temp);
            fout.write(ntp.getTxtAria().getText());
        } catch (IOException e) {
            updateStatus(temp, false);
            return false;
        } finally {
            try {
                fout.close();
            } catch (Exception e) {

            }
        }
        updateStatus(temp, true);
        return true;
    }

    boolean saveThisFile() {
        if (!newFileFlag) {
            return saveFile(fileRef);
        }
        return saveAsFile();
    }

    void updateStatus(File temp, boolean saved) {
        if (saved) {
            this.saved = true;
            fileName = new String(temp.getName());
            if (!temp.canWrite()) {
                fileName += "(Read only)";
                newFileFlag = true;
            }
            fileRef = temp;
            ntp.getTxtAria().setText(fileName + " - " + appTitle);
            newFileFlag = false;
            ntp.getStatusBar().setText("File : " + temp.getPath() + " saved/opened successfully.");
        } else {
            ntp.getStatusBar().setText("Failed to save/open : " + temp.getPath());
        }
    }

    boolean saveAsFile() {
        File temp = null;
        do {
            if (chooser.showSaveDialog(this.ntp) != JFileChooser.APPROVE_OPTION) {
                return false;
            }
            temp = chooser.getSelectedFile();
            if (!temp.exists()) {
                break;
            }
            if (JOptionPane.showConfirmDialog(
                    this.ntp, "<html>" + temp.getPath() + " already exists.<br>Do you want to replace it?<html>",
                    "Save As", JOptionPane.YES_NO_OPTION
            ) == JOptionPane.YES_OPTION) {
                break;
            }
        } while (true);

        return saveFile(temp);
    }

    boolean confirmSave() {
        String strMsg = "<html>The text in the " + fileName + " file has been changed.<br>"
                + "Do you want to save the changes?<html>";
        if (!saved) {
            int x = JOptionPane.showConfirmDialog(this.ntp, strMsg, appTitle, JOptionPane.YES_NO_CANCEL_OPTION);

            if (x == JOptionPane.CANCEL_OPTION) {
                return false;
            }
            if (x == JOptionPane.YES_OPTION && !saveAsFile()) {
                return false;
            }
        }
        return true;
    }

    void pageSetup() {

    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="File Handling Event">   
    private void fileHandling() {
        ntp.setVisible(true);
        ntp.getTxtAria().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_MASK), "none");

        ntp.getFileOpen().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        ntp.getTxtAria().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                int lineNumber = 0, column = 0, pos = 0;

                try {
                    pos = ntp.getTxtAria().getCaretPosition();
                    lineNumber = ntp.getTxtAria().getLineOfOffset(pos);
                    column = pos - ntp.getTxtAria().getLineStartOffset(lineNumber);
                } catch (Exception excp) {
                }
                if (ntp.getTxtAria().getText().length() == 0) {
                    lineNumber = 0;
                    column = 0;
                }
                ntp.getStatusBar().setText("Line " + (lineNumber + 1) + ", Col " + (column + 1));
            }
        });

//       ntp.getFileNew().add
        ntp.getFileExit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (confirmSave()) {
                    System.exit(0);
                }
            }
        });

        ntp.getFileSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveThisFile();
            }
        });

        ntp.getFileSaveAs().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAsFile();
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
                new FindDialog(ntp, true).setVisible(true);
            }
        });

        ntp.getEditFindNext().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FindDialog(ntp, true).setVisible(true);
            }
        });

        ntp.getEditReplace().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReplaceDialog(ntp, true).setVisible(true);
            }
        });

    }
    // </editor-fold>
    
    
   
    public static void main(String[] args) {
        HandlingWorkAll hdWork = new HandlingWorkAll(new NotePadForm(), new FindDialog(null, true), new ReplaceDialog(null, true));
        hdWork.fileHandling();
        hdWork.editFileHandling();
    }

}
