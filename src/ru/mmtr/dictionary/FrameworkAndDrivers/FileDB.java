package ru.mmtr.dictionary.FrameworkAndDrivers;

import java.util.Map;

public interface FileDB {
    Map<String,String> readInFile(String fileName);
    void writeInFile(String key, String value, String fileName);
    void writeAllInFile(Map<String,String> hashMap, String fileName);
}
