import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by libsys on 1/23/2023.
 */
public class EncryptionLogic {


    private static String encKeyName;


    public static Cipher cipherEnc = null;
    private static Cipher cipherDec = null;


    public static void initializeKey(String keyName){
        try {
            encKeyName = keyName;
            Key key = new SecretKeySpec(keyName.getBytes(), "AES");
            cipherEnc = Cipher.getInstance("AES");
            cipherEnc.init(Cipher.ENCRYPT_MODE, key);
            cipherDec = Cipher.getInstance("AES");
            cipherDec.init(Cipher.DECRYPT_MODE, key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    public static String encryptDataBase64(String data) {
        if(data!=null) {
            try {
                return Base64.getEncoder().encodeToString(cipherEnc.doFinal(data.getBytes("UTF-8")));
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static String decryptDataBase64(String data) {
        if(data!=null) {
            try {
                return new String(cipherDec.doFinal(Base64.getDecoder().decode(data)),"UTF-8");
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static void main(String[] args){
        EncryptionLogic.initializeKey("LIBSYS2023LIBSYS");

        {
            String encryptedData1 = EncryptionLogic.encryptDataBase64("AB1234567899");
            System.out.println(encryptedData1 + " " + encryptedData1.length());
            System.out.println(EncryptionLogic.decryptDataBase64(encryptedData1));
        }

        {
            String encryptedData1 = EncryptionLogic.encryptDataBase64("AB0000000001");
            System.out.println(encryptedData1 + " " + encryptedData1.length());
            System.out.println(EncryptionLogic.decryptDataBase64(encryptedData1));
        }

        {
            String encryptedData2 = EncryptionLogic.encryptDataBase64("AB1");
            System.out.println(encryptedData2 + " " + encryptedData2.length());
            System.out.println(EncryptionLogic.decryptDataBase64(encryptedData2));
        }

        {
            String encryptedData3 = EncryptionLogic.encryptDataBase64("12345678912345");
            System.out.println(encryptedData3 + " " + encryptedData3.length());
            System.out.println(EncryptionLogic.decryptDataBase64(encryptedData3));
        }
    }

}
