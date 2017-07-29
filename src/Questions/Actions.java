package Questions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alvian
 */
public enum Actions {
    
    CONVERSATION(1, "HI.*"),
    COLLEGE_INFORMATION(2, "I WANT TO TALK ABOUT GUNADARMA");
    
    private final int id;
    private final String mainCommand;
    
    Actions (int id, String mainCommand) {
        this.id = id;
        this.mainCommand = mainCommand;
    }
    
    private int getId () {
        return id;
    }
    
    private String getMainCommand () {
        return mainCommand;
    }
    
    public static int shouldOpenAction (String command) {
        if (command.matches(Actions.CONVERSATION.getMainCommand())) { return Actions.CONVERSATION.getId();}
        if (command.matches(Actions.COLLEGE_INFORMATION.getMainCommand())) { return Actions.COLLEGE_INFORMATION.getId();}
        else {return 0;}
    }
    
    public static void runAction (int id, String command, int key) {
       if (id == Actions.CONVERSATION.getId() && id == key) {
           new Conversation().runResponse(command);
       }
       if (id == Actions.COLLEGE_INFORMATION.getId() && id == key) {
           new CollegeInformation().runResponse(command);
       }
    }
    
}
