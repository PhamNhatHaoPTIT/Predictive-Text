package utilities;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;

public class DataHelper {

    public DataHelper() {

    }

    public String[] readAllXmlFile() throws Exception {
        String content = "";
        String filePath = "/home/haopn/Downloads/blogs";
        File folder = new File(filePath);
        File[] listOfFiles = folder.listFiles();

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        for(int i = 0; i < listOfFiles.length; i++) {
            String fileName = listOfFiles[i].getName();
            if(fileName.endsWith(".xml")) {
                Document doc = dBuilder.parse(listOfFiles[i]);
                doc.getDocumentElement().normalize();
                content += doc.getElementsByTagName("post").item(0).getTextContent();
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
