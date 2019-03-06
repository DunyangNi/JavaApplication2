package DunyangN_U1A1Q4;

/*Unit1 Assignment1 Question3
 *Dunyang Ni
 *02/03/2019
 *write a program that generates 100 random integers between 0 and 9 and displays the count for each number.
 */
import java.util.*;
public class DunyangN_U1A1Q4 {
    public static void main(String []args){
        int start,end,interval,amount,number,answer_int;//setting up variables
        String blank,num1,num2,answer_string,answer_s;
        Scanner in=new Scanner(System.in);
        Boolean done=false;
        int[] arr;
        Random rand=new Random();
        while(done==false){
            System.out.println("Please enter 2 integers, I will generate random numbers between these two integers.");//Instruction
            if(in.hasNextInt()){//read the first input
                start=in.nextInt();
            }
            else{
                System.out.println("Invalid input");
                blank=in.nextLine();//cancel the invalid input
                continue;
            }
            if(in.hasNextInt()){
                end=in.nextInt();
            }
            else{
                System.out.println("Invalid input");
                blank=in.nextLine();
                continue;
            }
            if(end<=start){//prompt user to enter valid input
                System.out.println("The second number should be bigger than the first one.");
                continue;
            }
            interval=end-start+1;//amount of numbers
            arr=new int[interval];//setting up the array
            System.out.println("How many random numbers do you want?");
            if(in.hasNextInt()){//read the second input
                amount=in.nextInt();
            }
            else{//prompt user to enter valid input
                System.out.println("Invalid input");
                continue;
            }
            for(int j=0;j<interval;j++){//initialize the array
                arr[j]=0;
            }
            for(int i=0;i<amount;i++){//generate random numbers and count
                number=rand.nextInt(interval);
                arr[number]+=1;
            }
            for(int m=0;m<interval;m++){//print the result
                num1=Integer.toString(m+start);
                num2=Integer.toString(arr[m]);
                System.out.println("The number of "+num1+"'s is "+num2);
            }
            System.out.println("Do you want to try again?(0 and 'no' means no, 1 and 'yes' means yes)");//instruction
            if(in.hasNextInt()){//if the input is a integer
                answer_int=in.nextInt();
                blank=in.nextLine();//get the "/n" after the int
                switch(answer_int){
                case 0:done=true;break;//done
                case 1:done=false;break;//continue
                default:System.out.println("Invalid input, and I think you don't want to try again.Bye!");
                    done=true;
                    break;
            }
            }
            else {//if the input is a string
                do{
                answer_string=in.nextLine();}
                while(answer_string.equals(""));
                answer_s=answer_string.toLowerCase();
                if (answer_s.equals("yes")){//turn the choice into int 
                    done=false;
                }
                else if(answer_s.equals("no")){
                    done=true;
                }
                else{//or the input is unvalid
                    System.out.println("Invalid input, and I think you don't want to try again.Bye!");
                    done=true;
                }
            }
        }
    }
}
