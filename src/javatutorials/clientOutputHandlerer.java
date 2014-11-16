/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javatutorials;

/**
 *
 * @author kride
 */
class clientOutputHandlerer {

    private static String handleWithCorrespondingStage(String input) {
        if(input.equals("Bye")){
            return "Bye.";
        }
        return input.toUpperCase();
    }

    private int stage;

    public clientOutputHandlerer() {
        this.stage = 0;
    }
    
    
    
    static String handle(String inputLine) {
         return handleWithCorrespondingStage(inputLine);
    }
    
}
