package ru.vlapin.demo.lombokdemo.stable.constructors;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * NacDemo3Test.
 */
class NacDemo3Test {

  @Test
  @DisplayName("NoArgsConstructor annotation works correctly")
  void noArgsConstructorAnnotationWorksCorrectlyTest() {
    // given
    val nacDemo = new NacDemo3();

    // when
    assertThat(nacDemo)
        // then
        .extracting("x", "s", "z")
        .contains(0, null, false);
  }
}
