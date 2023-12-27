package ru.mmtr.dictionary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Dictionary2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dictionarykey", length = 5, unique = true)
    @Size(min = 5, max = 5)
    private String dictionarykey;

    @OneToMany(mappedBy = "dictionary2", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DictionaryValue2> value2;

    public Dictionary2(String dictionarykey) {
        this.dictionarykey = dictionarykey;
    }

    public Dictionary2() {
    }

    @Override
    public String toString() {
        return getDictionarykey();
    }
}

