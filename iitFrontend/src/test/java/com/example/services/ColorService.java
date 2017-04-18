package com.example.services;


public class ColorService {
    public static String[] parseRGBAStringToInt(String str)
    {
        str=str.substring(5);
        String[]rgbaS=str.split(", ");

        return rgbaS;
    }
    public static boolean isEqualColor(String[]after,String[]before)
    {
        boolean res=true;
        for (int j=0;j<before.length;j++)
        {
            if(Integer.parseInt(before[j])!=Integer.parseInt(after[j]))
            {
                res=false;
            }

        }
        return res;
    }
    public static boolean isDarker(String[]after,String[]before)
    {
        boolean res=true;
        for (int j=0;j<before.length-1;j++)
        {
            if(Integer.parseInt(before[j])<=Integer.parseInt(after[j]))
            {
                res=false;
            }
        }
    return res;
    }
}
