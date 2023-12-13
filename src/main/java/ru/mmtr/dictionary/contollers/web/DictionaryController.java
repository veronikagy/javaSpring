package ru.mmtr.dictionary.contollers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mmtr.dictionary.service.logic.OperationDictionaryWeb;

@Controller
public class DictionaryController {
    private final OperationDictionaryWeb operWeb;


    @Autowired
    public DictionaryController(OperationDictionaryWeb operWeb) {
        this.operWeb = operWeb;
    }

    @GetMapping("/main")
    public String myMain(Model model) {
        return "main.html";
    }

    @PostMapping("/view")
    public String dictionaryActions(@RequestParam(name = "answer", required = false) String selectedValue,
                                    @RequestParam(required = false) String key,
                                    @RequestParam(required = false) String value,
                                    @RequestParam(name = "search", required = false) String search,
                                    @RequestParam(name = "searchInTwo", required = false) String searchInTwo,
                                    @RequestParam(name = "add", required = false) String add,
                                    @RequestParam(name = "delete", required = false) String delete,
                                    Model model) {

        Integer dictionaryNumber = mapSelectedValueToEnum(selectedValue);

        collapsinglist(model); //схлопывающийся список

        if (search != null) {
            searchAction(key, value, dictionaryNumber, model);
        }
        if (searchInTwo != null) {
            String result;
            result = operWeb.searchValue(value, 1) + " " + operWeb.searchValue(value, 2);
            model.addAttribute("message", result);
        }
        if (add != null) {
            addAction(key, value, dictionaryNumber, model);
        }
        if (delete != null) {
            deleteAction(key, dictionaryNumber, model);
        }

        return "viewdict.html";
    }

    private void collapsinglist(Model model) {
        String dictionary1 = operWeb.showAll(1);
        String dictionary2 = operWeb.showAll(2);
        model.addAttribute("dictionary1", dictionary1);
        model.addAttribute("dictionary2", dictionary2);
    }


    private Integer mapSelectedValueToEnum(String selectedValue) {
        if ("option1".equals(selectedValue)) {
            return 1;
        } else if ("option2".equals(selectedValue)) {
            return 2;
        } else {
            return null;
        }
    }

    private void searchAction(String key, String value, Integer dictionaryNumber, Model model) {
        String result;
        if (key != null && !key.isEmpty()) {
            result = operWeb.searchKey(key, dictionaryNumber);
        } else if (value != null && !value.isEmpty()) {
            result = operWeb.searchValue(value, dictionaryNumber);
        } else {

            result = "Вы заполнили не все поля.";
        }
        model.addAttribute("message", result);
    }

    private void addAction(String key, String value, Integer dictionaryNumber, Model model) {
        String result = operWeb.addInFile(key, value, dictionaryNumber);
        model.addAttribute("message", result);
    }

    private void deleteAction(String key, Integer dictionaryNumber, Model model) {
        String result = operWeb.delete(key, dictionaryNumber);
        model.addAttribute("message", result);
    }


    @GetMapping("/view")
    public String viewDictionary() {
        return "viewdict.html";
    }
}





/*
    private StringBuilder mapToSb(Map<String, String> hashMap) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue());
            if (++count < hashMap.size()) {
                sb.append("; ");
            }
        }
        return sb;
    }
*/
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