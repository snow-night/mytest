package com.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GetRandomUtil {
	public static String getStringRandom(int length) {  
        
        String val = "";  
        Random random = new Random();  
          
        //参数length，表示生成几位随机数  
        for(int i = 0; i < length; i++) {  
              
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";  
            //输出字母还是数字  
            if( "char".equalsIgnoreCase(charOrNum) ) {  
                //输出是大写字母还是小写字母  
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;  
                val += (char)(random.nextInt(26) + temp);  
            } else if( "num".equalsIgnoreCase(charOrNum) ) {  
                val += String.valueOf(random.nextInt(10));  
            }  
        }  
        return val;  
    }  
	public static String getOrgPassword(String orgCode){
		return orgCode+"_"+getStringRandom(6);
	}
	public static List<String> getListFromArray(String codes,String separator){
		ArrayList<String> arraylist = new ArrayList<String>();
		for(String s:codes.split(separator)){
			arraylist.add(s);
		}
		return arraylist;
	}
	public static List<String> setListPrice(String codes,String separator,String value){
		ArrayList<String> arraylist = new ArrayList<String>();
		for(String s:codes.split(separator)){
			arraylist.add(value);
		}
		return arraylist;
	}
	public static void main(String[] args) {
		System.out.println(GetRandomUtil.getOrgPassword("test"));
	}
}
