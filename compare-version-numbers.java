class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0, j = 0;
        while(i < v1.length && j < v2.length) {
            int val1 = Integer.valueOf(v1[i]);
            int val2 = Integer.valueOf(v2[i]);
            if(val1 != val2)
                return val1 < val2 ? -1 : 1;
            i++;
            j++;
        }
        
        while(i < v1.length) {
            int val = Integer.valueOf(v1[i]);
            if(val != 0)
                return 1;
            i++;
        }
        
        while(j < v2.length) {
            int val = Integer.valueOf(v2[j]);
            if(val != 0)
                return -1;
            j++;
        }
        return 0;
    }
}