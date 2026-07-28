package com.security.java_project.system_design.patterns.builderPattern;

public class User {

        private String name;
        private int age;
        private String email;

        // Private constructor
        private User(UserBuilder builder) {
            this.name = builder.name;
            this.age = builder.age;
            this.email = builder.email;
        }

        // Static builder() method
        public static UserBuilder builder() {
            return new UserBuilder();
        }

        // Optional: Display user details
        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", email='" + email + '\'' +
                    '}';
        }

        // Builder Class
        public static class UserBuilder {

            private String name;
            private int age;
            private String email;

            public UserBuilder name(String name) {
                this.name = name;
                return this;
            }

            public UserBuilder age(int age) {
                this.age = age;
                return this;
            }

            public UserBuilder email(String email) {
                this.email = email;
                return this;
            }

            public User build() {
                return new User(this);
            }
        }

}
