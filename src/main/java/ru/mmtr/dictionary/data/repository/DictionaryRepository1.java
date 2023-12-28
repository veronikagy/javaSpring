package ru.mmtr.dictionary.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mmtr.dictionary.model.Dictionary1;
import ru.mmtr.dictionary.model.DictionaryValue1;

import java.util.List;

@Repository
@Transactional
public interface DictionaryRepository1 extends JpaRepository<Dictionary1, Long> {
    @Query("from Dictionary1 s join s.value1 d where d.dictionaryvalue=?1")
    Dictionary1 searchByDictionaryvalue(String key);

    @Query("from DictionaryValue1 d join d.dictionary1 s where s.dictionarykey=?1")
    List<DictionaryValue1> searchByDictionarykey(String key);

    @Query("from DictionaryValue1 d join d.dictionary1 s ")
    List<DictionaryValue1> searchAll();

    @Modifying
    void deleteByDictionarykey(String key);

    @Modifying
    @Query(value = "UPDATE Dictionary_value1 SET dictionaryvalue = ?2 FROM Dictionary1 d" +
            " WHERE Dictionary_value1.dictionaryid1 = d.id AND d.dictionarykey = ?1", nativeQuery = true)
    void updateByDictionarykey(String dictionarykey, String value);


}
/*   @Modifying
    @Query(value = "DELETE FROM DictionaryValue1 dv1 " +
            "WHERE EXISTS (" +
            "    SELECT 1 " +
            "    FROM Dictionary1 d1 " +
            "    WHERE dv1.dictionary1=d1.value1  " +
            "    AND d1.dictionarykey = 'onee')",nativeQuery = true)*/
    /*@Query("UPDATE DictionaryValue1 d SET d.dictionaryvalue = 'aaa' WHERE EXISTS ( SELECT 1 FROM Dictionary1 s WHERE s.value1 = d.dictionary1 AND s.dictionarykey = 'onee')")

    ("UPDATE DictionaryValue1 d SET d.dictionaryvalue='s' WHERE d.dictionary1=Dictionary1.value1 And Dictionary1.dictionarykey  ='z'" )

    @Modifying
    @Query("INSERT INTO Dictionary1(dictionarykey) values (?1)")
    void saveKey(String key);
    @Query("FROM Dictionary1 s where s.dictionarykey=?1")
    Dictionary1 searchID(String key);
    @Modifying
    @Query("INSERT INTO DictionaryValue1(dictionaryvalue,dictionary1) values (?1,?2)")
    void saveValue(String value,Dictionary1 id);*/

