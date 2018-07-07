package ch03.classpath;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class DirEntry implements Entry {
    String absDir;

    @Override
    public byte[] readClass(String className) {
        try {
            File file = new File(absDir + "\\" + className);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[1024 * 4];
            int n = 0;
            while ((n = bf.read(buffer)) != -1) {
                out.write(buffer, 0, n);
            }
            out.close();
            bf.close();
            return out.toByteArray();
        } catch (Exception e) {
            return new byte[0];
        }
    }

    public DirEntry(String path) {
        File file = new File(path);
        absDir = file.getAbsolutePath();
    }

    @Override
    public String toString() {
        return absDir;
    }

}
