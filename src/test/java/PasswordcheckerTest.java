/*
Author: Chiara Fedrizzi
Repo-Link: https://github.com/chiarafedrizzi/prog2-ss21-exercise1
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PasswordcheckerTest {
    /*
    Das Kennwort muss zwischen 8 und 25 Zeichen lang sein
    Das Kennwort muss aus Klein- und Großbuchstaben bestehen.
    Das Kennwort muss Zahlen enthalten.
    Das Kennwort muss mindestens eines der folgenden Sonderzeichen enthalten: ()#$?!%/@
    Andere Sonderzeichen sind nicht erlaubt.
     */

    //tests if user entered a password that is null
    @Test
    public void passwordNull(){
        assertFalse(Passwordchecker.checkPassword(null));
    }

    //tests if user entered a password that is empty
    @Test
    public void passwordEmpty(){
        String password = "";
        assertFalse(Passwordchecker.checkPassword(password));
    }

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

    @Test
    public void LowerCaseLetter() {
        String password = "AaBbCcDdEeFGHIJ2!";
        assertTrue(Passwordchecker.checkPassword(password));
    }

    //tests if user entered at least one upper case letter
    @Test
    public void noUpperCaseLetter() {
        String password = "abcdeghij2!";
        assertFalse(Passwordchecker.checkPassword(password));
    }

    @Test
    public void UpperCaseLetter() {
        String password = "aAbBcCdDeghij2!";
        assertTrue(Passwordchecker.checkPassword(password));
    }

    //tests if user entered at least one number
    @Test
    public void noNumber() {
        String password = "AbCdEfGhIj!";
        assertFalse(Passwordchecker.checkPassword(password));
    }

    @Test
    public void Number() {
        String password = "1A2b3C4dEfGhIj!";
        assertTrue(Passwordchecker.checkPassword(password));
    }

    //tests if user entered at least one allowed symbol
    @Test
    public void noAllowedSymbol() {
        String password = "AbCdEfGhIj2";
        assertFalse(Passwordchecker.checkPassword(password));
    }

    @Test
    public void AllowedSymbol() {
        String password = "AbCdEfGhIj2!#?";
        assertTrue(Passwordchecker.checkPassword(password));
    }

    //tests if user entered not more than three consecutive numbers
    @Test
    public void moreThanTwoConsecutive() {
        String password = "AbCdE1234";
        assertFalse(Passwordchecker.checkPassword(password));
    }

    @Test
    public void noMoreThanTwoConsecutive() {
        String password = "12AbCdE78ff!?34";
        assertTrue(Passwordchecker.checkPassword(password));
    }

    //tests if user entered the same number not more than three times
    @Test
    public void sameNumberMoreThanThreeTimes() {
        String password = "AbCdEfGhIj1111!";
        assertFalse(Passwordchecker.checkPassword(password));
    }

    @Test
    public void noNumberMoreThanThreeTimes() {
        String password = "AbCdEfGhIj111!555";
        assertTrue(Passwordchecker.checkPassword(password));
    }
}
