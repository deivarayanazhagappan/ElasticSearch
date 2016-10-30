package dev.search.elasticsearch.test.emails;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dev.search.elasticsearch.dao.EmailRepository;
import dev.search.elasticsearch.entities.Email;
import dev.search.elasticsearch.jsonconvertor.JsonConvertor;


/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmailTest {

  @Autowired
  private EmailRepository emailRepository;

  @Autowired
  private JsonConvertor jsonConvertor;

  private final String fileName = "sample.json";

  @Before
  public void setUp() {
    startJsonConvertorHelper();
  }
  
  @Test
  public void jsonConversion() {
    // Test json conversion
    assertEquals(2, jsonConvertor.getTotalEmails());
  }

  @Test
  public void searchValidText() {
    List<Email> results = emailRepository.findByTextLikeOrSenderLike("example.com", "example.com");
    assertTrue(results.size() > 1);
  }
  
  @Test
  public void searchRandomText() {
    List<Email> results = emailRepository.findByTextLikeOrSenderLike("RWGYH", "RWGYH");
    assertTrue(results.size() == 0);
  }

  public void startJsonConvertorHelper() {
    JsonConvertor.setFileName(fileName);
    if(!JsonConvertor.isInitialized()) {
      jsonConvertor.initialize();
    }
  }
}
