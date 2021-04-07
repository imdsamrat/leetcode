//PriorityQueue Implementation


class PriorityQueue {
	List<Integer> data;
	PriorityQueue() {
		data = new ArrayList<>();
	}

	public void add(int val) {
		data.add(val);
		upHeapify(data.szie() -1);
	}

	public void upHeapify(int i) {
		if(i == 0)
			return;
		int pi = (i - 1) / 2;
		if(data.get(i) < data.get(pi))
			swap(i, pi);
			upHeapify(pi);
		}
	}

	public int remove(int a) {
		if(data.size() == 0) {
			System.out.println("Underflow");
			return -1;
		}
		int val = data.get(data.size() -1);
		swap(0, data.size() -1);
		data.remove();
		downHeapify(0);
		return val;
	}

	public void downHeapify(int pi) {
		int mini = pi;
		int li = 2 * pi + 1;
		if(li < data.size() && data.get(li) < data.get(mini))
			mini = li;

		int ri = 2 * pi + 2;
		if(ri < data.size() && data.get(ri) < data.get(mini))
			mini = ri;

		if(mini != pi) {
			swap(mini, pi);
			downHeapify(mini);
		}
	}

	public int peek() {
		if(data.size() == 0) {
			System.out.println("Underflow");
			return -1;
		}
		return data.get(0);
	}

	public int size() {
		return data.size();
	}

}