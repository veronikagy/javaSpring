package ru.mmtr.dictionary.data.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.mmtr.dictionary.domain.DictionaryFileEnum;
import ru.mmtr.dictionary.exceptions.ReaderWriterException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

//dc
//kj
@Component
public class ReaderWriter implements FileDB {

    @Value("${file}")
    private String file;

    private String getFileName(DictionaryFileEnum fileNameEnum) {
        int n = fileNameEnum.getDictionaryNumber();
        return file + n;
    }

    @Override
    public Map<String, String> readInFile(DictionaryFileEnum fileNameEnum) {
        Map<String, String> hashMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(getFileName(fileNameEnum)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String first = line.substring(0, line.indexOf(" "));
                String second = line.substring(line.indexOf(" ") + 1);
                hashMap.put(first, second);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new ReaderWriterException("IndexOutOfBoundsException");
        } catch (FileNotFoundException e) {
            throw new ReaderWriterException("FileNotFoundException");
        } catch (IOException k) {
            throw new ReaderWriterException("Exception in writeInFile.");
        }
        return hashMap;
    }

    @Override
    public void writeInFile(String key, String value, DictionaryFileEnum fileNameEnum) {
        File f = new File(getFileName(fileNameEnum));
        try (FileWriter writer = new FileWriter(f, true)) {
            if (f.length() == 0) {
                writer.write(key + " " + value);
            } else {
                writer.write("\n" + key + " " + value);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new ReaderWriterException("IndexOutOfBoundsException");
        } catch (FileNotFoundException e) {
            throw new ReaderWriterException("FileNotFoundException");
        } catch (IOException e) {
            throw new ReaderWriterException("Exception in writeInFile");
        }
    }

    @Override
    public void writeAllInFile(Map<String, String> hashMap, DictionaryFileEnum fileNameEnum) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getFileName(fileNameEnum)))) {
            int count = 0;
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                writer.write(entry.getKey() + " "
                        + entry.getValue());
                if (++count < hashMap.size()) {
                    writer.write("\n");
                }
            }
            writer.flush();
        } catch (IndexOutOfBoundsException e) {
            throw new ReaderWriterException("IndexOutOfBoundsException");
        } catch (FileNotFoundException e) {
            throw new ReaderWriterException("FileNotFoundException");
        } catch (IOException e) {
            throw new ReaderWriterException("Exception in writeInFile");
        }
    }


}
