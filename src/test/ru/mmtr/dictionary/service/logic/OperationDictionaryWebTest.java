package test.ru.mmtr.dictionary.service.logic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mmtr.dictionary.data.repository.DictionaryRepository1;
import ru.mmtr.dictionary.domain.DictionaryFileEnum;
import ru.mmtr.dictionary.model.Dictionary1;
import ru.mmtr.dictionary.model.DictionaryValue1;
import ru.mmtr.dictionary.service.logic.OperationDictionaryWeb;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class OperationDictionaryWebTest {
    @Mock
    private DictionaryRepository1 repository1;
    @InjectMocks
    private OperationDictionaryWeb operationDictionaryWeb;

    @Test
    public void searchAll1() {
        // Arrange
        List<DictionaryValue1> list = new ArrayList<>();
        given(repository1.searchAll()).willReturn(list);
        DictionaryFileEnum dictionaryNumber = DictionaryFileEnum.DICTIONARY1;
        // Act
        String result = operationDictionaryWeb.showAll(dictionaryNumber);
        // Assert
        verify(repository1).searchAll();
        assertEquals("Словарь пустой.", result);
    }

    @Test
    public void searchAll2() {
        // Arrange
        DictionaryValue1 value = new DictionaryValue1();
        List<DictionaryValue1> list = new ArrayList<>();
        list.add(value);
        given(repository1.searchAll()).willReturn(list);
        DictionaryFileEnum dictionaryNumber = DictionaryFileEnum.DICTIONARY1;
        // Act
        String result = operationDictionaryWeb.showAll(dictionaryNumber);
        // Assert
        verify(repository1).searchAll();
        assertEquals(list.toString(), result);
    }

    @Test
    public void searchKey1() {
        // Arrange
        String key = "asdf";
        DictionaryValue1 value = new DictionaryValue1();
        List<DictionaryValue1> list = new ArrayList<>();
        list.add(value);
        given(repository1.searchByDictionarykey(key)).willReturn(list);
        DictionaryFileEnum dictionaryNumber = DictionaryFileEnum.DICTIONARY1;
        // Act
        String result = operationDictionaryWeb.searchKey(key, dictionaryNumber);
        // Assert
        verify(repository1).searchByDictionarykey(key);
        assertEquals(list.toString(), result);
    }

    @Test
    public void searchKey2() {
        // Arrange
        String key = "asdf";
        List<DictionaryValue1> list = new ArrayList<>();
        given(repository1.searchByDictionarykey(key)).willReturn(list);
        DictionaryFileEnum dictionaryNumber = DictionaryFileEnum.DICTIONARY1;
        // Act
        String result = operationDictionaryWeb.searchKey(key, dictionaryNumber);
        // Assert
        verify(repository1).searchByDictionarykey(key);
        assertEquals("Такой записи нет.", result);
    }

    @Test
    public void searchValue1() {
        // Arrange
        String value = "asdf";
        Dictionary1 d = new Dictionary1();
        given(repository1.searchByDictionaryvalue(value)).willReturn(d);
        DictionaryFileEnum dictionaryNumber = DictionaryFileEnum.DICTIONARY1;
        // Act
        String result = operationDictionaryWeb.searchValue(value, dictionaryNumber);
        // Assert
        verify(repository1).searchByDictionaryvalue(value);
        assertEquals(d + " " + value, result);
    }

    @Test
    public void searchValue2() {
        // Arrange
        String value = "asdf";
        Dictionary1 d = null;
        given(repository1.searchByDictionaryvalue(value)).willReturn(d);
        DictionaryFileEnum dictionaryNumber = DictionaryFileEnum.DICTIONARY1;
        // Act
        String result = operationDictionaryWeb.searchValue(value, dictionaryNumber);
        // Assert
        verify(repository1).searchByDictionaryvalue(value);
        assertEquals("Словарь не содержит такого значения.", result);
    }
}
