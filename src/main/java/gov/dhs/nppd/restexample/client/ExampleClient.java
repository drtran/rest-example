package gov.dhs.nppd.restexample.client;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import gov.dhs.nppd.restexample.domain.Book;

public class ExampleClient {
	public static final Book[] LIBRARY = { new Book(1L, "Margaret Mitchell", "Gone With The Wind"),
			new Book(2L, "William Shakespeare", "Hamlet"), new Book(3L, "William Shakespeare", "Macbeth"),
			new Book(4L, "Mark Twain", "Adventures of Huckleberry"),
			new Book(5L, "Mark Twain", "Life on the Mississippi"), new Book(6L, "Plato", "The Republic"), };

	public static void main(String[] args) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			for (Book book : LIBRARY) {
				restTemplate.postForEntity("http://localhost:8181/books", book, Book.class);
			}
			for (int i = 1; i <= LIBRARY.length; i++) {
				ResponseEntity<Book> response = restTemplate
						.getForEntity(String.format("http://localhost:8181/books/%d", i), Book.class);
				System.out.println(response.getBody());
			}

			for (int i = 1; i <= LIBRARY.length; i++) {
				restTemplate.delete(new URI(String.format("http://localhost:8181/books/%d", i)));

				System.out.println("Removed book id: " + i);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}