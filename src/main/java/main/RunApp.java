package main;

import trie.Trie;
import trie.TrieNode;
import utilities.DataHelper;

import javax.swing.*;

public class RunApp {

    public static void main(String[] args) throws Exception {

        DataHelper helper = new DataHelper();
        String[] keys = helper.readAllXmlFile("/home/cpu12457/Downloads/blogs");

        Trie trie = Trie.getInstance();

        for(int i = 0; i < keys.length; i++) {
            trie.insert(keys[i]);
        }

        InputUI inputUI = new InputUI(trie);
    }

}
