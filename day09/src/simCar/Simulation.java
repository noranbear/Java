package simCar;

public class Simulation {

	public static void main(String[] args) {
		
		// 1. ��������ϸ� �����.
		Car ram = new Gas("Ramborghini", "Yellow", "Sports Car", "111", 20);
		System.out.println(ram.toString());
		System.out.println();
		
		// 2. �⸧�� �ִ´�.
		Gas ramb = (Gas)ram;
		ramb.addFuel(1);
		System.out.println("Adding Fuel");
		System.out.println(ram.toString());
		System.out.println();
		
		// 3. ������ 30km ����.
		ram.go(30);
		System.out.println(ram.toString());
		System.out.println();
		
		// 4. �ڷ� 2km ����.
		ram.back(4);
		System.out.println(ram.toString());
		System.out.println();
		
		
		// 1. IONIQ 5�� �����.
		Car io = new Electro("IONIQ 5", "Grey", "Electronic Car", "333", 5);
		System.out.println(io.toString());
		System.out.println();
		
		// 2. �⸧�� �ִ´�.
		Electro ion = (Electro)io;
		ion.chargeBattery(80);
		System.out.println("Charging Battery");
		System.out.println(ion.toString());
		System.out.println();
		
		// 3. ������ 8km ����.
		ion.go(8);
		System.out.println(ion.toString());
		System.out.println();
		
		// 4. �ڷ� 3km ����.
		ion.back(3);
		System.out.println(ion.toString());
		System.out.println();

	}

}
