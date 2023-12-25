package ru.mmtr.dictionary.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Dictionary1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dictionarykey", length = 4)
    private String dictionarykey;

    @OneToMany(mappedBy = "dictionary1", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DictionaryValue1> value1;

    public Dictionary1(String dictionarykey) {
        this.dictionarykey = dictionarykey;
    }
    public Dictionary1() {
    }
    @Override
    public String toString() {
        return getDictionarykey();
    }
}

