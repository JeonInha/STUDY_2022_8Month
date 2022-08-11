import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

	public static void main(String[] args) {
		String line = "This is a book.";
		Pattern p = Pattern.compile("is");
		// 이 안에 들어가는 정규표현식::
		Matcher m = p.matcher(line);
		// 패턴 객체를 통해 생성: 파라미터로 검사하고싶은 것 넣음.

		System.out.println(m.lookingAt());
		// lookingAt: 시작부분이 같은지 여부를 boolean값으로 출력

		boolean find = m.find();
		// 찾고자 하는 정규표현식을 찾았는지의 여부를 boolean 값으로 출력

		if (find) {
			System.out.println("시작: " + m.start()); // 정규표현식의 시작지점
			System.out.println("끝: " + m.end()); // 정규표현식의 끝지점
		}
		System.out.println("한번 더 찾장.");
		find = m.find(); // 다음 표현식 부분 찾음
		if (find) {
			System.out.println("시작: " + m.start()); // 정규표현식의 시작지점
			System.out.println("끝: " + m.end()); // 정규표현식의 끝지점
		}

		find = m.find(); // 다음 표현식 부분 찾음
		if (!find) {
			System.out.println("이제 없당");
		}

	}

}
