package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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

	public String updateQuestion(Integer id, Question question) {
		// TODO Auto-generated method stub
		
		 Optional<Question> byId = questionDao.findById(id);
		
		 if (byId.isPresent()) {
			 
			 Question que = byId.get();
			 
			 que.setOption1(question.getOption1());
			 que.setOption2(question.getOption2());
			 que.setOption3(question.getOption3());
			 que.setOption4(question.getOption4());
			 que.setQuestionTitle(question.getQuestionTitle());
			 que.setCategory(question.getCategory());
			 que.setDifficultyLevel(question.getDifficultyLevel());
			 que.setRightAnswer(question.getRightAnswer());
			 
			 questionDao.save(que);
			 
			 return "successful updated";
			 
			
		}
		 else {
		 
		return "id not found";
		 }
	}

	

}
