package com.demo.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Article;
import com.demo.model.ResponseObject;
import com.demo.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private NewsApiWrapperService wrapperService;

	@Override
	public int getArticleCount(String query) {
		ResponseObject responseObject = wrapperService.getResponse(query);
		return responseObject.getTotalResults();
	}

	@Override
	public List<String> getSouceName(String query) {
		ResponseObject responseObject = wrapperService.getResponse(query);
		List<String> list = new ArrayList<String>();
		if (responseObject != null) {
			for (Article article : responseObject.getArticles()) {
				list.add(article.getSource().getName());
			}
		}
		return list;
	}
	public ResponseObject getResponseSelectedParameter(String parameter ) {
		return wrapperService.getResponseSelectedParameter(parameter);
	}
}
