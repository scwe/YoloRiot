package gui;

import image.ImageLoader;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import map.Map;
import map.Tile;
import model.Model;

public class ScreenPanel extends JPanel {

	private Graphics2D buffer;

	private Map map;
	private Model model;
	private MapPanel m;

	private Cursor cursor;

	public ScreenPanel(Model model, Map map, MapPanel m) {
		setFocusable(true);
		requestFocusInWindow();

		this.model = model;
		this.m = m;
		this.map = map;

	}

	@Override
	public void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Image offscreen = createImage(getWidth(), getHeight());

		buffer = (Graphics2D) offscreen.getGraphics();
		buffer.setColor(Color.white);
		buffer.fillRect(0, 0, getWidth(), getHeight());
		buffer.setRenderingHints(rh);

		// TODO drawing of any background shit should go here

		g2d.drawImage(offscreen, 0, 0, this);
	}

}