package ru.mmtr.dictionary.Service;

import ru.mmtr.dictionary.FrameworkAndDrivers.FileDB;
import ru.mmtr.dictionary.FrameworkAndDrivers.ReaderWriter;

public class OperationA implements Operation {
    FileDB readerWriter = new ReaderWriter();
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }



    /*public Map<String,String> readList(){
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
    }*/

    /*@Override
    public void delete(String key){
        Map<String,String> hashMap = readList();
        if (!hashMap.containsKey(key)){
            System.out.println("Словарь не содержит такого слова.");
        }
        else {
            hashMap.remove(key);
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

    @Override
    public void poisk(String key){
        Map<String,String> hashMap = readList();
        //getOrDefault!!!!!
        if (!hashMap.containsKey(key)){
            System.out.println("Словарь не содержит такого слова.");
        }else {
            String value = hashMap.get(key);
            System.out.println(key + " " + value);
        }
    }*/

    @Override
    public void delete(String key) {

    }

    @Override
    public void search(String key) {

    }

    @Override
    public void addInFile(String key, String value) {

    }

   /* @Override
    public void addInFile(String key, String value){
        String regex;
        Pattern pattern;
        Matcher matcher;
        if (fileName.equals("C:\\Users\\veron\\IdeaProjects\\dictionary1\\src\\dictionary1")){
            regex = "[a-zA-Z]{4}";
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(key);
            if(matcher.matches()){
                add(key,value);
            }
            else {
                System.out.println("Неправильный ключ, ключ должен состоять из четырёх латинских букв.");
            }
        } else if (fileName.equals("C:\\Users\\veron\\IdeaProjects\\dictionary1\\src\\dictionary2")) {
            regex = "[0-9]{5}";
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(key);
            if(matcher.matches()){
                add(key,value);
            }
            else {
                System.out.println("Неправильный ключ, ключ должен состоять из пяти цифр.");
            }
        }
    }*/

    /*public void add(String key, String value){
        Map<String, String> hashMap  = readList();

        if (!hashMap.containsKey(key)){
            try(FileWriter writer = new FileWriter(fileName,true)){
                writer.write("\n");
                writer.write(key+ " "+ value);

            }catch(IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Пара добавлена.");
        }else {
            System.out.println("Такой ключ уже имеется.");
        }


    }*/
}
