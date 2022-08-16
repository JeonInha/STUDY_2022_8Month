package signUp;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class AccVailidator {

	public Map<String, String> vaildID(String id) {
		AccManagerDaoImpl ad = new AccManagerDaoImpl();
		Map<String, String> error = new HashMap<>();
		Pattern p = Pattern.compile("[0-9a-zA-Z\\_]");
		if (id != null) {
			if (id.length() < 4 || id.length() > 12) {
				error.put("id_length", "아이디는 4자 이상 12자 이내로 입력해주세요.");
			}
			if (!(p.matcher(id).matches())) {
				error.put("id_error", "아이디에는 지정된 문자(숫자, 영문자, _)만 사용해주세요.");
			}
			if (ad.getIdCheck(id)) {
				error.put("id_duplicate", "이미 존재하는 아이디입니다.");
			}
		} else {
			error.put("id_null", "아이디를 입력하세요.");
		}
		return error;
	}

	public Map<String, String> vaildNic(String nickname) {
		Map<String, String> error = new HashMap<>();
		Pattern p = Pattern.compile("[0-9a-zA-Z가-힣]");
		
		if (nickname != null) {
			if (nickname.length()==0 || nickname.length()>8) {
				error.put("nic_length", "닉네임은 8자 이내로 입력해주세요.");
			}
			if (!(p.matcher(nickname).matches())) {
				error.put("nic_error", "닉네임은 지정된 문자(영문자, 숫자, 한글)만 사용해주세요..");
			}
		} else {
			error.put("nic_null", "닉네임을 입력하세요.");
		}
		return error;
	}

	public Map<String, String> vaildPW(String pw) {
		Map<String, String> error = new HashMap<>();
		Pattern p = Pattern.compile("[0-9a-z]");
		
		if (pw != null) {
			if (pw.length() < 4 || pw.length() > 12) {
				error.put("pw_length", "패스워드는 4자 이상 12자 이내로 입력해주세요.");
			}
			if (!(p.matcher(pw).matches())) {
				error.put("pw_error", "패스워드에는 지정된 문자(영소문자, 숫자)만 사용해주세요.");
			}
		} else {
			error.put("pw_null", "패스워드를 입력하세요.");
		}
		return error;
	}

}
