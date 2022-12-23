package com.austin.discordhornbot;

import com.austin.discordhornbot.listeners.audio.PlayerManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiscordHornBotApplication {

	public static void main(String[] args) {
		PlayerManager.init();
		SpringApplication.run(DiscordHornBotApplication.class, args);
	}

}
