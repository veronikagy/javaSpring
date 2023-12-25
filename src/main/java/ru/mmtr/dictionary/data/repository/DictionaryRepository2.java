package ru.mmtr.dictionary.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mmtr.dictionary.model.Dictionary2;
import ru.mmtr.dictionary.model.DictionaryValue2;

import java.util.List;

@Repository
@Transactional
public interface DictionaryRepository2 extends JpaRepository<Dictionary2, Long> {

    void deleteByDictionarykey(String key);

    @Query("from Dictionary2 s join s.value2 d where d.dictionaryvalue=?1")
    Dictionary2 searchByDictionaryvalue(String key);

    @Query("from DictionaryValue2 d join d.dictionary2 s where s.dictionarykey=?1")
    List<DictionaryValue2> searchByDictionarykey(String key);

    @Query("from DictionaryValue2 d join d.dictionary2 s ")
    List<DictionaryValue2> searchAll();
}
