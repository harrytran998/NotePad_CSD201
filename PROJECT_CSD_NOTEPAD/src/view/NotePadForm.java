/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

/**
 *
 * @author DemonsLight
 */
public class NotePadForm extends javax.swing.JFrame  {

    public NotePadForm() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    //<editor-fold defaultstate="collapsed" desc=" Getter - setter properties">
    public void setViewStatusBar(JCheckBoxMenuItem viewStatusBar) {    
        this.viewStatusBar = viewStatusBar;
    }

    public JTextArea getTxtAria() {
        return txtAria;
    }

    public void setTxtAria(JTextArea txtAria) {
        this.txtAria = txtAria;
    }
    
    public JMenuItem getEditCopy() {

        return editCopy;
    }

    public void setEditCopy(JMenuItem editCopy) {
        this.editCopy = editCopy;
    }

    public JMenuItem getEditCut() {
        return editCut;
    }

    public void setEditCut(JMenuItem editCut) {
        this.editCut = editCut;
    }

    public JMenuItem getEditDelete() {
        return editDelete;
    }

    public void setEditDelete(JMenuItem editDelete) {
        this.editDelete = editDelete;
    }

    public JMenuItem getEditFind() {
        return editFind;
    }

    public void setEditFind(JMenuItem editFind) {
        this.editFind = editFind;
    }

    public JMenuItem getEditFindNext() {
        return editFindNext;
    }

    public void setEditFindNext(JMenuItem editFindNext) {
        this.editFindNext = editFindNext;
    }

    public JMenuItem getEditGoTo() {
        return editGoTo;
    }

    public void setEditGoTo(JMenuItem editGoTo) {
        this.editGoTo = editGoTo;
    }

    public JMenuItem getEditPaste() {
        return editPaste;
    }

    public void setEditPaste(JMenuItem editPaste) {
        this.editPaste = editPaste;
    }

    public JMenuItem getEditReplace() {
        return editReplace;
    }

    public void setEditReplace(JMenuItem editReplace) {
        this.editReplace = editReplace;
    }

    public JMenuItem getEditSelectAll() {
        return editSelectAll;
    }

    public void setEditSelectAll(JMenuItem editSelectAll) {
        this.editSelectAll = editSelectAll;
    }

    public JMenuItem getEditTime_DateNow() {
        return editTime_DateNow;
    }

    public void setEditTime_DateNow(JMenuItem editTime_DateNow) {
        this.editTime_DateNow = editTime_DateNow;
    }

    public JMenuItem getEditUndo() {
        return editUndo;
    }

    public void setEditUndo(JMenuItem editUndo) {
        this.editUndo = editUndo;
    }

    public JMenuItem getFileExit() {
        return fileExit;
    }

    public void setFileExit(JMenuItem fileExit) {
        this.fileExit = fileExit;
    }

    public JMenuItem getFileNew() {
        return fileNew;
    }

    public void setFileNew(JMenuItem fileNew) {
        this.fileNew = fileNew;
    }

    public JMenuItem getFileOpen() {
        return fileOpen;
    }

    public void setFileOpen(JMenuItem fileOpen) {
        this.fileOpen = fileOpen;
    }

    public JMenuItem getFilePageSetUp() {
        return filePageSetUp;
    }

    public void setFilePageSetUp(JMenuItem filePageSetUp) {
        this.filePageSetUp = filePageSetUp;
    }

    public JMenuItem getFilePrint() {
        return filePrint;
    }

    public void setFilePrint(JMenuItem filePrint) {
        this.filePrint = filePrint;
    }

    public JMenuItem getFileSave() {
        return fileSave;
    }

    public void setFileSave(JMenuItem fileSave) {
        this.fileSave = fileSave;
    }

    public JMenuItem getFileSaveAs() {
        return fileSaveAs;
    }

    public void setFileSaveAs(JMenuItem fileSaveAs) {
        this.fileSaveAs = fileSaveAs;
    }

    public JMenuItem getFmFont() {
        return fmFont;
    }

    public void setFmFont(JMenuItem fmFont) {
        this.fmFont = fmFont;
    }

    public JMenuItem getFmPadColor() {
        return fmPadColor;
    }

    public void setFmPadColor(JMenuItem fmPadColor) {
        this.fmPadColor = fmPadColor;
    }

    public JMenuItem getFmTextColor() {
        return fmTextColor;
    }

    public void setFmTextColor(JMenuItem fmTextColor) {
        this.fmTextColor = fmTextColor;
    }

    public JCheckBoxMenuItem getFmWordWrap() {
        return fmWordWrap;
    }

    public void setFmWordWrap(JCheckBoxMenuItem fmWordWrap) {
        this.fmWordWrap = fmWordWrap;
    }

    public JMenuItem getHelpAbout() {
        return helpAbout;
    }

    public void setHelpAbout(JMenuItem helpAbout) {
        this.helpAbout = helpAbout;
    }

    public JMenuItem getHelpViewHelp() {
        return helpViewHelp;
    }

    public void setHelpViewHelp(JMenuItem helpViewHelp) {
        this.helpViewHelp = helpViewHelp;
    }

    public JMenuItem getViewLook_Feel() {
        return viewLook_Feel;
    }

    public void setViewLook_Feel(JMenuItem viewLook_Feel) {
        this.viewLook_Feel = viewLook_Feel;
    }

    public JCheckBoxMenuItem getViewStatusBar() {
        return viewStatusBar;
    }

    //</editor-fold>
    
