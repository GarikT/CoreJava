package homework.fileAnalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileAnalyzer {

    public Map<String, Integer> wordMap(String path) throws IOException {
        // Читаем файл, составляем мапу слово-количество и возвращаем ее
        Map<String, Integer> map = new HashMap<>();
        String[] words;
        boolean wordAdded = false;
        int count = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            String temp = bufferedReader.readLine().toLowerCase();
            while(temp != null) {
                words = temp.split("[,.\\s]+");
                for (String word : words) {
                    if(map.containsKey(word)) {
                        count = map.get(word);
                        map.remove(word);
                        map.put(word, Integer.valueOf(++count));
                    } else{
                        map.put(word, 1);
                    }

                }
                temp = bufferedReader.readLine();
                if(temp != null){
                    temp = temp.toLowerCase();
                }
            }
            return map;
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public int totalWordCount(String path) throws IOException {
        // Читаем файл, подсчитываем общее количество слов
        List<String> words = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            String temp = bufferedReader.readLine();
            while(temp != null) {
                words.addAll(new ArrayList<>(List.of(temp.split(" "))));
                temp = bufferedReader.readLine();
            }
            return words.size();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int uniqueWordCount(String path) throws IOException {
        // Читаем файл, подсчитываем количество уникальных слов
        Map<String, Integer> map;
        map = wordMap(path);
        int uniqueCount = 0;
        for (Integer value : map.values()) {
            if(value == 1){
                uniqueCount++;
            }
        }
        return uniqueCount;
    }

    public Map<String, Integer> topFrequentWords(String path, int n) throws IOException {
        // Читаем файл, находим топ-N часто встречающихся слов
        Map<String, Integer> map;
        map = wordMap(path);
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries,Comparator.comparing(Map.Entry::getValue));
        if(entries.size() > n){
            int startingIndex = entries.size() - n;
            List<Map.Entry<String, Integer>> frequentWords = entries.subList(startingIndex, entries.size());
            Map<String, Integer> result = new HashMap<>();
            for (Map.Entry<String, Integer> frequentWord : frequentWords) {
                result.put(frequentWord.getKey(), frequentWord.getValue());
            }
            return result;
        }else{
            return map;
        }
    }

    public int countWordOccurrences(String path, String word) throws IOException {
        // Читаем файл, находим количество вхождений слова и возвращаем это число
        Map<String, Integer> map;
        map = wordMap(path);
        return map.get(word);
    }

}
