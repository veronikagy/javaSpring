package ru.mmtr.dictionary.Service;

import ru.mmtr.dictionary.FrameworkAndDrivers.FileDB;
import ru.mmtr.dictionary.FrameworkAndDrivers.ReaderWriter;

import java.util.HashMap;
import java.util.Map;

public class OperationDictionary2 extends OperationA {
        private static final String pattern = "[0-9]{5}";
        private static final String fileName = "C:\\Users\\veron\\IdeaProjects\\slovary\\src\\slovary2";

        private Map<String, String> hashMap;
        private FileDB readerWriter = new ReaderWriter();

        public String getFileName() {
            return fileName;
        }

        public OperationDictionary2() {                       //Правильно ли?
            this.hashMap = new HashMap<>();
            this.hashMap = readerWriter.readInFile(this.fileName);
        }

        @Override
        public void delete(String key) {
            if (!hashMap.containsKey(key)){
                System.out.println("Словарь не содержит такого слова.");
            }
            else {
                hashMap.remove(key);
                readerWriter.writeAllInFile( hashMap,fileName);
                System.out.println("Запись, ключ которой является " + key + ", успешно удалена.");
            }

        }

        @Override
        public void search(String key) {
            if (!hashMap.containsKey(key)){
                System.out.println("Словарь не содержит такого слова.");
            }else {
                String value = hashMap.get(key);
                System.out.println(key + " " + value);
            }
        }

        @Override
        public void addInFile(String key, String value) {
            if(key.matches(pattern)){
                readerWriter.writeInFile(key,value,fileName);
                System.out.println("Запись успешно добавлена.");
            }
            else {
                System.out.println("Неправильный ключ, ключ должен состоять из пяти цифр.");
            }
        }

}
