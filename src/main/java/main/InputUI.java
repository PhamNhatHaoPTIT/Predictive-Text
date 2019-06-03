package main;

import trie.Trie;
import trie.TrieNode;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InputUI extends JFrame {

    public InputUI(final Trie trie) {
        add(main_panel);
        setTitle("Predictive Text");
        setVisible(true);
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txt_input.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                if(!txt_input.getText().equals("")) {
                    ArrayList<String> tmp = new ArrayList<String>();
                    tmp.add("");
                    words.setListData(tmp.toArray());
                    ArrayList<String> result = new ArrayList<String>();
                    if( trie.searchNode(trie.getRoot(), txt_input.getText()) != null ) {
                        TrieNode temp = trie.searchNode(trie.getRoot(), txt_input.getText());
                        trie.printAllWords(result, temp, txt_input.getText(), "");
                        words.setListData(result.toArray());
                    }
                } else {
                    ArrayList<String> result = new ArrayList<String>();
                    result.add("");
                    words.setListData(result.toArray());
                }
            }

        });
    }

    private JPanel main_panel;
    private JTextField txt_input;
    private JList words;
}
