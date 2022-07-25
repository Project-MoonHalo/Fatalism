package MoonHalo.Fatalism.Utils;

import com.google.common.hash.Hashing;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author fireanmeng
 * Disable as default.
 */
@SuppressWarnings("all")
public class HWID {
    /**
     * Invoke this method to start HWID verify.
     * @param link find hwid from this url.
     * @param key encrypt key.
     */
    public static void Verify(String link, String key) {
        String Final = null;
        ArrayList<String> HWIDList = new ArrayList<String>();
        try {
            String inputLine;
            String main = System.getenv("PROCESS_IDENTIFIER") + System.getenv("PROCESSOR_LEVEL") + System.getenv("PROCESSOR_REVISION") + System.getenv("PROCESSOR_ARCHITECTURE") + System.getenv("PROCESSOR_ARCHITEW6432") + System.getenv("NUMBER_OF_PROCESSORS") + System.getenv("COMPUTERNAME");
            byte[] bytes = main.getBytes(StandardCharsets.UTF_8);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            String a = Hashing.sha1().hashString(new String(messageDigest.digest(bytes)), StandardCharsets.UTF_8).toString();
            String b = Hashing.sha256().hashString(a, StandardCharsets.UTF_8).toString();
            String c = Hashing.sha512().hashString(b, StandardCharsets.UTF_8).toString();
            Final = HWID.Encrypt(c, key);
            URL url = new URL(link);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((inputLine = in.readLine()) != null) {
                HWIDList.add(inputLine);
            }
            if (!HWIDList.contains(Final)) {
                throw new Exception();
            }
        }
        catch (Exception e) {
            Error error = new Error();
            StackTraceElement[] stackTraceElements = new StackTraceElement[]{new StackTraceElement("MoonNight", "--VERIFY FAILED--", Final, 0)};
            error.setStackTrace(stackTraceElements);
            throw error;
        }
    }

    private static String Encrypt(String strToEncrypt, String secret) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, HWID.getKey(secret));
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        }
        catch (Exception e) {
            System.out.println("Error while encrypting: " + e);
            return null;
        }
    }

    private static SecretKeySpec getKey(String myKey) {
        try {
            byte[] key = myKey.getBytes(StandardCharsets.UTF_8);
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            return new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

