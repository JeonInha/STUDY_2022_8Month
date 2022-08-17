package board;

public class BoardArticle {
	private int ba_id;
	private String title;
	private String content;
	
	public BoardArticle(int ba_id, String title, String content) {
		super();
		this.ba_id = ba_id;
		this.title = title;
		this.content = content;
	}

	public BoardArticle(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	
	public int getBa_id() {
		return ba_id;
	}
	public void setBa_id(int ba_id) {
		this.ba_id = ba_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	// 제목 내용 생성자 게터세터 등등
}
