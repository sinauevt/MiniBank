package Coba.action.data;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import Coba.data.gui.AbstractFrameConstructor;

public class MainBankMenuClickListener implements ActionListener {

	private AbstractFrameConstructor frameOpener;
	private AbstractFrameConstructor frameCloser;

	public MainBankMenuClickListener(AbstractFrameConstructor frameOpener,
			AbstractFrameConstructor frameCloser) {
		this.frameOpener = frameOpener;
		this.frameCloser = frameCloser;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (frameOpener != null) {
			frameOpener.show();
		}
		if (frameCloser != null) {
			frameCloser.hide();
		}

	}

}
