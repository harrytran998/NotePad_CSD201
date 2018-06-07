/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import view.MyFileFilter;

/**
 *
 * @author DemonsLight
 */
public class HanldingFile {

    // <editor-fold defaultstate="collapsed" desc="Properties">     
    private boolean saved, newFileFlag;
    private String fileName, appTitle = "Notto ♥";
    private File fileRef;
    private JFileChooser chooser;

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
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Handling Methods">     
    void newFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void openFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void saveFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void saveAsFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean comfirmSave() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void pageSetup() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // </editor-fold>
}
