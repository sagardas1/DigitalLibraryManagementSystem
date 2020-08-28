package com.digitallbrarymanagementsystem.userService;

import java.util.List;

import com.digitallbrarymanagementsystem.dto.BooksDTO;
import com.digitallbrarymanagementsystem.dto.UserDTO;

public interface AdminService {

	List<UserDTO> getAllUser();

	List<BooksDTO> getAllBooks();

	List<BooksDTO> getAllIssuesdBooks();

	BooksDTO addNewBook(BooksDTO bookDTO);
	
	
	String issueBook(String bookName, long userId);
	String returnBook(long bookId);

}
