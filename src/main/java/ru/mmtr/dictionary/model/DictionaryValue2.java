package ru.mmtr.dictionary.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DictionaryValue2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dictionaryvalue")
    private String dictionaryvalue;

    @ManyToOne
    @JoinColumn(name = "dictionaryid2", referencedColumnName = "id")
    private Dictionary2 dictionary2;

    public DictionaryValue2(String dictionaryvalue) {
        this.dictionaryvalue = dictionaryvalue;
    }

    public DictionaryValue2() {
    }

    @Override
    public String toString() {
        return  dictionary2+ " " +dictionaryvalue ;
    }
}
