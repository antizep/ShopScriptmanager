package services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Hasher {

    public String generateHash(long id) {

        StringBuilder builder = new StringBuilder();

        builder.append(id)
                .append(new Date())
                .append("chestnuts");

        byte [] hashByte = getMessageDigest("MD5", new String(builder) );

        String hash =  byteToString(hashByte);

        return hash;

    }

    public byte[] getMessageDigest(final String algo, final String text) {

        if ((algo == null) || (algo.trim().length() == 0) || (text == null))
            return null;

        MessageDigest md = null;

        try {

            md = MessageDigest.getInstance(algo);
            md.update(text.getBytes());

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();

        }

        if (md != null)

            return md.digest();

        else

            return null;

    }

    public String byteToString(byte [] bites){

        StringBuffer sb = new StringBuffer();

        for (int j = 0; j < bites.length; j++) {
            String s = Integer.toHexString(0xff & bites[j]);
            s = (s.length() == 1) ? "0" + s : s;
            sb.append(s);
        }

        return new String(sb);

    }
}
