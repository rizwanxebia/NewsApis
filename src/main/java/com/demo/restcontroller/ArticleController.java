package com.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.ResponseObject;
import com.demo.service.ArticleService;

@RestController
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@GetMapping(value = "/count/{query}")
	public ResponseEntity<?> getCount(@PathVariable(name = "query", required = true)String query){
		Object object = articleService.getArticleCount(query);
		return new ResponseEntity(object, HttpStatus.OK);
	}
	
	@GetMapping(value = "/sourceName/{query}")
	public ResponseEntity<?> getSourceName(@PathVariable(name = "query", required = true)String query){
		Object object = articleService.getSouceName(query);
		return new ResponseEntity(object, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getData/{parameter}")
	public ResponseEntity<?> getResponseSelectedParameter(@PathVariable(name = "parameter", required = true)String parameter){
		Object object = articleService.getResponseSelectedParameter(parameter);
		return new ResponseEntity(object, HttpStatus.OK);
	}
	
	
}
