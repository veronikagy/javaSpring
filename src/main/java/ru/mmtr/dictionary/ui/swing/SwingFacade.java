package ru.mmtr.dictionary.ui.swing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mmtr.dictionary.domain.DictionaryFileEnum;
import ru.mmtr.dictionary.service.logic.OperationDictionaryWeb;

@Component
public class SwingFacade {
    private final OperationDictionaryWeb operationDictionary;

    @Autowired
    public SwingFacade(OperationDictionaryWeb operationDictionary) {
        this.operationDictionary = operationDictionary;
    }

    public String searchKey(String key, int dictionaryNumber) {
        return operationDictionary.searchKey(key, DictionaryFileEnum.resolveDictionaryNumber(dictionaryNumber));
    }

    public String searchValue(String value, int dictionaryNumber) {
        return operationDictionary.searchValue(value, DictionaryFileEnum.resolveDictionaryNumber(dictionaryNumber));
    }

    public String addEntry(String key, String value, int dictionaryNumber) {
        return operationDictionary.addInFile(key, value, DictionaryFileEnum.resolveDictionaryNumber(dictionaryNumber));
    }

    public String deleteEntry(String key, int dictionaryNumber) {
        return operationDictionary.delete(key, DictionaryFileEnum.resolveDictionaryNumber(dictionaryNumber));
    }

    public String editEntry(String key, String value, int dictionaryNumber) {
        return operationDictionary.edit(key, value, DictionaryFileEnum.resolveDictionaryNumber(dictionaryNumber));
    }

    public String showAll(int dictionaryNumber) {
        return operationDictionary.showAll(DictionaryFileEnum.resolveDictionaryNumber(dictionaryNumber));
    }

    public String exportToJson(int dictionaryNumber) {
        return operationDictionary.exportToJson(DictionaryFileEnum.resolveDictionaryNumber(dictionaryNumber));
    }
} 