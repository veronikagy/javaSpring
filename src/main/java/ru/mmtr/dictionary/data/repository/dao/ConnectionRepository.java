package ru.mmtr.dictionary.data.repository.dao;

public interface ConnectionRepository {

    String saveConnection(String key, String value);
    String editConnection(String key, String value);
}
