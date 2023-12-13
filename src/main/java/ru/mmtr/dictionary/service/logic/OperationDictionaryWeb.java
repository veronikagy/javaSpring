package ru.mmtr.dictionary.service.logic;

import org.springframework.stereotype.Service;
import ru.mmtr.dictionary.data.repository.ReaderWriterDao;
import ru.mmtr.dictionary.service.integration.web.OperationWeb;

@Service
public class OperationDictionaryWeb implements OperationWeb {
    private final ReaderWriterDao writerDao;

    public OperationDictionaryWeb(ReaderWriterDao writerDao) {
        this.writerDao = writerDao;
    }

    @Override
    public String showAll(int dictionaryNumber) {
        return writerDao.getAll(dictionaryNumber);
    }

    @Override
    public String delete(String key, int dictionaryNumber) {
        writerDao.deleteByKey(key, dictionaryNumber);
        return "Запись с ключём " + key + " успешно удалена.";
    }

    @Override
    public String searchKey(String key, int dictionaryNumber) {
        return writerDao.getByKey(key, dictionaryNumber);
    }

    @Override
    public String searchValue(String key, int dictionaryNumber) {
        return writerDao.getByValue(key, dictionaryNumber);
    }

    @Override
    public String addInFile(String key, String value, int dictionaryNumber) {
        writerDao.save(key, value, dictionaryNumber);
        return key + " " + value + " успешно добавлено.";
    }
    @Override
    public String edit(String key, String value, Integer dictionaryNumber) {
        writerDao.update(key,value,dictionaryNumber);
        return "Запись с ключом "+key + " теперь имеет значение " + value;
    }
}
