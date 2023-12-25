package ru.mmtr.dictionary.service.integration.web;

import org.springframework.stereotype.Service;

@Service
public interface OperationWeb {
    String delete(String key);

    String showAll(int dictionaryNumber);

    String searchKey(String key, int dictionaryNumber);

    String searchValue(String key, int dictionaryNumber);

    String addInFile(String key, String value, int dictionaryNumber);

    String edit(String key, String value, Integer dictionaryNumber);
}
