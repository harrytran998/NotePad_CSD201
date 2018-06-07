/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author DemonsLight
 */
public class MyFileFilter extends FileFilter {

    private String desCription;
    private String extension;

    public String getDesCription() {
        return desCription;
    }

    public void setDesCription(String desCription) {
        if (desCription == null) {
            this.desCription = new String("All Files(*.*");
        } else {
            this.desCription = new String(desCription);
        }
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        if (extension == null) {
            this.extension = null;
            return;
        }
        this.extension = new String(extension).toLowerCase();
        if (!extension.startsWith(".")) {
            this.extension = "." + this.extension;
        }
    }

    public MyFileFilter() {
        setExtension(null);
        setDesCription(null);
    }

    public MyFileFilter(String desCription, String extension) {
        setExtension(extension);
        setDesCription(desCription);
    }

    @Override
    public boolean accept(File f) {
        final String fileName = f.getName();
        if (f.isDirectory() || extension == null || fileName.toLowerCase().endsWith(extension.toUpperCase())) {
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return desCription;
    }

}
