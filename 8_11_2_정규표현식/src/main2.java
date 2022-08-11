import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main2 {
	public static void main(String[] args) {
		
		String line = "1 He2llo. 3 Wor4ld! 5";
		Pattern p = Pattern.compile("[3-4]");
		// 대괄호에 문자에 대한 범위를 설정할 수 있음. 위의 예제는 0~9 사이의 숫자
		Matcher m = p.matcher(line);
		
		boolean find = m.find();
		while (find) {
			System.out.println(m.start());
			find = m.find();
		}

		
	}
}
