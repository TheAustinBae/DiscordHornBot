package com.austin.discordhornbot.listeners.audio;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TrackScheduler extends AudioEventAdapter {
  private final AudioPlayer player;
  private final BlockingQueue<AudioTrack> queue;

  public TrackScheduler(AudioPlayer player) {
    this.player = player;
    this.queue = new LinkedBlockingQueue<>();
  }

  public void queue(AudioTrack audioTrack) {
    if(!player.startTrack(audioTrack, true)) {
      queue.offer(audioTrack);
    }
  }

  public void nextTrack() {
    this.player.startTrack(this.queue.poll(), false);
  }

}
