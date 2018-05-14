import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Fruit extends CommonObject {
    Random rd = new Random();
    public boolean fadeOut = false;
    public Fruit( int width, int height, int level){
        this.width = width;
        this.height = height;
        this.level = level;
        this.type = rd.nextInt(6) + 1;
        this.speed = this.type + 1 + level;
        try {
            this.image = ImageIO.read(new File("F:\\Practice_JAVA\\HungHoaQua_SangTigo\\res\\Fruit"+level+type+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void paintFruit(Graphics g) {
        g.drawImage(image,x,y,width,height,null);
    }

    public void moveDown(int speed){
        y += speed;
    }
    public void fadeOut(){
        if(y >= (GUI.height-140)){
            y = GUI.height + 500;
            fadeOut = true;
        }
    }
    public void goIntoBasket(){
        if(x > MyPanel.basket.x && x < MyPanel.basket.x + 120 && fadeOut == true){
            if(type != 6){
                MyPanel.basket.countFruits ++;
            }
            if(type == 6){
                MyPanel.basket.countBom ++;
            }
            switch (type){
                case 1: MyPanel.basket.score +=10; break;
                case 2: MyPanel.basket.score +=20; break;
                case 3: MyPanel.basket.score +=30; break;
                case 4: MyPanel.basket.score +=40; break;
                case 5: MyPanel.basket.score +=50; break;
                case 6: if((MyPanel.basket.score - 50) >=0){
                    MyPanel.basket.score -=50;
                }else{
                    MyPanel.basket.score = 0;
                }; break;
                default: MyPanel.basket.score +=0;

            }
        }
    }

}
