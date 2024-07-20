package com.dsalgo.recursion;

import java.io.File;

public class DeleteAllSubFolders {

    public int deleteAllFolderWhichAreEmpty(File file,int length){

        File[] listFiles=file.listFiles();
        if(listFiles.length==0){
            file.delete();
            return length;
        }
        for (File eachFile:listFiles){

            if(eachFile.isDirectory()){
                deleteAllFolderWhichAreEmpty(eachFile,length);
            }else{
                length++;
            }

        }
        return length;

    }

    public static void main(String[] args) {
        DeleteAllSubFolders deleteAllSubFolders=new DeleteAllSubFolders();
        File mainFolder=new File("/Users/ashokbudagala/Documents/Main Folder");
        int totalLength = 0;
        if(mainFolder.exists()) {
           totalLength= deleteAllSubFolders.deleteAllFolderWhichAreEmpty(mainFolder,0);
        }else{
            System.out.println("Folder does not exists to proceed further");
        }

        if(totalLength==0){
            mainFolder.delete();
        }
    }

}
