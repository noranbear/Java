/**
 * 
 */
package simCar;

/**
 * Car�� ��ӹ��� ������ ����
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 19. ���� 4:35:37
 * @version 2.0
 */
public class Electro extends Car {

	private int batterySize;
	private double cBattery;
	private int batteryE;
	
	// Constructors
	public Electro() {
		
	}

	public Electro(String name, String color, String kind, String serial) {
		super(name, color, kind, serial);
	}

	public Electro(String name, String color, String kind, String serial, int batteryE) {
		super(name, color, kind, serial);
		this.batterySize = 100;
		this.cBattery = 0;
		this.batteryE = batteryE;
	}


	/**
	 * @return the cBattery
	 */
	public double getcBattery() {
		return cBattery;
	}

	/**
	 * @param cBattery the cBattery to set
	 */
	public void setcBattery(double cBattery) {
		this.cBattery = cBattery;
	}

	/**
	 * @return the batterySize
	 */
	public int getBatterySize() {
		return batterySize;
	}

	/**
	 * @return the batteryE
	 */
	public int getBatteryE() {
		return batteryE;
	}

	
	@Override
	public void go(int distance) {
		// 1. �������� �Ѵ�. (���ָ����� ���� �׳� ������)
		cBattery -= distance/batteryE;
		
		// ���͸��� ���� ���
		if(cBattery <= 0) {
			if(getStatus().equals("GO") || getStatus().equals("BACK")) {
				System.out.println("0% of battery. This car would stop soon. 1, 2, 3...\n");
				setStatus("STOP");
				
			}else {
				System.out.println("0% of battery. This car can't move.\n");
			}
		// ���͸��� ������ ���		
		}else if(cBattery <= 5) {
			setStatus("GO");
			System.out.printf("Go %dkm.\n",distance);
			System.out.println("Warning! Low percentage of battery.\n");
			
		}else {
			setStatus("GO");
			System.out.printf("Go %dkm.\n",distance);
		}
	}

	@Override
	public void back(int distance) {
		cBattery -= distance/batteryE;
		
		// ���͸��� ���� ���
		if(cBattery <= 0) {
			if(getStatus().equals("GO") || getStatus().equals("BACK")) {
				System.out.println("0% of battery. This car would stop soon. 1, 2, 3...\n");
				setStatus("STOP");
				
			}else {
				System.out.println("0% of battery. This car can't move.\n");
			}
		// ���͸��� ������ ���		
		}else if(cBattery <= 5) {
			setStatus("BACK");
			System.out.printf("Back %dkm.\n",distance);
			System.out.println("Warning! Low percentage of battery.\n");
			
		}else {
			setStatus("BACK");
			System.out.printf("Back %dkm.\n",distance);
		}
	}

	public void chargeBattery(int per) {
		//* total size���� ũ�� 
		if((cBattery += per) >= batterySize) {
			System.out.println("Battery is fully charged.");
			cBattery = 100;
		}else {
			cBattery += per;
		}
	}
	
	
	@Override
	public String toString() {
		return "Electro [batterySize=" + batterySize + ", cBattery=" + cBattery + ", "
				+ "batteryE=" + batteryE + ",\n toString()=" + super.toString() + "]";
	}
	
	

}
