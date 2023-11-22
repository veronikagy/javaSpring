package ru.mmtr.dictionary.service.logic;


import ru.mmtr.dictionary.domain.DictionaryFileEnum;
import ru.mmtr.dictionary.data.FileDB;
import ru.mmtr.dictionary.service.integration.shell.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OperationDictionary implements Operation {
    private FileDB readerWriter;

    public OperationDictionary() {
    }

    @Autowired
    public OperationDictionary(FileDB readerWriter) {
        this.readerWriter = readerWriter;
    }

    @Override
    public void delete(String key, DictionaryFileEnum fileNameEnum) {
        Map<String, String> hashMap = readerWriter.readInFile(fileNameEnum);
        if (!hashMap.containsKey(key)) {
            System.out.println("Словарь не содержит такого слова.");
        } else {
            hashMap.remove(key);
            readerWriter.writeAllInFile(hashMap, fileNameEnum);
            System.out.println("Запись, ключ которой является " + key + ", успешно удалена.");
        }
    }

    @Override
    public void search(String key, DictionaryFileEnum fileNameEnum) {
        Map<String, String> hashMap = readerWriter.readInFile(fileNameEnum);
        if (!hashMap.containsKey(key)) {
            System.out.println("Словарь не содержит такого слова.");
        } else {
            String value = hashMap.get(key);
            System.out.println(key + " " + value);
        }
    }

    @Override
    public void addInFile(String key, String value, DictionaryFileEnum fileNameEnum) {
        if (fileNameEnum.getDictionaryPattern().verification(key)) {
            readerWriter.writeInFile(key, value, fileNameEnum);
            System.out.println("Запись успешно добавлена.");
        }
    }

}
