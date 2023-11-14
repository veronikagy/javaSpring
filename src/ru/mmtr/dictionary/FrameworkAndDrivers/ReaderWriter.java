package ru.mmtr.dictionary.FrameworkAndDrivers;

import org.springframework.stereotype.Repository;
import ru.mmtr.dictionary.Entitles.DictionaryFileEnum;
import ru.mmtr.dictionary.Exceptions.FileException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ReaderWriter implements FileDB {
    private static final String file = "C:\\Users\\veron\\IdeaProjects\\slovary\\src\\dictionary";

    private static String getFileName(DictionaryFileEnum fileNameEnum){
        int n = fileNameEnum.ordinal() +1;
        StringBuilder fileName = new StringBuilder(file+n);
        return String.valueOf(fileName);
    }

    @Override
    public Map<String,String> readInFile(DictionaryFileEnum fileNameEnum){
        Map<String,String> hashMap = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(getFileName(fileNameEnum)))) {
            String line;
            while((line=reader.readLine())!=null){
                String first = line.substring(0,line.indexOf(" "));
                String second = line.substring(line.indexOf(" ")+1);
                hashMap.put(first,second);
            }
        } catch (IOException k) {
            throw new FileException("Exception in writeInFile");
        }
        return hashMap;
    }

    @Override
    public void writeInFile(String key, String value, DictionaryFileEnum fileNameEnum){
        try(FileWriter writer = new FileWriter(getFileName(fileNameEnum),true)){
            writer.write("\n"+key+ " "+ value);

        }catch(IOException e) {
            throw new FileException("Exception in writeInFile");
        }
    }
    @Override
    public void writeAllInFile(Map<String,String> hashMap, DictionaryFileEnum fileNameEnum){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getFileName(fileNameEnum)))) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                writer.write(entry.getKey() + " "
                        + entry.getValue()+"\n");
            }
            writer.flush();
        } catch (IOException e) {
            throw new FileException("Exception in writeInFile");
        }
    }
}
