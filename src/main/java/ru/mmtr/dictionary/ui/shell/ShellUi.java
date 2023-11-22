package ru.mmtr.dictionary.ui.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.mmtr.dictionary.service.integration.shell.Operation;
import static ru.mmtr.dictionary.domain.DictionaryFileEnum.resolveDictionaryNumber;

@ShellComponent
public class ShellUi {
    private Operation oper;
    @Autowired
    public ShellUi(Operation oper) {
        this.oper = oper;
    }

    @ShellMethod(value = "addInFIle", key = "add")
    public void addInFIle(int dictionary_number, String key, String value) {
        oper.addInFile(key, value, resolveDictionaryNumber(dictionary_number));
    }

    @ShellMethod(value = "search")
    public void search(int dictionary_number, String key) {        //@ShellOption(defaultValue = " Nika")
        oper.search(key, resolveDictionaryNumber(dictionary_number));
    }

    @ShellMethod(value = "delete")
    public void delete(int dictionary_number, String key) {
        oper.delete(key, resolveDictionaryNumber(dictionary_number));
    }

}
