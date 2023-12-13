package ru.mmtr.dictionary.data.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryRepository<T> {
        String getAll(int dictionaryNumber);
        void save(String key,String value, int dictionaryNumber);
        void update(String key, String value,int dictionaryNumber) ;
        void deleteByKey(String key, int dictionaryNumber);
        T getByKey(String key, int dictionaryNumber);
        T getByValue(String value, int dictionaryNumber);
}
