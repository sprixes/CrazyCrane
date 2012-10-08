import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.noobs2d.crazycrane.CrazyCrane;
import com.noobs2d.crazycrane.Settings;

public class CrazyCraneDesktop {
	public static void main(String[] args) {
		new LwjglApplication(new CrazyCrane(), "Crazy Crane", Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT, false);
	}
}
