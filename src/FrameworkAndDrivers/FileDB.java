package FrameworkAndDrivers;

import java.util.Map;

public interface FileDB {
    public Map<String,String> readInFile(String fileName);
    public void writeInFile(String key, String value, String fileName);
}
