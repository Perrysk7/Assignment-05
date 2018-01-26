package assignment5; 
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Parry Katodia
 */
public class A5Q3 {
    
    public boolean inLang(String word) {
        // create a character stack
        Stack<Character> stack = new Stack<>();
        
        // make a string for each side of the $
        String stackWord = "";
        String half = "";
        
        // look for $ in the string
        if(word.charAt(word.length()/2) != '$'){
            // if $ is not found in the middle ask for it to be put in the middle
            System.out.println("Please insert '$' in the middle");
            // then return false
            return false;
            // if $ is found in the middle
        }else{
            for (int i = 0; i < word.length()/2; i++) {
                // put the first half of the input into the stack
                stack.push(word.charAt(i));
            }
            for (int i = 0; i < word.length()/2; i++) {
                // move characters from the stack into the stackWord
                char c = stack.pop();
                // make the reverse version of the word
                stackWord += c;
            }
            for (int i = (word.length()/2)+1; i < word.length(); i++) {
                // put the second half into a string
                char c = word.charAt(i);
                half += c;
            }
            // put both sides of the $ together to see if they are the same
            // if they are not then return false and alert the user
            if(!half.equals(stackWord)){
                System.out.println("The first is not the same as the second one revered");
                return false;
                // otherwise return true and tell the user it is the same
            }else{
                System.out.println("The first is the same as the second one reversed!!");
                return true;
            }
        }
    }    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // test 
         A5Q3 test = new A5Q3();
        
        String word = "srac$cars";
        
        System.out.println(word + " = "+ test.inLang(word));
    }
    
}
