package com.toyproject.service;


import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.toyproject.domain.Word;
import com.toyproject.repository.WordRepository;
import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class NlpService {

    @Autowired
    WordRepository wordRepository;

    public void process() throws IOException{
        File file = new File("resource/Jim_Carrey.txt");
        List<String> lines = Files.readLines(file, Charsets.UTF_8);

        for (String line : lines) {
            Document doc = new Document(line);
            for (Sentence sent : doc.sentences()) {

                List<String> lemmas = sent.lemmas().stream()
                        .filter(s -> !s.equals(",")&&!s.equals(".")&&!s.equals("?"))
                        .collect(toList());
                List<String> words = sent.words().stream()
                        .filter(s -> !s.equals(",")&&!s.equals(".")&&!s.equals("?"))
                        .collect(toList());
                List<String> postTags = sent.posTags().stream()
                        .filter(s -> !s.equals(",")&&!s.equals(".")&&!s.equals("?"))
                        .collect(toList());
                for (int i = 0; i < lemmas.size(); i++) {

                    try{
                        Word word = new Word();
                        word.setWord(lemmas.get(i));
                        word.setPostTag(postTags.get(i));
                        word.setDocument("Jim Carrey");
                        word.setGenre("speech");
                        word.setSentence(sent.text());
                        wordRepository.save(word);
                    }catch (Exception e){
                        System.out.println();
                    }
                }
            }
        }
    }
}
