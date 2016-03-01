import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.rmi.server.ExportException;

/**
 * Created by VinhNguyenDinh on 02/27/2016.
 */
public class GameWindow extends Frame implements KeyListener,Runnable,MouseMotionListener {
    // ĐỠ GIẬT MÀN HÌNH
    // start
    Graphics seconds;
    Image image;
    // end


    BufferedImage background;
    int direction = 0, checkShoot = 0;
    Plane plane, plane2;
    Bullet bullet;

    public GameWindow()  {

        plane = new Plane();
        plane2 = new Plane();
        plane.setPositionX(100);
        plane.setPositionY(200);
        plane2.setPositionX(300);
        plane2.setPositionY(400);
        plane.setSpeed(3);

        //bullet = new Bullet();

        this.setTitle("1945");
        this.setSize(400, 640);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        }
        );
        try {
            background = ImageIO.read(new File("Resouces/Background.png"));
            plane.sprite = ImageIO.read(new File("Resouces/PLANE1.png"));
            plane2.sprite = ImageIO.read(new File("Resouces/PLANE2.png"));
            bullet.sprite = ImageIO.read(new File("Resouces/DAN.png"));
        } catch(IOException e) { }

        this.addKeyListener(this);
        this.addMouseMotionListener(this);

        repaint();
    }

    @Override
    // **********    cho màn hình đỡ giật
    public void update(Graphics g){
        if(image == null){
            image = createImage(this.getWidth(), this.getHeight());
            seconds = image.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0, 0, getWidth(), getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image,0,0,null);
    }
    // end ******

    @Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, null);
        plane.draw(g);
        plane2.draw(g);
        if(checkShoot == 1) {
            bullet.draw(g);
            while(true) {
                bullet.setPositionY(bullet.getPositionY() - 2);
                if(bullet.getPositionY() < 0)   break;
                bullet.draw(g);
            }

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == 'w') {
            direction = 1;
        }
        else if(e.getKeyChar() == 's') {
            direction = 2;
        }
        else if(e.getKeyChar() == 'a') {
            direction = 3;
        }
        else if(e.getKeyChar() == 'd') {
            direction = 4;
        }
        else if(e.getKeyChar() == ' ') {
            checkShoot = 1;
            bullet.setPositionX(plane.getPositionX() + bullet.getAlign());
            bullet.setPositionY(plane.getPositionY() - bullet.getAlign());
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
        direction = 0;
    }
    @Override
    public void run() {
        //int x = 0;
        while (true) {
            if(direction == 1) {
                plane.setPositionY(plane.getPositionY() - plane.getSpeed());
            }
            else if(direction == 2) {
                plane.setPositionY(plane.getPositionY() + plane.getSpeed());
            }
            else if(direction == 3) {
                plane.setPositionX(plane.getPositionX() - plane.getSpeed());
            }
            else if(direction == 4) {
                plane.setPositionX(plane.getPositionX() + plane.getSpeed());
            }
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        plane2.setPositionX(e.getX());
        plane2.setPositionY(e.getY());

        e.consume();
        BufferedImage cursorImg = new BufferedImage(plane2.getPositionX(), plane2.getPositionY(), BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                cursorImg, new Point(0, 0), "blank cursor");
        setCursor(blankCursor);
    }

}
