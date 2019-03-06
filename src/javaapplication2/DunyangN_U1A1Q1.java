/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *Unit1 Assignment1 Question1
 *Dunyang Ni
 *25/02/2019
 *Write a program that plays rock scissors paper. 
 *The program randomly generates a number 0, 1, or 2 
 *representing rock, scissor, or paper. 
 *The program prompts the user to enter a number 0, 1, or 2 
 *and displays a message indicating whether the user or the computer won.
 */
import java.util.*;
public class DunyangN_U1A1Q1 {
    public static void main(String []args){
        Scanner input=new Scanner(System.in);// setting up variables and constants
        Boolean done=false;
        Random rand=new Random();
        String sc="scissor";//0 means scissor
        String ro="rock";//1 means rock
        String pa="paper";//2 means paper
        String win="You win!";
        String lose="You lose!";
        String draw="Draw";
        String wrong="The input is invalid";
        String answer;
        String yn;
        int result=10;//0 means lose,1 means draw,2 means win
        int random_choice_n;
        int your_choice_n=10;
        do{//loop for play it again
            System.out.println("Please enter one of 'scissor', 'rock','paper' or an integer:0(means scissor),1(means rock),2(means paper)");
            your_choice_n=10;
            answer="1";
            result=10;
            random_choice_n=rand.nextInt(3);//generate a random number
            if(input.hasNextInt()){//if the input is a integer
                your_choice_n=input.nextInt();
                answer=input.nextLine();//get the "/n" after the int
            }
            else if(input.hasNext()){//if the input is a string
                answer=input.nextLine();
                answer=answer.toLowerCase();
                if (answer.equals(sc)){//turn the choice into int
                    your_choice_n=0;
                }
                else if(answer.equals(ro)){
                    your_choice_n=1;
                }
                else if(answer.equals(pa)){
                    your_choice_n=2;
                }
                else{//or the input is unvalid
                    
                    your_choice_n=3;
                    
                }
            }
            
            switch(your_choice_n){
                case 0://if you choose scissor
                     switch(random_choice_n){
                         case 0: result=1;break;//computer choose scissor;draw
                         case 1: result=0;break;//computer choose rock;lose
                         case 2: result=2;break;//computer choose paper;win
                     }
                     break;
                case 1://if you choose rock
                     switch(random_choice_n){
                         case 0: result=2;break;//computer choose scissor;win
                         case 1: result=1;break;//computer choose rock;draw
                         case 2: result=0;break;//computer choose paper;lose
                     }
                     break;
                case 2://if you choose paper
                     switch(random_choice_n){
                         case 0: result=0;break;//computer choose scissor;lose
                         case 1: result=2;break;//computer choose rock;win
                         case 2: result=1;break;//computer choose paper;draw
                     }
                     break;
                default: result=3;break;
            }
            if (result != 3){//if the input is valid
            System.out.print("My choice is: ");//print the result
            switch(random_choice_n){
                case 0:System.out.println(sc);break;
                case 1:System.out.println(ro);break;
                case 2:System.out.println(pa);break;
            }}
            switch(result){
                case 0:System.out.println(lose);break;
                case 1:System.out.println(draw);break;
                case 2:System.out.println(win);break;
                case 3:System.out.println(wrong);break;
            }
            System.out.println("Do you want to try again? Enter 'yes','no' or 0(means no),1(means yes)");
            if(input.hasNextInt()){//if the input is a integer
                your_choice_n=input.nextInt();
                answer=input.nextLine();//get the "/n" after the int
                switch(your_choice_n){
                case 0:done=true;break;//done
                case 1:done=false;break;//continue
                default:System.out.println("Invalid input, and I think you don't want to try again.Bye!");
                    done=true;
                    break;
            }
            }
            else {//if the input is a string
                yn=input.nextLine();
                yn=yn.toLowerCase();
                if (yn.equals("yes")){//turn the choice into int 
                    done=false;
                }
                else if(yn.equals("no")){
                    done=true;
                }
                else{//or the input is unvalid
                    System.out.println("Invalid input, and I think you don't want to try again.Bye!");
                    done=true;
                }
            }
            
        }
        while(done==false);
    }
}
