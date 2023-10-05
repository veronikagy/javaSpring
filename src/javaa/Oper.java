package javaa;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Oper {

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private String fileName;

    public Oper(String fileName) {
        this.fileName = fileName;
    }

    public Map<String,String> readList(){
        Map<String,String> hashMap = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line=reader.readLine())!=null){
                String first = line.substring(0,line.indexOf(" "));
                String second = line.substring(line.indexOf(" ")+1);
                hashMap.put(first,second);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return hashMap;
    }

    public void delete(String key){
        Map<String,String> hashMap = readList();
        if (!hashMap.containsKey(key)){
            System.out.println("Словарь не содержит такого слова.");
        }
        else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (Map.Entry<String, String> entry :
                        hashMap.entrySet()) {
                    writer.write(entry.getKey() + " "
                            + entry.getValue());
                    writer.newLine();
                }
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Запись, ключ которой является " + key + ", успешно удалена.");
        }
    }


    public void poisk(String key){
        Map<String,String> hashMap = readList();
        String value = hashMap.get(key);
        System.out.println(key+" "+value);
    }
}
