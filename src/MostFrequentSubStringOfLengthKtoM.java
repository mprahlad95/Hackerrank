import java.util.*;

public class MostFrequentSubStringOfLengthKtoM {
	public static int getMaxOccurrences(String s, int minLength, int maxLength, int maxUnique) {
		Set<Character> uniqueChars = new HashSet<Character>();
		Map<String, Integer> stats = new HashMap<String, Integer>();
		for (int i = 0; i <= s.length() - minLength; i++) {
			for (int j = i + minLength; j <= s.length() && j <= i + maxLength && uniqueChars.size() <= maxUnique; j++) {
				uniqueChars.clear();
				String subStr = s.substring(i, j);
				if (stats.containsKey(subStr)) {
					stats.put(subStr, stats.get(subStr) + 1);
					for (char c : s.toCharArray())
						uniqueChars.add(c);
				} else
					stats.put(subStr, 1);
			}
		}

		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(stats.size(),
				new Comparator<Map.Entry<String, Integer>>() {
					@Override
					public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
						return o2.getValue() - o1.getValue();
					}
				});

		pq.addAll(stats.entrySet());
		Map.Entry<String, Integer> entry = pq.poll();
		return entry.getValue();
	}

	public static void main(String[] args) {
		getMaxOccurrences("ababab", 2, 3, 4);
	}
}
