package BeanClasses;

public class Employee3 {

	private int eid ;
	private String address ;
	private String name ;
	private int salary ;
	
	public Employee3(){
		
	}
	public Employee3(int eid, String address,String name,int salary) {
		this.eid = eid ;
		this.address = address ;
		this.name = name ;
		this.salary = salary ;
	}
   public int getEid() {
	   return eid ;
   }
   public String getAddress() {
	   return address ;
   }
   public String getName() {
	return name ;
      }
   public int getSalary() {
	return salary ;
     }

   @Override 
   public String toString() {
	   return ("name : "+name+" Address : "+address+" Employee Id : "+eid+" Salary : "+salary) ;
   }
}
