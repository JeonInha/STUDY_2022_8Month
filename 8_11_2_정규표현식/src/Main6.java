import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main6 {

	public static void main(String[] args) {
		String line = "(abc, 123) | (de, 6) | (qewr, 15)";
		Pattern p = Pattern.compile("\\(([a-zA-Z]+), ([0-9]+)\\)");

		Matcher m = p.matcher(line);

		while (m.find()) {
			System.out.println(m.group(1));
			System.out.println(m.group(2));
		}

	}

}
