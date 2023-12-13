package ru.mmtr.dictionary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
public class Dictionary1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dictionary_key",length = 4)
    @Size(min=4,max=4)
    private String dictionary_key;

    @Column(name = "dictionary_value")
    private String dictionary_value;

    public Dictionary1(String dictionary_key, String dictionary_value) {
        this.dictionary_key = dictionary_key;
        this.dictionary_value = dictionary_value;
    }
    public Dictionary1() {

    }

    @Override
    public String toString() {
        return getDictionary_key()+" "+getDictionary_value();
    }
}

