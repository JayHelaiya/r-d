package com.bookstore;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.bookstore.dao.BookRepository;
import com.bookstore.dao.spec.Bookspec;
import com.bookstore.model.Book;

@SpringBootApplication
@EnableJpaAuditing
public class App implements CommandLineRunner  {

	@Autowired
	BookRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		//save();
		get();
		

	}
	private void get() {
		
		Optional<Book> findById = repository.findById(1L);
		System.out.println(findById.get());
	}

	private void save() {
		Book book=new Book();
		book.setTitle("viveka nunda");
		book.setAuthor("dipak bhatt");
		book = repository.save(book);
		System.out.println(book);
	}
}
