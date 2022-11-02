package TigerGame;

public enum MapElementType {
	CLOUD, BUSH;
	
	public String toString() {
		switch(this) {
			case CLOUD: return "cloud";
			case BUSH: return "bush";
		}
		return "n/a";
	}
	
	
}
