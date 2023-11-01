package ru.mmtr.dictionary.FrameworkAndDrivers;

import ru.mmtr.dictionary.Entitles.DictionaryFileEnum;
import ru.mmtr.dictionary.Exceptions.FileException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReaderWriter implements FileDB {
    private Map<String,String> hashMap = new HashMap<>();//final
    private static StringBuilder fileName;

    private static String getFileName(DictionaryFileEnum fileNameEnum){
        int n = fileNameEnum.ordinal() +1;
        fileName = new StringBuilder("C:\\Users\\veron\\IdeaProjects\\slovary\\src\\dictionary"+n);
        return String.valueOf(fileName);
    }

    @Override
    public Map<String,String> readInFile(DictionaryFileEnum fileNameEnum){
        try(BufferedReader reader = new BufferedReader(new FileReader(getFileName(fileNameEnum)))) {
            String line;
            while((line=reader.readLine())!=null){
                String first = line.substring(0,line.indexOf(" "));
                String second = line.substring(line.indexOf(" ")+1);
                hashMap.put(first,second);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
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
                //writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            throw new FileException("Exception in writeInFile");
        }
    }
}
