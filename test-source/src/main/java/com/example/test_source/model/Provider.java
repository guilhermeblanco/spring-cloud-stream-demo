package com.example.test_source.model;

public class Provider {
    private String name;
    private String authUser;
    private String authToken;

    public Provider() {}

    private Provider(final Builder builder) {
        this.name = builder.name;
        this.authToken = builder.authToken;
        this.authUser = builder.authUser;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthUser() {
        return this.authUser;
    }

    public String getAuthToken() {
        return this.authToken;
    }

    public static Builder newBuilder(final String name) {
        return new Builder(name);
    }

    public static class Builder {
        private String name;
        private String authUser;
        private String authToken;

        private Builder(final String name) {
            this.name = name;
        }

        public Builder withAuthUser(final String authUser) {
            this.authUser = authUser;

            return this;
        }

        public Builder withAuthToken(final String authToken) {
            this.authToken = authToken;

            return this;
        }

        public Provider build() {
            return new Provider(this);
        }
    }
}
