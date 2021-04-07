class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[^a-zA-Z0-9]", " ");
        paragraph = paragraph.toLowerCase();
        String[] para = paragraph.split(" ");
        System.out.println(paragraph);
        Set<String> bannedSet = new HashSet<>();
        for(String a : banned) {
            bannedSet.add(a);
        }
        String ans = "";
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        for(String a : para) {
            if(!a.isEmpty()) {
                if(!map.containsKey(a)) {
                    map.put(a, 1);
                } else {
                    map.put(a, map.get(a) + 1);
                }
                if(!bannedSet.contains(a) && map.get(a) > max){
                    ans = a;
                    max = map.get(a);
                }
            }
        }
        return ans;
    }
}