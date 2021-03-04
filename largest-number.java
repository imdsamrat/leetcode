class Solution {
    public String largestNumber(int[] nums) {
        Comparator<String> comparator = new String2Comparator();
        
        String[] s_num = new String[nums.length];
		for(int i = 0; i < nums.length; i++)
		    s_num[i] = String.valueOf(nums[i]);
        Arrays.sort(s_num, comparator);
       if(s_num[0].charAt(0) == '0')
			return "0";
            
		StringBuilder sb = new StringBuilder();
		for(String s: s_num)
	        sb.append(s);
		
		return sb.toString();
		
    }
    
    class String2Comparator implements Comparator<String>{
        @Override
        public int compare(String a, String b) {
            String s1 = a+b;
            String s2 = b+a;
            return s2.compareTo(s1);
        }
    }
}