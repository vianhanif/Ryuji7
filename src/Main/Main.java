/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Library.SpeechToText;
import Questions.CollegeInformation;
import Questions.Conversation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alvian
 */
public class Main {

    private static String 
            DICTIONARY_PATH = "/Users/alvian/Development/Java/NetBeansProjects/Ryuji7/2450.dic",
            LANGUAGE_MODEL_PATH = "/Users/alvian/Development/Java/NetBeansProjects/Ryuji7/2450.lm",
            ACOUSTIC_MODEL_PATH = "resource:/edu/cmu/sphinx/models/en-us/en-us";

    public static void main(String[] args) {
        SpeechToText speechToText = new SpeechToText(
                ACOUSTIC_MODEL_PATH, 
                DICTIONARY_PATH, 
                LANGUAGE_MODEL_PATH
        );
        speechToText.shouldUseActionId(true);
        speechToText.setResponses(new ArrayList(){{
            add(new Conversation().items());
            add(new CollegeInformation().items());
        }});
        speechToText.startRecognition();
    }
}
