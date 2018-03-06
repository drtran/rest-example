package gov.dhs.nppd.restexample.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import gov.dhs.nppd.restexample.domain.Book;
import gov.dhs.nppd.restexample.service.exception.BookAlreadyExistsException;

public interface BookService {
	Book saveBook(@NotNull @Valid final Book book) throws BookAlreadyExistsException;

	List<Book> getList();

	Book getBook(Long bookId);

	void deleteBook(final Long bookId);
}
