package homework.fileAnalyzer;

import java.io.IOException;
import java.util.Map;

public class FileAnalyzerMain {
    public static void main(String[] args) throws IOException {
        String path = "/Users/garegintonoyan/Desktop/Java/Hello.txt";
        FileAnalyzer fa = new FileAnalyzer();

        System.out.println("======== totalWordCount");
        System.out.println(fa.totalWordCount(path));

        System.out.println("\n======== WordMap ===========");
        Map<String, Integer> mp = fa.wordMap(path);
        System.out.println(mp);

        System.out.println("\n======= uniqueWordCount ========");
        System.out.println(fa.uniqueWordCount(path));

        System.out.println("\n======= topFrequentWords =======");
        System.out.println(fa.topFrequentWords(path, 5));

        System.out.println("\n======= countWordOccurrences =====");
        System.out.println(fa.countWordOccurrences(path, "thea"));

    }
}
