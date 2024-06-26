package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Question;
import com.example.demo.service.QuestionService;

@RestController
@RequestMapping("/home")
public class QuestionController {
	@Autowired
	QuestionService questionService;
	
	
	@GetMapping("/allQue")
	public ResponseEntity<List<Question>> getAllQuestion() {
		//return "Satyajit";
		
		return questionService.getAllQuestion();
		
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
		return questionService.getQuestionByCategory(category);
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable Integer id) {
		
		
		return questionService.deleteQuestion(id);
		
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateQuestion(@PathVariable Integer id, @RequestBody Question question) {
		
		
		
		return questionService.updateQuestion(id, question);
		
		
	} 
      
}
