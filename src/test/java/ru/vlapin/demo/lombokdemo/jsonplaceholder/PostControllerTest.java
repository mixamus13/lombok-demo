package ru.vlapin.demo.lombokdemo.jsonplaceholder;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import ru.vlapin.demo.lombokdemo.jsonplaceholder.client.api.PostApiClient;

import static ru.vlapin.demo.lombokdemo.jsonplaceholder.client.model.PostAssert.*;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class PostControllerTest {

  private static final int ID = 57;
  private static final int USER_ID = 6;
  private static final String TITLE = "sed ab est est";
  private static final String BODY = """
          at pariatur consequuntur earum quidem
          quo est laudantium soluta voluptatem
          qui ullam et est
          et cum voluptas voluptatum repellat est""";

  PostApiClient postsApiClient;

  @Test
  @DisplayName("Get method works correctly")
  void get() {
    Assertions.assertThat(postsApiClient.posts(null)).isNotNull()
            .extracting(HttpEntity::getBody).asList()
            .isNotEmpty()
            .hasSize(100);
  }

  @Test
  @DisplayName("Get one post method works correctly")
  void getOnePostMethodWorksCorrectlyTest() {
    assertThat(postsApiClient.pickPost(ID).getBody()).isNotNull()
            .hasId(ID)
            .hasTitle(TITLE)
            .hasUserId(USER_ID)
            .hasBody(BODY);
  }
}
