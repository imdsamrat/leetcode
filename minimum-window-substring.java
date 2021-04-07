class Solution {
    public String minWindow(String s, String t) {
        int[] tFreq = new int[128];
        int tLen = t.length();
        for(int i = 0; i < t.length(); i++) {
            tFreq[t.charAt(i)]++;
        }
        int[] sFreq = new int[128];
        int i = 0, j = 0;
        int cnt = 0;
        int ansS = -1, ansR = s.length();
        while(i < s.length()){
            char ch = s.charAt(i);
            //if cnt is lesser...aquire, 
            if(cnt < tLen) {
                if(sFreq[ch] < tFreq[ch])
                    cnt++;
                sFreq[ch]++;
            }
            while(cnt == tLen && j <= i){
                if(i-j < ansR-ansS){
                    ansS = j;
                    ansR = i;
                }
                ch = s.charAt(j);
                if(sFreq[ch] == tFreq[ch])
                    cnt--;
                sFreq[ch]--;
                j++;
            }
            
            i++;
            //else release and check if is min window answer while cnt is lesser
        }
        StringBuilder sb = new StringBuilder();
        if(ansS >= 0){
            for(i = ansS; i <= ansR; i++)
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}