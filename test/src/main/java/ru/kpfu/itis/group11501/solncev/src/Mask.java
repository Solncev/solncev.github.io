package ru.kpfu.itis.group11501.solncev.src;

/**
 * Created by Марат on 20.05.2016.
 */
public class Mask {

    String mask;

    public static boolean isMask(String mask){
        char [] a = {':','/', '|' ,  '<','\\', '>' ,'"'};
        for (int i = 0; i < mask.length(); i++) {
            for(int j  = 0; j < a.length; j++){
                if (mask.charAt(i) == a[j])
                    return false;
            }
        }
        return true;
    }
}
