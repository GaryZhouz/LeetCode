package com.wzz;

public class x {

    public static void main(String[] args) {
        System.out.println(new x().fractionToDecimal(2, 3));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        // write code here
        double v = Double.parseDouble(numerator + "") / Double.parseDouble(denominator + "");
        if ((v + "").length() <= 3) return v + "";
        else {
            String s = v + "";
            String substring = s.substring(0, 2);
            String substring2 = s.substring(2, 3);
            return substring + "(" + substring2 + ")";
        }
    }
}
