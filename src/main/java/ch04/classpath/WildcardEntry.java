package ch04.classpath;

import java.io.File;
import java.util.Arrays;

public class WildcardEntry implements Entry {
    String[] pathEntries;

    @Override
    public byte[] readClass(String className) {
        Entry entry;
        byte[] data;
        for (String str : pathEntries) {
            try {
                if (!str.endsWith("*")) {
                    entry= ConstructEntry.constructEntry(str);
                    data=entry.readClass(className);
                    if(data.length>0){
                        return data;
                    }
                    continue;
                }else{
                    String tempPath=str.substring(0,str.length()-1);
                    File file=new File(tempPath);
                    File[] files = file.listFiles();
                    for(File f:files){
                        try{
                            String fname=f.getAbsolutePath();
                            //System_.out.println(f.getAbsolutePath());
                            if(fname.endsWith("jar")||fname.endsWith("JAR")){
                                entry= ConstructEntry.constructEntry(fname);
                                data=entry.readClass(className);
                                if(data.length>0){
                                    return data;
                                }
                                continue;
                            }

                        }catch (Exception e){
                            continue;
                        }

                    }

                }
            } catch (Exception e) {
                continue;
            }

        }
        return new byte[0];
    }

    public WildcardEntry(String path) {
        this.pathEntries = path.split(";");
    }

    @Override
    public String toString() {
        return Arrays.toString(pathEntries);
    }
}
