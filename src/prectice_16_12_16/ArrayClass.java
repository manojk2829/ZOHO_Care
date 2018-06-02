package prectice_16_12_16;

public class ArrayClass {

	public static void main(String[] args) {
		
		int i[]  = new int[3];
         i[0] = 1;
         i[1] = 20;
         i[2] = 30;
		String str[] = new String[4];
		str[0] = "Manoj";
		str[1] = "age";
		str[2] = "26";
		str[3] = "varansi";

		for(int a=0;a<str.length;a++){
			System.out.println(str[a]);
		}
		
		for(int a=0;a<i.length;a++){
			System.out.println(i[a]);
		}
		
		int j[] = {2,4,7,8,0,30};
		System.out.println(j.length);
		for(int b=0;b<j.length;b++){
			System.out.println(j[b]);
		}
System.out.println("********************");
		System.out.println(i.length);
		for(int f=i.length-1;f>=0;f--)
		{
			System.out.println(i[f]);
		}
		
    }
}
