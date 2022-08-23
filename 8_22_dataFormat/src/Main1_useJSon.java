import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Main1_useJSon {
	// 사람
	// 이름 = 홍길동
	// 나이 = 22
	// 데이터를 추가해보자
	public static void main(String[] args) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		// jackson은 ObjectMapper객체로 전부 다룸
		ObjectNode node = mapper.createObjectNode();
		// 새 노드

		node.put("name", "홍길동");
		node.put("age", 22);
		node.put("boolean", true);
		// json 객체에 값 넣기
		// 값, value의 형태

		String json = mapper.writeValueAsString(node);
		// 노드를 String 문자열 형태로 바꿔줌

		System.out.println(json);
		
		
		
		ObjectNode node2 = mapper.createObjectNode();
		node2.put("이름", "둘리");
		node2.put("나이", "23");
		// 
		node.set("bf", node2);
		// 다른 객체도 넣을 수 있음. 여기서는 다른 node를 넣어봄.
		
		
		System.out.println(node);

	}

}
