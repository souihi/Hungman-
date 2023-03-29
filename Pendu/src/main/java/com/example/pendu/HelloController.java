package com.example.pendu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField guess;

    @FXML
    private Text hangmanTextArea;

    @FXML
    private Text textForWord;
    private String word;
    private final StringBuilder secretWord = new StringBuilder();

    ArrayList<String> hangmanLives = new ArrayList<>(Arrays.asList(

            """
                =========
                    """,
            """
                    |        
                    |
                    |
                    |
                    |
                =========     """,

            """
              ------|        
                    |
                    |
                    |
                    |
                =========   
                    """,
            """
                 |------|        
                 |      |
                        |
                        |
                        |
                    =========      
                    """,
            """
                 |------|        
                 |      |
                 o      |
                        |
                        |
                    =========   
                    """,
            """
                 |------|        
                 |      |
                 o      |
                 |      |
                        |
                    =========  """,
            """
                 |------|        
                 |      |
                 o      |
                 |\\    |
                        |
                    =========   """,
            """
                |------|        
                |      |
                o      |
              //|\\    |
                       |
                   =========    """,
            """
                      |------|        
                      |      |
                      o      |
                    //|\\    |
                       \\    |
                         =========   """,
            """
                      |------|        
                      |      |
                      o      |
                    //|\\    |
                    // \\    |
                         ========= """
    ))  ;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hangmanTextArea.setText(hangmanLives.get(5));
    }

    @FXML
    void getTextInput(ActionEvent event) {
        if (word == null){
            word = guess.getText();
            setupWord();
            guess.clear();
        }else{
            playTurn();
            System.out.println("Playing");
        }
    }

    public void setupWord(){
        int wordLenght = word.length();

        for (int i = 0; i < wordLenght; i++) {
            secretWord.append("*");
        }
        textForWord.setText(String.valueOf(secretWord));
    }

    public void playTurn(){
        String guess = this.guess.getText();
        ArrayList<Integer> position = new ArrayList<>();
        char[] wordChars = word.toCharArray();

        if (word.equals(guess)){
            System.out.println("Winn");
            return;
        }
        if (word.contains(guess)){
            for (int i = 0; i < word.length(); i++) {
                wordChars[0] = guess.charAt(0);
            }
        }
    }
}
