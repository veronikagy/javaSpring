package test.ru.mmtr.dictionary.controllers.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import ru.mmtr.dictionary.contollers.web.AddEditController;
import ru.mmtr.dictionary.service.logic.OperationDictionaryWeb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AddEditControllerTest {
    @Mock
    private Model model;
    @Mock
    private OperationDictionaryWeb operWeb;
    @InjectMocks
    private AddEditController addEditController;

    @Test
    public void myMainPostTestSuccess1() {

        // Arrange
        String selectedValue = null;
        String add = "true";
        String key = "thre";
        String value = "3";
        // Act
        String result = addEditController.myMainPost(selectedValue, key, value, add, null, null, model);

        // Assert
        verify(model).addAttribute("message", "Выберите словарь.");
        assertEquals("addEdit.html", result);
    }


}

