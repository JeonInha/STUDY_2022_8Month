package world;

public class Country {
	String name;
	int population;
	
	public Country(String name, int population) {
		super();
		this.name = name;
		this.population = population;
	}

	@Override
	public String toString() {
		return String.format("국가명: %s, 인구수: %d", name, population);
	}
}