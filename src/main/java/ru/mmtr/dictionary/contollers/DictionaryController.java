package ru.mmtr.dictionary.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mmtr.dictionary.data.ReaderWriter;
import ru.mmtr.dictionary.domain.DictionaryFileEnum;
import ru.mmtr.dictionary.service.integration.shell.Operation;

import java.util.Map;

@Controller
public class DictionaryController {
    private final ReaderWriter readerWriter;
    private final Operation oper;


    @Autowired
    public DictionaryController(ReaderWriter readerWriter, Operation oper) {
        this.readerWriter = readerWriter;
        this.oper = oper;
    }


    @PostMapping("/view")
    public String dictionaryActions(
            @RequestParam(name = "answer",required = false) String selectedValue,
            @RequestParam(required = false) String key,
            @RequestParam(required = false) String value,
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "searchInTwo", required = false) String searchInTwo,
            @RequestParam(name = "add", required = false) String add,
            @RequestParam(name = "delete", required = false) String delete,
            Model model) {

        DictionaryFileEnum fileEnum = mapSelectedValueToEnum(selectedValue);

        Map<String, String> dictionary1 = readerWriter.readInFile(DictionaryFileEnum.DICTIONARY1);//список словарей
        Map<String, String> dictionary2 = readerWriter.readInFile(DictionaryFileEnum.DICTIONARY2);
        model.addAttribute("dictionary1", dictionary1);
        model.addAttribute("dictionary2", dictionary2);

        System.out.println(search);
        System.out.println(add);
        System.out.println(delete);
        if (search != null) {
            searchAction(key, value, fileEnum, model);
        }

        if (searchInTwo != null) {
            String result;
            result = oper.searchValue(value, DictionaryFileEnum.DICTIONARY1) +" "+ oper.searchValue(value,DictionaryFileEnum.DICTIONARY2);
            model.addAttribute("message",result);
        }

        if (add!=null) {

            addAction(key, value, fileEnum, model);
        }

        if (delete!=null) {
            deleteAction(key, fileEnum, model);
        }

        return "viewdict.html";
    }

    private DictionaryFileEnum mapSelectedValueToEnum(String selectedValue) {
        if ("option1".equals(selectedValue)) {
            return DictionaryFileEnum.DICTIONARY1;
        } else if ("option2".equals(selectedValue)) {
            return DictionaryFileEnum.DICTIONARY2;
        } else {

            return null;
        }
    }

    private void searchAction(String key, String value, DictionaryFileEnum fileEnum, Model model) {
        String result;
        if (key != null && !key.isEmpty()) {
            result = oper.searchKey(key, fileEnum);
        } else if (value != null && !value.isEmpty()) {
            result = oper.searchValue(value, fileEnum);
        } else {

            result = "Вы заполнили не все поля.";
        }
        model.addAttribute("message", result);
    }

    private void addAction(String key, String value, DictionaryFileEnum fileEnum, Model model) {
        String result = oper.addInFile(key, value, fileEnum);
        model.addAttribute("message", result);
    }

    private void deleteAction(String key, DictionaryFileEnum fileEnum, Model model) {
        String result = oper.delete(key, fileEnum);
        model.addAttribute("message", result);
    }
    /*
    @PostMapping("/view")
    public String dictPost(
                           @RequestParam(name = "answer") String selectedValue,
                           @RequestParam(required = false) String key,
                           @RequestParam(required = false) String value,
                           @RequestParam(name = "search", required = false) String search,
                           @RequestParam(name = "add", required = false) String add,
                           @RequestParam(name = "delete", required = false) String delete,
                           Model model) {
        DictionaryFileEnum fileEnum=null;
        DictionaryFileEnum fileEnum2=null;
        if ("option1".equals(selectedValue)) {
            System.out.println("option1");
            fileEnum = DictionaryFileEnum.DICTIONARY1;
        } else if ("option2".equals(selectedValue)) {
            System.out.println("option2");
            fileEnum = DictionaryFileEnum.DICTIONARY2;
        } else if ("option3".equals(selectedValue)) {

        }

        Map<String, String> dictionary1 = readerWriter.readInFile(DictionaryFileEnum.DICTIONARY1);//список словарей
        Map<String, String> dictionary2 = readerWriter.readInFile(DictionaryFileEnum.DICTIONARY2);
        model.addAttribute("dictionary1", dictionary1);
        model.addAttribute("dictionary2", dictionary2);


        if (search != null) {                                                   //search add delete
            if (!key.isEmpty()) {                                               //поиск по ключу
                String s = oper.searchKey(key, fileEnum);
                model.addAttribute("message", s);
            } else if (!value.isEmpty()) {                                      //поиск по значению
                String s = oper.searchValue(value, fileEnum);
                model.addAttribute("message", s);
            }
        }
        if (add != null) {
            String s = oper.addInFile(key, value, fileEnum);
            model.addAttribute("message", s);
        }
        if (delete != null) {
            String s = oper.delete(key, fileEnum);
            model.addAttribute("message", s);
        }

        return "viewdict.html";
    }*/

    @GetMapping("/view")
    public String viewDictionary() {
        return "viewdict.html";
    }
}
