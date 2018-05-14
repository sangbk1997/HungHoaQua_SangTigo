import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Basket extends CommonObject {
    Random rd = new Random();
    public int score = 0, countFruits = 0, countBom = 0;
    public Basket(int width, int height, int level){
        this.width = width;
        this.height = height;
        this.x = 500;
        this.y = 600;
        this.speed = 15 + level*5;
        this.level = level;
        this.type = rd.nextInt(3) + 1;
        try {
            this.image = ImageIO.read(new File("F:\\Practice_JAVA\\HungHoaQua_SangTigo\\res\\basket"+level+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void paintBasket(Graphics g) {
        g.drawImage(image,x,y,width,height,null);
    }

    public void moveLeft(int speed){
        if(x >= speed){
            x -= speed;
        }
    }
    public void moveRight(int speed){
        if(x <= GUI.width - 400 -speed){
            x += speed;
        }
    }
}
