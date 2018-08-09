package ch09.classpath;

import ch09.classpath.ConstructEntry;
import ch09.classpath.Entry;

import java.util.Arrays;

public class CompositeEntry implements Entry {
    Entry[] entries;
    @Override
    public byte[] readClass(String className)  {
        for(Entry entry:entries) {
            try {
                byte[] data=entry.readClass(className);
                if(data.length>0){
                    return data;
                }
                continue;
            } catch (Exception e) {
                continue;
            }
        }
        return new byte[0];
    }

    public CompositeEntry(String pathList) {
        String[] strs=pathList.split(";");
        entries=new Entry[strs.length];
        for(int i=0;i<strs.length;i++){
            entries[i]= ConstructEntry.constructEntry(strs[i]) ;
        }
        this.entries = entries;
    }

    @Override
    public String toString() {
        return Arrays.toString(entries);
    }
}
