package DunyangN_U1A1Q2;


/*Unit1 Assignment1 Question2
 *Dunyang Ni
 *01/03/2019
 *a program  to check an ISBN.
 *prompts the user to enter the first 9 digits
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
public class DunyangN_U1A1Q2 extends JFrame{
    private JButton ok;//setting up variables
    private JButton ab;
    private JButton start;
    private JTextField tf;
    private String in;
    private int code;
    private JPanel p1;
    private JPanel p2;
    private JLabel l1,l3;
    private JLabel l2;
    private Font f = new Font("Arial",0,20);
    private Font f2 = new Font("Arial",0,12);
    int factor,rem,r_code,sum;
    String r_code_s;
    private int[] arr= new int[9];
    public DunyangN_U1A1Q2(){//constructor
        setLayout(new GridLayout(2,1, 5, 5));//divide the window into two part
        p1=new JPanel(null);//initialize variables
        p2=new JPanel(null);
        ok=new JButton("ok");
        ab=new JButton("restart");
        start=new JButton("Start");
        tf=new JTextField("Please enter");
        l1=new JLabel("This program can help you to find out the ");
        l3=new JLabel("10th digit of an ISBN");
        l2=new JLabel("Please enter the first 9 digits");
        tf.setBounds(145,65,185,90);
        start.setBounds(145,35,185,60);
        ok.setBounds(145,35,185,60);
        ab.setBounds(145,35,185,60);
        mylistener ml=new mylistener();//add the actionlistener to buttons
        ok.addActionListener(ml);
        ab.addActionListener(ml);
        start.addActionListener(ml);
        l1.setBounds(105,65,245,90);//set the instruction labels
        l3.setBounds(105,75,215,100);
        l2.setBounds(105,85,215,115);
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p2.add(start);//add the start button to panel
        add(p1);//add panels to the window
        add(p2);
    }
    private void ana_code(int a){//method to convert the interger from input into array
        for(int i=1;i<=9;i++){//using mathmatical method to get each digit 
            factor=(int)Math.pow(10, i);
            rem=a%factor;
            factor=(int)Math.pow(10, i-1);
            arr[i-1]=(int)rem/factor;}//and put them in an array

        for(int j=9;j>=1;j--){
            System.out.println(arr[j-1]);
            sum+=arr[j-1]*(10-j);
        }
        r_code=sum%11;
        r_code_s=Integer.toString(r_code);
        if (r_code==10){
            r_code_s="X";
        }
    }
    private class mylistener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String bn=e.getActionCommand();
            if (bn.equals("Start")){
                p1.add(tf);//add textfield to panel
                p1.remove(l1);//clear the window
                p1.remove(l2);
                p1.remove(l3);
                p2.remove(start);//replace start button with the confirmation button
                p2.add(ok);
            }
            if (bn.equals("ok")){//if ok is pressed
                sum=0;
                p2.remove(ok);//replace the ok button with reset button
                p2.add(ab);
                in=tf.getText(); //get the input 
                if(in.length()==9){
                    try{//convert it into integer
                        code=Integer.parseInt(in);
                        ana_code(code);
                        l1=new JLabel("The input is "+in);    
                        l2=new JLabel("The 10th digit is "+r_code_s);
                        l3=new JLabel("The ISBN code is "+code+r_code_s);
                        l1.setFont(f);
                        l2.setFont(f);
                        l3.setFont(f);
                        l1.setBounds(105,65,215,90);
                        l2.setBounds(105,85,215,115);
                        l3.setBounds(105,105,300,115);
                        p1.add(l1);
                        p1.add(l2);
                        p1.add(l3);
                    } catch(Exception b){//or tell the user that input is invalid
                        l1=new JLabel("Invalid input");
                        l1.setBounds(145,65,185,90);
                        l1.setFont(f);
                        l2=new JLabel("");
                        p1.add(l1);
                        p1.add(l2);
                    }
                }
                else{//if the lenghth is incorrect, input is invalid
                    l1=new JLabel("Invalid input");
                    l1.setBounds(145,65,185,90);
                    l1.setFont(f);
                    l2=new JLabel("");
                    p1.add(l1);
                    p1.add(l2);
                }
                p1.remove(tf);//replace the input box with a label
                
                               
            }
            else if (bn.equals("restart")){//if reset is pressed
                p2.remove(ab);//put ok and input box back
                p2.add(ok);
                p1.add(tf);
                p1.remove(l1);
                p1.remove(l2);
                p1.remove(l3);
                
            }
            validate();
            repaint();
        }
    }
    public static void main(String []args){//main part
        DunyangN_U1A1Q2 a=new DunyangN_U1A1Q2();//create the window
        a.setTitle("DunyangN_U1Q1A2");
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setSize(500,400);// settings of the window
        a.setVisible(true);
    }
}