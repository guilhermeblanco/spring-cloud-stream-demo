package com.example.test_sink.model;

import org.springframework.http.MediaType;

public class Content {
    private String type;
    private String body;

    public Content() {}

    private Content(final Builder builder) {
        this.type = builder.type;
        this.body = builder.body;
    }

    public String getType() {
        return this.type;
    }

    public String getBody() {
        return this.body;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String type;
        private String body;

        private Builder() {
            this.type = MediaType.TEXT_PLAIN_VALUE;
        }

        public Builder withType(final String type) {
            this.type = type;

            return this;
        }

        public Builder withBody(final String body) {
            this.body = body;

            return this;
        }

        public Content build() {
            return new Content(this);
        }
    }
}
