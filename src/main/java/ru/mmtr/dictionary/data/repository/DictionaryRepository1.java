package ru.mmtr.dictionary.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mmtr.dictionary.model.Dictionary1;
import ru.mmtr.dictionary.model.DictionaryValue1;

import java.util.List;

@Repository
@Transactional
public interface DictionaryRepository1 extends JpaRepository<Dictionary1, Long> {

    void deleteByDictionarykey(String key);

    @Query("from Dictionary1 s join s.value1 d where d.dictionaryvalue=?1")
    Dictionary1 searchByDictionaryvalue(String key);

    @Query("from DictionaryValue1 d join d.dictionary1 s where s.dictionarykey=?1")
    List<DictionaryValue1> searchByDictionarykey(String key);

    @Query("from DictionaryValue1 d join d.dictionary1 s ")
    List<DictionaryValue1> searchAll();


/*    @Modifying
    @Query("INSERT INTO Dictionary1(dictionarykey) values (?1)")
    void saveKey(String key);
    @Query("FROM Dictionary1 s where s.dictionarykey=?1")
    Dictionary1 searchID(String key);
    @Modifying
    @Query("INSERT INTO DictionaryValue1(dictionaryvalue,dictionary1) values (?1,?2)")
    void saveValue(String value,Dictionary1 id);*/


}
