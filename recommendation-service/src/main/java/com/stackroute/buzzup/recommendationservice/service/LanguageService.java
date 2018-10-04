package com.stackroute.buzzup.recommendationservice.service;

import com.stackroute.buzzup.recommendationservice.model.Language;

public interface LanguageService {
	public Language findBylanguageName(String languageName);
}
