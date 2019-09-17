package com.joeknowles.Week19.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.joeknowles.Week19.models.overflow.Answer;
import com.joeknowles.Week19.models.overflow.Question;
import com.joeknowles.Week19.models.overflow.Tag;
import com.joeknowles.Week19.repository.overflow.AnswerRepository;
import com.joeknowles.Week19.repository.overflow.QuestionRepository;
import com.joeknowles.Week19.repository.overflow.TagRepository;

@Service
public class OverFlowService {
	private QuestionRepository qRepo;
	private AnswerRepository aRepo;
	private TagRepository tRepo;
	
	public OverFlowService(QuestionRepository q, AnswerRepository a, TagRepository t) { qRepo = q; aRepo = a; tRepo = t; }
	
	public void createQuestion(Question q) { qRepo.save(q); }
	public List<Question> allQuestions() { return qRepo.findAll(); }
	public Optional<Question> findQuestionById(Long id) { return qRepo.findById(id); }
	public void updateQuestion(Question q) { qRepo.save(q); }
	public void createAnswer(Answer a) { aRepo.save(a); }
	public List<Answer> allAnswers() { return aRepo.findAll(); }
	public Optional<Answer> findAnswerById(Long id) { return aRepo.findById(id); }
	public void createTag(Tag t ) { tRepo.save(t); }
	public List<Tag> allTags() { return tRepo.findAll(); }
	public Optional<Tag> findTagById(Long id) { return tRepo.findById(id); }
}
