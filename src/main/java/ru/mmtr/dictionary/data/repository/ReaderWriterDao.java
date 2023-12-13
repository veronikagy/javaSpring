package ru.mmtr.dictionary.data.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mmtr.dictionary.model.Dictionary1;
import ru.mmtr.dictionary.model.Dictionary2;


@Repository
public class ReaderWriterDao implements DictionaryRepository {

    private final EntityManager entityManager;

    public ReaderWriterDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public String getAll(int dictionaryNumber) {
        return switch (dictionaryNumber) {
            case 1 -> entityManager.createQuery("from Dictionary1", Dictionary1.class).getResultList().toString();
            default -> entityManager.createQuery("from Dictionary2", Dictionary2.class).getResultList().toString();
        };
    }

    @Override
    @Transactional
    public void save(String key, String value, int dictionaryNumber) {
        switch (dictionaryNumber) {
            case 1 -> entityManager.persist(new Dictionary1(key, value));
            default -> entityManager.persist(new Dictionary2(key, value));
        }
    }

    @Override
    @Transactional
    public void update(String key, String value,int dictionaryNumber) {
        deleteByKey(key,dictionaryNumber);
        save(key,value,dictionaryNumber);
    }

    @Override
    @Transactional
    public void deleteByKey(String key, int dictionaryNumber) {

        String select = "delete from Dictionary" + dictionaryNumber + " where dictionary_key=:key";
        Query query = entityManager.createQuery(select);
        query.setParameter("key", key);
        query.executeUpdate();
    }

    @Override
    public String getByKey(String key, int dictionaryNumber) {
        String select= "from Dictionary" + dictionaryNumber + " where dictionary_key=:key";
        try {
            Query query = entityManager.createQuery(select);
            query.setParameter("key", key);
            return query.getSingleResult().toString();
        } catch (NoResultException e) {
            return "Словарь не содержит такого слова.";
        }
    }

    @Override
    public String getByValue(String value, int dictionaryNumber) {
        String select = "from Dictionary" + dictionaryNumber + " where dictionary_value=:value";
        try {
            Query query = entityManager.createQuery(select);
            query.setParameter("value", value);
            return query.getSingleResult().toString();
        } catch (NoResultException e) {
            return "Словарь не содержит такого слова.";
        }
    }

}
