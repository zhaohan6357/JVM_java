package ziptest;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipTest{
    public static void main(String[] args) throws IOException {
        File file=new File("F:\\zipTest\\hello");
        ZipFile zf=new ZipFile(file);
        InputStream in=new BufferedInputStream(new FileInputStream(file));
        ZipInputStream zin=new ZipInputStream(in);
        ZipEntry ze;
        while ((ze = zin.getNextEntry()) != null) {

            if (ze.isDirectory()) {
            } else {
                System.err.println("file - " + ze.getName() + " : "
                        + ze.getSize() + " bytes");
                long size = ze.getSize();
                if (size > 0) {

                    BufferedInputStream bf=new BufferedInputStream(zf.getInputStream(ze));
                    byte[] data=new byte[3];
                    int c;
                    while ((c=bf.read(data))!=-1){
                        System.out.print(" read:"+c+" ");
                        for(int i=0;i<c;i++){
                        System.out.print((char)data[i]);}
                    }
                    System.out.println();

//                    BufferedReader br = new BufferedReader(
//                            new InputStreamReader(zf.getInputStream(ze)));
//                    String line;
//                    while ((line = br.readLine()) != null) {
//                        System.out.println(line);
//                    }
//                    br.close();
                }
                System.out.println();
            }
        }
        zin.closeEntry();

    }
}
