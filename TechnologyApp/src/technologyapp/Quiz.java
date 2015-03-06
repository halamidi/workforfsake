/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analogsection;

/**
 *
 * @author Stephen kearns 
 */
import javax.swing.*;
import java.util.Random;


public class Quiz {
    protected String [] question;
    protected String randomizedQuestion;
    protected String userAnwser,anwser;
    protected String[] correctAnwser;
    protected int correct, incorrect,randQuestion,index;
    protected Random rand;
    
    
    public Quiz(){
        //question should be filled with 20 questions to maxmise the scope corvered and also to not repeat the same questions
        question = new String[]{"no","yes","maybe","2","£","4","6","7","8","9","10","11","12","13","14","9","1","2","3","6"};
        userAnwser = "";
        // this should be also filled with 20 anwsers
       // also more correct anwser should be addedd to maxinmise the number of coorect anwser's
        correctAnwser = new String[]{"nope","of course","perhaps"};
        correct = 0;
        incorrect = 0;
        rand = new Random();
        anwser = "";
        //index = 18;
        index = 19;
        
    }
    // Choses a random question from the array 
    public String choseRandomQuestion(){
        /*randQuestion = rand.nextInt(question.length);
        randomizedQuestion = question[randQuestion];
        //will have to put in a checker to make sure that a certing question isnt repeated 
        //algoritim:
        //chose random index with rquestion 
        // store question in last index of the array
        // chose an random array in the index of aaray length -1
        // question will not be reapeted 
        question[19] = randomizedQuestion;
        return randomizedQuestion;*/
          for(int counter = 0; counter < 11; counter++){
            
            randQuestion = rand.nextInt(question.length-counter);
            randomizedQuestion = question[randQuestion];
            
            question[index] = randomizedQuestion;
            index--;
            break;
            } // end of loop  
        
        return randomizedQuestion;
        
    }

    public void setAnwser(String anwser) {
        this.userAnwser = anwser;
    }
    
    //working !!
    // checks through all of the anwsers 
    // to see if the user choice entered
    // is corrected 
    public String checkAnwsers(){
        
      for(int counter = 0; counter < correctAnwser.length; counter++){
          anwser = correctAnwser[counter];
       
          if(anwser.equals(userAnwser)){
              break;
          }
       }
      
       
        return anwser;
    }
    
    public String dontChoseExistQuestion(){
        //could do the whole of the chose a random question in a loop
        // i.e the counter could start at say 1 then when your have stored the 
        //the random question in the last index in the array you could then,
        // chose a random index in the range of array.length - counter;
        // this will prevent the same question from being chosen a multiple of times.
       // int index = 19;
        for(int counter = 1; counter < 11; counter++){
            
            randQuestion = rand.nextInt(question.length-counter);
            randomizedQuestion = question[randQuestion];
            
            question[index] = randomizedQuestion;
            index--;
            break;
            } // end of loop 
        
        return randomizedQuestion;
        
        
    }
    public void compute(){
        
        if(userAnwser.equals(checkAnwsers())){
            correct++;
        }
        else{
            incorrect++;
        }
    }

    public int getCorrect() {
        return correct;
    }

    public int getIncorrect() {
        return incorrect;
    }
    
    
    
}
