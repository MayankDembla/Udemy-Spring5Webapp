package com.ayan.spring.webapp.service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class JokeServiceImpl implements JokeService {

    private final ChuckNorrisQuotes chuckNorrisQuotes;

    public JokeServiceImpl(ChuckNorrisQuotes chuckNorrisQuotes) {
        this.chuckNorrisQuotes = chuckNorrisQuotes; // Now this is not in Spring Context as it is coming from Jar
    }


    @Override
    public String getJoke() {
        return chuckNorrisQuotes.getRandomQuote();
    }
}
