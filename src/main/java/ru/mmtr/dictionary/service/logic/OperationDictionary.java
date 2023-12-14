package ru.mmtr.dictionary.service.logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mmtr.dictionary.data.file.FileDB;
import ru.mmtr.dictionary.domain.DictionaryFileEnum;
import ru.mmtr.dictionary.service.integration.shell.Operation;

import java.util.Map;

@Service
public class OperationDictionary implements Operation {
    private final FileDB readerWriter;

    @Autowired
    public OperationDictionary(FileDB readerWriter) {
        this.readerWriter = readerWriter;
    }

    @Override
    public String delete(String key, DictionaryFileEnum fileNameEnum) {
        Map<String, String> hashMap = readerWriter.readInFile(fileNameEnum);
        if (!hashMap.containsKey(key)) {
            System.out.println("Словарь не содержит такого слова.");
            return "Словарь не содержит такого слова.";
        } else {
            hashMap.remove(key);
            readerWriter.writeAllInFile(hashMap, fileNameEnum);
            System.out.println("Запись, ключ которой является " + key + ", успешно удалена.");
            return "Запись, ключ которой является " + key + ", успешно удалена.";
        }

    }

    @Override
    public String searchKey(String key, DictionaryFileEnum fileNameEnum) {
        Map<String, String> hashMap = readerWriter.readInFile(fileNameEnum);
        if (!hashMap.containsKey(key)) {
            System.out.println("Словарь не содержит такого слова.");
            return "Словарь не содержит такого слова.";
        } else {
            String value = hashMap.get(key);
            System.out.println(key + " " + value);
            return key + " " + value;
        }

    }

    @Override
    public String searchValue(String value, DictionaryFileEnum fileNameEnum) {
        Map<String, String> hashMap = readerWriter.readInFile(fileNameEnum);
        System.out.println(value);
        if (!hashMap.containsValue(value)) {
            System.out.println("Словарь не содержит такого слова.");
            return "Словарь не содержит такого слова.";
        } else {
            String key = null;
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                if (entry.getValue().equals(value)) {
                    key = entry.getKey();
                    break;
                }
            }
            return key + " " + value;
        }
    }

    @Override
    public String addInFile(String key, String value, DictionaryFileEnum fileNameEnum) {
        if (fileNameEnum.getDictionaryPattern().verification(key)) {
            readerWriter.writeInFile(key, value, fileNameEnum);
            System.out.println("Запись успешно добавлена.");
        }
        return "Запись успешно добавлена.";
    }

}
