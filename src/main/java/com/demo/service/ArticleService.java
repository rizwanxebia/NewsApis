package com.demo.service;

import java.util.List;

import com.demo.model.ResponseObject;

public interface ArticleService {
	
	public int getArticleCount(String query);
	
	public List<String> getSouceName(String query);
	public ResponseObject getResponseSelectedParameter(String parameter );

}
