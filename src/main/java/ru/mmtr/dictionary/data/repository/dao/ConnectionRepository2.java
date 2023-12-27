package ru.mmtr.dictionary.data.repository.dao;

import org.springframework.stereotype.Repository;
import ru.mmtr.dictionary.data.repository.DictionaryRepository2;
import ru.mmtr.dictionary.model.Dictionary2;
import ru.mmtr.dictionary.model.DictionaryValue2;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConnectionRepository2 implements ConnectionRepository {
    public final DictionaryRepository2 repository;

    public ConnectionRepository2(DictionaryRepository2 repository) {
        this.repository = repository;
    }

    @Override
    public String saveConnection(String key, String value) {
        List<DictionaryValue2> search = repository.searchByDictionarykey(key);
        Dictionary2 dictionary = search.isEmpty() ? new Dictionary2(key) : search.get(0).getDictionary2();
        dictionary.setDictionarykey(key);

        DictionaryValue2 dictionaryValue = new DictionaryValue2();
        dictionaryValue.setDictionary2(dictionary);
        dictionaryValue.setDictionaryvalue(value);

        List<DictionaryValue2> v = new ArrayList<>();
        v.add(dictionaryValue);
        dictionary.setValue2(v);
        repository.save(dictionary);
        return key + " " + value + " успешно добавлено.";
    }

    @Override
    public String editConnection(String key, String value) {
        repository.updateByDictionarykey(key, value);
        return "Запись с ключом " + key + " теперь имеет значение " + value;
    }
}
