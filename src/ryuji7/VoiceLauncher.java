/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryuji7;

/**
 *
 * @author jefri
 */
//Imports
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;
 
/**
 *
 * @author ex094
 */
public class VoiceLauncher {
    public static void main(String[] args) throws IOException {
        // Configuration Object
        Configuration configuration = new Configuration();
 
        // Set path to the acoustic model.
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        // Set path to the dictionary.
        configuration.setDictionaryPath("/home/jefri/NetBeansProjects/Ryuji7/2450.dic");
        // Set path to the language model.
        configuration.setLanguageModelPath("/home/jefri/NetBeansProjects/Ryuji7/2450.lm");
        
         LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(configuration);
 
        //Start Recognition Process (The bool parameter clears the previous cache if true)
        recognize.startRecognition(true);
        
        //Create SpeechResult Object
        //Start Recognition Process (The bool parameter clears the previous cache if true)
        recognize.startRecognition(true);
 
        //Creating SpeechResult object
        SpeechResult result;
 
        //Check if recognizer recognized the speech
        while ((result = recognize.getResult()) != null) {
 
            //Get the recognized speech
            String command = result.getHypothesis();
            String work = null;
            Process p;
 
            if(command.equalsIgnoreCase("open file manager")) {
                work = "nautilus";
            } else if (command.equalsIgnoreCase("close file manager")) {
                work = "pkill nautilus";
            } else if (command.equalsIgnoreCase("open browser")) {
                work = "google-chrome";
            } else if (command.equalsIgnoreCase("close browser")) {
                work = "pkill google-chrome";
            }
            //In case command recognized is none of the above hence work might be null
            if(work != null) {
                //Execute the command
                p = Runtime.getRuntime().exec(work);
            }
        }
        
      }
 
}