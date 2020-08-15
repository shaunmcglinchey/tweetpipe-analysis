package com.clearpath.tweetpipeanalyser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
@Slf4j
public class TweetpipeAnalyserApplication {

    @Autowired
    SentimentAnalyser sentimentAnalyser;

    public static void main(String[] args) {
        SpringApplication.run(TweetpipeAnalyserApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void handle(Tweet tweet) {
        log.info("Tweet with {} sentiment rating received: {}", sentimentAnalyser.analyse(tweet.getText()).sentiment(), tweet);
    }

}
