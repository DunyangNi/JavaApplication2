package DunyangN_U1A1Q5;

/*Unit1 Assignment1 Question3
 *Dunyang Ni
 *04/03/2019
 *Impress you with your Array, GUI, Images, Listeners, Buttons an other GUI classes 
 *A game called 2048
 */
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DunyangN_U1A1Q5 extends JFrame implements KeyListener,ActionListener{
  private int[][] arr= new int[4][4];//setting variables
  private int[][] copy_arr=new int[4][4];
  private int[][] copy_arr2=new int[4][4];
  private Boolean check;
  private int[] sup_list;//delete static!!
  private JButton start;
  private JButton restart;
  private final JLabel lb1=new JLabel("This game is called 2048.Every turn, a new tile will randomly appear");//setting instructions
  private final JLabel lb2=new JLabel("in an empty spot on the board with a value of either 2 or 4. Tiles slide as far as possible ");
  private final JLabel lb3=new JLabel("in the chosen direction until they are stopped by either another tile or the edge of the grid. If two tiles of ");
  private final JLabel lb4=new JLabel("the same number collide while moving, they will merge into a tile with the total  ");
  private final JLabel lb5=new JLabel("value of the two tiles that collided. Press up,down,left and right on your keyboard to control.");
  /*The intoduction is from wiki*/
  int w1=147;
  int h1=147;
  String number;
  int w,h;
  FontMetrics fm;
  int l1,l2,l3,l4;
  Random rand=new Random();
  int a,b,c;//for adding elements
  String key;
  boader gamepanel;
    /** Main method */
  public static void main(String[] args) {
    DunyangN_U1A1Q5 frame = new DunyangN_U1A1Q5();
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(655,685);
    frame.setVisible(true);
  }
  public DunyangN_U1A1Q5() {
    setLayout(null);
    start=new JButton("Start");
    restart=new JButton("Restart");
    lb1.setBounds(10,150,590,50);//setting locations for instruction labels
    lb2.setBounds(10,170,590,50);
    lb3.setBounds(10,190,590,50);
    lb4.setBounds(10,210,590,50);
    lb5.setBounds(10,230,590,50);
    start.setBounds(280,300,100,50);
    restart.setBounds(280,300,100,50);
    start.addActionListener(this);
    restart.addActionListener(this);
    add(start);//display instructions
    add(lb1);
    add(lb2);
    add(lb3);
    add(lb4);
    add(lb5);
  }

  public void actionPerformed(ActionEvent e){//actions for buttons
    String bn=e.getActionCommand();
        if (bn.equals("Start")){//if "start" is pressed
            start.removeActionListener(this);
            remove(start);//clear the screen
            remove(lb1);
            remove(lb2);
            remove(lb3);
            remove(lb4);
            remove(lb5);
            gamepanel = new boader();//create a game panel
            gamepanel.setBounds(0,0,655,685);
            add(gamepanel);
            add_element();//add the first two elements
            add_element();
            copy(copy_arr,arr);
            gamepanel.setBackground(Color.WHITE);//finish the settings
            gamepanel.setFont(new Font("Californian FB", Font.BOLD, 30));
            gamepanel.addKeyListener(this);
            gamepanel.requestFocus();
            repaint();           
        }
        else if(bn.equals("Restart")){//if "start" is pressed
            remove(restart);//clear the screen
            gamepanel = new boader();//reset variables
            gamepanel.setBounds(0,0,655,685);
            copy_arr2=new int[4][4];
            arr= new int[4][4];
            add(gamepanel);
            add_element();
            add_element();
            copy(copy_arr,arr);
            gamepanel.setBackground(Color.WHITE);
            gamepanel.addKeyListener(this);
            gamepanel.requestFocus();
            repaint();
        }
        }
    
    public void copy(int[][] a,int[][] b){//a method for copy the two-dimension array
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                a[i][j]=b[i][j];
            }
        }
    }
    public Boolean not_equal(int[][] a,int[][] b){////a method to check if two two-dimension arrays are equal
        check=true;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(a[i][j]==b[i][j]){//compare each element in two arrays                 
                }
                else{
                    check=false;//result is false when confliction occurs
                }
            }
        }
        check=!check;//return the opposite value to the result
        return check;
    }
    public Boolean full(int[][] arr){//check if the game is over
        copy(copy_arr2,arr);
        for(int b=0;b<4;b++){
            copy_arr2[b]=align_left(copy_arr2[b]);
        }
        if(not_equal(arr,copy_arr2)){//check if left_align possible
            return false;
        }
        copy(copy_arr2,arr);
        for(int b=0;b<4;b++){
            copy_arr2[b]=align_right(copy_arr2[b]);
        }
        if(not_equal(arr,copy_arr2)){//check if right_align possible
            return false;
        }
        copy(copy_arr2,arr);
        copy_arr2=align_up(copy_arr2);
        if(not_equal(arr,copy_arr2)){//check if up_align possible
            return false;
        }
        copy(copy_arr2,arr);
        copy_arr2=align_down(copy_arr2);
        if(not_equal(arr,copy_arr2)){//check if up_align possible
            return false;
        }
        return true;
    }
    public void add_element(){//method for adding elements
        a=rand.nextInt(4);//generate a position randomly
        b=rand.nextInt(4);
        c=1+rand.nextInt(2);
        while (arr[a][b]!=0){//generate again if the generated location has number on it
            a=rand.nextInt(4);
            b=rand.nextInt(4);
        }
        arr[a][b]=(int)c*2;
    }
    public int[] align_left1(int[] list){//align a single array to the left withoud any calculation
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(list[j]==0){
                    list[j]=list[j+1];
                    list[j+1]=0;
                }
            }
        }
        return list;
    }
    public int[] align_left2(int[] list){//sorting numbers as the game rules
        for(int j=0;j<3;j++){
            if(list[j]==list[j+1]){
                list[j]+=list[j+1];
                list[j+1]=0;
            }
        
        }
        return list;
    }
    public int[] align_left(int[] list){//align a single array to the left
        list=align_left1(list);
        list=align_left2(list);
        list=align_left1(list);
        return list;
    }
    public int[] align_right(int[] list){//align a single array to the right
        list=reverse(list);
        list=align_left(list);
        list=reverse(list);
        return list;
    }
    public int[] reverse(int[] list){//methoud to reverse a array
        sup_list=new int[4];
        for(int i=0;i<4;i++){
            sup_list[3-i]=list[i];
        }
        return sup_list;
    }
    public int[][] convert(int[][] list2) {//method for matrix transpose
        int[][] converted = new int[list2[0].length][list2.length];
        for (int i=0;i<converted.length;i++){
            for (int j=0;j<converted[i].length;j++){
              converted[i][j] = list2[j][i];    
            } 
    } 
    return converted; 
    }
    public int[][] align_up(int[][] list){//align the two-dimension array upwards
        list=convert(list);
        for(int[] a:list){
            a=align_left(a);

        }
        list=convert(list);
        return list;
    }
    public int[][] align_down(int[][] list){//align the two-dimension downwards
        list=convert(list);
        for(int i=0;i<4;i++){
            list[i]=align_right(list[i]);
        }
        list=convert(list);
        return list;
    }
  @Override
    public void keyPressed(KeyEvent e) {//actions for keys in keyboard
        if ( e.getKeyCode()==KeyEvent.VK_DOWN )//if Down is pressed
            {
                arr=align_down(arr);//sort the "arr" array
                if(not_equal(arr,copy_arr)){//add a element when changes happen to the array                  
                    add_element();
                    copy(copy_arr,arr);
                }
                if(full(arr)){//check if the game is over
                    remove(gamepanel);
                    add(restart);
                }
            } 
        else if (e.getKeyCode()==KeyEvent.VK_UP)//if up is pressed  
            {
                arr=align_up(arr);//sort the "arr" array
                if(not_equal(arr,copy_arr)){  //add a element when changes happen to the array                     
                    add_element();
                    copy(copy_arr,arr);
                }
                if(full(arr)){//check if the game is over
                    remove(gamepanel);
                    add(restart);
                }
            } 
        else if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                for(int a=0;a<4;a++){//sort the "arr" array
                        arr[a]=align_right(arr[a]);
                    }
                if(not_equal(arr,copy_arr)){    //add a element when changes happen to the array                  
                    add_element();
                    copy(copy_arr,arr);
                }
                if(full(arr)){//check if the game is over
                    remove(gamepanel);
                    add(restart);
                }
            } 
        else if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                for(int[] a:arr){//sort the "arr" array
                        a=align_left(a);
                    }
                if(not_equal(arr,copy_arr)){   //add a element when changes happen to the array                   
                    add_element();
                    copy(copy_arr,arr);
                }
                if(full(arr)){//check if the game is over
                    remove(gamepanel);
                    add(restart);
                }
            } 
        else 
            {

            }
        repaint();
    }

      
    public void keyTyped(KeyEvent e){
          
    }
    public void keyReleased(KeyEvent e){
          
    }
  



    class boader extends JPanel{
      /** game panel*/

      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Get font metrics for the current font
        fm = g.getFontMetrics();
        for(int[] a:arr){
            for(int b:a){
                b=0;
            }
        }
        for(int i=0;i<5;i++){//draw lines
            g.setColor(Color.black);
            g.fillRect(i*157,0,10, 640);
            g.fillRect(0,i*157,640, 10);
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                switch(arr[i][j]){//setting colors depending on the number on that position
                    case 0: g.setColor(new java.awt.Color(255,255,255));break;
                    case 2: g.setColor(new java.awt.Color(255,215,0));break;
                    case 4: g.setColor(new java.awt.Color(255,165,0));break;
                    case 8: g.setColor(new java.awt.Color(255,135,0));break;
                    case 16: g.setColor(new java.awt.Color(255,105,0));break;
                    case 32: g.setColor(new java.awt.Color(255,75,0));break;
                    case 64: g.setColor(new java.awt.Color(255,55,0));break;
                    case 128: g.setColor(new java.awt.Color(244,164,96));break;
                    case 256: g.setColor(new java.awt.Color(210,105,30));break;
                    case 512: g.setColor(new java.awt.Color(255,99,71));break;
                    case 1024: g.setColor(new java.awt.Color(128,0,0));break;
                    case 2048: g.setColor(new java.awt.Color(255, 0, 0));break;
                }
                g.fillRect(j*157+83-w1/2, i*157+83-h1/2,w1,h1);//draw squares
            }
        }
      }
      @Override
      public void paint(Graphics g){
          super.paint(g);
          for(int i=0;i<4;i++){//draw numbers
            for(int j=0;j<4;j++){
                g.setFont(new Font("TimesRoman", Font.BOLD, 64));//set fonts
                if(arr[i][j]!=0){
                    number=Integer.toString(arr[i][j]);
                    w=fm.stringWidth(number);
                    h=fm.getAscent();
                    g.drawString(number,j*157+75-w/2, i*157+112-h/2);
                }
            }
        }
      }
    }
}




