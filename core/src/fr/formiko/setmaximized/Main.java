package fr.formiko.setmaximized;

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
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();
		viewport = new FitViewport(width, height, new OrthographicCamera());
		stage = new Stage(viewport, batch);

		LabelStyle labelStyle = new LabelStyle(new BitmapFont(), Color.WHITE);
		label = new Label("Initial label state; won't be shown.",
				labelStyle);
		stage.addActor(label);
	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0, 1);
		label.setText("I'm a " + Gdx.graphics.getWidth() + " " + Gdx.graphics.getHeight() + " window on a "
				+ Gdx.graphics.getDisplayMode().width + " " + Gdx.graphics.getDisplayMode().height + " screen.");
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
	}

	@Override
	public void dispose() {
		batch.dispose();
		stage.dispose();
	}
}
