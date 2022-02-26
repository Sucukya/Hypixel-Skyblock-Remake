package me.sucukya.utility;

public class randomGenerator {

    public enum Mode{
        APLHA, ALPHANUMERIC, NUMERIC, SYMBOLIC, ALPHASYMBOLIC, NUMERICSYMBOLIC, APLHANUMERICSYMBOLIC;
    }

    public static String getString(int lenght, Mode mode){
        StringBuilder builder = new StringBuilder();
        String s = "";
        switch(mode){
            case APLHA:
                s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            case ALPHANUMERIC:
                s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            case NUMERIC:
                s = "0123456789";
        }
        for(int i = 0; i<lenght; i++){
            double index = Math.random() * s.length();
            builder.append(s.charAt((int)index));
        }
        return builder.toString();
    }
}
