package model;

public enum SystemLevel {
	LEVEL_1(1),
	LEVEL_2(2),
	LEVEL_3(3);
int systemLevel;
	
	private SystemLevel(int value) {
		systemLevel = value;
	}
	
	public int value() {
		return systemLevel;
	}
	
}
