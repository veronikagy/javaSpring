package FrameworkAndDrivers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReaderWriter implements FileDB {
    public Map<String,String> hashMap = new HashMap<>();

    @Override
    public Map<String,String> readInFile(String fileName){
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

    @Override
    public void writeInFile(String key, String value, String fileName){
        try(FileWriter writer = new FileWriter(fileName,true)){
            writer.write("\n");
            writer.write(key+ " "+ value);

        }catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
