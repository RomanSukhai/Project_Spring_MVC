package ua.lviv.lgs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.lgs.domain.Participant;
import ua.lviv.lgs.service.ParticipantService;

@Controller
public class ParticipantController {

	
	 ParticipantService bookService = new ParticipantService();
	
	@GetMapping("/")
	public String init(HttpServletRequest request) {
		request.setAttribute("books", bookService.findAllParticipant());
		request.setAttribute("mode", "PRACTICIPANT_EDIT");
		return "index";
	}
	
	@GetMapping("/new")
	public String create(HttpServletRequest request) {
		request.setAttribute("mode", "PRACTICIPANT_CREATE");
		return "index";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int id,HttpServletRequest request) {
		bookService.delete(id);
		request.setAttribute("books", bookService.findAllParticipant());
		request.setAttribute("mode", "PRACTICIPANT_VIEW");
		return "index";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Participant book , HttpServletRequest request) {
		bookService.save(book);
		request.setAttribute("books", bookService.findAllParticipant());
		request.setAttribute("mode", "PRACTICIPANT_VIEW");
		return "index";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam int id, HttpServletRequest request) {
		bookService.findById(id);
		request.setAttribute("book", bookService.findAllParticipant());
		request.setAttribute("mode", "PRACTICIPANT_EDIT");
		return "index";
	}
	
}
