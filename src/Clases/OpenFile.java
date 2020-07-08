/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.random;
import java.util.HashSet;
import java.util.Set;
import java.lang.Math.*;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import static jdk.nashorn.internal.objects.NativeMath.random;

/**
 *
 * @author UNI
 */
public class OpenFile {

    public static void main(String args[]) {
        try {
            SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
            // Generate 20 integers 0..20
            for (int i = 0; i < 1; i++) {
                System.out.println(number.nextInt(1000000));
            }
        } catch (NoSuchAlgorithmException nsae) {

        }
    }
}
