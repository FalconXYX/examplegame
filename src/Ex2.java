import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class Ex2 extends BasicGame {
Image rock;
ArrayList<Rectangle> rocks;
public Ex2 (String title) {
super(title);
}

public void init(GameContainer gc) throws SlickException {
    rocks = new ArrayList();
    rock = new Image("Jars/astroid.PNG");
    for (int i = 0; i < 10; i++) {
        int rx = (int)(Math.random()*750);
        int ry = (int)(Math.random()*550);
        rocks.add(new Rectangle(rx,ry, rock.getWidth(), rock.getHeight()));
        
    }

}

public void update(GameContainer gc, int i) throws SlickException {
    Input in = gc.getInput();
    int mx = in.getMouseX();
        int my = in.getMouseY();
        for (Rectangle r : rocks) {
            if (r.contains(mx,my)) {
                rocks.remove(r);
                break;
                
            }
        
    }
}

public void render(GameContainer gc, Graphics g) throws SlickException {
    for (Rectangle r : rocks) {
        
        rock.draw(r.getX(), r.getY());
        
    }

}

public static void main(String args[]) throws SlickException {
  Ex2 game = new Ex2("Testing Game");
  AppGameContainer app = new AppGameContainer(game);
  app.setDisplayMode(800, 600, false);
  app.setShowFPS(false);
  app.setTargetFrameRate(100);
  app.start();
}

}