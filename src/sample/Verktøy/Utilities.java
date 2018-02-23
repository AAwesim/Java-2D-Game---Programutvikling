package sample.Verktøy;

import java.util.ArrayList;

public class Utilities {

    //DIAGNOSE VERKTØY, SJEKKER ID TIL ELEMENT//
    public static String getId(String a){
        ArrayList<Character> result = new ArrayList<>();

        char[] chars = a.toCharArray();
        int x = 0;

        for(int i = 0 ; i < chars.length ; i++){

            if(chars[i] == ','){
                x = 0;
                break;
            }

            if(x == 1){
                result.add(chars[i]);
            }

            if(chars[i] == '='){
                x = 1;
            }
        }

        StringBuilder builder = new StringBuilder(result.size());

        for(Character ch : result){
            builder.append(ch);
        }

        return builder.toString();
    }


}
