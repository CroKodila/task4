import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
      StartProgram start = new StartProgram();
      start.startGame(args);
    }

}
