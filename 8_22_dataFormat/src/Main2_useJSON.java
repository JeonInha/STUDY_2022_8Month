import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import model.Person;

public class Main2_useJSON {
	public static void main(String[] args) throws JsonProcessingException {
		Person hong = new Person("홍길동", 22);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(hong);
		// 이렇게 문자열표현으로 바로바꿀수있음!!
		System.out.println(json);
		
		String jsonString = "{\"name\":\"둘리\",\"age\":23}";
		// 문자열 표현 제이슨 객체를 매퍼를 통해 클래스형태로 변환이 가능함.
		// 자바 객체로 재생성됨.
		Person dooli = mapper.readValue(jsonString, Person.class);
		
		System.out.println(dooli.getName());
		System.out.println(dooli.getAge());
	}
}
