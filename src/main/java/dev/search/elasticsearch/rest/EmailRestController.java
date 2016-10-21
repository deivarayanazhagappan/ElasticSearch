package dev.search.elasticsearch.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.search.elasticsearch.entities.Email;
import dev.search.elasticsearch.service.EmailService;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
@RestController
@RequestMapping("/email")
public class EmailRestController {

  @Autowired
  public EmailService emailService;

  @RequestMapping(path = "/text", method = { RequestMethod.GET })
  public List<Email> getEmail(@RequestParam String text) {
    return emailService.findByText(text);
  }
 }
