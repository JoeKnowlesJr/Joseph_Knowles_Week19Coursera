package com.joeknowles.Week19.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joeknowles.Week19.models.overflow.Answer;
import com.joeknowles.Week19.models.overflow.Question;
import com.joeknowles.Week19.models.overflow.Tag;
import com.joeknowles.Week19.services.OverFlowService;

@Controller
public class OverFlowController {
	private OverFlowService service;
	
	public OverFlowController(OverFlowService s) { service = s; }
	
	@PostMapping("/overflow")
	public String overflowhome() {
		return "overflow/index";
	}
	
	@PostMapping("/overflow/dash")
	public String overflowdash(Model model) {
		model.addAttribute("questions", service.allQuestions());
		return "overflow/dash";
	}	
	
	@PostMapping("/overflow/newQuestion")
	public String overflownewquestion() {
		return "overflow/newQuestion";
	}
	
	@PostMapping("/overflow/createQuestion")
	public String overflowcreatequestion(Model model, @RequestParam("question") String question, @RequestParam(name="tags", required=false) String tags) {
		Question q = new Question(question);
		if (tags != null && !tags.isEmpty()) {
			String[] parts = tags.split(",");
			List<Tag> tList = service.allTags();
			for (String s : parts) {
				Tag t = new Tag(s);
				if (!tList.contains(t)) {
					service.createTag(t);
				}
				q.addTag(t);
			}
		}
		service.createQuestion(q);
		model.addAttribute("questions", service.allQuestions());
		return "overflow/dash";
	}
	
	@GetMapping("/overflow/show/{id}")
	public String overflowshowget(Model model, @PathVariable("id") Long q_id) {
		Optional<Question> oQ = service.findQuestionById(q_id);
		if (oQ.isPresent()) {
			model.addAttribute("question", oQ.get());
		}
		return "overflow/ofShow";
	}	
	
	@PostMapping("/overflow/show/{id}")
	public String overflowshowpost(Model model, @PathVariable("id") Long q_id) {
		Optional<Question> oQ = service.findQuestionById(q_id);
		if (oQ.isPresent()) {
			model.addAttribute("question", oQ.get());
		}
		return "overflow/ofShow";
	}	
	
	@PostMapping("/overflow/tags/{id}")
	public String overflowshowbytag(Model model, @PathVariable("id") Long t_id) {
		Optional<Tag> oT = service.findTagById(t_id);
		if (oT.isPresent()) {
			Tag t = oT.get();
			model.addAttribute("questions", t.getQuestions());
			model.addAttribute("tagged", true);
			model.addAttribute("tag", t.getSubject());
		}
		return "overflow/dash";
	}
	
	@PostMapping("/overflow/answerQuestion")
	public String answerQuestion(Model model, @RequestParam("q_id") Long q_id, @RequestParam("answer") String answer) {
		Optional<Question> oQ = service.findQuestionById(q_id);
		if (oQ.isPresent()) {
			Question q = oQ.get();
			Answer a = new Answer(answer);
			q.addAnswer(a);
			service.createAnswer(a);
			service.updateQuestion(q);
		}
		return "redirect:/overflow/show/" + q_id;
	}
	
	
	
	
}
