package dev.search.elasticsearch.test.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import dev.search.elasticsearch.dao.EmailRepository;
import dev.search.elasticsearch.entities.Email;
import dev.search.elasticsearch.jsonconvertor.JsonConvertor;
import dev.search.elasticsearch.service.EmailService;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmailRestControllerTest {

  public static final String PATH = "/email/text";

  @Autowired
  private WebApplicationContext ctx;

  private MockMvc mockMvc;

  @Autowired
  @InjectMocks
  private EmailService emailService;

  @Mock
  private EmailRepository emailRepository;

  @Mock
  private JsonConvertor convertor;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    emailService.setEmailRepository(emailRepository);
    JsonConvertor.initialized = true;
    emailService.setJsonConvertor(convertor);
  }

  @Test
  public void searchValidText() throws Exception {
    
    Mockito.when(emailRepository
          .findByTextLikeOrSenderLike(Mockito.anyString(), Mockito.anyString()))
          .thenReturn(
           createEmails());

    mockMvc.perform(get(PATH)
      .param("text", "Vanessa"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$[0].docid").value("docid"));
     
  }

  @Test
  public void getByMissingTextParameter() throws Exception {

    Mockito.when(emailRepository
        .findByTextLikeOrSenderLike(Mockito.anyString(), Mockito.anyString()))
        .thenReturn(null);

    mockMvc.perform(get(PATH))
      .andExpect(status().is4xxClientError());

  }

  private List<Email> createEmails() {
    Email email = new Email();
    email.setBcc(Arrays.asList("bcc"));
    email.setCc(Arrays.asList("cc"));
    email.setDocid("docid");
    email.setMid("mid");
    email.setCtype("cType");
    email.setSender("sender");
    email.setText("sampleText");
    return Arrays.asList(email);
  }
 }
