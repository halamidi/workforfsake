/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package technologyapp;

/**
 *
 * @author Hassan Al-Amidi, Stephen kearns, Patrick Kelly, Sean Maguire
 */
import javax.swing.*;
import java.util.Random;
import java.util.Arrays;


public class Quiz {
    protected String [] question;
    protected String [] randomizedQuestion;
    protected String anwser,temp, temp2;
    private String [] userAnswer;
    protected String[] correctAnswer;
    protected int correct, incorrect,randQuestion,index,temp1;
    protected int chosenquestions[];
    protected Random rand;
    //set as integer because integer is different to int as it may contain null where as int cannot
    private Integer a;
     //only used in the process of checking if the chosen random question has already been asked
    //i am using this value for checking because the process requires the array to be rearranged their for making my validation process invalid
     private int[] binarysort;
    
    public Quiz(){
        //question should be filled with 20 questions to maxmise the scope corvered and also to not repeat the same questions
        question = new String[]{"b","yes","maybe","n","v","a","sdf","sd","sg","hgf","ko","ui","nmxc","oid","hf","skdj","sr","df","cv","hj"};
        userAnswer = new String[10];
        // this should be also filled with 20 anwsers
       // also more correct anwser should be addedd to maxinmise the number of coorect anwser's
        correctAnswer = new String[]{"b","yes","maybe","n","v","a","sdf","sd","sg","hgf","ko","ui","nmxc","oid","hf","skdj","sr","df","cv","hj"};
        correct = 0;
        temp = "";
        temp2 = "";
        incorrect = 0;
        rand = new Random();
        chosenquestions = new int[10];
        randomizedQuestion = new String[10];
        anwser = "";
        //index = 18;
        index = 19;
        a = null;
        binarysort = new int[10];
        
    }
    // Choses a random question from the array 
    public String[] choseRandomQuestion(){
       
          for(int counter = 0; counter < 10; counter++){
            //saves the values of the question going to be asked
            //values being declared inside loop as they are not needed outside loop there for they will not be there outside of the loop
              int i = 0;
              //temp claims its not being used because it cannot see inside the do while loop
              int temp = 0;
              int tempbin = 0;
              temp = rand.nextInt(20);
             
            do{
                //using if statement because i doesnt seem to reset out side of if statement there for same questions are being asked
                if(i != 0){
                i= 0;
                }
                
                tempbin = -1;
                
               
                
                //tempbin not needed outside array. for if statement to see if question alrady exsists more explained next time its used
                
                //this will run only once during the entirety of both loops as this is to only put first value in the array 
                if(a == null && counter == 0){
                a = 1;
                i=1;
                binarysort[counter] = temp;
                temp = rand.nextInt(20);
                chosenquestions[counter] = temp;
                randomizedQuestion[counter] = question[chosenquestions[counter]];
                //JOptionPane.showMessageDialog(null,"one time");
                }
                else{
                //getting binarysort ready for checking 
                Arrays.sort(binarysort);
                //cheking binarysort to see if value of temp alrady exsits if it exsists the value in tempbin will be a positive number
                //if value does not exsist then value in tempbin will be negitive
                tempbin = Arrays.binarySearch(binarysort,temp);
                
               
                //if value of tempbin is negitive the question will be put into the question list to ask user. if value is positive question will be chosen again
                JOptionPane.showMessageDialog(null,"test" + tempbin + " " +  Arrays.toString(chosenquestions) + Arrays.toString(binarysort) + " " + temp);
                if(tempbin < 0){
                    binarysort[counter] = temp;
                    //JOptionPane.showMessageDialog(null,"test" + tempbin + " " +  chosenquestions + " " + temp);
                    //number stored in temp will be stored in chosenquestion array for checking if user input matches later on
                    chosenquestions[counter] = temp;
                    //number in chosenquestions[index number is in] will tell question where the question wanted is stored then the question is stored in randomizedQuestion
                    randomizedQuestion[counter] = question[chosenquestions[counter]];
                    //sets i to 1 to end loop
                    i = 1;
                }
                else if(tempbin >= 0){
                    //picks new question and stores question in temp
                    temp = rand.nextInt(20);
                    //sets i to 0 to re-run loop and check if chosen question is already in array
                    i = 0;
                }
                else{
                    //error checking
                JOptionPane.showMessageDialog(null,"something went wrong");
                }
                }
                JOptionPane.showMessageDialog(null, i);
            }while(i != 1);
            } // end of loop  
            //returns value to ask user questions
        return randomizedQuestion;
        
    }

    public void setAnswer(String[] userAnswer) {
        //sets userAnswer to check if they were correct or incorrect
        this.userAnswer = userAnswer;
        
    }
    
    //working !!
    // checks through all of the anwsers 
    // to see if the user choice entered
    // is corrected 
    public void checkAnwsers(){
        //loop checks all 10 questions
        for(int counter = 0; counter < 10; counter++){
            //stores user answer in temp
            temp = userAnswer[counter];
            //stores question related to answer in temp1 used to find what index of correctanswer the answer is in
            temp1 = chosenquestions[counter];
            //stores the correct answer in temp2
            temp2 = correctAnswer[temp1];
            JOptionPane.showMessageDialog(null,"test temp 2 = " + temp2+ " temp =" + temp + " userans = " + userAnswer[counter] + "chosenquestion =" + chosenquestions[counter]);
        //if temp is equal to temp2 then the value of correct will be increased by one if they are not equal then the value in incorrect will increase by one
        if(temp.equalsIgnoreCase(temp2)){
        correct++;
        }
        else if(!temp.equalsIgnoreCase(temp2)){
        incorrect++;
        }
        else{
            //error checking( this error cheking is not needed because if something goes wrong like no value entered into one of the values the program crashes)
        JOptionPane.showMessageDialog(null,"something went wrong with corrections");
        }
        }
    }
    //returns the amount of times the user inputted the correct answer
     public int getcorrect(){
     return correct;
     }
     //returns the amount of times the user inputted the incorrect answer
     public int getIncorrect(){
     return incorrect;
     
     }
    
}
  