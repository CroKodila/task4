
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;

public class GeneratorKeys {
    private String key = "";
    public void generateKey(String computerCommand) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        SecureRandom secureRandom = new SecureRandom();
        byte raw[] = new byte[32];
        secureRandom.nextBytes(raw);
        for(int i = 0; i< raw.length; i++){
            this.key += Integer.toHexString(raw[i]&0xFF);
        }
        GeneratorHMAC hmacKeyGen = new GeneratorHMAC();
        hmacKeyGen.generateHMAC(computerCommand,this.key);
    }
    public String getKey(){
        return this.key;
    }
}
