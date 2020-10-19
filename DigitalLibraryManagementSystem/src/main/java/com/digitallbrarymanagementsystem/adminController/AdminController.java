package com.digitallbrarymanagementsystem.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitallbrarymanagementsystem.dto.BooksDTO;
import com.digitallbrarymanagementsystem.dto.UserDTO;
import com.digitallbrarymanagementsystem.userService.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired

	AdminService adminService;

	@GetMapping("/getalluser")
	List<UserDTO> getAllUser() {
		return adminService.getAllUser();
	}

	@GetMapping("/getallbooks")
	List<BooksDTO> getAllBooks() {
		return adminService.getAllBooks();
	}

	@GetMapping("/getallissuesdbooks")
	List<BooksDTO> getAllIssuesdBooks() {
		return adminService.getAllIssuesdBooks();
	}

	@PostMapping("/addnewbook")
	BooksDTO addNewBook(@RequestBody BooksDTO bookDTO) {
		return adminService.addNewBook(bookDTO);
	}

	@GetMapping("/issuebook")
	String issueBook(@PathVariable("userId") long userId, @RequestParam(value = "bookName") String bookName) {
		return adminService.issueBook(bookName, userId);
	}

	@GetMapping("/returnBook")
	String returnBook(long bookId) {
		return adminService.returnBook(bookId);
	}

}
