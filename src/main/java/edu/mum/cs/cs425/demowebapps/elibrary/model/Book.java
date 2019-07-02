package edu.mum.cs.cs425.demowebapps.elibrary.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Books")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bookid", nullable=false, unique=true)
	private long idBook;
	private String title;
	private float free;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate datepublished;
	public Book(String title, float free, LocalDate datepublished) {
		this.title = title;
		this.free = free;
		this.datepublished = datepublished;
	}
	public Book() {
	}
	public long getIdBook() {
		return idBook;
	}
	public void setIdBook(long idBook) {
		this.idBook = idBook;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getFree() {
		return free;
	}
	public void setFree(float free) {
		this.free = free;
	}
	public LocalDate getDatepublished() {
		return datepublished;
	}
	public void setDatepublished(LocalDate datepublished) {
		this.datepublished = datepublished;
	}
	
	
	
	
}
