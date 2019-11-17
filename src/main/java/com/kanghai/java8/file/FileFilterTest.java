package com.kanghai.java8.file;

import java.io.File;
import java.io.FileFilter;

/**
 * @author likanghai
 * @version 1.0
 * @date 2019/11/16 17:25
 * @description
 */

public class FileFilterTest {
    public static void main(String[] args) {

     }

     public void fileFilter(){
         File file = new File("E:\\GitRepo");
         String[] files = file.list();
         for (String str: files){
             System.out.println(str);
         }

         System.out.println();

         File[] files1 = file.listFiles(File::isHidden);
         for (File fil:files1){
             System.out.println(fil);
         }
     }


     public void newFileFilter(){
         File[] hiddenFiles = new File("E:\\GitRepo").listFiles(new FileFilter() {
             @Override
             public boolean accept(File file) {
                 return file.isHidden();
             }
         });
         for (File hiddenFile: hiddenFiles) {
             System.out.println(hiddenFile);
         }
     }
}
