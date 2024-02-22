package com.semi.bookrep.service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.semi.bookrep.APIKEY;
import com.semi.bookrep.dao.ReportDao;
import com.semi.bookrep.dto.BookDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReportCService {
	
	@Autowired
	private ReportDao reportDao;

	public List<BookDTO> getBookByAPI(String keyword) throws IOException, InterruptedException {
		log.info("getBookByAPI()");
		
		HttpClient client = HttpClient.newHttpClient();
		String url = "https://openapi.naver.com/v1/search/book.json"
				+ "?query=" + URLEncoder.encode(keyword, "UTF-8")
				+ "&display=100";
		HttpRequest request = HttpRequest.newBuilder()
				.header("X-Naver-Client-Id", APIKEY.ID)
				.header("X-Naver-Client-Secret", APIKEY.SECRET)
				.uri(URI.create(url))
				.GET()
				.build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		String responseBody = response.body();
		NaverBook naverBook = new ObjectMapper().readValue(responseBody, NaverBook.class);
		List<NaverBook.Item> items = naverBook.getItems();
		List<BookDTO> bookList = new ArrayList<BookDTO>();
		try {
			for (NaverBook.Item item : items) {
				BookDTO bookDTO = new BookDTO(item.getTitle(), item.getAuthor(), item.getPublisher(), item.getIsbn(), item.getImage());
				bookList.add(bookDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bookList;
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class NaverBook{
		private List<Item> items;
		
		
		public List<Item> getItems() {
			return items;
		}


		@JsonIgnoreProperties(ignoreUnknown = true)
		public class Item{
			
			private String title;
			
			private String author;
			
			private String publisher;
			
			private String isbn;
			
			private String image;

			public String getTitle() {
				return title;
			}

			public String getAuthor() {
				return author;
			}

			public String getPublisher() {
				return publisher;
			}

			public String getIsbn() {
				return isbn;
			}

			public String getImage() {
				return image;
			}
			
		}
	}

}
