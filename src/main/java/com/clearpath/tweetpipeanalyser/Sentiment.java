package com.clearpath.tweetpipeanalyser;

public enum Sentiment {

    STRONG_NEGATIVE(0) {
        @Override
        public String sentiment() {
            return "strong negative";
        }
    },
    WEAK_NEGATIVE(1) {
        @Override
        public String sentiment() {
            return "weak negative";
        }
    },
    NEUTRAL(2) {
        @Override
        public String sentiment() {
            return "neutral";
        }
    },
    WEAK_POSITIVE(3) {
        @Override
        public String sentiment() {
            return "weak";
        }
    },
    STRONG_POSITIVE(4) {
        @Override
        public String sentiment() {
            return "positive";
        }
    };

    int value;

    Sentiment(int value) {
        this.value = value;
    }

    public static Sentiment fromScore(int score) {
        switch (score) {
            case 0: return STRONG_NEGATIVE;
            case 1: return WEAK_NEGATIVE;
            case 3: return WEAK_POSITIVE;
            case 4: return STRONG_POSITIVE;
            default:
                return NEUTRAL;
        }
    }

    public abstract String sentiment();
}
