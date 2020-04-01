/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author HP
 */
public class Validate {
    public static boolean checkName(String name) {
        return name.matches("[\\p{L}\\s]{3,50}");
    }
    public static boolean checkEmailOrPhone(String emailOrPhone) {
        if (!emailOrPhone.matches("\\w+@\\w+[.]\\w")) { // email@address.com
            if (!emailOrPhone.matches("\\d{9,11}")) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkPassword(String password) {
        return password.matches("\\w{4,30}");
    }
}
