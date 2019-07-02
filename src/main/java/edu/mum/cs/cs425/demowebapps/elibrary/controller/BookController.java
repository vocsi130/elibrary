package edu.mum.cs.cs425.demowebapps.elibrary.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.demowebapps.elibrary.model.Book;
import edu.mum.cs.cs425.demowebapps.elibrary.repository.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public ModelAndView books(){
		List<Book> books = (List<Book>) bookRepository.findAll();		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("books", books);
		modelAndView.setViewName("book/list");
		return modelAndView;
	}
	
	@RequestMapping(value="/book", method = RequestMethod.GET)
	public String create(Model model){			
		model.addAttribute("book", new Book());
		return "book/edit";
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("book") Book book, 
			BindingResult result, Model model)  {

		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "book/edit";
		}
		book = bookRepository.save(book);
		return "redirect:/books";
	}	
	
	
	
	@RequestMapping(value="/book/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id, Model model){		
		bookRepository.deleteById(id);
		return "redirect:/books";
	}	
	
}
