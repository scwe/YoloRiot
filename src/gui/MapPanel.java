package gui;

import javax.swing.JPanel;
import map.Map;
import map.Tile;
import model.Model;
import java.awt.*;

public class MapPanel extends JPanel{
	private Map map;
	private Model model;
	
	public MapPanel(Model model, Map m){
		setPreferredSize(new Dimension(Tile.TILE_WIDTH*Map.MAP_WIDTH, Tile.TILE_HEIGHT* Map.MAP_HEIGHT));
		this.map = m;
		this.model = model;
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		Image offscreen = createImage(getWidth(), getHeight());
		Graphics2D buffer = (Graphics2D) offscreen.getGraphics();
		buffer.setColor(Color.black);
		buffer.fillRect(0, 0, getWidth(), getHeight());

		map.draw(buffer);
		model.draw(buffer);
		
		g2d.drawImage(offscreen, 0, 0, this);
	}
}
