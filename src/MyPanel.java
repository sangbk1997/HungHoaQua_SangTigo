import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MyPanel extends JPanel implements  Runnable{

    public static  int level =1;
    public static Basket basket = new Basket(120,100,level);
    private Cloud [] clouds = new Cloud[10];
    private Fruit [] fruits = new Fruit[20];
    private Thread threadT;
    private BufferedImage bgRight, bgLeft, scoreFruits, basketResult;

    public MyPanel(){
        for(int i=0; i<10;i++){
            clouds[i] = new Cloud(120,100, level);

        }
        for(int i=0; i<20;i++){
            fruits[i] = new Fruit(50,50,level);
            fruits[i].x = -200;
            fruits[i].y = -200;
        }
        threadT = new Thread(this);
        threadT.start();
    }

    public void paint(Graphics g){
        level = (basket.score / 500) + 1;
        try {
            bgLeft = ImageIO.read(new File("F:\\Practice_JAVA\\HungHoaQua_SangTigo\\res\\Background"+level+".jpg"));
            bgRight = ImageIO.read(new File("F:\\Practice_JAVA\\HungHoaQua_SangTigo\\res\\BackgroundResult.jpg"));
            scoreFruits = ImageIO.read(new File("F:\\Practice_JAVA\\HungHoaQua_SangTigo\\res\\ScoreFruit1.png"));
            basketResult = ImageIO.read(new File("F:\\Practice_JAVA\\HungHoaQua_SangTigo\\res\\NumberBasket.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(bgLeft,0,0,GUI.width,GUI.height,null);
//        g.setColor(Color.MAGENTA);
//        g.setFont(new Font("Courier New", Font.BOLD, 20));
//        g.setColor(Color.BLACK);
//        g.drawString("Level: " + level,200,30);
//        g.setFont(new Font("Magneto Bold",Font.BOLD,20));
//        g.setColor(Color.blue);
//        g.drawString("Sang Tigo", 20,60);
//        g.setColor(Color.GREEN);
//        g.drawString("Hang's Kokoro", 200,60);
//
        g.setColor(Color.orange);
        g.drawString(basket.countFruits+" Fruits",100,50);
        g.setColor(Color.red);
        g.drawString(basket.countBom+" Boms",200,50);
        basket.paintBasket(g);
        for(int i = 0; i < 10; i++){
            clouds[i].paintCloud(g);
        }
        for (int i=0; i<20; i++){
            fruits[i].paintFruit(g);
        }
        g.drawImage(bgRight,GUI.width-300,0,300,GUI.height,null);
        g.setFont(new Font("Arial",Font.BOLD,30));
        g.setColor(Color.red);
        g.drawString(basket.score+" points",1150,560);
        g.drawImage(scoreFruits,20,200,100,400,null);
        g.drawImage(basketResult,10,20,50,50,null);

    }

    @Override
    public void run() {

        while (true){
            repaint();
            for(int i=0; i<10;i++){
                clouds[i].moveLeft(clouds[i].speed);
                if( clouds[i].diemRoi1 >= (clouds[i].x - clouds[i].speed) && clouds[i].diemRoi1 <= (clouds[i].x + clouds[i].speed)){
                    fruits[i].x = clouds[i].x + 20;
                    fruits[i].y = clouds[i].y + 20;
                }
                if( clouds[i].diemRoi2 >= (clouds[i].x - clouds[i].speed) && clouds[i].diemRoi2 <= (clouds[i].x + clouds[i].speed)){
                    fruits[i+10].x = clouds[i].x + 20;
                    fruits[i+10].y = clouds[i].y + 20;

                }
                if(fruits[i].x > 0){
                    fruits[i].moveDown(fruits[i].speed);
                    fruits[i].fadeOut();
                }
                if(fruits[i+10].x > 0){
                    fruits[i+10].moveDown(fruits[i+10].speed);
                    fruits[i+10].fadeOut();
                }
                clouds[i].comeBack();
            }
            for(int i=0; i<20; i++){
                fruits[i].goIntoBasket();
            }
            for(int i=0; i< 20; i++){
                if(fruits[i].fadeOut == true){
                    fruits[i] = new Fruit(50,50,level);
                    fruits[i].x = -200;
                    fruits[i].y = -200;
                }
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}