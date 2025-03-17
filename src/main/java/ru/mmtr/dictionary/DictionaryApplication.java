package ru.mmtr.dictionary;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {
    org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.class,
    org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration.class,
    org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration.class,
    org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration.class,
    org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration.class
})
@EnableJpaRepositories
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DictionaryApplication {

}

