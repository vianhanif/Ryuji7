/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

/**
 *
 * @author jefri
 */
//Imports
import Questions.Actions;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ex094
 */
public class SpeechToText {
    
    private Configuration configuration;
    private LiveSpeechRecognizer liveSpeechRecognizer;
    private SpeechResult speechResult;
    private ArrayList<ArrayList> responses;
    private boolean useActionId = false;
    private int actionId = 0;
    
    
    public SpeechToText (String acousticModelPath, String dictionaryPath, String languageModel) {
        configuration = new Configuration();
        configuration.setAcousticModelPath(acousticModelPath);
        configuration.setDictionaryPath(dictionaryPath);
        configuration.setLanguageModelPath(languageModel);
        responses = new ArrayList();
    }
    
    public void setResponses (List<ArrayList<ArrayList>> _responses) {
        for (int i = 0; i < _responses.size(); i++) {
            for (int j = 0; j < _responses.get(i).size(); j++) {
                responses.add(_responses.get(i).get(j));
            }
        }
    }
    
    public void shouldUseActionId (boolean should) {
        useActionId = should;
    }
    
    public void startRecognition () {
        try {
            liveSpeechRecognizer = new LiveSpeechRecognizer(configuration);
            liveSpeechRecognizer.startRecognition(true);            
            while ((speechResult = liveSpeechRecognizer.getResult()) != null) {
               String command = speechResult.getHypothesis();
                checkResponse(command);
            }
        } catch (IOException e) {
            
        }
    }
    
    public void checkResponse (String command) {
        for (int i = 0; i < responses.size(); i++) {
            int id = Integer.parseInt(responses.get(i).get(2).toString());
            int getActionId = Actions.shouldOpenAction(command);
            if (getActionId > 0) {actionId = getActionId;}
            if (useActionId) {Actions.runAction(id, command, actionId);}
        }
    }
}
