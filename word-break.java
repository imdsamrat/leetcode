class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }
    
    public boolean wordBreak(String s, Set<String> wordDict, int start, Boolean[] dp) {
        if(start == s.length())
            return true;
        if(dp[start] != null) return dp[start];
        for(int i = start + 1; i <= s.length(); i++) {
            if(wordDict.contains(s.substring(start, i)) 
              && wordBreak(s, wordDict, i, dp))
                return dp[start] = true;
        }
        return dp[start] = false;
    }
}