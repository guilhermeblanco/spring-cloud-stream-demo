package com.example.test_sink.model;

public class Email {
    private String address;
    private String name;

    public Email() {}

    private Email(final Builder builder) {
        this.address = builder.address;
        this.name = builder.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getName() {
        return this.name;
    }

    public static Builder newBuilder(final String address) {
        return new Builder(address);
    }

    public static class Builder {
        private String address;
        private String name;

        private Builder(final String address) {
            this.address = address;
        }

        public Builder withName(final String name) {
            this.name = name;

            return this;
        }

        public Email build() {
            return new Email(this);
        }
    }
}
