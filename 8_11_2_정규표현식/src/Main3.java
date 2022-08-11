import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3 {
	public static void main(String[] args) {
		String line = "123 He234llo. 39 Wor48ld! 57 9";
		Pattern p = Pattern.compile("[0-9]{2,3}");
		// 중괄호 안에 들어있는 것: 길이값. (2자리 숫자부터 3자리 숫자까지.)
		Matcher m = p.matcher(line);
		
		boolean find = m.find();
		while (find) {
		System.out.println(m.start());
		System.out.println(m.end());
		find = m.find();
		}
	}
}
