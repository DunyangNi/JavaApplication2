package DunyangN_U1A1Q3;

/**
 *Unit1 Assignment1 Question3
 *Dunyang Ni
 *01/03/2019
 *write a program for the dice game craps.
 *Check the sum of the two dice. If the sum is 2,3,, or 12 (called craps), you lose. 
 *If the sum is 7 or 11 (called natural), you win.
 *If the sum is another value (i.e., 4,5,6,8,9, or 10.), a point is awarded. 
 *Continue to roll the dice until either a 7 or the same point value is rolled. 
 *If a 7 is rolled, you lose. Otherwise you win.
 */
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.JFrame;
public class DunyangN_U1A1Q3 extends JFrame{//setting up variables
    private JButton roll;//the confirmation button
    private JButton restart;//the restart button 
    private JButton start;//the Start button
    private JPanel p1;//panels
    private JPanel p2;
    private JLabel l1,l3,l4,l5,l6;//labels
    private JLabel l2;
    private JLabel pl1;//picture label 1
    private JLabel pl2;//picture label 2
    private Font f = new Font("Arial",0,20);//fonts for results
    private Font f2 = new Font("Arial",0,12);//fonts for instruction
    ImageIcon one=new ImageIcon("H:\\NetBeansProjects\\JavaApplication2\\src\\DunyangN_U1A1Q3\\Dice-1.jpg");//import images
    ImageIcon two=new ImageIcon("H:\\NetBeansProjects\\JavaApplication2\\src\\DunyangN_U1A1Q3\\Dice-2.jpg");
    ImageIcon three=new ImageIcon("H:\\NetBeansProjects\\JavaApplication2\\src\\DunyangN_U1A1Q3\\Dice-3.jpg");
    ImageIcon four=new ImageIcon("H:\\NetBeansProjects\\JavaApplication2\\src\\DunyangN_U1A1Q3\\Dice-4.jpg");
    ImageIcon five=new ImageIcon("H:\\NetBeansProjects\\JavaApplication2\\src\\DunyangN_U1A1Q3\\Dice-5.jpg");
    ImageIcon six=new ImageIcon("H:\\NetBeansProjects\\JavaApplication2\\src\\DunyangN_U1A1Q3\\Dice-6.jpg");
    int point,sum;
    int dice1,dice2;
    private String pt;
    Random rand1=new Random();
    Random rand2=new Random();
    public DunyangN_U1A1Q3(){//constructor
        setLayout(new GridLayout(2,1, 5, 5));//divide the window into two part
        p1=new JPanel(null);//initialize variables
        p2=new JPanel(null);
        roll=new JButton("roll");
        restart=new JButton("restart");
        start=new JButton("Start");
        l1=new JLabel("Roll 2 dice. If the sum is 2,3,or 12, you lose.");//Instruction
        l3=new JLabel(" If the sum is 7 or 11, you win.");
        l2=new JLabel("If the sum is another value , a point is awarded.");
        l4=new JLabel("Continue to roll the dice until either a 7 ");
        l5=new JLabel("or the same point value is rolled.");
        l6=new JLabel("If a 7 is rolled, you lose. Otherwise you win.");
        pl1=new JLabel("");pl2=new JLabel("");p1.add(pl1);p1.add(pl2);
        start.setBounds(145,35,185,60);
        roll.setBounds(145,55,185,80);
        restart.setBounds(145,45,185,60);
        mylistener ml=new mylistener();//add the actionlistener to buttons
        roll.addActionListener(ml);
        restart.addActionListener(ml);
        start.addActionListener(ml);
        l1.setBounds(85,45,265,90);//set locations for instruction labels
        l3.setBounds(85,55,265,100);
        l2.setBounds(85,65,265,115);
        l4.setBounds(85,75,305,130);
        l5.setBounds(85,85,265,145);
        l6.setBounds(85,95,265,160);
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(l4);
        p1.add(l5);
        p2.add(start);//add the start button to panel
        add(p1);//add panels to the window
        add(p2);
    }
    private class mylistener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String bn=e.getActionCommand();
            if("Start".equals(bn)){//if "start" is pressed
                p1.remove(l1);//clear the screen
                p1.remove(l2);
                p1.remove(l3);
                p1.remove(l4);
                p1.remove(l5);
                p2.remove(start);
                p2.add(roll);//add the button"roll'
                validate();
                repaint();
            }
            else if("roll".equals(bn)){
                sum=0;
                p1.remove(pl1);
                p1.remove(pl2);
                dice1=rand1.nextInt(6)+1;//get the values of two dices and calculate the sum
                dice2=rand1.nextInt(6)+1;
                sum=dice1+dice2;
                switch(dice1){//display graphs for two dices
                    case 1:pl1=new JLabel(one);break;
                    case 2:pl1=new JLabel(two);break;
                    case 3:pl1=new JLabel(three);break;
                    case 4:pl1=new JLabel(four);break;
                    case 5:pl1=new JLabel(five);break;
                    case 6:pl1=new JLabel(six);break;                    
                }
                pl1.setBounds(35,35,265,160);
                p1.add(pl1);
                switch(dice2){
                    case 1:pl2=new JLabel(one);break;
                    case 2:pl2=new JLabel(two);break;
                    case 3:pl2=new JLabel(three);break;
                    case 4:pl2=new JLabel(four);break;
                    case 5:pl2=new JLabel(five);break;
                    case 6:pl2=new JLabel(six);break;                      
                }
                pl2.setBounds(105,35,465,160);
                p1.add(pl2);
                if (point==0){//for the fist time(when point=0)
                switch(sum){
                    case 2:lose();break;//you lose when the sum is 2,3,12
                    case 3:lose();break;
                    case 12:lose();break;
                    case 7:win();break;//you win when the sum is 7,11
                    case 11:win();break;
                    default:point=sum;point();break;
                }}
                else{//after the first roll
                    if (sum==7){//you lose when the sum is 7
                        p2.remove(l1);
                        lose();
                    }
                    else if(sum==point){//you win when the sum equals to the point
                        p2.remove(l1);
                        win();
                    }
                    else{
                        pt=Integer.toString(point);
                        p2.remove(l1);
                        l1=new JLabel("Your point is "+pt+"   Continue.");//print the result
                        l1.setBounds(185,0,245,45);
                        l1.setFont(f);            
                        p2.add(l1);
                       
                    }
                        
                }
                System.out.println(dice1);
                System.out.println(dice2);
                validate();
                repaint();
            }
            else if("restart".equals(bn)){
                p1.remove(pl1);//clear the screen
                p1.remove(pl2);
                p2.remove(l1);
                p2.remove(restart);
                
                point=0;//initialize variables again
                l1=new JLabel("Roll 2 dice. If the sum is 2,3,or 12, you lose.");
                l3=new JLabel(" If the sum is 7 or 11, you win.");
                l2=new JLabel("If the sum is another value , a point is awarded.");
                l4=new JLabel("Continue to roll the dice until either a 7 ");
                l5=new JLabel("or the same point value is rolled.");
                l6=new JLabel("If a 7 is rolled, you lose. Otherwise you win.");
                l1.setBounds(85,45,265,90);//set locations for instruction labels
                l3.setBounds(85,55,265,100);
                l2.setBounds(85,65,265,115);
                l4.setBounds(85,75,305,130);
                l5.setBounds(85,85,265,145);
                l6.setBounds(85,95,265,160);
                pl1=new JLabel("");pl2=new JLabel("");p1.add(pl1);p1.add(pl2);
                p1.add(l1);
                p1.add(l2);
                p1.add(l3);
                p1.add(l4);
                p1.add(l5);
                p2.add(start);//add the start button to panel
                validate();
                repaint();
            }
            
        }
        private void win(){//if you win
            p2.remove(roll);
            l1=new JLabel("You Win!!");//print the result
            l1.setBounds(185,0,145,45);   
            l1.setFont(f); 
            p2.add(restart);//replace "roll" with "restart"
            p2.add(l1);
        }
        private void lose(){//if you win
            p2.remove(roll);
            
            l1=new JLabel("You Lose.");//print the result
            l1.setBounds(185,0,245,45);
            l1.setFont(f);            
            p2.add(restart);
            p2.add(l1);
        }
        private void point(){
            pt=Integer.toString(point);
            l1=new JLabel("Your point is "+pt);//print the result
            l1.setBounds(185,0,245,45);
            l1.setFont(f);            
            p2.add(l1);
        }
        
    }
    public static void main(String []args){//main part
        DunyangN_U1A1Q3 myscreen=new DunyangN_U1A1Q3();//create a screen
        myscreen.setTitle("DunyangN_U1A1Q3");
        myscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myscreen.setSize(500,400);// settings of the window
        myscreen.setVisible(true);
    }
}