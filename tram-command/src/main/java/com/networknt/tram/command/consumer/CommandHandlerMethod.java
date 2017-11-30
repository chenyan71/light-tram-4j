package com.networknt.tram.command.consumer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CommandHandlerMethod {
  String commandType() default "";
  String path();
  String replyChannel();
  String partitionId() default "'DontCare'";
}
