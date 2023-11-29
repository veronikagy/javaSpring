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
    public String dictPost(@RequestParam int dictionaryNumber,
                           @RequestParam(required = false) String key,
                           @RequestParam(required = false) String value,
                           @RequestParam(name = "search", required = false) String search,
                           @RequestParam(name = "add", required = false) String add,
                           @RequestParam(name = "delete", required = false) String delete,
                           Model model) {
        DictionaryFileEnum fileEnum = DictionaryFileEnum.resolveDictionaryNumber(dictionaryNumber);

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
    }

    @GetMapping("/view")
    public String viewDictionary() {
        return "viewdict.html";
    }
}
