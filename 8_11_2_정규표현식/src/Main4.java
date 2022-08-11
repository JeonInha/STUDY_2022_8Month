import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main4 {

	public static void main(String[] args) {
		String line1 = "lowercase";
		String line2 = "UPPERCASE";
		
		Pattern p1 = Pattern.compile("[a-z]{9}");
		// 문자에 대한 범위 줌. a-z로 이루어진 문자열 : 문자 수 9개
		Matcher m1 = p1.matcher(line1);
		
		System.out.println(m1.matches());
		// matches: 해당 정규형과 문자열이 일치할 때 true, 아니면 false;
		
		
		//////////////////////////////////////////////
		Pattern p2 = Pattern.compile("[A-Z]{9}");
		Matcher m2 = p2.matcher(line2);
		
		System.out.println(m2.matches());
		
		////////////////////////////
		// 한글 표현 : [가-힣]
		
		String line3 = "1q2w3e";
		Pattern p3 = Pattern.compile("[0-9a-z]{6}");
		// 범위가 숫자여도 되고 영소문자여도 됨.
		Matcher m3 = p3.matcher(line3);
		System.out.println(m3.matches());
		
	}
}
