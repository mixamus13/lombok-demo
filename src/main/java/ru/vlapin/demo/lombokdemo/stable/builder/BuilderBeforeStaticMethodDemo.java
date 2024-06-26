package ru.vlapin.demo.lombokdemo.stable.builder;

import java.time.LocalDate;
import lombok.Builder;
import lombok.experimental.UtilityClass;

@SuppressWarnings({"java:S125", "CommentedOutCode"})

@UtilityClass
public class BuilderBeforeStaticMethodDemo {

  @Builder(builderMethodName = "beforeNowCaller",
           buildMethodName = "call",
           builderClassName = "BeforeNowCaller")
  public static LocalDate beforeNow(int days, int months) {
    return LocalDate.now().minusDays(days).minusMonths(months);
  }

//public static BeforeNowCaller beforeNowCaller() {
//  return new BeforeNowCaller();
//}

//@Setter
//@ToString
//@Accessors(fluent = true)
//@FieldDefaults(level = PRIVATE)
//@NoArgsConstructor(access = PACKAGE)
//public static class BeforeNowCaller {
//  int days;
//  int months;

//  public LocalDate call() {
//    return beforeNow(this.days, this.months);
//  }
//}
}
