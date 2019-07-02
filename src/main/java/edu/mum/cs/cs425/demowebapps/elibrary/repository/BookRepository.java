package edu.mum.cs.cs425.demowebapps.elibrary.repository;


import org.springframework.data.repository.CrudRepository;

import edu.mum.cs.cs425.demowebapps.elibrary.model.Book;

public interface BookRepository  extends CrudRepository<Book, Long>{


}
