package Coba.data.gui;

public abstract class AbstractFrameConstructor {
	protected AbstractFrameConstructor() {
		construcgui();
		addFrameComponent();
		addFrameAction();
	}

	protected abstract void construcgui();

	protected abstract void addFrameComponent();

	protected abstract void addFrameAction();

	public abstract void show();

	public abstract void hide();

}
