package ch07.classpath;

import ch07.classpath.Entry;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class Zip_Entry implements Entry {
    String absPath;

    @Override
    public byte[] readClass(String className) {
        try {
            File file = new File(absPath);
            ZipFile zf = new ZipFile(file);
            InputStream in = new BufferedInputStream(new FileInputStream(file));
            ZipInputStream zin = new ZipInputStream(in);
            ZipEntry ze;
            while ((ze = zin.getNextEntry()) != null) {
                if (ze.isDirectory()) {
                } else {
                    long size = ze.getSize();
                    //System_.out.println(ze.getName());
                   /// String[] names=ze.getName().split("/");//此处getName中含有路径,需要去除//并不需要 zip文件名自带层级结构
                    //String fileName=names[names.length-1];
                    String fileName=ze.getName();
                   // System_.out.println(fileName);
                    if (size > 0&&fileName.equals(className)) { //String 比较 使用equals
                        BufferedInputStream bf = new BufferedInputStream(zf.getInputStream(ze));
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        byte[] buffer = new byte[1024 * 4];
                        int n = 0;
                        while ((n = bf.read(buffer)) != -1) {
                            out.write(buffer, 0, n);
                        }
                        out.close();
                        return out.toByteArray();

                    }
                }
            }
            zin.closeEntry();
            return new byte[0];
        } catch (Exception e) {
            return new byte[0];
        }
    }

    public Zip_Entry(String path) {
        File zipFile = new File(path);
        absPath = zipFile.getAbsolutePath();
    }

    @Override
    public String toString() {
        return absPath;
    }

}
