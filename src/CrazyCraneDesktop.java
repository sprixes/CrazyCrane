import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.noobs2d.crazycrane.CrazyCrane;

public class CrazyCraneDesktop {
	public static void main(String[] args) {
		new LwjglApplication(new CrazyCrane(), "Crazy Crane", 800, 1280, false);
	}
}
