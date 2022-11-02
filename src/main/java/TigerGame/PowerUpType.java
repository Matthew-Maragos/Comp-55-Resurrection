package TigerGame;

public enum PowerUpType {
	
ONEUP, DOUBLEJUMP, INVINCIBILITY, JEOPARDY;
	
	public String toString() {
		switch(this) {
			case ONEUP: return "cloud";
			case DOUBLEJUMP: return "doublejump";
			case INVINCIBILITY: return "invincibility";
			case JEOPARDY: return "jeopardy";
			
		}
		return "n/a";
	}
	
}
