package dao;

import model.BloomFilter;
import model.Trie;

public interface WordDao {
    void insertWords(String filePath, Trie trie, BloomFilter bloomFilter) throws Exception;
}
