package com.example.test_source.model;

public class Attachment {
    private String type;
    private String content;
    private String contentId;
    private String filename;
    private String disposition;

    public Attachment() {}

    private Attachment(final Builder builder) {
        this.type = builder.type;
        this.content = builder.content;
        this.contentId = builder.contentId;
        this.filename = builder.filename;
        this.disposition = builder.disposition;
    }

    public String getType() {
        return this.type;
    }

    public String getContent() {
        return this.content;
    }

    public String getContentId() {
        return this.contentId;
    }

    public String getFilename() {
        return this.filename;
    }

    public String getDisposition() {
        return this.disposition;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String type;
        private String content;
        private String contentId;
        private String filename;
        private String disposition;

        public Builder withType(final String type) {
            this.type = type;

            return this;
        }

        public Builder withContent(final String content) {
            this.content = content;

            return this;
        }

        public Builder withContentId(final String contentId) {
            this.contentId = contentId;

            return this;
        }

        public Builder withFilename(final String filename) {
            this.filename = filename;

            return this;
        }

        public Builder withDisposition(final String disposition) {
            this.disposition = disposition;

            return this;
        }

        public Attachment build() {
            return new Attachment(this);
        }
    }
}
