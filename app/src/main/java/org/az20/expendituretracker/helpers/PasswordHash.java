package org.az20.expendituretracker.helpers;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHash {

    public static String hashPassword(String password){

        final int salt = 15;
        return BCrypt.hashpw(password, BCrypt.gensalt(salt));
    }

    public static boolean verifyHash(String password, String hashedPassword){

        return BCrypt.checkpw(password, hashedPassword);
    }
}
