
public enum shipType {
	ENEMYSHIP, BOSSSHIP, PLAYERSHIP;
	public String toSring() {
		switch(this){
		case ENEMYSHIP: return "enemyship";
		case BOSSSHIP: return "bossShip";
		case PLAYERSHIP: return "playership";
		}
		return "n/a";
	}
}


