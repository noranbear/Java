package simCar;

public class Simulation {

	public static void main(String[] args) {
		
		// 1. 람보르기니를 만든다.
		Car ram = new Gas("Ramborghini", "Yellow", "Sports Car", "111", 20);
		System.out.println(ram.toString());
		System.out.println();
		
		// 2. 기름을 넣는다.
		Gas ramb = (Gas)ram;
		ramb.addFuel(1);
		System.out.println("Adding Fuel");
		System.out.println(ram.toString());
		System.out.println();
		
		// 3. 앞으로 30km 간다.
		ram.go(30);
		System.out.println(ram.toString());
		System.out.println();
		
		// 4. 뒤로 2km 간다.
		ram.back(4);
		System.out.println(ram.toString());
		System.out.println();
		
		
		// 1. IONIQ 5를 만든다.
		Car io = new Electro("IONIQ 5", "Grey", "Electronic Car", "333", 5);
		System.out.println(io.toString());
		System.out.println();
		
		// 2. 기름을 넣는다.
		Electro ion = (Electro)io;
		ion.chargeBattery(80);
		System.out.println("Charging Battery");
		System.out.println(ion.toString());
		System.out.println();
		
		// 3. 앞으로 8km 간다.
		ion.go(8);
		System.out.println(ion.toString());
		System.out.println();
		
		// 4. 뒤로 3km 간다.
		ion.back(3);
		System.out.println(ion.toString());
		System.out.println();

	}

}
