import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class prac_idAndTel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력하세요.");
		
		///////////////
		// 아이디는 영소문자와 숫자로 이루어져야 하고 최대 10자임.
		String inputid = sc.nextLine();
		Pattern idp = Pattern.compile("[0-9a-z]{6,10}");
		Pattern idp2 = Pattern.compile("[a-z]");
		// 대괄호 1개가 문자 한개의 범위를 표현할 수 있음.
		Matcher mid = idp.matcher(inputid);
		
		if (mid.matches() || idp2.matcher(inputid).lookingAt() ) {
			System.out.println("적합한 아이디");
		} else {
			System.out.println("올바르지 않음.");
		}
		
		
		System.out.println("전화번호를 입력하세요.");
		String inputTel = sc.nextLine();
		Pattern telP = Pattern.compile("[0-9-]{13}");
		Pattern telP2 = Pattern.compile("010-");
		// "010-[0-9]{4}-[0-9]{4}"
		// 요렇게 하는 편이 더 좋겠다...
		Matcher telM1 = telP.matcher(inputTel);
		Matcher telM2 = telP2.matcher(inputTel);
		
		boolean find1 = telM1.matches();
		boolean find2 = telM2.lookingAt();
		
		if (find1 && find2) {
			System.out.println("통과");
		} else {
			System.out.println("잘못된 입력");
		}
	}
}
