package Service;

import FrameworkAndDrivers.FileDB;
import FrameworkAndDrivers.ReaderWriter;

import java.util.HashMap;
import java.util.Map;

public class OperaziiSlovary2 extends OperaziiObshii{
        private static final String pattern = "[0-9]{5}";
        private Map<String, String> hashMap;
        private FileDB readerWriter = new ReaderWriter();

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }
        private String fileName = "C:\\Users\\veron\\IdeaProjects\\slovary\\src\\slovary2";

        public OperaziiSlovary2() {                       //Правильно ли?
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
        public void poisk(String key) {
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
