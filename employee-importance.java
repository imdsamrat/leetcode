/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    int total = 0;
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<Integer, Employee>();
        Employee emp;
        for(int i = 0; i < employees.size(); i++) {
            emp = employees.get(i);
            map.put(emp.id, emp);
        }
        emp = map.get(id);
        Queue<Employee> q = new LinkedList<Employee>();
        q.add(emp);
        int ans = 0;
        while(!q.isEmpty()) {
            emp = q.poll();
            ans += emp.importance;
            List<Integer> subordinates = emp.subordinates;
            for(int i = 0; i < subordinates.size(); i++) {
                q.add(map.get(subordinates.get(i)));
            }
        }
        return ans;
    }
}