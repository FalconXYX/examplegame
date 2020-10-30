
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;

public class rockblast extends BasicGame {

    Image rock;
    ArrayList<Astroid> rocks;

    public rockblast(String title) {
        super(title);
    }

    public void init(GameContainer gc) throws SlickException {
        rocks = new ArrayList();
        Astroid.setgamesize(800, 600);
        rock = new Image("Jars/astroid.PNG");
        for (int i = 0; i < 10; i++) {
            int rx = (int) (Math.random() * 750);
            int ry = (int) (Math.random() * 550);
            rocks.add(new Astroid(rx,ry));

        }
    }

    public void update(GameContainer gc, int i) throws SlickException {
        Input in = gc.getInput();
        int mx = in.getMouseX();
        int my = in.getMouseY();
        for (Astroid a : rocks) {
            a.move();
            
        }
        for (Astroid a : rocks) {
            if (a.hit(mx,my) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                rocks.remove(a);
                break;
                
            }
            
        }

    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
         for (Astroid a : rocks) {
            a.draw();
            
        }

    }

    public static void main(String args[]) throws SlickException {
        rockblast game = new rockblast("Testing Game");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(800, 600, false);
        app.setShowFPS(false);
        app.setTargetFrameRate(100);
        app.start();
    }

}
