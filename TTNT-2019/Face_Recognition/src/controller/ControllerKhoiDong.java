package controller;

import javax.swing.JFrame;

import view.KhoiDong;
import view.Start;

public class ControllerKhoiDong extends JFrame {
	private KhoiDong runView;
	private int i;

	public ControllerKhoiDong(KhoiDong runView) {
		this.runView = runView;
	}

	public void iterate() {
		while (i <= 500) {
			runView.getJb().setValue(i);
			i = i + 20;
			try {
				Thread.sleep(150);
			} catch (Exception e) {
			}
		}
		new Start();
		runView.dispose();

	}
}
