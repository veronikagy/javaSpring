package FrameworkAndDrivers;

import java.util.HashMap;
import java.util.Map;

public interface FileDB {
    public Map<String,String> readInFile(String fileName);
    public void writeInFile(String key, String value, String fileName);
    public void writeAllInFile(Map<String,String> hashMap, String fileName);
}
