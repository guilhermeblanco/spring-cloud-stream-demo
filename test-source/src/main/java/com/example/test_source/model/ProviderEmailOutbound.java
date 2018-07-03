package com.example.test_source.model;

import java.util.ArrayList;
import java.util.List;

public class ProviderEmailOutbound {
    private Provider provider;
    private List<Mail> mailList;

    public ProviderEmailOutbound() {}

    private ProviderEmailOutbound(final Builder builder) {
        this.provider = builder.provider;
        this.mailList = builder.mailList;
    }

    public Provider getProvider() {
        return this.provider;
    }

    public List<Mail> getMailList() {
        return this.mailList;
    }

    public static Builder newBuilder(final Provider provider) {
        return new Builder(provider);
    }

    public static class Builder {
        private Provider provider;
        private List<Mail> mailList;

        private Builder(final Provider provider) {
            this.provider = provider;
            this.mailList = new ArrayList<>();
        }

        public Builder addMail(final Mail mail) {
            this.mailList.add(mail);

            return this;
        }

        public Builder withMailList(final List<Mail> mailList) {
            this.mailList = mailList;

            return this;
        }

        public ProviderEmailOutbound build() {
            return new ProviderEmailOutbound(this);
        }
    }
}
