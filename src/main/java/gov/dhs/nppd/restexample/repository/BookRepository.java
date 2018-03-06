package gov.dhs.nppd.restexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.dhs.nppd.restexample.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
