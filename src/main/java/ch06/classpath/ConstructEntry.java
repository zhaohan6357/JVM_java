package ch06.classpath;

import ch06.classpath.CompositeEntry;
import ch06.classpath.DirEntry;
import ch06.classpath.Entry;
import ch06.classpath.WildcardEntry;
import ch06.classpath.Zip_Entry;

public class ConstructEntry {
    public static Entry constructEntry(String path){
        if(path.endsWith("*")){
            return new WildcardEntry(path);
        }
        if(path.contains(";")){
            return new CompositeEntry(path);
        }
        if(path.endsWith(".zip")||path.endsWith("jar")||
                path.endsWith("ZIP")||path.endsWith("JAR")){
            return new Zip_Entry(path);
        }
        return new DirEntry(path);
    }
}
