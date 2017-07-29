/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions;

import Library.TextToSpeech;
import java.util.ArrayList;

/**
 *
 * @author alvian
 */
public class Conversation {
    
    private int CODE = 1;
    private String MAIN_COMMAND = "Hi.*";
    private String[][] DATA = new String[][]{
        {MAIN_COMMAND, "HELLO TOO"},
        {"HELLO.*", "HELLO TOO"},
        {"CAN YOU HELP.*", "WHAT CAN I DO FOR YOU ?"},
        {"THANKS.*", "YOUR WELCOME"},
        {"THANKYOU.*", "YOUR WELCOME"},
        {".*NICE TO MEET YOU.*", "NICE TO MEET YOU TOO"}
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
        for (int i = 0; i < DATA.length; i++) {
            if (command.matches(DATA[i][0])) {
                System.out.println("command : " + command);
                System.out.println("answer : " + DATA[i][1]);
                textToSpeech.speak(DATA[i][1]);
            }
        }
    }
}