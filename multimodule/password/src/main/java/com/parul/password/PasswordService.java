package com.parul.password;

public interface PasswordService {
    String hash(String input);

    String algorithm();
}

