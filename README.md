TweetPipe
==============
Spring Boot Kafka consumer application that consumes tweets from a Kafka topic (via Cloud Stream integration) and 
performs sentiment analysis (using Stanford NLP library) on them, emitting one of the following sentiment ratings for 
each analysed tweet:

* Strong Negative
* Weakly Negative
* Neutral
* Weakly Positive
* Strongly Positive

This application forms the analysis tier of the TweetPipe Data Pipeline.

Technologies used
--------------
* Java 8
* Spring Boot 2.*
* Maven
* Kafka
* Lombok
* Spring Cloud Stream
* Stanford CoreNLP library (for sentiment analysis)