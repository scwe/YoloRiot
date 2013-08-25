package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import map.LevelData;
import map.LevelData.LevelName;
import map.Map;
import model.Model;

public class YoloRiot extends JFrame implements ActionListener {
	public static final int SCREEN_WIDTH = 1200;
	public static final int SCREEN_HEIGHT = 720;

	private static final int TICK = 10;

	private ScreenPanel screen;
	private Model model;
	private Map map;

	private JPanel yoloPanel = new JPanel();
	private ScreenPanel mainScreen;
	private MapPanel mapPanel;
	private ItemPanel itemPanel;
	private StartScreen startScreen;
	private LoseScreen loseScreen;
	private WinScreen winScreen;

	private SoundFactory sounds; // use the sounds.playSound(filename) to play a
									// sound

	private YoloMouse mouse;
	private YoloKeyboard key;

	private boolean startS = true, mainS = false;
	public boolean lost = false;
	public boolean won = false;

	Timer t = new Timer(1000, this);
	Timer startTimer;

	public YoloRiot() {
		this.setPreferredSize(new Dimension(1200,1000));
		this.setMinimumSize(new Dimension(1200,1000));
		setTitle("Yolo Riot");
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);

		startScreen = new StartScreen();
		winScreen = new WinScreen ();
		loseScreen = new LoseScreen ();
		add(startScreen);
		startScreen.setVisible(true);

		
		
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.anchor = GridBagConstraints.WEST;
		gc.fill = GridBagConstraints.NONE;

		yoloPanel = new JPanel(new GridBagLayout());
		
	
	

		
		mapPanel = new MapPanel(model, map);
		mapPanel.setPreferredSize(new Dimension(1000,700));
		mapPanel.setMinimumSize(new Dimension(1000,700));
		
		screen = new ScreenPanel(model, map,mapPanel);
		screen.setPreferredSize(new Dimension(1000,200));
		screen.setMinimumSize(new Dimension(1000,200));
		screen.setOpaque(false);
		screen.setVisible(false);
		
		gc.gridx = 1;
		gc.gridy = 0;
		yoloPanel.add(screen, gc);
		gc.insets = new Insets(120,0,0,0);
		
		yoloPanel.add(mapPanel, gc);
		


		
		makeNewGame ();
		
		screen.setOpaque(false);
		screen.setVisible(false);
		itemPanel.setVisible(false);


		setDefaultCloseOperation(EXIT_ON_CLOSE);

		screen.setVisible(false);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//pack ();
		setFocusable(true);
		setVisible(true);
		
		startNewGame ();

		
		itemPanel = new ItemPanel();
		itemPanel.setPreferredSize(new Dimension(260,815));
		itemPanel.setMinimumSize(new Dimension(260,815));
		
		itemPanel.setVisible(false);
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.NORTH;
		yoloPanel.add(itemPanel);
	}
	
	private void makeNewGame () {
		if (itemPanel != null) remove(itemPanel);
		if (screen != null) remove(screen);
		
		model = new Model(this);	
		LevelData startLevel = new LevelData(LevelName.START);
		map = new Map(startLevel);
		
		itemPanel = new ItemPanel(model);
		mapPanel = new MapPanel(model, map);
		screen = new ScreenPanel(model, map, mapPanel);
		
		mouse = new YoloMouse(model, mapPanel);
		key = new YoloKeyboard(model.getPlayer());
		sounds = new SoundFactory();

		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		addMouseWheelListener(mouse);
		addKeyListener(key);

		setFocusable(true);
		setVisible(true);

		
	}
	
	private void startNewGame () {
		t = new Timer(TICK, this);
		startTimer = new Timer(1000, this);
		startTimer.start();
		add(yoloPanel);
		screen.repaint();
	}

	public void gameLoop() {
		if (startS) {
			startScreen.repaint();
		} else if (lost) {
			loseScreen.repaint();
		} else if (won) {
			winScreen.repaint ();
			startTimer.stop();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {}
			makeNewGame ();
			startNewGame ();
		} else {
			model.tick();
			key.update();
			mapPanel.repaint();
		}
	}

	public static void main(String[] args) {
		new YoloRiot();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (won == true) {
			
		}
		
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