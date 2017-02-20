/**
 * @author ArneK
 */

import java.awt.*;

public class Ball implements Konstanter, Runnable{
    double x, y, fartx, farty;
    int d;
    Color c;

    public Ball( int x1, int y1, Color c, int d1) throws InterruptedException {

        x = x1;
        y = y1;
        this.c = c;
        d = d1;
        this.fartx = Math.random() * 15;
        this.farty = Math.random() * 10;

    }

    public void drawball(Graphics g) {
        g.setColor(c);
        g.fillOval((int)x,(int)y,d,d);
    }

    public void moveBall(){
        x=x+fartx;
        y=y+farty;
        farty=farty+gravity;

        if (x < 0) fartx = Math.abs(fartx);
        if (x + d > sizeJFrameX) fartx = -Math.abs(fartx);
        if (y < 0) farty = Math.abs(farty);
        if (y + d > sizeJFrameY) farty = -Math.abs(farty);

        }

        @Override
    public void run(){
        while (true) {
            moveBall();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}