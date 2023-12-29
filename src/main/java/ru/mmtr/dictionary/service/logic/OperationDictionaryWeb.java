package ru.mmtr.dictionary.service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mmtr.dictionary.data.repository.DictionaryRepository1;
import ru.mmtr.dictionary.data.repository.DictionaryRepository2;
import ru.mmtr.dictionary.data.repository.dao.DictionaryDao1;
import ru.mmtr.dictionary.data.repository.dao.DictionaryDao2;
import ru.mmtr.dictionary.domain.DictionaryFileEnum;
import ru.mmtr.dictionary.model.Dictionary1;
import ru.mmtr.dictionary.model.Dictionary2;
import ru.mmtr.dictionary.model.DictionaryValue1;
import ru.mmtr.dictionary.model.DictionaryValue2;
import ru.mmtr.dictionary.service.integration.shell.Operation;

import java.util.List;

@Service
public class OperationDictionaryWeb implements Operation {      //можно сделать в два класса, но тогда не нужно будет передавать enum и нужно будет менять имплемент на другой
    //минусы одного класса:зависимость от двух репозиториев
    private final DictionaryDao1 connectionRepository1;
    private final DictionaryDao2 connectionRepository2;
    private final DictionaryRepository1 repository1;
    private final DictionaryRepository2 repository2;

    @Autowired
    public OperationDictionaryWeb(DictionaryDao1 connectionRepository1, DictionaryDao2 connectionRepository2, DictionaryRepository1 writerDao, DictionaryRepository2 repository2) {
        this.connectionRepository1 = connectionRepository1;
        this.connectionRepository2 = connectionRepository2;
        this.repository1 = writerDao;
        this.repository2 = repository2;
    }

    public String showAll(DictionaryFileEnum dictionaryNumber) {
        if (dictionaryNumber.getDictionaryNumber() == 1) {
            List<DictionaryValue1> list = repository1.searchAll();
            return list.isEmpty() ? "Словарь пустой." : list.toString();
        } else {
            List<DictionaryValue2> list = repository2.searchAll();
            return list.isEmpty() ? "Словарь пустой." : list.toString();
        }
    }

    @Override
    public String delete(String key, DictionaryFileEnum dictionaryNumber) {     //работает, спасибо cascade
        if (dictionaryNumber.getDictionaryNumber() == 1) {
            repository1.deleteByDictionarykey(key);
        } else {
            repository2.deleteByDictionarykey(key);
        }
        return "Запись с ключём " + key + " успешно удалена.";
    }

    @Override
    public String searchKey(String key, DictionaryFileEnum dictionaryNumber) {     //все гуd
        if (dictionaryNumber.getDictionaryNumber() == 1) {
            List<DictionaryValue1> list = repository1.searchByDictionarykey(key);
            return list.isEmpty() ? "Такой записи нет." : list.toString();
        } else {
            List<DictionaryValue2> list = repository2.searchByDictionarykey(key);
            return list.isEmpty() ? "Такой записи нет." : list.toString();
        }
    }

    @Override
    public String searchValue(String value, DictionaryFileEnum dictionaryNumber) {    //все гуд
        if (dictionaryNumber.getDictionaryNumber() == 1) {
            Dictionary1 d = repository1.searchByDictionaryvalue(value);
            return d == null ? "Словарь не содержит такого значения." : d + " " + value;
        } else {
            Dictionary2 d = repository2.searchByDictionaryvalue(value);
            return d == null ? "Словарь не содержит такого значения." : d + " " + value;
        }
    }

    @Override
    public String addInFile(String key, String value, DictionaryFileEnum dictionaryNumber) {
        if (dictionaryNumber.getDictionaryNumber() == 1) {
            return connectionRepository1.saveConnection(key, value);
        } else {
            return connectionRepository2.saveConnection(key, value);
        }
    }

    public String edit(String key, String value, DictionaryFileEnum dictionaryNumber) {
        if (dictionaryNumber.getDictionaryNumber() == 1) {
            return connectionRepository1.editConnection(key, value);
        } else {
            return connectionRepository2.editConnection(key, value);
        }
    }
}
