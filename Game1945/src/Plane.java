import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by VinhNguyenDinh on 02/28/2016.
 */
public class Plane {
    // Thuộc tính
    private int positionX;
    private int positionY;
    private int damage;
    private int speed;
    private int health;
    private int planeType;
    public BufferedImage sprite;
    private Vector<Bullet> vecBul = new Vector<Bullet>();
    // Phương thức

    // Khởi tạo
    public Plane() {
        // Không có kiểu trả về và tên giống tên class
        this.positionX = 300;
        this.positionY = 300;
        this.speed = 4;
        try {
            this.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Plane(int positionX, int positionY, int speed, int planeType) {
        // Không có kiểu trả về và tên giống tên class
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        switch(planeType) {
            case 1:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE2.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE3.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE4.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

        }
    }
    public void shot() {
        //Bullet bul
    }
    public void move() {

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

    public int getDamage() {
        return this.damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return this.speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return this.health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public int getPlaneType() {
        return this.planeType;
    }
    public void setPlaneType(int planeType) {
        this.planeType = planeType;
    }

}
