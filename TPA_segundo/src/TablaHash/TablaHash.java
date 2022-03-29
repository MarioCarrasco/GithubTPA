package TablaHash;

public abstract class TablaHash {

	protected Object[][] array;

	TablaHash(int startSize) {
		array = new Integer[startSize][2];
	}

	abstract int hash(Integer key, int collision);

	public void add(Integer key, Integer val) {
		int collision = 0;
		while(array[hash(key, collision) % array.length][0] != null) {
			collision++;
		}
		array[hash(key, collision) % array.length][0] = key;
		array[hash(key, collision) % array.length][1] = val;

		for (Object[] i : array) {
			System.out.println("["+i[0]+", "+i[1]+"]");
		}
		System.out.println("[###################]");
	}

}
