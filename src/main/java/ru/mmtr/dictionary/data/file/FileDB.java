package ru.mmtr.dictionary.data.file;

import ru.mmtr.dictionary.domain.DictionaryFileEnum;
import java.util.Map;

public interface FileDB {
    Map<String, String> readInFile(DictionaryFileEnum fileNameEnum);

    void writeInFile(String key, String value, DictionaryFileEnum fileNameEnum);

    void writeAllInFile(Map<String, String> hashMap, DictionaryFileEnum fileNameEnum);
}
