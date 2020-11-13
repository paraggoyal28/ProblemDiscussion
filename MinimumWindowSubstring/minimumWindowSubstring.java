class Solution{
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }

        Map<Character, Integer> mp = 
          new HashMap<Character, Integer>();

        int counter = 0;
        int begin = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        int head = 0;

        for(int iter = 0; iter < t.length(); ++iter){
            char character = t.charAt(iter);
            if(mp.containsKey(character)){
                mp.put(character, mp.get(character)+1);
            } else {
                mp.put(character, 1);
            }
        }

        counter = mp.size();

        while(end < s.length()) {
            char endChar = s.charAt(end);
            if(mp.containsKey(endChar)){
                mp.put(endChar, mp.get(endChar)-1);
                if(mp.get(endChar)==0){
                    counter--;
                }
            }
            end++;

            while(counter == 0){
                char beginChar = s.charAt(begin);
                if(mp.containsKey(beginChar)){
                    mp.put(beginChar, mp.get(beginChar)+1);
                    if(mp.get(beginChar) > 0){
                        counter++;
                    }
                }
                if(end - begin < len){
                    head = begin;
                    len  = end - begin;
                }
                begin++;
            }
        }
        if(len == Integer.MAX_VALUE){
            return  "";
        } 
        return s.substring(head, head+len);
    }
}