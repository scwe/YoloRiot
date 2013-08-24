package map;

public class LevelData {
	

	String innerTile,outerTile,cornerTile;
	public LevelData(LevelName ln) {
		this.innerTile = ln.inner;
		this.outerTile = ln.outer;
		this.cornerTile = ln.corner;
	}

	public String getInnerTile() {
		return innerTile;
	}
	public void setInnerTile(String innerTile) {
		this.innerTile = innerTile;
	}
	public String getOuterTile() {
		return outerTile;
	}
	public void setOuterTile(String outerTile) {
		this.outerTile = outerTile;
	}
	public String getCornerTile() {
		return cornerTile;
	}
	public void setCornerTile(String cornerTile) {
		this.cornerTile = cornerTile;
	}
	
	public enum LevelName{
	
		START("START_TILES_INNER.png", "START_TILES_OUTER.png", "START_TILES_CORNER.png");

		public final String inner;
		public final String outer;
		public final String corner;
		
		private LevelName(String inner, String outer, String corner) {
			this.inner = inner;
			this.outer = outer;
			this.corner = corner;
		}
		
		

	}
}
