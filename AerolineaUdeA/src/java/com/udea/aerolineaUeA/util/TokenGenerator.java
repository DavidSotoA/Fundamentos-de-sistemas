package com.udea.aerolineaUeA.util;

import java.math.BigInteger;
import java.security.SecureRandom;

public class TokenGenerator {

    public static String generarToken(){
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }
   
}
