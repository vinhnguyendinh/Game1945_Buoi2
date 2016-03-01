import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by VinhNguyenDinh on 03/01/2016.
 */
public class Bullet {
    // Thuộc tính
    private int positionX;
    private int positionY;
    private int speed;
    private int align;
    private BufferedImage sprite;

    // Phương thức

    private Bullet(int positionX, int positionY, int speed, int align) throws IOException {
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        this.align = align;
        this.sprite = ImageIO.read(new File("Resouces/DAN.png"));
    }
    public void move() {
        this.positionY -= this.speed;
    }
    public void update() {
        this.move();
    }
    public void draw(Graphics g) {
        g.drawImage(this.sprite, this.positionX, this.positionY, null);
    }
    public int getPositionX() {
        return this.positionX;
    }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getSpeed() {
        return this.speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAlign() {
        return this.align;
    }

}
