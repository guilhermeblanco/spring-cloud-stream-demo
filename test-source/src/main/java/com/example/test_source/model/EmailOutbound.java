package com.example.test_source.model;

import java.util.ArrayList;
import java.util.List;

public class EmailOutbound {
    private String vendor;
    private String provider;
    private List<Mail> mailList;

    public EmailOutbound() {}

    private EmailOutbound(final Builder builder) {
        this.vendor = builder.vendor;
        this.provider = builder.provider;
        this.mailList = builder.mailList;
    }

    public String getVendor() {
        return this.vendor;
    }

    public String getProvider() {
        return this.provider;
    }

    public List<Mail> getMailList() {
        return this.mailList;
    }

    public static Builder newBuilder(final String vendor) {
        return new Builder(vendor);
    }

    public static class Builder {
        private String vendor;
        private String provider;
        private List<Mail> mailList;

        private Builder(final String vendor) {
            this.vendor = vendor;
            this.mailList = new ArrayList<>();
        }

        public Builder addMail(final Mail mail) {
            this.mailList.add(mail);

            return this;
        }

        public Builder withMail(final List<Mail> mailList) {
            this.mailList = mailList;

            return this;
        }

        public Builder withProvider(final String provider) {
            this.provider = provider;

            return this;
        }

        public EmailOutbound build() {
            return new EmailOutbound(this);
        }
    }
}
