package dev.search.elasticsearch.jsonconvertor;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.search.elasticsearch.dao.EmailRepository;
import dev.search.elasticsearch.entities.Email;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
@Component
public class JsonConvertor {

  private static Logger LOGGER = Logger.getLogger("InfoLogging");

  @Autowired
  EmailRepository emailRepository;

  public static boolean initialized = false;

  public static String fileName;

  private int totalEmails;

  public void initialize() {
    ObjectMapper mapper = new ObjectMapper();

    try {
      emailRepository.deleteAll();
      Email[] emails = mapper.readValue(new File(fileName), Email[].class);
      for (Email email : emails) {
        email.setDocid(email.getId().toString());
      }
      emailRepository.save(Arrays.asList(emails));
      LOGGER.info(emails.length + " emails saved");
      initialized = true;
      totalEmails = emails.length;
    } catch (IOException e) {
      LOGGER.severe(fileName + " not found");
    }
  }

  public static void setFileName(String file) {
    fileName = file;
  }

  public int getTotalEmails() {
    return totalEmails;  
  }
  
  public static boolean isInitialized() {
    return initialized;
  }
}
