package TigerGame;

public enum PowerUpType {
	
ONEUP, DOUBLEJUMP, INVINCIBILITY, JEOPARDY, EXTRAPOINTS;
	
	public String toString() {
		switch(this) {
			case ONEUP: return "oneup";
			case DOUBLEJUMP: return "doublejump";
			case INVINCIBILITY: return "invincibility";
			case EXTRAPOINTS: return "extrapoints";
		}
		return "n/a";
	}
	
}