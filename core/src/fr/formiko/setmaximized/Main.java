package fr.formiko.setmaximized;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Main extends ApplicationAdapter {
	private SpriteBatch batch;
	private Stage stage;
	private Label label;
	private Viewport viewport;

	@Override
	public void create() {
		batch = new SpriteBatch();
		viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera());
		stage = new Stage(viewport, batch);
		log("Create");
	}

	@Override
	public void render() {
		// if (label == null) { //This should be enoth, but there is some call to render with default window size.
		if (label == null && Gdx.graphics.getWidth() != 640) { // by lasy
			log("Create by lazy");
			LabelStyle labelStyle = new LabelStyle(new BitmapFont(), Color.WHITE);
			label = new Label("Initial label state; won't be shown.", labelStyle);
			stage.addActor(label);
			label.setText("I'm a " + Gdx.graphics.getWidth() + " " + Gdx.graphics.getHeight() + " window on a "
					+ Gdx.graphics.getDisplayMode().width + " " + Gdx.graphics.getDisplayMode().height + " screen.");
			// Label display the rigth window size but is still to big & pixelated.
		}

		ScreenUtils.clear(0, 0, 0, 1);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		log("Resize to " + width + " " + height);
		viewport.update(width, height);
	}

	@Override
	public void dispose() {
		batch.dispose();
		stage.dispose();
	}


	public void log(String message) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Gdx.app.log("LOG", formatter.format(new Date(System.currentTimeMillis())) + " " + message);
	}
}
