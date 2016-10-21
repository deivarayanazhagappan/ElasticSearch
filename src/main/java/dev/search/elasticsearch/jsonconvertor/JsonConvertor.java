package dev.search.elasticsearch.jsonconvertor;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.search.elasticsearch.dao.EmailRepository;
import dev.search.elasticsearch.entities.Email;

@Component
public class JsonConvertor {

  private static Logger LOGGER = Logger.getLogger("InfoLogging");
  
  @Autowired
  EmailRepository emailRepository;

  public static boolean initialized = false;

  public static String fileName;

  public void initialize() {
    ObjectMapper mapper = new ObjectMapper();

    try {
      Email[] emails = mapper.readValue(new File(fileName), Email[].class);
        for(Email email: emails) {
          emailRepository.save(email);  
        }
        LOGGER.info(emails + " emails saved");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void setFileName(String file) {
    fileName = file;    
  }
  
  public static boolean isInitialized() {
    return initialized;
  }
}
