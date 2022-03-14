public class Passwordchecker {

    public static boolean checkPassword(String password) {
        if (passwordLength(password)) return false;
        if (checkSpecialChar(password)) return false;
        if (checkNumUpperLower(password)) return false;
        if (checkThreeConsecutive(password)) return false;
        if (checkMoreThanThreeSame(password)) return false;
        return true;
    }

    private static boolean passwordLength(String password) {
        return password == null || password.length() < 8 || password.length() > 25;
    }

    private static boolean checkSpecialChar(String password) {
        return !password.matches(".*[()#$?!%/@]*.");
    }

    private static boolean checkNumUpperLower(String password) {
        return !password.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])");
    }

    private static boolean checkThreeConsecutive(String password) {
        for (int i = 0; i < password.length() - 2; i++) {
            if (Character.isDigit(password.charAt(i)) && Character.isDigit(password.charAt(i + 1)) && Character.isDigit(password.charAt(i + 2))) {
                int con1 = password.charAt(i), con2 = password.charAt(i + 1), con3 = password.charAt(i + 2);
                if ((con2 - con1 == 1) && (con3 - con2 == 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkMoreThanThreeSame(String password) {
        for (int i = 0; i < password.length() - 3; i++) {
            if (Character.isDigit(password.charAt(i)) && Character.isDigit(password.charAt(i + 1)) && Character.isDigit(password.charAt(i + 2)) && Character.isDigit(password.charAt(i + 3))) {
                int next1 = password.charAt(i), next2 = password.charAt(i + 1), next3 = password.charAt(i + 2), next4 = password.charAt(i + 3);
                if ((next1 == next2) && (next2 == next3) && (next3 == next4)) {
                    return true;
                }
            }
        }
        return false;
    }
}
