package dev.search.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.search.elasticsearch.jsonconvertor.JsonConvertor;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {

    if (args.length == 1) {
      SpringApplication.run(Application.class, args);
      JsonConvertor.setFileName(args[0]);
    } else {

    }

  }
}
