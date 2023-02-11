package fr.formiko.setmaximized;

import java.awt.Dimension;
import java.awt.Toolkit;
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
	private Viewport viewport;

	@Override
	public void create() {
		batch = new SpriteBatch();
		int width = Gdx.graphics.getWidth();
		int heigth = Gdx.graphics.getHeight();
		viewport = new FitViewport(width, heigth, new OrthographicCamera());
		stage = new Stage(viewport, batch);

		LabelStyle labelStyle = new LabelStyle(new BitmapFont(), Color.WHITE);
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		Label label = new Label("I'm a " + width + " " + heigth + " window on a " + size.getWidth() + " " + size.getHeight() + " screen.",
				labelStyle);
		stage.addActor(label);
	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0, 1);
		stage.draw();
	}

	@Override
	public void dispose() {
		batch.dispose();
		stage.dispose();
	}
}
