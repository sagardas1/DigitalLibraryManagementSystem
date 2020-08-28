package com.digitallbrarymanagementsystem.userDao;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digitallbrarymanagementsystem.model.Issue;

@Repository
@Transactional
public interface IssueDAO extends CrudRepository<Issue, Long> {

	@Query(value = "SELECT BID FROM ISSUE WHERE returnDate = NULL", nativeQuery = true)
	List<Long> getIssuedBookIds();
	
	@Query(value = "SELECT * FROM ISSUE WHERE BID = :BID", nativeQuery = true)
	List<Issue> getIssueByBookId(long bookId);

	@Modifying
	@Query(value = "UPDATE ISSUE SET returnDate = :date  WHERE BID = :BID", nativeQuery = true)
	int updateIssedBookReturnDate(LocalDate date, long BID);
	
	@Query(value = "SELECT BID, returnDate FROM ISSUE WHERE BID = :BID", nativeQuery = true)
	List<Object[]> getBookDetail(long BID);
	
	@Modifying
	@Query(value = "DELETE FROM ISSUE WHERE BID = :BID", nativeQuery = true)
	int deleteRecordByBID(long BID);


}
