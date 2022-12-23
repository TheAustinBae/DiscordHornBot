package com.austin.discordhornbot.listeners.audio;


import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;

public class LocalSourcePlayer {

  public final AudioPlayer player;
  public final TrackScheduler scheduler;

  public LocalSourcePlayer(AudioPlayerManager manager) {
    player = manager.createPlayer();
    scheduler = new TrackScheduler(player);
    player.addListener(scheduler);
  }

}
