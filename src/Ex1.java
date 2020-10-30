
import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class Ex1 extends BasicGame {

    Shape s1, s2;
    int cy, cx;
    Color bcolor;
    Image rock;
    Rectangle hb;

    public Ex1(String title) {
        super(title);
    }

    public void init(GameContainer gc) throws SlickException {
        s1 = new Circle(cx, cy, 20);// 100, 200 is the center of the circle 
        s2 = new Rectangle(100, 300, 200, 75);
        bcolor = Color.yellow;
        
        rock = new Image("Jars/android.PNG");
        hb = new Rectangle(300,200,rock.getWidth(),rock.getHeight());
        
        

    }

    public void update(GameContainer gc, int i) throws SlickException {
        Input in = gc.getInput();
        if (in.isKeyDown(Input.KEY_RIGHT)) {
            cx++;

        }
         if (in.isKeyDown(Input.KEY_LEFT)) {
            cx--;

        }
          if (in.isKeyDown(Input.KEY_UP)) {
            cy--;

        } if (in.isKeyDown(Input.KEY_DOWN)) {
            cy++;

        }
        //colsion
        if (hb.intersects(s2)) {
            bcolor = Color.blue;
            
        }
        else{bcolor = Color.yellow;}

        s1.setX(cx);
        s1.setY(cy);
        
        //mouse click
        int mx = in.getMouseX();
        int my = in.getMouseY();
        if (in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) ) {
            //blah
            
        }
        

    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        
        g.setColor(bcolor);
        g.fill(s1);
        g.setColor(Color.red);
        g.fill(s2);
        rock.draw(300,300);
        

    }

    public static void main(String args[]) throws SlickException {
        Ex1 game = new Ex1("Testing Game");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(800, 600, false);
        app.setShowFPS(false);
        app.setTargetFrameRate(100);
        app.start();
    }

}
