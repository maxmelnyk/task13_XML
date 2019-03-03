package com.melnyk.filechecker;

import java.io.File;
import org.apache.commons.io.FilenameUtils;

public class ExtensionChecker {
    public static boolean isXML(File xml) {
        return xml.isFile() && FilenameUtils.getExtension(xml.getName()).equals("xml");
    }

    public static boolean isXSD(File xsd){
        return xsd.isFile() && FilenameUtils.getExtension(xsd.getName()).equals("xsd");
    }
}
