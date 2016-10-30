package dev.search.elasticsearch.customdao;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import dev.search.elasticsearch.entities.Email;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
public class EmailRepositoryImpl implements CustomEmailRepository {

  @Autowired
  private ElasticsearchTemplate template;

  @Override
  public List<Email> containsText(String text) {
    NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();

    MatchQueryBuilder matchPhraseQuery =  QueryBuilders.matchPhrasePrefixQuery("text",text);

    nativeSearchQueryBuilder.withQuery(matchPhraseQuery);

    NativeSearchQuery nativeSearchQuery = nativeSearchQueryBuilder.build();

    Page<Email> queryForPage = template.queryForPage(nativeSearchQuery, Email.class);

    List<Email> emails = new ArrayList<>();
    queryForPage.forEach(page -> {
      emails.add(page);
    });
    
    return emails;
  }

}