    @SuppressWarnings(value = "unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAria = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        fileNew = new javax.swing.JMenuItem();
        fileOpen = new javax.swing.JMenuItem();
        fileSave = new javax.swing.JMenuItem();
        fileSaveAs = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        filePageSetUp = new javax.swing.JMenuItem();
        filePrint = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        fileExit = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        editUndo = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        editCut = new javax.swing.JMenuItem();
        editCopy = new javax.swing.JMenuItem();
        editPaste = new javax.swing.JMenuItem();
        editDelete = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        editFind = new javax.swing.JMenuItem();
        editFindNext = new javax.swing.JMenuItem();
        editReplace = new javax.swing.JMenuItem();
        editGoTo = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        editSelectAll = new javax.swing.JMenuItem();
        editTime_DateNow = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        fmWordWrap = new javax.swing.JCheckBoxMenuItem();
        fmFont = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        fmTextColor = new javax.swing.JMenuItem();
        fmPadColor = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        viewStatusBar = new javax.swing.JCheckBoxMenuItem();
        viewLook_Feel = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        helpViewHelp = new javax.swing.JMenuItem();
        helpAbout = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtAria.setColumns(20);
        txtAria.setRows(5);
        jScrollPane1.setViewportView(txtAria);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu5.setText("File");

        fileNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        fileNew.setText("New");
        jMenu5.add(fileNew);

        fileOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        fileOpen.setText("Open...");
        jMenu5.add(fileOpen);

        fileSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        fileSave.setText("Save");
        jMenu5.add(fileSave);

        fileSaveAs.setText("Save As...");
        jMenu5.add(fileSaveAs);
        jMenu5.add(jSeparator1);

        filePageSetUp.setText("Page Setup");
        jMenu5.add(filePageSetUp);

        filePrint.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        filePrint.setText("Print");
        jMenu5.add(filePrint);
        jMenu5.add(jSeparator2);

        fileExit.setText("Exit");
        jMenu5.add(fileExit);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Edit");

        editUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        editUndo.setText("Undo");
        jMenu6.add(editUndo);
        jMenu6.add(jSeparator3);

        editCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        editCut.setText("Cut");
        jMenu6.add(editCut);

        editCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        editCopy.setText("Copy");
        jMenu6.add(editCopy);

        editPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        editPaste.setText("Paste");
        jMenu6.add(editPaste);

        editDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        editDelete.setText("Delete");
        jMenu6.add(editDelete);
        jMenu6.add(jSeparator4);

        editFind.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        editFind.setText("Find...");
        jMenu6.add(editFind);

        editFindNext.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        editFindNext.setText("Find Next");
        jMenu6.add(editFindNext);

        editReplace.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        editReplace.setText("Replace...");
        jMenu6.add(editReplace);

        editGoTo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        editGoTo.setText("Go to...");
        jMenu6.add(editGoTo);
        jMenu6.add(jSeparator5);

        editSelectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        editSelectAll.setText("Select All");
        jMenu6.add(editSelectAll);

        editTime_DateNow.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        editTime_DateNow.setText("Time/Date");
        jMenu6.add(editTime_DateNow);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Format");

        fmWordWrap.setSelected(true);
        fmWordWrap.setText("Word Wrap");
        jMenu7.add(fmWordWrap);

        fmFont.setText("Font...");
        jMenu7.add(fmFont);
        jMenu7.add(jSeparator6);

        fmTextColor.setText("Set Text Color");
        jMenu7.add(fmTextColor);

        fmPadColor.setText("Set Background Color");
        jMenu7.add(fmPadColor);

        jMenuBar1.add(jMenu7);

        jMenu9.setText("View");

        viewStatusBar.setSelected(true);
        viewStatusBar.setText("Status Bar");
        jMenu9.add(viewStatusBar);

        viewLook_Feel.setText("Change Look & Feel");
        jMenu9.add(viewLook_Feel);

        jMenuBar1.add(jMenu9);

        jMenu10.setText("Help");

        helpViewHelp.setText("View Help");
        jMenu10.add(helpViewHelp);

        helpAbout.setText("About");
        jMenu10.add(helpAbout);

        jMenuBar1.add(jMenu10);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem editCopy;
    private javax.swing.JMenuItem editCut;
    private javax.swing.JMenuItem editDelete;
    private javax.swing.JMenuItem editFind;
    private javax.swing.JMenuItem editFindNext;
    private javax.swing.JMenuItem editGoTo;
    private javax.swing.JMenuItem editPaste;
    private javax.swing.JMenuItem editReplace;
    private javax.swing.JMenuItem editSelectAll;
    private javax.swing.JMenuItem editTime_DateNow;
    private javax.swing.JMenuItem editUndo;
    private javax.swing.JMenuItem fileExit;
    private javax.swing.JMenuItem fileNew;
    private javax.swing.JMenuItem fileOpen;
    private javax.swing.JMenuItem filePageSetUp;
    private javax.swing.JMenuItem filePrint;
    private javax.swing.JMenuItem fileSave;
    private javax.swing.JMenuItem fileSaveAs;
    private javax.swing.JMenuItem fmFont;
    private javax.swing.JMenuItem fmPadColor;
    private javax.swing.JMenuItem fmTextColor;
    private javax.swing.JCheckBoxMenuItem fmWordWrap;
    private javax.swing.JMenuItem helpAbout;
    private javax.swing.JMenuItem helpViewHelp;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JTextArea txtAria;
    private javax.swing.JMenuItem viewLook_Feel;
    private javax.swing.JCheckBoxMenuItem viewStatusBar;
    // End of variables declaration//GEN-END:variables

}
