package main;

import trie.Trie;
import utilities.DataHelper;

public class RunApp {

    public static void main(String[] args) throws Exception {

        DataHelper helper = new DataHelper();
        Trie trie = Trie.getInstance();
        helper.readAllXmlFile("/home/cpu12457/Downloads/blogs", trie);

        InputUI inputUI = new InputUI(trie);

    }

}
