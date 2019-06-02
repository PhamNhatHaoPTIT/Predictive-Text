package main;

import trie.Trie;
import trie.TrieNode;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class InputUI extends JFrame {

    public InputUI(final Trie trie) {
        add(main_panel);
        setTitle("Predictive Text");
        setVisible(true);
        setSize(450, 400);
        txt_output.setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txt_input.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                if(!txt_input.getText().equals("")) {
                    txt_output.setText("");
                    ArrayList<String> result = new ArrayList<String>();
                    if( trie.searchNode(trie.getRoot(), txt_input.getText()) != null ) {
                        txt_output.setVisible(true);
                        TrieNode temp = trie.searchNode(trie.getRoot(), txt_input.getText());
                        trie.printAllWords(result, temp, txt_input.getText(), "");
                        for(int i = 0; i < result.size(); i++) {
                            txt_output.append(result.get(i) + "\n");
                        }
                    }
                } else {
                    txt_output.setText("");
                    txt_output.setVisible(false);
                }
            }
        });
    }

    private JPanel main_panel;
    private JTextField txt_input;
    private JTextArea txt_output;
}
