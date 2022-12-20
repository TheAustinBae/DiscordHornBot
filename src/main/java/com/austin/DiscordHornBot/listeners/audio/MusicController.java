package com.austin.DiscordHornBot.listeners.audio;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import lombok.extern.slf4j.Slf4j;
import org.javacord.api.DiscordApi;
import org.javacord.api.audio.AudioSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MusicController {

  @Autowired DiscordApi discordApi;

  @Bean
  // @Scheduled
  public void playMusic() {
    log.info("Play Music Bean");
    discordApi
        .getServerVoiceChannelById("1052335782867779649")
        .ifPresent(
            channel -> {
              channel
                  .connect()
                  .thenAccept(
                      audioConnection -> {
                        AudioPlayerManager playerManager = PlayerManager.getManager();
                        LocalSourcePlayer localSourcePlayer = new LocalSourcePlayer(playerManager);
                        AudioSource source =
                            new LavaplayerAudioSource(discordApi, localSourcePlayer.player);
                        audioConnection.setAudioSource(source);

                        log.info("Loading Item");
                        playerManager.loadItem(
                            "C:/Development/Discord Horn Bot/DiscordHornBot/src/main/assets/fog horn.mp3",
                            new AudioLoadResultHandler() {
                              @Override
                              public void trackLoaded(AudioTrack track) {
                                log.info("Track Loaded");
                                localSourcePlayer.scheduler.queue(track);
                              }

                              @Override
                              public void playlistLoaded(AudioPlaylist playlist) {
                                // do nothing
                              }

                              @Override
                              public void noMatches() {
                                log.info("No Matches");
                              }

                              @Override
                              public void loadFailed(FriendlyException throwable) {
                                log.info("Loading Failed");
                              }
                            });
                      })
                  .exceptionally(
                      e -> {
                        // Failed to connect to voice channel (no permissions?)
                        e.printStackTrace();
                        return null;
                      });
            });
  }
}
