package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import map.LevelData;
import map.LevelData.LevelName;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;

import map.Map;
import model.Model;

public class YoloRiot extends JFrame implements ActionListener {
	public static final int SCREEN_WIDTH = 1200;
	public static final int SCREEN_HEIGHT = 720;

	private static final int TICK = 5;

	private ScreenPanel screen;
	private Model model;
	private Map map;

	private ScreenPanel mainScreen;
	private MapPanel mapPanel;
	private ItemPanel itemPanel;
	private StartScreen startScreen;

	private SoundFactory sounds; // use the sounds.playSound(filename) to play a
									// sound

	private YoloMouse mouse;
	private YoloKeyboard key;

	private boolean startS = true, mainS = false;

	Timer t = new Timer(1000, this);
	Timer startTimer;

	public YoloRiot() {
		setTitle("Yolo Riot");
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		model = new Model();
		LevelData startLevel = new LevelData(LevelName.START);
		map = new Map(startLevel);

		startScreen = new StartScreen();
		add(startScreen);
		startScreen.setVisible(true);

		itemPanel = new ItemPanel();
		mapPanel = new MapPanel(model, map);
		screen = new ScreenPanel(model, map, mapPanel);
		screen.add(mapPanel);
		screen.setOpaque(false);
		screen.setVisible(false);
		itemPanel.setVisible(false);
		add(itemPanel, BorderLayout.WEST);
		add(screen);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		screen.setVisible(false);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mouse = new YoloMouse(model, mapPanel);
		key = new YoloKeyboard(model.getPlayer());
		sounds = new SoundFactory();

		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		addKeyListener(key);

		setFocusable(true);
		setVisible(true);

		t = new Timer(TICK, this);
		startTimer = new Timer(1000, this);
		startTimer.start();
	}

	public void gameLoop() {
		if (startS) {
			startScreen.repaint();
		} else {
			model.tick();
			key.update();
			screen.repaint();
		}

	}

	public static void main(String[] args) {
		new YoloRiot();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == startTimer && startS) {
			startScreen.setVisible(false);
			screen.setVisible(true);
			itemPanel.setVisible(true);
			startS = false;
			startTimer.stop();
			t.start();
		}
		gameLoop();
	}
}