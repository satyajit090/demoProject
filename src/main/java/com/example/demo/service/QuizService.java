package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.QuestionDao;
import com.example.demo.dao.QuizDao;
import com.example.demo.entity.Question;
import com.example.demo.entity.QuestionWrapper;
import com.example.demo.entity.Quiz;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		// TODO Auto-generated method stub
		 
		List<Question> question=questionDao.findRandomQuestionByCategory(category,numQ);
		
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(question);
		quizDao.save(quiz);
		
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
		// TODO Auto-generated method stub
		
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questions = quiz.get().getQuestions();
		
		List<QuestionWrapper> questionsForUser=new ArrayList<>();
		for (Question q : questions) {
			
			QuestionWrapper questionWrapper=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionsForUser.add(questionWrapper);
			
		}
		
		return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
	}

	
	

}
