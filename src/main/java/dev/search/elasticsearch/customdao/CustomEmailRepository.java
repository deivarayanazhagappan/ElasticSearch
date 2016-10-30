package dev.search.elasticsearch.customdao;

import java.util.List;

import dev.search.elasticsearch.entities.Email;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
public interface CustomEmailRepository {

  public List<Email> containsText(String text);
}

