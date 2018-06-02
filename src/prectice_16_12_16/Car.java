package prectice_16_12_16;

public class Car {
      String mod;
      int price;
      static int wheel = 4; 
	public static void main(String[] args) {
		Car a= new Car();
		a.mod="Maruti";
		a.price=200000;
		wheel=4;
		
		Car b= new Car();
		b.price=300000;
		Car c= new Car();
		a.start();
	    acce();
        System.out.println(a.mod);
        System.out.println(b.price);
	

	}
	
	public void start(){
		System.out.println("Start car --- " );
		
	}
	
	public static void acce(){
		
		System.out.println("Accelrate car --- " );
	}

}
