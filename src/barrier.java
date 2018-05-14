import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class barrier extends JPanel {

    private static int FIXED = 1500;
    private static int X1=FIXED, X2 = X1 + 250, X3 = X2+250, X4 = X3+250;
    private static int h1, h2, h3, h4;
    private BufferedImage topBarrier, bottomBarrier;



    public boolean b1 = true, b2= true, b3= true, b4= true;

    public int getX1() {
        return X1;
    }


    public void setX1(int x1) {
        X1 = x1;
    }

    public int getX2() {
        return X2;
    }

    public void setX2(int x2) {
        X2 = x2;
    }

    public int getX3() {
        return X3;
    }

    public void setX3(int x3) {
        X3 = x3;
    }

    public int getX4() {
        return X4;
    }

    public void setX4(int x4) {
        X4 = x4;
    }

    public int getH1() {
        return h1;
    }

    public void setH1(int h1) {
        this.h1 = h1;
    }

    public int getH2() {
        return h2;
    }

    public void setH2(int h2) {
        this.h2 = h2;
    }

    public int getH3() {
        return h3;
    }

    public void setH3(int h3) {
        this.h3 = h3;
    }

    public int getH4() {
        return h4;
    }

    public void setH4(int h4) {
        this.h4 = h4;
    }


    public static int rand(int min, int max) {
        try {
            Random rn = new Random();
            int range = max - min + 1;
            int randomNum = min + rn.nextInt(range);
            return randomNum;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    public void randomHigh(){
        Random rd = new Random();
        if(b1 == true){
            h1 = rd.nextInt(200);
            b1 = false;
        }
        if(b2 == true){
            h2 = rd.nextInt(200);
            b2 =false;
        }
        if(b3 == true){
            h3 = rd.nextInt(200);
            b3 =false;
        }
        if(b4 == true){
            h4 = rd.nextInt(200);
            b4= false;
        }

    }
    public void paint(Graphics g){
        g.setColor(Color.green);
        randomHigh();
        try {
            topBarrier = ImageIO.read(new File("F:\\Practice_JAVA\\MyFlappyBird\\res\\OngnuocTren.png"));
            bottomBarrier = ImageIO.read(new File("F:\\Practice_JAVA\\MyFlappyBird\\res\\OngnuocDuoi.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Ve ong nuoc tren
//        g.fillRect(X1,0,70,h1);
//        g.fillRect(X1, h1+70,70, 500);
//        g.fillRect(X2,0,70,h2);
//        g.fillRect(X2, h2+70,70, 500);
//        g.fillRect(X3,0,70,h3);
//        g.fillRect(X3, h3+70,70, 500);
//        g.fillRect(X4,0,70,h4);
//        g.fillRect(X4, h4+70,70, 500);

        g.drawImage(topBarrier,X1,0,60,h1,null);
        g.drawImage(bottomBarrier,X1,h1+70,60,500,null);

        g.drawImage(topBarrier,X2,0,60,h2,null);
        g.drawImage(bottomBarrier,X2,h2+70,60,500,null);

        g.drawImage(topBarrier,X3,0,60,h3,null);
        g.drawImage(bottomBarrier,X3,h3+70,60,500,null);

        g.drawImage(topBarrier,X4,0,60,h4,null);
        g.drawImage(bottomBarrier,X4,h4+70,60,500,null);
    }

    public void moveLeft(int x){
        X1 -=x;
        X2 -=x;
        X3 -=x;
        X4 -=x;
    }
    public void comeBack(){
        if(X1 <= -60){
            X1 = 1500;
            b1 = true;

        }
        if(X2 <= -60){
            X2 = 1500;
            b2 = true;
        }
        if(X3 <= -60){
            X3 = 1500;
            b3 = true;
        }
        if(X4 <= -60){
            X4 = 1500;
            b4 = true;
        }
    }
}
