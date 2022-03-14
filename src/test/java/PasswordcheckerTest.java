/*
Author: Chiara Fedrizzi
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PasswordcheckerTest {
    /*
    Das Kennwort muss zwischen 8 und 25 Zeichen lang sein
    Das Kennwort muss aus Klein- und Großbuchstaben bestehen.
    Das Kennwort muss Zahlen enthalten.
    Das Kennwort muss mindestens eines der folgenden Sonderzeichen enthalten: ()#$?!%/@
    Andere Sonderzeichen sind nicht erlaubt.
     */

    //tests if user entered a password that is too short
    @Test
    public void passwordTooShort(){
        String password = "aBcD1!";
        assertFalse(Passwordchecker.checkPassword(password));
    }

    //tests if user entered a password that is too long
    @Test
    public void passwordTooLong(){
        String password = "aBcDeFgHiJkLmNoPqRsTuVwXyZ1234567890!";
        assertFalse(Passwordchecker.checkPassword(password));
    }

    //tests if user entered at least one lower case letter
    @Test
    public void noLowerCaseLetter() {
        String password = "ABCDEFGHIJ2!";
        assertFalse(Passwordchecker.checkPassword(password));
    }

    //tests if user entered at least one upper case letter
    @Test
    public void noUpperCaseLetter() {
        String password = "abcdeghij2!";
        assertFalse(Passwordchecker.checkPassword(password));
    }

    //tests if user entered at least one number
    @Test
    public void noNumber() {
        String password = "AbCdEfGhIj!";
        assertFalse(Passwordchecker.checkPassword(password));
    }

    //tests if user entered at least one allowed symbol
    @Test
    public void noAllowedSymbol() {
        String password = "AbCdEfGhIj2";
        assertFalse(Passwordchecker.checkPassword(password));
    }

    //tests if user entered not more than three consecutive numbers
    @Test
    public void moreThanTwoConsecutive() {
        String password = "AbCdE1234";
        assertFalse(Passwordchecker.checkPassword(password));
    }

    //tests if user entered the same number not more than three times
    @Test
    public void sameNumberMoreThanThreeTimes() {
        String password = "AbCdEfGhIj1111!";
        assertFalse(Passwordchecker.checkPassword(password));
    }
}
