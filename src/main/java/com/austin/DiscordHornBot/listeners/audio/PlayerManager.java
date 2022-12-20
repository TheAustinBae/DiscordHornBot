package com.austin.DiscordHornBot.listeners.audio;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.local.LocalAudioSourceManager;

public class PlayerManager {
  private static final AudioPlayerManager manager = new DefaultAudioPlayerManager();

  public static void init() {
    manager.registerSourceManager(new LocalAudioSourceManager());
  }

  public static AudioPlayerManager getManager() {
    return manager;
  }
}
