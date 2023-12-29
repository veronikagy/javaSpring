package ru.mmtr.dictionary.controllers.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import ru.mmtr.dictionary.contollers.web.AddEditController;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AddEditControllerTest {
    @Mock
    private Model model;
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
        assertEquals("addEdit.html", result);
    }


}

