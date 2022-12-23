package com.austin.discordhornbot;

import lombok.extern.slf4j.Slf4j;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.intent.Intent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class BotConfiguration {
  @Value("${token}")
  String token;

  @Bean
  @ConfigurationProperties(value = "discord-api")
  public DiscordApi discordApi() {
    DiscordApi api =
        new DiscordApiBuilder().setToken(token).addIntents(Intent.MESSAGE_CONTENT).login().join();

    log.info("Discord API bean");

    return api;
  }
}
