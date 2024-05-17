/*
 * Copyright 2017-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.file.FileReadingMessageSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.springframework.integration.dsl.IntegrationFlow.from;
import static org.springframework.integration.file.FileReadingMessageSource.WatchEventType.*;

/** Storage Spring Integration sample app. */
@SpringBootApplication
public class SampleIntegrationApplication {

  private static final String NEW_FILE_CHANNEL = "newFileChannel";

  @Value("${local-directory}")
  private String localDirectory;

  public static void main(String[] args) {
    SpringApplication.run(SampleIntegrationApplication.class, args);
  }

  @Bean
  @InboundChannelAdapter(value = NEW_FILE_CHANNEL, poller = @Poller(fixedDelay = "1"))
  public MessageSource<File> fileReadingMessageSource() {
    FileReadingMessageSource source = new FileReadingMessageSource();
    source.setDirectory(new File(localDirectory));
    source.setUseWatchService(true);
    source.setWatchEvents(CREATE, MODIFY, DELETE);
    return source;
  }

  @Bean
  public IntegrationFlow newFileFlow() {
    return from(NEW_FILE_CHANNEL)
            .<File>handle((f, h) -> deleteFile(f))
            .log()
            .nullChannel();
  }

  public File deleteFile(File file) {
      try {
          Files.delete(file.toPath());
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
      return file;
  }

}
