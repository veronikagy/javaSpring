package ru.mmtr.dictionary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
public class Dictionary2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dictionary_key", length = 5)
    @Size(min = 5, max = 5, message = "Слово должно быть 5 цифр в длину.")
    private String dictionary_key;

    @Column(name = "dictionary_value")
    private String dictionary_value;

    public Dictionary2(String dictionary_key, String dictionary_value) {
        this.dictionary_key = dictionary_key;
        this.dictionary_value = dictionary_value;
    }
    public Dictionary2() {

    }

    @Override
    public String toString() {
        return getDictionary_key()+" "+getDictionary_value();
    }
}

