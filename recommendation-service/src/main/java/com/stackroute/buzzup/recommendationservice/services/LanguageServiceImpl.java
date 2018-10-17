package com.stackroute.buzzup.recommendationservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.recommendationservice.model.Language;
import com.stackroute.buzzup.recommendationservice.repositories.LanguageRepository;


@Service
public class LanguageServiceImpl implements LanguageService {

	private LanguageRepository languageRepository;

	@Autowired
	public LanguageServiceImpl(LanguageRepository languageRepository) {
		super();
		this.languageRepository = languageRepository;
	}

	@Override
	public Language findBylanguageName(String languageName) {

		return languageRepository.findByName(languageName);
	}

}
