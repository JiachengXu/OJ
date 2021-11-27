/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        return rec(employees,id);
    }
    public int rec(List<Employee> employees, int id){
        if(employees.size()==0) return 0;
        int value = 0;
        for(Employee employee: employees){
            if(employee.id == id){
                value += employee.importance;
                for(Integer e:employee.subordinates){
                    value += rec(employees, e);
                }
                return value; 
            }
        }
        return 0;
    }
}