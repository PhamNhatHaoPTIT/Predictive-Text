package main;

import dao.WordDao;
import dao.impl.WordDaoImpl;
import model.BloomFilter;
import model.Trie;
import view.InputUI;

public class RunApp {

    public static void main(String[] args) throws Exception {

        Trie trie = Trie.getInstance();
        BloomFilter bloomFilter = new BloomFilter(28, 8);
        WordDao wordDao = new WordDaoImpl();
        wordDao.insertWords("/home/cpu12457/Downloads/blog", trie, bloomFilter);
        InputUI inputUI = new InputUI(trie, bloomFilter);

    }

}
