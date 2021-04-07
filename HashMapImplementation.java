// HashMap implementation

class HashMap {
	class Node {
		int hashCode;
		Key key;
		int value;
		Node next;
	}

	class Key {
		String key;
		Key(String key) {
			this.key = key;
		}

		@Override
		public int hashCode(String key) {
			return hashValue(key); // return hash value of key
		}

		@Override
		public boolean equals(Object obj) {
			return key.equals((String)obj);
		}
	}

	int size;
	List<Node> map;

	HashMap() {
		map = new ArrayList<>();
		size = 0;
	}

	public void put(String key, int value) {
		Key currKey = new Key(key);
		int index = currKey.hashCode() & (size - 1);
		Node node = map.get(index);
		// insert into this node linked list using currKey
	}

	public int get(int key) {
		Key currKey = new Key(key);
		int index = currKey.hashCode() & (size - 1);
		Node node = map.get(index);
		// retrieve value from node linked list using currKey
	}

	public int remove(int key) {
		Key currKey = new Key(key);
		int index = currKey.hashCode() & (size - 1);
		Node node = map.get(index);
	}

	public int size() {
		return size;
	}

}