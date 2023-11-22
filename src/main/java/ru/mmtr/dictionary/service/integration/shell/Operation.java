package ru.mmtr.dictionary.service.integration.shell;

import ru.mmtr.dictionary.domain.DictionaryFileEnum;

public interface Operation {
    void delete(String key, DictionaryFileEnum fileNameEnum);

    void search(String key, DictionaryFileEnum fileEnum);

    void addInFile(String key, String value, DictionaryFileEnum fileNameEnum);

}
