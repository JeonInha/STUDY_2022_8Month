import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main7 {
	
	private static String getSaraminInfo(String url) throws IOException {
		Document doc = Jsoup.connect(url).timeout(5000).get();
		String info = doc.select("meta[name=description]").first().attr("content");
		return info;
	}
	
	public static void main(String[] args) throws IOException {
		String searchURL = "https://www.saramin.co.kr/zf_user/search?search_area=main&search_done=y&search_optional_item=n&searchType=search&searchword=java";
		String startString = "/zf_user/jobs/relay/view";
		
		Document doc = Jsoup.connect(searchURL).timeout(5000).get();
		Elements links = doc.select("a[href]");
		
		Set<String> set = new HashSet<>();
		for (Element e : links) {
			String attr = e.attr("href");
			if (attr.startsWith(startString)) {
				set.add("http://www.saramin.co.kr" + attr);
			}
		}
		
//		for (String url : set) {
//			System.out.println(getSaraminInfo(url));
//			}
//		}
		
		set.parallelStream().map(url -> {
			try {
				return getSaraminInfo(url);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return null;
		}).forEach(System.out::println);
	}
}
