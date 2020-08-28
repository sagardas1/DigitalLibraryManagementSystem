package com.digitallbrarymanagementsystem.userDao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digitallbrarymanagementsystem.model.Books;


@Repository
@Transactional
public interface BooksDAO extends CrudRepository<Books, Long>{
	
	
	@Query(value = "SELECT * FROM BOOKS WHERE BID = :BID", nativeQuery = true)
	List<Books> getBookById(long BID);
	
	@Query(value = "SELECT * FROM BOOKS WHERE bookName = :bookName", nativeQuery = true)
	List<Books> getBookByName(String bookName);
	
	@Query(value = "SELECT BID FROM BOOKS WHERE bookName = :bookName", nativeQuery = true)
	List<Long> getBookIdByBookName(String bookName);

}
