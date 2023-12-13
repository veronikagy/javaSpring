package ru.mmtr.dictionary.service.integration.web;

public interface OperationWeb {
    String delete(String key, int dictionaryNumber);
    String showAll(int dictionaryNumber);
    String searchKey(String key, int dictionaryNumber);
    String searchValue(String key,int dictionaryNumber);
    String addInFile(String key, String value, int dictionaryNumber);

    String edit(String key, String value, Integer dictionaryNumber);
}
