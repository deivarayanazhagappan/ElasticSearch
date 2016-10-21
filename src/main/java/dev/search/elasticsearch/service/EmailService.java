package dev.search.elasticsearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.search.elasticsearch.dao.EmailRepository;
import dev.search.elasticsearch.entities.Email;
import dev.search.elasticsearch.jsonconvertor.JsonConvertor;

@Service
public class EmailService {

  @Autowired
  EmailRepository emailRepository;

  @Autowired
  JsonConvertor convertor;

  public List<Email> findByText(String text) {
    
    if(!JsonConvertor.isInitialized()) {
      convertor.initialize();  
    }
    
    return emailRepository.findByText(text);  
  }
}
