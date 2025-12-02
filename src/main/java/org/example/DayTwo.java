package org.example;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.*;
import java.math.BigInteger;
import java.util.HashSet;

public class DayTwo {
    void main() throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream("DayTwo.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = br.readLine();
        String[] parts =  line.split(",");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }
        HashSet<BigInteger> vals = new HashSet<>();

        for (String r : parts) {
            String[] lr = r.split("-");

            BigInteger left = new BigInteger(lr[0]);
            BigInteger right = new BigInteger(lr[1]);

            int maxDigits = right.toString().length();

            for (int n = 1; n < maxDigits; n++) {
                BigInteger pow10_n = BigInteger.TEN.pow(n);
                BigInteger sMinDigits = (n == 1) ? BigInteger.ONE : pow10_n.divide(BigInteger.TEN);
                BigInteger sMaxDigits = pow10_n.subtract(BigInteger.ONE);

                for (int k = 2; n * k <= maxDigits; k++) {
                    BigInteger pow10_nk = BigInteger.TEN.pow(n * k);
                    BigInteger M = pow10_nk.subtract(BigInteger.ONE).divide(pow10_n.subtract(BigInteger.ONE));

                    BigInteger sMinByRange = left.add(M).subtract(BigInteger.ONE).divide(M);
                    BigInteger sMaxByRange = right.divide(M);

                    BigInteger sMin = sMinDigits.max(sMinByRange);
                    BigInteger sMax = sMaxDigits.min(sMaxByRange);

                    for (BigInteger s = sMin; s.compareTo(sMax) <= 0; s = s.add(BigInteger.ONE)) {
                        BigInteger val = M.multiply(s);
                        vals.add(val);
                    }
                }
            }
        }

        BigInteger total = BigInteger.ZERO;
        for (BigInteger v : vals) {
            total = total.add(v);
        }

        System.out.println(total);
    }
}

