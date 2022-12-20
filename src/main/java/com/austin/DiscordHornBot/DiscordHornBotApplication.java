package com.austin.DiscordHornBot;

import com.austin.DiscordHornBot.listeners.audio.PlayerManager;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.intent.Intent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DiscordHornBotApplication {

	public static void main(String[] args) {
		PlayerManager.init();
		SpringApplication.run(DiscordHornBotApplication.class, args);
	}

}
