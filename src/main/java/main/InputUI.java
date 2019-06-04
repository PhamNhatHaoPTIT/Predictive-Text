package main;

import org.apache.commons.lang.StringUtils;
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
        setSize(470, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txt_input.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                if(!txt_input.getText().equals("")) {

                    ArrayList<String> tmp = new ArrayList<String>();      // reset JList
                    tmp.add("");
                    words.setListData(tmp.toArray());

                    ArrayList<String> result = new ArrayList<String>();
                    TrieNode temp = trie.searchNode(trie.getRoot(), txt_input.getText());

                    if( temp != null ) {                            // found word in trie
                        trie.getAllWordsInNode(result, temp, txt_input.getText(), "");
                        words.setListData(result.toArray());
                    }

                } else {
                    ArrayList<String> result = new ArrayList<String>();   // reset JList
                    result.add("");
                    words.setListData(result.toArray());
                }
            }

        });
        words.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                String selectedValue = (String) words.getSelectedValue();
                if(trie.search(trie.getRoot(), selectedValue) != false) {
                    JOptionPane.showMessageDialog(main_panel, "Word found");
                }
            }
        });
        btn_search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                String word = txt_input.getText();
                if(trie.search(trie.getRoot(), word) == false) {
                    JOptionPane.showMessageDialog(main_panel, "Word not found");
                } else {
                    JOptionPane.showMessageDialog(main_panel, "Word found");
                }
            }
        });
    }

    private JPanel main_panel;
    private JTextField txt_input;
    private JList words;
    private JButton btn_search;
}
