package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.stereotype.Service;

import com.example.demo.dao.QuestionDao;
import com.example.demo.entity.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	
	
	//Display all questions and answer ....
	
	public ResponseEntity<List<Question>> getAllQuestion() {
		
		try {
			return  new ResponseEntity<>( questionDao.findAll(), HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
		return  new ResponseEntity<>( new ArrayList<>(), HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	//Display only those question format , users are requesting 

	
	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		// TODO Auto-generated method stub
		
		try {
			return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.BAD_REQUEST);
	}

	
	//Adding question and answer 
	public ResponseEntity<String> addQuestion(Question question) {
		// TODO Auto-generated method stub
		  
		 
		  try {
			  questionDao.save(question);
			 return new ResponseEntity<>("Success", HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return new ResponseEntity<>("FAil", HttpStatus.INTERNAL_SERVER_ERROR) ;
	}

	
	
	//delete the question
	
	public  ResponseEntity<String> deleteQuestion(Integer id) {
		// TODO Auto-generated method stub
		
		try {
			
		questionDao.deleteById(id);
		return new ResponseEntity<>( "Successfuly deleted",HttpStatus.NO_CONTENT);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<>( "Successfuly deleted",HttpStatus.NO_CONTENT);
	
	}

	
	//Update questions
	public ResponseEntity<String> updateQuestion(Integer id, Question question) {
		// TODO Auto-generated method stub
		
		
		 try {
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
				 
				 return  new ResponseEntity<>("successful updated",HttpStatus.OK);
				 
				
			}
			 else {
			 
				 return  new ResponseEntity<>("successful updated",HttpStatus.BAD_REQUEST);
			 }
			 
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 return  new ResponseEntity<>("successful updated",HttpStatus.BAD_REQUEST);
	}

	

}
