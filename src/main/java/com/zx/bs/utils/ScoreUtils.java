package com.zx.bs.utils;

public class ScoreUtils {
    public static Integer score(int n){
        if(n<=18)
            return new Integer(n*5);
        else if(n<=28)
            return new Integer((n-18)+90);
        else
            return  new Integer(100);
    }
}
