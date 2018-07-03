package com.example.test_source.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mail {
    private Email from;
    private Email replyTo;
    private String subject;
    private List<Attachment> attachmentList;
    private List<Destination> destinationList;
    private String template;
    private Content content;
    private Map<String, String> headerMap;
    private Map<String, Object> dataMap;

    public Mail() {}

    private Mail(final Builder builder) {
        this.from = builder.from;
        this.replyTo = builder.replyTo;
        this.subject = builder.subject;
        this.attachmentList = builder.attachmentList;
        this.destinationList = builder.destinationList;
        this.template = builder.template;
        this.content = builder.content;
        this.headerMap = builder.headerMap;
        this.dataMap = builder.dataMap;
    }

    public Email getFrom() {
        return this.from;
    }

    public Email getReplyTo() {
        return this.replyTo;
    }

    public String getSubject() {
        return this.subject;
    }

    public List<Attachment> getAttachmentList() {
        return this.attachmentList;
    }

    public List<Destination> getDestinationList() {
        return this.destinationList;
    }

    public String getTemplate() {
        return this.template;
    }

    public Content getContent() {
        return this.content;
    }

    public Map<String, String> getHeaderMap() {
        return this.headerMap;
    }

    public Map<String, Object> getDataMap() {
        return this.dataMap;
    }

    public static Builder newBuilder(final Email from) {
        return new Builder(from);
    }

    public static class Builder {
        private Email from;
        private Email replyTo;
        private String subject;
        private List<Attachment> attachmentList;
        private List<Destination> destinationList;
        private String template;
        private Content content;
        private Map<String, String> headerMap;
        private Map<String, Object> dataMap;

        private Builder(final Email from) {
            this.from = from;
            this.replyTo = from;
            this.attachmentList = new ArrayList<>();
            this.destinationList = new ArrayList<>();
            this.headerMap = new HashMap<>();
            this.dataMap = new HashMap<>();
        }

        public Builder withReplyTo(final Email replyTo) {
            this.replyTo = replyTo;

            return this;
        }

        public Builder withSubject(final String subject) {
            this.subject = subject;

            return this;
        }

        public Builder addAttachment(final Attachment attachment) {
            this.attachmentList.add(attachment);

            return this;
        }

        public Builder withAttachmentList(final List<Attachment> attachmentList) {
            this.attachmentList = attachmentList;

            return this;
        }

        public Builder addDestination(final Destination destination) {
            this.destinationList.add(destination);

            return this;
        }

        public Builder withDestinationList(final List<Destination> destinationList) {
            this.destinationList = destinationList;

            return this;
        }

        public Builder withTemplate(final String template) {
            this.template = template;

            return this;
        }

        public Builder withContent(final Content content) {
            this.content = content;

            return this;
        }

        public Builder addHeader(final String key, final String value) {
            this.headerMap.put(key, value);

            return this;
        }

        public Builder withHeaderMap(final Map<String, String> headerMap) {
            this.headerMap = headerMap;

            return this;
        }

        public Builder addData(final String key, final Object value) {
            this.dataMap.put(key, value);

            return this;
        }

        public Builder withDataMap(final Map<String, Object> dataMap) {
            this.dataMap = dataMap;

            return this;
        }

        public Mail build() {
            return new Mail(this);
        }
    }
}
