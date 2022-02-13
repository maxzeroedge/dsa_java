public class CoursePrerequisitePairs {

	static class Node<T> {
		public Node<T> next;
		public T data;
		public Node(T data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		// x a b y c d
		String[][] coursePair1 = new String[][]{{"a", "b"}, {"c", "d"}, {"x", "a"}, {"b", "y"}, {"y", "c"}};
		System.out.println(getMidCourse(coursePair1));
	}

	public static String getMidCourse(String[][] inputCoursePairs) {
		Node<String> courseRoot = null;
		boolean[] visited = new boolean[inputCoursePairs.length+1];
		int currentIndex = -1;
		while(++currentIndex < inputCoursePairs.length) {
			if(visited[currentIndex]) {continue;}
			String[] coursePair = inputCoursePairs[currentIndex];
			if(courseRoot == null) {
				courseRoot = new Node<>(coursePair[1]);
				courseRoot.next = new Node<>(coursePair[0]);
			}
			visited[currentIndex] = true;
			Node<String> temp = courseRoot;
			Node<String> prev = null;
			// Find coursePair[0] in linkedList
			while(temp != null) {
				if(temp.data == coursePair[0]) {break;}
				prev = temp;
				temp = temp.next;
			}
			for(int i = 0; i < inputCoursePairs.length; i++) {
				// Find the course whose prerequisite is coursePair[0]
				if(inputCoursePairs[i][1] == coursePair[0]) {
					visited[i] = true;
					Node<String> tempData = new Node<>(inputCoursePairs[i][1]);
					tempData.next = temp;
					if(prev != null) {prev.next = temp;}
					else {courseRoot = tempData;}
				}
			}
		}
		Node<String> high = courseRoot, low = courseRoot;
		while(high != null && low != null && high.next != null) {
			low = low.next;
			high = high.next.next;
		}
		return low.data;
	}
	
}
