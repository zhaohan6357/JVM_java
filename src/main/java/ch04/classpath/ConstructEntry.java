package ch04.classpath;

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
