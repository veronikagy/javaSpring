package test.ru.mmtr.dictionary.service.logic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mmtr.dictionary.data.repository.DictionaryRepository1;
import ru.mmtr.dictionary.data.repository.DictionaryRepository2;
import ru.mmtr.dictionary.domain.DictionaryFileEnum;
import ru.mmtr.dictionary.model.Dictionary1;
import ru.mmtr.dictionary.model.Dictionary2;
import ru.mmtr.dictionary.model.DictionaryValue1;
import ru.mmtr.dictionary.model.DictionaryValue2;
import ru.mmtr.dictionary.service.logic.OperationDictionaryWeb;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class OperationDictionaryWebTest {
    @Mock
    private DictionaryRepository1 repository1;
    @Mock
    private DictionaryRepository2 repository2;
    @InjectMocks
    private OperationDictionaryWeb operationDictionaryWeb;

    @Test
    public void searchAllEmptyDictionary1() {
        // Arrange
        var list = getEmptyListOfValue1();
        given(repository1.searchAll()).willReturn(list);
        // Act
        String result = operationDictionaryWeb.showAll(DictionaryFileEnum.DICTIONARY1);
        // Assert
        assertEquals("Словарь пустой.", result);
    }

    @Test
    public void searchAllDictionary1() {
        // Arrange
        var list = getListOfValue1();
        given(repository1.searchAll()).willReturn(list);
        // Act
        String result = operationDictionaryWeb.showAll(DictionaryFileEnum.DICTIONARY1);
        // Assert
        assertEquals(list.toString(), result);
    }

    @Test
    public void searchKeyDictionary1() {
        // Arrange
        var list = getListOfValue1();
        var validKey = getValidKey1();
        given(repository1.searchByDictionarykey(validKey)).willReturn(list);
        // Act
        String result = operationDictionaryWeb.searchKey(validKey, DictionaryFileEnum.DICTIONARY1);
        // Assert
        assertEquals(list.toString(), result);
    }

    @Test
    public void searchKeyEmptyDictionary1() {
        // Arrange
        var list = getEmptyListOfValue1();
        var validKey = getValidKey1();
        given(repository1.searchByDictionarykey(validKey)).willReturn(list);
        // Act
        String result = operationDictionaryWeb.searchKey(validKey, DictionaryFileEnum.DICTIONARY1);
        // Assert
        assertEquals("Такой записи нет.", result);
    }

    @Test
    public void searchValueDictionary1() {
        // Arrange
        var value = getValue();
        var d = new Dictionary1();
        given(repository1.searchByDictionaryvalue(value)).willReturn(d);
        // Act
        String result = operationDictionaryWeb.searchValue(value, DictionaryFileEnum.DICTIONARY1);
        // Assert
        assertEquals(d + " " + value, result);
    }

    @Test
    public void searchValueEmptyDictionary1() {
        // Arrange
        String value = getValue();
        given(repository1.searchByDictionaryvalue(value)).willReturn(null);
        // Act
        String result = operationDictionaryWeb.searchValue(value, DictionaryFileEnum.DICTIONARY1);
        // Assert
        assertEquals("Словарь не содержит такого значения.", result);
    }

    @Test
    public void searchAllEmptyDictionary2() {
        // Arrange
        var list = getEmptyListOfValue2();
        given(repository2.searchAll()).willReturn(list);
        // Act
        String result = operationDictionaryWeb.showAll(DictionaryFileEnum.DICTIONARY2);
        // Assert
        assertEquals("Словарь пустой.", result);
    }

    @Test
    public void searchAllDictionary2() {
        // Arrange
        var list = getListOfValue2();
        given(repository2.searchAll()).willReturn(list);
        // Act
        String result = operationDictionaryWeb.showAll(DictionaryFileEnum.DICTIONARY2);
        // Assert
        assertEquals(list.toString(), result);
    }

    @Test
    public void searchKeyDictionary2() {
        // Arrange
        var list = getListOfValue2();
        var validKey = getValidKey2();
        given(repository2.searchByDictionarykey(validKey)).willReturn(list);
        // Act
        String result = operationDictionaryWeb.searchKey(validKey, DictionaryFileEnum.DICTIONARY2);
        // Assert
        assertEquals(list.toString(), result);
    }

    @Test
    public void searchKeyEmptyDictionary2() {
        // Arrange
        var list = getEmptyListOfValue2();
        var validKey = getValidKey2();
        given(repository2.searchByDictionarykey(validKey)).willReturn(list);
        // Act
        String result = operationDictionaryWeb.searchKey(validKey, DictionaryFileEnum.DICTIONARY2);
        // Assert
        assertEquals("Такой записи нет.", result);
    }

    @Test
    public void searchValueDictionary2() {
        // Arrange
        var value = getValue();
        var d = new Dictionary2();
        given(repository2.searchByDictionaryvalue(value)).willReturn(d);
        // Act
        String result = operationDictionaryWeb.searchValue(value, DictionaryFileEnum.DICTIONARY2);
        // Assert
        assertEquals(d + " " + value, result);
    }

    @Test
    public void searchValueEmptyDictionary2() {
        // Arrange
        String value = getValue();
        given(repository2.searchByDictionaryvalue(value)).willReturn(null);
        // Act
        String result = operationDictionaryWeb.searchValue(value, DictionaryFileEnum.DICTIONARY2);
        // Assert
        assertEquals("Словарь не содержит такого значения.", result);
    }

    private List<DictionaryValue1> getListOfValue1() {
        List<DictionaryValue1> list = new ArrayList<>();
        DictionaryValue1 value = new DictionaryValue1();
        list.add(value);
        return list;
    }

    private List<DictionaryValue1> getEmptyListOfValue1() {
        return new ArrayList<>();
    }

    private String getValidKey1() {
        return "qwer";
    }

    private String getValue() {
        return "value";
    }

    private List<DictionaryValue2> getListOfValue2() {
        List<DictionaryValue2> list = new ArrayList<>();
        DictionaryValue2 value = new DictionaryValue2();
        list.add(value);
        return list;
    }

    private List<DictionaryValue2> getEmptyListOfValue2() {
        return new ArrayList<>();
    }

    private String getValidKey2() {
        return "11111";
    }
}
