import java.util.*;

public class WorkSchedule {
	/*
	 * Complete the 'findSchedules' function below.
	 *
	 * The function is expected to return a STRING_ARRAY. The function accepts
	 * following parameters: 1. INTEGER workHours 2. INTEGER dayHours 3. STRING
	 * pattern
	 */
	static ArrayList<String> ans = new ArrayList<>();
	static int day_hours, work_hours;

	public static List<String> findSchedules(int workHours, int dayHours, String pattern) {

		work_hours = workHours;
		day_hours = dayHours;

		StringBuilder sb = new StringBuilder(pattern);

		int existingHours = 0;
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.charAt(i) != '?')
				existingHours += (pattern.charAt(i) - '0');
		}

		int remainingHours = work_hours - existingHours;
		rec(sb, 0, pattern.length(), remainingHours);

		String[] ansArray = new String[ans.size()];

		for (int i = 0; i < ans.size(); i++)
			ansArray[i] = ans.get(i);
		// System.out.println(Arrays.toString(ansArray));
		return ans;
	}

	public static void rec(StringBuilder sb, int i, int n, int remainingHours) {
		if (i >= n) {
			if (remainingHours == 0)
				ans.add(sb.toString());
			return;
		}

		if (sb.charAt(i) != '?')
			rec(sb, i + 1, n, remainingHours);
		else {
			for (int j = 0; j <= day_hours; j++) {
				sb.setCharAt(i, (char) ('0' + j));
				rec(sb, i + 1, n, remainingHours - j);

				sb.setCharAt(i, '?');
			}
		}

	}
}
