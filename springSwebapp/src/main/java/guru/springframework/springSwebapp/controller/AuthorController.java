package guru.springframework.springSwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.springSwebapp.repositoreis.AuthorRepository;

@Controller
public class AuthorController {

	private final AuthorRepository authorRepository;

	
	public AuthorController(AuthorRepository authorRepository)
	{
		this.authorRepository=authorRepository;
	}
	
	@RequestMapping("/authors")
	public String getAuthor(Model model)
	{
		model.addAttribute("authors", authorRepository.findAll());
		return "authors/Alist";
	}
	
}
