/**
 * @author ArneK
 */
import java.awt.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;

public class TestBolde  implements  Konstanter{

  private static ArrayList<Ball> ballArrayList = new ArrayList<>();
  private static int numberOfBalls = 5;
											
  public static void main(String[] arg) throws InterruptedException
  {
    JFrame f = new JFrame();
    f.setTitle("Le Balls");
    f.setSize(sizeJFrameX,sizeJFrameY);
    f.getContentPane().setBackground(Color.WHITE);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Graphics g = f.getGraphics();
    f.update(g);
    Random r =new Random();

    for (int i = 0; i < numberOfBalls; i++) {
      float r1 = r.nextFloat();
      float g1 = r.nextFloat();
      float b1 = r.nextFloat();
      Color randomColor = new Color(r1,g1,b1);
      Ball ball = new Ball(50,40, randomColor,60);
      new Thread(ball ,"Ball number "+(i+1)).start();
      ballArrayList.add(ball);
    }

    Thread guiThread = new Thread(()-> {
      while(true) {
        for (Ball ball : ballArrayList) {
          ball.drawball(g);
        }
        try {
          Thread.sleep(100);
        }catch (InterruptedException e) {
          e.printStackTrace();
        }
        f.update(g);
  }

    },"guiThread");
    guiThread.start();
    int active = Thread.activeCount();
    System.out.println("Number if active threads: "+ active);
    Thread all[] = new Thread[active];
    Thread.enumerate(all);
    for (int i =0; i < active; i++){
      System.out.println(i+ ": "+ all[i]);
    }
  }
}