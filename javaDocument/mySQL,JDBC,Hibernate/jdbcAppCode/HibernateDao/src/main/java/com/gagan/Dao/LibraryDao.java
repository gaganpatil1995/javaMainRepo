package com.gagan.Dao;

import java.util.List;

import com.gagan.Entity.Book;
import com.gagan.Entity.Book_Genre;
import com.gagan.Exceptions.BookNotFound;
import com.gagan.Exceptions.GenreNotFound;

public interface LibraryDao {

	
	boolean addBook(Book book,int genreid);
	boolean addGenre(Book_Genre bookGenre);
	List<Book> getBooksByGenre(String genre) throws GenreNotFound;
	String updateAuthorName(String bookName, String authorName) throws BookNotFound;
	void removeGenre(String genre) throws GenreNotFound;
	void removeBook(String bookName) throws BookNotFound;
}
