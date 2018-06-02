package prectice_16_12_16;

public class Hospital_Test {

	public static void main(String[] args) {
		City_Hospital h= new City_Hospital();
		h.doscaning();
		h.doscanning();
		h.streetVacination();
		h.Vacination();
		h.Xray();
		
		
		String str1 = "MY name is manoj Kushwaha "
				+ "I am QA "
				+ "Engineer.";
		String str2 = "my name is manoj Kushwaha I am QA Engineer.";
		
		System.out.println(str1.equalsIgnoreCase(str2));
		System.out.println(str1.substring(4,12));
		String temp[]=str1.split(" ");
		System.out.println(temp[1]);
		for(int i=0;i<temp.length;i++)
			System.out.println(temp[i]);
		
		String s = "200";
		int a = Integer.parseInt(s);
		System.out.println(a);
		
		int p = 250;
		String ss = String.valueOf(p);
		System.out.println(ss);
	}

}
