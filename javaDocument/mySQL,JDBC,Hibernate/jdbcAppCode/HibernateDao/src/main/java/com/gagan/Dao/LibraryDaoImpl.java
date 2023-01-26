package com.gagan.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.gagan.EMUtil.EMUtil;
import com.gagan.Entity.Book;
import com.gagan.Entity.Book_Genre;
import com.gagan.Exceptions.BookNotFound;
import com.gagan.Exceptions.GenreNotFound;

public class LibraryDaoImpl implements LibraryDao{

	@Override
	public boolean addBook(Book book, int genreid) {
		EntityManager em = EMUtil.provideEntityManager();
		boolean added = false ;
		Book_Genre bg = em.find(Book_Genre.class, genreid);
		em.getTransaction().begin();
		bg.getBooklist().add(book);
		added = true ;
		em.getTransaction().commit();
		em.close();
		
		return added;
	}

	@Override
	public boolean addGenre(Book_Genre bookGenre) {
		EntityManager em = EMUtil.provideEntityManager();
		boolean added = false ;
		em.getTransaction();
		em.persist(bookGenre);
		added = true ;
		em.getTransaction().commit();
		em.close();
		
		return added;
	}

	@Override
	public List<Book> getBooksByGenre(String genre) throws GenreNotFound {
		List<Book> booklist = null ;
		EntityManager em = EMUtil.provideEntityManager();
		String jpql = "select booklist from Book_Genre where genre_name=?1" ;
		Query q = em.createQuery(jpql);
		
		if(q!=null) {
			q.setParameter(1, genre);
			em.getTransaction().begin();
			booklist = q.getResultList();
			em.getTransaction().commit();
			
		
			
			
		}
		else {
			throw new GenreNotFound("Genre is not found");
		}
		
		
		em.close();
		
		return booklist;
	}

	@Override
	public String updateAuthorName(String bookName, String authorName) throws BookNotFound {
		
		EntityManager em = EMUtil.provideEntityManager();
		String update = "Not Updated" ;
		String jpql = "from Book where book_name=?1" ;
		Query q = em.createQuery(jpql);
		
		if(q!=null) {
			q.setParameter(1, bookName);
			em.getTransaction().begin();
			Book book = (Book) q.getSingleResult();
			book.setAuthor_name(authorName);
			update = "Updated" ;
			em.getTransaction().commit();	
		}
		else {
			throw new  BookNotFound("book is not found");
		}
		return update;
	}

	@Override
	public void removeGenre(String genre) throws GenreNotFound {
		EntityManager em = EMUtil.provideEntityManager();
	
		String jpql = "from BookGenre where genre_name=?1" ;
		Query q = em.createQuery(jpql);
		
		if(q!=null) {
			q.setParameter(1, genre);
			em.getTransaction().begin();
			Book_Genre bgenre = (Book_Genre) q.getSingleResult();
			em.remove(bgenre);
			
			em.getTransaction().commit();	
		}
		else {
			throw new  GenreNotFound("Genre is not found");
		}
	
	}

		
	

	@Override
	public void removeBook(String bookName) throws BookNotFound {
		EntityManager em = EMUtil.provideEntityManager();
	
		String jpql = "from Book where book_name=?1" ;
		Query q = em.createQuery(jpql);
		
		if(q!=null) {
			q.setParameter(1, bookName);
			em.getTransaction().begin();
			Book book = (Book) q.getSingleResult();
			em.remove(book);
		
			em.getTransaction().commit();	
			em.close();
		}
		else {
			throw new  BookNotFound("book is not found");
		}
	
	}

		
	}

	


