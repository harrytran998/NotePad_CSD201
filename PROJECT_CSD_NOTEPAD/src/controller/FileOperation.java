/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import view.MyFileFilter;
import view.NotePadForm;

/**
 *
 * @author DemonsLight
 */
public class FileOperation {
//    boolean saved;
//    boolean newFileFlag;
//    String fileName;
//    String applicationTitle = "Javapad";
//    File fileRef;
//    JFileChooser chooser;

//    FileOperation(NotePadForm npd) {
//        saved = true;
//        newFileFlag = true;
//        fileName = "Untitled";
//        fileRef = new File(fileName);
//        npd.setTitle(fileName + " - " + applicationTitle);
//        chooser = new JFileChooser();
//        chooser.addChoosableFileFilter(new MyFileFilter(".java", "Java Source Files(*.java)"));
//        chooser.addChoosableFileFilter(new MyFileFilter(".txt", "Text Files(*.txt)"));
//        chooser.setCurrentDirectory(new File("."));
//
//    }
//////////////////////////////////////
    boolean saveFile(File temp, NotePadForm npd, String fileName, String applicationTitle,
            boolean newFileFlag, File fileRef) {
        FileWriter fout = null;
        try {
            fout = new FileWriter(temp);
            fout.write(npd.getTxtAria().getText());
        } catch (IOException ioe) {
            updateStatus(temp, false, npd, fileName, newFileFlag, fileRef, applicationTitle);
            return false;
        } finally {
            try {
                fout.close();
            } catch (IOException excp) {
            }
        }
        updateStatus(temp, true, npd, fileName, newFileFlag, fileRef, applicationTitle);
        return true;
    }

    boolean saveThisFile(File temp, NotePadForm npd, JFileChooser chooser, File fileRef, boolean newFileFlag,
            String fileName, String applicationTitle) {
        if (!newFileFlag) {
            return saveFile(temp, npd, fileName, applicationTitle, newFileFlag, fileRef);
        }

        return saveAsFile(npd, chooser, fileName, applicationTitle, newFileFlag, fileRef);
    }

    boolean saveAsFile(NotePadForm npd, JFileChooser chooser, String fileName, String applicationTitle,
            boolean newFileFlag, File fileRef) {
        File temp = null;
        chooser.setDialogTitle("Save As...");
        chooser.setApproveButtonText("Save Now");
        chooser.setApproveButtonMnemonic(KeyEvent.VK_S);
        chooser.setApproveButtonToolTipText("Click me to save!");

        do {
            if (chooser.showSaveDialog(npd) != JFileChooser.APPROVE_OPTION) {
                return false;
            }
            temp = chooser.getSelectedFile();
            if (!temp.exists()) {
                break;
            }
            if (JOptionPane.showConfirmDialog(
                    npd, "<html>" + temp.getPath() + " already exists.<br>Do you want to replace it?<html>",
                    "Save As", JOptionPane.YES_NO_OPTION
            ) == JOptionPane.YES_OPTION) {
                break;
            }
        } while (true);
        return saveFile(temp, npd, fileName, applicationTitle, newFileFlag, fileRef);
    }

////////////////////////
    boolean openFile(File temp, NotePadForm npd, boolean newFileFlag,
            String fileName, String applicationTitle, File fileRef) {
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
                npd.getTxtAria().append(str + "\n");
            }

        } catch (IOException ioe) {
            updateStatus(temp, false, npd, fileName, newFileFlag, fileRef, applicationTitle);
            return false;
        } finally {
            try {
                din.close();
                fin.close();
            } catch (IOException excp) {
            }
        }
        updateStatus(temp, true, npd, fileName, newFileFlag, fileRef, applicationTitle);
        npd.getTxtAria().setCaretPosition(0);
        return true;
    }
///////////////////////

    void openFile(JFileChooser chooser, NotePadForm npd, String fileName, boolean saved,
            String applicationTitle, boolean newFileFlag, File fileRef) {
        if (!confirmSave(fileName, saved, npd, applicationTitle, chooser, fileRef)) {
            return;
        }
        chooser.setDialogTitle("Open File...");
        chooser.setApproveButtonText("Open this");
        chooser.setApproveButtonMnemonic(KeyEvent.VK_O);
        chooser.setApproveButtonToolTipText("Click me to open the selected file.!");

        File temp = null;
        do {
            if (chooser.showOpenDialog(npd) != JFileChooser.APPROVE_OPTION) {
                return;
            }
            temp = chooser.getSelectedFile();

            if (temp.exists()) {
                break;
            }
//
            JOptionPane.showMessageDialog(npd,
                    "<html>" + temp.getName() + "<br>file not found.<br>"
                    + "Please verify the correct file name was given.<html>",
                    "Open", JOptionPane.INFORMATION_MESSAGE);

        } while (true);

        npd.getTxtAria().setText("");

        if (!openFile(temp, npd, newFileFlag, fileName, applicationTitle, temp)) {
            fileName = "Untitled";
            saved = true;
            npd.setTitle(fileName + " - " + applicationTitle);
        }
        if (!temp.canWrite()) {
            newFileFlag = true;
        }

    }
////////////////////////

    void updateStatus(File temp, boolean saved, NotePadForm npd,
            String fileName, boolean newFileFlag, File fileRef,
            String applicationTitle) {
        if (saved) {
//            saved = true;
            fileName = new String(temp.getName());
            if (!temp.canWrite()) {
                fileName += "(Read only)";
                newFileFlag = true;
            }
            fileRef = temp;
            npd.setTitle(fileName + " - " + applicationTitle);
            npd.getStatusBar().setText("File : " + temp.getPath() + " saved/opened successfully.");
            newFileFlag = false;
        } else {
            npd.getStatusBar().setText("Failed to save/open : " + temp.getPath());
        }
    }
///////////////////////

    public boolean confirmSave(String fileName, boolean saved, NotePadForm npd,
            String applicationTitle, JFileChooser chooser, File fileRef) {
        String strMsg = "<html>The text in the " + fileName + " file has been changed.<br>"
                + "Do you want to save the changes?<html>";
        if (!saved) {
            int x = JOptionPane.showConfirmDialog(npd, strMsg, applicationTitle, JOptionPane.YES_NO_CANCEL_OPTION);

            if (x == JOptionPane.CANCEL_OPTION) {
                return false;
            }
            if (x == JOptionPane.YES_OPTION && !saveAsFile(npd, chooser, fileName, applicationTitle, saved, fileRef)) {
                return false;
            }
        }
        return true;
    }

    public void newFile(NotePadForm npd, String fileName,
            File fileRef, boolean saved, boolean newFileFlag, JFileChooser chooser,
            String applicationTitle) {
        if (!confirmSave(fileName, saved, npd, applicationTitle, chooser, fileRef)) {
            return;
        }
        npd.getTxtAria().setText("");
        fileName = "Untitled";
        fileRef = new File(fileName);
//        saved = true;
//        newFileFlag = true;
        npd.setTitle(fileName + " - " + applicationTitle);
    }
}
