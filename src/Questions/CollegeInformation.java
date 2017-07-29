/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions;

import Library.TagMatch;
import Library.TextToSpeech;
import java.util.ArrayList;

/**
 *
 * @author alvian
 */
public class CollegeInformation {
    
    private int CODE = 1;
    private int ACCURACY = 1;
    private String DATA_PATH = "/base-data/";
    private String MAIN_COMMAND = "I WANT TO TALK ABOUT GUNADARMA";
    private String[][] DATA = new String[][]{
        {MAIN_COMMAND, "OKAY"},
        {"WHAT IS THE VISION OF GUNADARMA UNIVERSITY", "WHAT"},
        {"WHAT IS THE MEANING OF GUNADARMA", "WHAT"},
        {"WHAT DEFINES GUNADARMA", "WHAT"},
        {"WHAT IS THE MISSION OF GUNADARMA", "WHAT"},
        {"WHAT ARE GUNADARMA ACTIVITIES", "WHAT"},
        {"WHEN DID GUNADARMA UNIVERSITY GOT LISTED", "WHEN"},
        {"WHEN DID GUNADARMA UNIVERSITY GOT WQUALIZED", "WHEN"},
        {"WHERE WAS GUNADARMA FIRST LOCATED", "WHERE"},
        {"HOW DID GUNADARMA FIRSTLY LOCATED", "HOW"},
        {"HOW DID GUNADARMA NAME CHOSEN", "HOW"},
        {"HOW DID GUNADARMA BUILD", "HOW"},
        {"HOW DID GUNADARMA FIRST FOUNDED", "HOW"}
    };
    
    public ArrayList items(){
        ArrayList<ArrayList> items = new ArrayList();
        for(int i=0;i<DATA.length;i++){
            ArrayList item = new ArrayList();
            item.add(DATA[i][0]);
            item.add(DATA[i][1]);   
            item.add(1);
            items.add(item);
        }
        return items;
    }
    
    public void runResponse (String command) {
        TextToSpeech textToSpeech = new TextToSpeech();
        TagMatch matchers = new TagMatch();
        matchers.setDataSet(DATA_PATH);
        String[] tags = command.split(" ");
        for (int i = 0; i < DATA.length; i++) {
            if (command.matches(MAIN_COMMAND)) {
                textToSpeech.speak(DATA[i][1]);
            } else {
                if (command.matches(DATA[i][0])) {
                    System.out.println("command : " + command);
                    String response = matchers.getMatch(ACCURACY, DATA[i][1], tags);
                    if (response != null && response != "null") {
                        System.out.println("answer : " + response);
                        textToSpeech.speak(response);
                    }
                }
            }
        }
    }
}
