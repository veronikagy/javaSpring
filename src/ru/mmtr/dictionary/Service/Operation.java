package ru.mmtr.dictionary.Service;

import ru.mmtr.dictionary.Entitles.DictionaryFileEnum;

public interface Operation {
   void delete(String key,DictionaryFileEnum fileNameEnum);
    void search(String key, DictionaryFileEnum fileEnum);
    void addInFile(String key, String value,DictionaryFileEnum fileNameEnum);

}
