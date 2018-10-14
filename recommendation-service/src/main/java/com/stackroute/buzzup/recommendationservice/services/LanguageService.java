package com.stackroute.buzzup.recommendationservice.services;

import com.stackroute.buzzup.recommendationservice.model.Language;

public interface LanguageService {
	public Language findBylanguageName(String languageName);
}
