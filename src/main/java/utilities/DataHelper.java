package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

public class DataHelper {

    public DataHelper() {

    }

    public String[] readAllXmlFile(String filePath) throws Exception {
        String content = "";
        File folder = new File(filePath);
        File[] listOfFiles = folder.listFiles();

        for(int i = 0; i < listOfFiles.length; i++) {
            String fileName = listOfFiles[i].getName();
            if(fileName.endsWith(".xml")) {
                BufferedReader br = new BufferedReader(new FileReader(listOfFiles[i]));
                String st;
                while ((st = br.readLine()) != null) {
                    content += st;
                }

                Pattern pattern = Pattern.compile("<post>(.*?)</post>");
                Matcher matcher = pattern.matcher(content);
                while (matcher.find()) {
                    content += matcher.group(1);
                }

            }
        }

        content = content.replace(".", " ")
                            .replace(",", " ")
                            .replace("?", " ")
                            .replace("!", " ")
                            .replace(":", " ")
                            .replace("&", " ")
                            .replace("\n", " ")
                            .replace("\t", " ")
                            .replace("'", "")
                            .replace("\\s+", " ")
                            .replace("(", " ")
                            .replace(")", " ")
                            .replace("/", " ")
                            .replace("+", " ")
                            .replace("=", " ")
                            .replace("_", " ")
                            .replace("%", " ")
                            .replace("^", " ")
                            .replace("*", " ")
                            .replace("|", " ")
                            .replace("[", " ")
                            .replace("]", " ")
                            .replace("{", " ")
                            .replace("}", " ")
                            .replace(">", " ")
                            .replace("<", " ")
                            .replace(" - ", " ")
                            .replace("\"", " ");

        String[] words = content.split("\\s+");
        for(int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
        }
        return words;
    }

}
