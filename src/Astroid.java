
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class Astroid {

    private Image image;
    private Rectangle hitbox;
    private int xdir, ydir;
    private boolean ischosen;
    private static int GameWidth;
    private static int GameHeight;

    public Astroid(int x, int y) throws SlickException {
        image = new Image("Jars/astroid.PNG");
        hitbox = new Rectangle(x, y, image.getWidth(), image.getHeight());
        ischosen = false;
        while (true) {
            xdir = (int) (Math.random() * 7 - 3);
            ydir = (int) (Math.random() * 7 - 3);
            if (xdir != 0 && ydir != 0) {
                break;

            }

        }
    }
    public static void setgamesize(int x, int y){
        GameWidth = x;
        GameHeight = y;
        
    }
    public boolean hit (int x, int y)
    {if (hitbox.contains(x,y)) {return true;
            
        }
    else return false;
    
    
    
    }
    public void draw(){
    image.draw(hitbox.getX(), hitbox.getY());}
    public void move(){
        hitbox.setX(hitbox.getX()+xdir);
        hitbox.setY(hitbox.getY()+ydir);
        if (hitbox.getX() <= 0 || hitbox.getX()>GameWidth) {
            xdir = -xdir;
        }
        if (hitbox.getY() <= 0 || hitbox.getY()>GameHeight) {
            ydir = -ydir;
            
        }
        
        
    }
    

}
