package ch05.classpath;

import java.io.File;

public class ClassPath {
    Entry bootClassPath;
    Entry extClassPath;
    Entry userClassPath;


   public ClassPath parse(String jreOption, String cpOption) {
        try {
            ClassPath cp = new ClassPath();
            cp.parseBootAndExtClassPath(jreOption);
            cp.parseUserClassPath(cpOption);
            return cp;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    void parseBootAndExtClassPath(String jreOption) {

        String jreDir = getJreDir(jreOption);
        String jreLibPath = jreDir + "\\lib\\*";
        bootClassPath = new WildcardEntry(jreLibPath);
        String jreExtPath = jreDir + "\\lib\\ext\\*";
        extClassPath = new WildcardEntry(jreExtPath);
    }

    void parseUserClassPath(String cpOption) {
        if (cpOption == null || cpOption == "") {
            cpOption = ".\\";
        }
        userClassPath = ConstructEntry.constructEntry(cpOption);
    }

    String getJreDir(String jreOption) {
        if (jreOption != null && new File(jreOption).exists()) {
            return jreOption;
        }
        if (new File(".\\jre").exists()) {
            return ".\\jre";
        }
        if (System.getenv("JAVA_HOME") != null) {
            return System.getenv("JAVA_HOME") + "\\jre";
        }
        return null;
    }

    public byte[] ReadClass(String className) {
        className = className + ".class";
        byte[] data;
        try {
            if ((data = bootClassPath.readClass(className)).length > 0) {
                return data;
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            try {
                if ((data = extClassPath.readClass(className)).length > 0) {
                    return data;
                }else{
                    throw new Exception();
                }
            } catch (Exception ee) {
                try {
                    if ((data = userClassPath.readClass(className)).length > 0) {
                        return data;
                    }
                } catch (Exception eee) {
                    return new byte[0];
                }

            }
        }
        return new byte[0];
    }

    @Override
    public String toString() {
        return userClassPath.toString();
    }
}
