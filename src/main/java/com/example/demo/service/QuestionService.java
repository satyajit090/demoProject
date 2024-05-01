package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.QuestionDao;
import com.example.demo.entity.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	
	public List<Question> getAllQuestion() {
		// TODO Auto-generated method stub
		return questionDao.findAll();
	}

	public List<Question> getQuestionByCategory(String category) {
		// TODO Auto-generated method stub
		return questionDao.findByCategory(category);
	}

	public String addQuestion(Question question) {
		// TODO Auto-generated method stub
		  questionDao.save(question);
		 
		 return "Success";
	}

	public String deleteQuestion(Integer id) {
		// TODO Auto-generated method stub
		questionDao.deleteById(id);
		return "Successfuly deleted";
	}

	

}
