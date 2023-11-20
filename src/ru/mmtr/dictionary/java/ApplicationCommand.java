package ru.mmtr.dictionary.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.mmtr.dictionary.Entitles.DictionaryFileEnum;
import ru.mmtr.dictionary.Service.Operation;

@ShellComponent
public class ApplicationCommand {

    private Operation oper;

    public ApplicationCommand() {
    }
    @Autowired
    public ApplicationCommand(Operation oper) {
        this.oper = oper;
    }
    private static DictionaryFileEnum fileNameEnum;
    @ShellMethod(value = "addInFIle", key="add")
    public void addInFIle(int dictionary_number, String key, String value) {
        fileNameEnum = whichDictionary(dictionary_number);
        oper.addInFile(key,value, fileNameEnum);
    }
    @ShellMethod(value = "search")
    public void search(int dictionary_number, String key) {        //@ShellOption(defaultValue = " Nika")
        fileNameEnum = whichDictionary(dictionary_number);
        oper.search(key,fileNameEnum);
    }
    @ShellMethod(value = "delete")
    public void delete(int dictionary_number, String key) {
        fileNameEnum = whichDictionary(dictionary_number);
        oper.delete(key,fileNameEnum);
    }
    private DictionaryFileEnum whichDictionary(int dictionary_number) {
        if (dictionary_number == 1) {
            return DictionaryFileEnum.DICTIONARY1;
        } else if (dictionary_number == 2) {
            return DictionaryFileEnum.DICTIONARY2;
        } else {
            return null;
        }
    }

}
