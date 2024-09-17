
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String login = read.next();

        System.out.print("Enter your password: ");
        String password = read.next();

        System.out.print("Repeat the password: ");
        String confirmPassword = read.next();

        try {
            EnterYourUsernameAndPassword(login, password, confirmPassword);
        } catch (WrongPasswordException | WrongLoginException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void EnterYourUsernameAndPassword(String userName, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {

        String ValidCharactersInTheLogin = "^[a-z0-9_]{3,20}$";
        Pattern patternLogin = Pattern.compile(ValidCharactersInTheLogin);
        Matcher matcherLogin = patternLogin.matcher(userName);

        String ValidCharactersInThePassword = "^[a-zA-Z0-9_]{6,20}$";
        Pattern patternPassword = Pattern.compile(ValidCharactersInThePassword);
        Matcher matcherPassword = patternPassword.matcher(password);

        if (!matcherLogin.matches()) {
            throw new WrongLoginException();
        }
        if (!matcherPassword.matches()) {
            throw new WrongPasswordException("Error, Invalid Password!!!");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Error, Passwords don't match!!!");
        }
    }


}