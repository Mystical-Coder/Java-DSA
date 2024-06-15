package Hashing;

import java.util.HashMap;

public class IternaryFromTicket {

    public static String getStart(HashMap<String, String> map){
        HashMap<String, String> rmap = new HashMap<>();
        for(String key : map.keySet()){
            rmap.put(map.get(key), key);
        }
        for(String key : map.keySet()){
            if(!rmap.containsKey(key)){
                return key;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Chennai","Bengaluru" );
        map.put("Mumbai","Delhi" );
        map.put("Goa","Chennai" );
        map.put("Delhi","Goa" );

        String start = getStart(map);
        System.out.print(start);
        for(int i = 0; i < map.size(); i++){
            System.out.print("->"+map.get(start));
            start = map.get(start);
        }
    }
}
