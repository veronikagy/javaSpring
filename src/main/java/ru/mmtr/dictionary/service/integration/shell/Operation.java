package ru.mmtr.dictionary.service.integration.shell;

import ru.mmtr.dictionary.domain.DictionaryFileEnum;

public interface Operation {
    String delete(String key, DictionaryFileEnum fileNameEnum);

    String searchKey(String key, DictionaryFileEnum fileEnum);

    String searchValue(String value, DictionaryFileEnum fileEnum);

    String addInFile(String key, String value, DictionaryFileEnum fileNameEnum);

}
