package com.semi.bookrep;


import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.semi.bookrep.dto.BookDTO;
import com.semi.bookrep.service.ReportCService.NaverBook;

public class NaverApiTest {

	@Test
	public void test() throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		String url = "https://openapi.naver.com/v1/search/book.json"
				+ "?query=" + URLEncoder.encode("¾Ë¶óµò", "UTF-8")
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
		for (BookDTO bookDTO : bookList) {
			System.out.println(bookDTO.getName());
		}
	}

}
