package dev.search.elasticsearch.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import dev.search.elasticsearch.customdao.CustomEmailRepository;
import dev.search.elasticsearch.entities.Email;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
public interface EmailRepository extends ElasticsearchRepository <Email, String >,
  CustomEmailRepository {
 
  public List <Email> findByTextLikeOrSenderLike(String text, String sender);

}
