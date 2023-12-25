package ru.mmtr.dictionary.service.integration.shell;

import org.springframework.stereotype.Service;
import ru.mmtr.dictionary.domain.DictionaryFileEnum;

@Service
public interface Operation {
    String delete(String key, DictionaryFileEnum fileNameEnum);

    String searchKey(String key, DictionaryFileEnum fileEnum);

    String searchValue(String value, DictionaryFileEnum fileEnum);

    String addInFile(String key, String value, DictionaryFileEnum fileNameEnum);

}
