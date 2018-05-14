import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Cloud extends CommonObject {
    Random rd = new Random();
    public int diemRoi1, diemRoi2;
    public Cloud(int width, int height, int level){
        diemRoi2 = rd.nextInt(300) + 200;
        diemRoi1 = diemRoi2 + 400;
        this.width = width;
        this.height = height;
        this.x = 1000 + rd.nextInt(500);
        this.y = rd.nextInt(120) + 10;
        this.speed = rd.nextInt(3) + 1 + level;
        this.level = level;
        this.type = rd.nextInt(5) + 1;
        try {
            this.image = ImageIO.read(new File("F:\\Practice_JAVA\\HungHoaQua_SangTigo\\res\\cloud"+level+type+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void paintCloud(Graphics g) {
        g.drawImage(image,x,y,width,height,null);
    }

    public void moveLeft(int value){
        this.x -= value;
    }

    public void comeBack(){
        if(x < -200){
            x = 1000 + rd.nextInt(500);
        }
    }
}
