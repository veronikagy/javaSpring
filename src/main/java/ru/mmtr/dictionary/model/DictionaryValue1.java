package ru.mmtr.dictionary.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DictionaryValue1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dictionaryvalue")
    private String dictionaryvalue;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dictionaryid1", referencedColumnName = "id")
    private Dictionary1 dictionary1;
    public DictionaryValue1(String dictionaryvalue) {
        this.dictionaryvalue = dictionaryvalue;
    }
    public DictionaryValue1() {
    }
    @Override
    public String toString() {
        return  dictionary1+ " " +dictionaryvalue ;
    }
}
