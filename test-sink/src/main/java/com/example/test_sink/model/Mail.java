package com.example.test_sink.model;

public class Mail {
    private String from;
    private String to;
    private String subject;
    private String content;

    public Mail() {}

    private Mail(final Builder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.subject = builder.subject;
        this.content = builder.content;
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getContent() {
        return this.content;
    }

    public static Builder newBuilder(final String from) {
        return new Builder(from);
    }

    public static class Builder {
        private String from;
        private String to;
        private String subject;
        private String content;

        private Builder(final String from) {
            this.from = from;
        }

        public Builder withTo(final String to) {
            this.to = to;

            return this;
        }

        public Builder withSubject(final String subject) {
            this.subject = subject;

            return this;
        }

        public Builder withContent(final String content) {
            this.content = content;

            return this;
        }

        public Mail build() {
            return new Mail(this);
        }
    }
}
