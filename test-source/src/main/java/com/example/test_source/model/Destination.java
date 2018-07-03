package com.example.test_source.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Destination
{
    private List<Email> toList;
    private List<Email> ccList;
    private List<Email> bccList;
    private String subject;
    private Map<String, Object> dataMap;

    public Destination() {}

    private Destination(final Builder builder) {
        this.toList = builder.toList;
        this.ccList = builder.ccList;
        this.bccList = builder.bccList;
        this.subject = builder.subject;
        this.dataMap = builder.dataMap;
    }

    public List<Email> getToList() {
        return this.toList;
    }

    public List<Email> getCCList() {
        return this.ccList;
    }

    public List<Email> getBCCList() {
        return this.bccList;
    }

    public String getSubject() {
        return this.subject;
    }

    public Map<String, Object> getDataMap() {
        return this.dataMap;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private List<Email> toList;
        private List<Email> ccList;
        private List<Email> bccList;
        private String subject;
        private Map<String, Object> dataMap;

        private Builder() {
            this.toList = new ArrayList<>();
            this.ccList = new ArrayList<>();
            this.bccList = new ArrayList<>();
            this.dataMap = new HashMap<>();
        }

        public Builder addTo(final Email email) {
            this.toList.add(email);

            return this;
        }

        public Builder withToList(final List<Email> toList) {
            this.toList = toList;

            return this;
        }

        public Builder addCC(final Email email) {
            this.ccList.add(email);

            return this;
        }

        public Builder withCCList(final List<Email> ccList) {
            this.ccList = ccList;

            return this;
        }

        public Builder addBCC(final Email email) {
            this.bccList.add(email);

            return this;
        }

        public Builder withBCCList(final List<Email> bccList) {
            this.bccList = bccList;

            return this;
        }

        public Builder withSubject(final String subject) {
            this.subject = subject;

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

        public Destination build() {
            return new Destination(this);
        }
    }
}
