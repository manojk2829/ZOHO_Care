package prectice_16_12_16;

public class Encapsulation_Example {

	public static void main(String[] args) {
		Encap c = new Encap();
		c.setEmpid(4);
		c.setEmpName("Manoj");
		System.out.println(c.getEmpid() + " -- " + c.getEmpName());
	}

}

class Encap{
	private int Empid;
	private String EmpName;
	
	public int getEmpid(){
		return Empid;
	}
	
	public void setEmpid(int empId){
		this.Empid=empId;
	}
	
	public String getEmpName(){
		return EmpName;
	}
	
	
	public void setEmpName(String empName){
		this.EmpName=empName;
	}
}
