package com.digitallbrarymanagementsystem.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitallbrarymanagementsystem.dto.BooksDTO;
import com.digitallbrarymanagementsystem.dto.UserDTO;
import com.digitallbrarymanagementsystem.model.Books;
import com.digitallbrarymanagementsystem.model.Issue;
import com.digitallbrarymanagementsystem.model.IssueDump;
import com.digitallbrarymanagementsystem.model.RegistrationVo;
import com.digitallbrarymanagementsystem.userDao.BooksDAO;
import com.digitallbrarymanagementsystem.userDao.IssueDAO;
import com.digitallbrarymanagementsystem.userDao.IssueDumpDAO;
import com.digitallbrarymanagementsystem.userDao.UserDoa;
import com.digitallbrarymanagementsystem.userService.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserDoa userDoa;

	@Autowired
	private BooksDAO booksDAO;

	@Autowired
	private IssueDAO issueDAO;

	@Autowired
	private IssueDumpDAO issueDumpDAO;

	@Override
	public List<UserDTO> getAllUser() {
		List<RegistrationVo> allUsers = (List<RegistrationVo>) userDoa.findAll();
		List<UserDTO> userList = new ArrayList<>();
		for (RegistrationVo registrationVo : allUsers) {
			userList.add(new UserDTO(registrationVo.getuID(), registrationVo.getUserName(), registrationVo.getAdmin()));
		}

		return userList;
	}

	@Override
	public List<BooksDTO> getAllBooks() {
		// TODO Auto-generated method stub
		List<BooksDTO> allBooks = new ArrayList<>();

		List<Books> allBooksFromDB = (List<Books>) booksDAO.findAll();
		for (Books book : allBooksFromDB) {
			allBooks.add(new BooksDTO(book.getBID(), book.getBookName(), book.getPrice(), book.getGenre()));

		}

		return allBooks;
	}

	@Override
	public List<BooksDTO> getAllIssuesdBooks() {
		List<Long> issuedBookIds = issueDAO.getIssuedBookIds();
		List<BooksDTO> issuedBooks = new ArrayList<>();

		for (long BID : issuedBookIds) {
			List<Books> getBook = booksDAO.getBookById(BID);
			issuedBooks.add(new BooksDTO(getBook.get(0).getBID(), getBook.get(0).getBookName(),
					getBook.get(0).getPrice(), getBook.get(0).getGenre()));
		}

		return issuedBooks;
	}

	
	@Override
	public BooksDTO addNewBook(BooksDTO bookDTO) {
		// TODO Auto-generated method stub
		List<Books> book = booksDAO.getBookByName(bookDTO.getBookName());
		if (book.size() == 0) {
			Books newBook = new Books();
			newBook.setBookName(bookDTO.getBookName());
			newBook.setGenre(bookDTO.getGenre());
			newBook.setPrice(bookDTO.getPrice());

			booksDAO.save(newBook);
			return bookDTO;

		}

		return null;
	}

	@Override
	public String returnBook(long bookId) {
		// TODO Auto-generated method stub
		// int updateCheck = issueDAO.updateIssedBookReturnDate(LocalDate.now(),
		// bookId);
		List<Issue> getissue = issueDAO.getIssueByBookId(bookId);

		IssueDump issueDump = new IssueDump();
		issueDump.setBID(getissue.get(0).getBID());
		issueDump.setFine(getissue.get(0).getFine());
		issueDump.setIssueDate(getissue.get(0).getIssueDate());
		issueDump.setPeriod(getissue.get(0).getPeriod());
		issueDump.setUID(getissue.get(0).getIID());
		issueDump.setReturnDate(LocalDate.now());

		issueDumpDAO.save(issueDump);

		issueDAO.deleteRecordByBID(bookId);

		return "Updated the return date.";
	}

	@Override
	public String issueBook(String bookName, long userId) {
		List<Long> bookId = booksDAO.getBookIdByBookName(bookName);
		if (bookId.size() == 0) {
			return "Book not present.";
		}

		List<Object[]> bookDetail = issueDAO.getBookDetail(bookId.get(0));

		if (bookDetail.size() == 0) {
			// we can addd.
			Issue issue = new Issue();
			issue.setBID(bookId.get(0));
			issue.setFine(0);
			issue.setIssueDate(LocalDate.now());
			issue.setPeriod(30);
			issue.setReturnDate(null);
			issue.setUID(userId);
			issueDAO.save(issue);

			return "Book is issued.";
		} else {
			if (Objects.nonNull(bookDetail.get(0)[1])) {
				Issue issue = new Issue();
				issue.setBID(bookId.get(0));
				issue.setFine(0);
				issue.setIssueDate(LocalDate.now());
				issue.setPeriod(30);
				issue.setReturnDate(null);
				issue.setUID(userId);
				issueDAO.save(issue);

				return "Book is issued.";
			} else {
				return "Book is already issued.";
			}
		}

	}

}
