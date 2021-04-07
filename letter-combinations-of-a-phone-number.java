class Solution {
    List<String> res = new ArrayList<String>();
    Map<Character, String> map = new HashMap<>();
    public List<String> letterCombinations(String str) {
        
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        char[] ans = new char[str.length()];
        if(!str.isEmpty())
            answer(str, 0, ans);
        return res;
    }
    
    public void answer(String str, int idx, char[] ans) {
        if(idx == str.length()){
            res.add(String.valueOf(ans));
            // System.out.println(ans);
            return;
        }
        String options = map.get(str.charAt(idx));
        char[] values = options.toCharArray();
        for(char ch : values){
            ans[idx] = ch;
            answer(str, idx + 1, ans);
        }
    }
}