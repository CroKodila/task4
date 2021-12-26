import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.HmacUtils;
public class GeneratorHMAC {
    public void generateHMAC(String computerMove, String key) throws NoSuchAlgorithmException, InvalidKeyException {

        String HMACcode = new HmacUtils("HmacSHA256", key).hmacHex(computerMove);
        System.out.println("HMAC code: "+HMACcode);
    }

}
