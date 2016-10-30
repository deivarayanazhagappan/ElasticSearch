package dev.search.elasticsearch;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.search.elasticsearch.jsonconvertor.JsonConvertor;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */
@SpringBootApplication
public class Application {

  private static Logger LOGGER = Logger.getLogger("InfoLogging");

  public static void main(String[] args) {

    if (args.length == 2 && args[0].equals("-input")
        && args[1].contains(".json")) {
      SpringApplication.run(Application.class, args);
      JsonConvertor.setFileName(args[1]);
    } else {
      LOGGER.info("Format: java -jar <ExecutableFile>.jar -input <filename>.json");
    }

  }
}
