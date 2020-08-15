package com.clearpath.tweetpipeanalyser.service;

import com.clearpath.tweetpipeanalyser.model.Tweet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
@Slf4j
public class TweetListener {

    private SentimentAnalyser sentimentAnalyser;

    public TweetListener(SentimentAnalyser sentimentAnalyser) {
        this.sentimentAnalyser = sentimentAnalyser;
    }

    @StreamListener(Sink.INPUT)
    public void handle(Tweet tweet) {
        log.info("Tweet with {} sentiment rating received: {}",
                sentimentAnalyser.analyse(tweet.getText()).sentiment(), tweet);
    }
}
