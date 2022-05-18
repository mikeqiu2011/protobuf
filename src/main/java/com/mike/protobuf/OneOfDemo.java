package com.mike.protobuf;

import com.mike.models.Credentials;
import com.mike.models.EmailCredentials;
import com.mike.models.PhoneOTP;

public class OneOfDemo {
    public static void main(String[] args) {
        EmailCredentials emailCredentials = EmailCredentials.newBuilder().setEmail("mike@gmail.com")
                .setPassword("admin123")
                .build();

        PhoneOTP phoneOTP = PhoneOTP.newBuilder().setNumber(12345678)
                .setCode(321)
                .build();

        Credentials credentials = Credentials.newBuilder()
                .setPhoneMode(phoneOTP)
                .setEmailMode(emailCredentials)
                .build();

        login(credentials);

    }

    private static void login(Credentials credentials) {

        switch (credentials.getModeCase()) {
            case EMAILMODE:
                System.out.println(credentials.getEmailMode());
            case PHONEMODE:
                System.out.println(credentials.getPhoneMode());
        }

    }
}
