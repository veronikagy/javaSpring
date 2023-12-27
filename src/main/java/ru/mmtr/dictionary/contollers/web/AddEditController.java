package ru.mmtr.dictionary.contollers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mmtr.dictionary.domain.DictionaryFileEnum;
import ru.mmtr.dictionary.service.logic.OperationDictionaryWeb;

@Controller
public class AddEditController {
    private final OperationDictionaryWeb operWeb;

    @Autowired
    public AddEditController(OperationDictionaryWeb operWeb) {
        this.operWeb = operWeb;
    }

    @GetMapping("/addEdit")
    public String myMain() {
        return "addEdit.html";
    }

    @PostMapping("/addEdit")
    public String myMainPost(@RequestParam(name = "answer", required = false) String selectedValue,
                             @RequestParam(required = false) String key,
                             @RequestParam(required = false) String value,
                             @RequestParam(name = "add", required = false) String add,
                             @RequestParam(name = "delete", required = false) String delete,
                             @RequestParam(name = "edit", required = false) String edit,
                             Model model) {
        if (selectedValue == null) {
            model.addAttribute("message", "Выберите словарь.");
        } else {
            Integer dictionaryNumber = mapSelectedValueToEnum(selectedValue);

            if (add != null) {
                addAction(key, value, DictionaryFileEnum.resolveDictionaryNumber(dictionaryNumber), model);
            }
            if (delete != null) {
                deleteAction(key, DictionaryFileEnum.resolveDictionaryNumber(dictionaryNumber), model);
            }
            if (edit != null) {
                editAction(key, value, DictionaryFileEnum.resolveDictionaryNumber(dictionaryNumber), model);
            }
        }
        return "addEdit.html";
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

    private void addAction(String key, String value, DictionaryFileEnum dictionaryNumber, Model model) {
        if (key == null || !dictionaryNumber.getDictionaryPattern().verification(key)) {
            model.addAttribute("message", "Неправильный ключ.");
        } else {
            String result = operWeb.addInFile(key, value, dictionaryNumber);
            model.addAttribute("message", result);
        }
    }

    private void deleteAction(String key, DictionaryFileEnum dictionaryNumber, Model model) {
        if (key == null || !dictionaryNumber.getDictionaryPattern().verification(key)) {
            model.addAttribute("message", "Неправильный ключ.");
        } else {
            String result = operWeb.delete(key, dictionaryNumber);
            model.addAttribute("message", result);
        }
    }

    private void editAction(String key, String value, DictionaryFileEnum dictionaryNumber, Model model) {
        if (key == null || !dictionaryNumber.getDictionaryPattern().verification(key)) {
            model.addAttribute("message", "Неправильный ключ.");
        } else {
            String result = operWeb.edit(key, value, dictionaryNumber);
            model.addAttribute("message", result);
        }
    }
}
