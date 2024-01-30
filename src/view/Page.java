package view;

import javafx.scene.Scene;

public abstract class Page {

	protected Scene scene;
	
	public Page() {
		initialize();
	}

	public abstract void initialize();

	public Scene getScene() {
		return scene;
	}

}
