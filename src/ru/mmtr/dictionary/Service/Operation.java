package ru.mmtr.dictionary.Service;

public interface Operation {
    void delete(String key);
    void search(String key);
    void addInFile(String key, String value);

}
