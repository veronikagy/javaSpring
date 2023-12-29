package ru.mmtr.dictionary.data.repository.dao;

public interface DictionaryDao {

    String saveConnection(String key, String value);
    String editConnection(String key, String value);
}
