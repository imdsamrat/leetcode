class Solution {
    char[] ans;
    List<String> res = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        ans = new char[2*n];
        generateParan(n, n, 0);
        return res;
    }
    
    public void generateParan(int l, int r, int idx) {
        if(l == 0 && r == 0){
            res.add(String.valueOf(ans));
            return;
        }
        if(l == r){
            ans[idx] = '(';
            generateParan(l-1, r, idx+1);
        } else if(l < r && l != 0) {
            ans[idx] = '(';
            generateParan(l-1, r, idx+1);
            ans[idx] = ')';
            generateParan(l, r-1, idx+1);
        } else {
            ans[idx] = ')';
            generateParan(l, r-1, idx+1);
        }
    }
}