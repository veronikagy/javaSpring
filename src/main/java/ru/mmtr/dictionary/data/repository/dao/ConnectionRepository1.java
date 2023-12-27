package ru.mmtr.dictionary.data.repository.dao;

import org.springframework.stereotype.Repository;
import ru.mmtr.dictionary.data.repository.DictionaryRepository1;
import ru.mmtr.dictionary.model.Dictionary1;
import ru.mmtr.dictionary.model.DictionaryValue1;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConnectionRepository1 implements ConnectionRepository {
    public final DictionaryRepository1 repository;

    public ConnectionRepository1(DictionaryRepository1 repository) {
        this.repository = repository;
    }

    @Override
    public String saveConnection(String key, String value) {
        List<DictionaryValue1> search = repository.searchByDictionarykey(key);
        System.out.println(search.toString());
        Dictionary1 dictionary = search.isEmpty() ? new Dictionary1(key) : search.get(0).getDictionary1();
        dictionary.setDictionarykey(key);

        DictionaryValue1 dictionaryValue = new DictionaryValue1();
        dictionaryValue.setDictionary1(dictionary);
        dictionaryValue.setDictionaryvalue(value);

        List<DictionaryValue1> v = new ArrayList<>();
        v.add(dictionaryValue);
        dictionary.setValue1(v);
        repository.save(dictionary);
        return key + " " + value + " успешно добавлено.";
    }

    @Override
    public String editConnection(String key, String value) {
        repository.updateByDictionarykey(key, value);
        return "Запись с ключом " + key + " теперь имеет значение " + value;
    }

}
