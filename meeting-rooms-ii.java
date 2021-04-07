class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<Integer> meetings = new ArrayList<>();
        for(int[] interval : intervals) {
            meetings.add(interval[0]);
            meetings.add(-1 * interval[1]);
        }
        Collections.sort(meetings, (a, b) -> Math.abs(a) - Math.abs(b) == 0 ? (a < b ? -1 : 1) : Math.abs(a) - Math.abs(b));
        int max = 0;
        int cnt = 0;
        for(int meeting : meetings) {
            if(meeting >= 0) {
                cnt++;
                max = Math.max(max, cnt);
            } else cnt--;
        }
        return max;
    }
}