/**
 * 
 */
package simCar;

/**
 * Car�� ��ӹ��� ������ ����
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 19. ���� 4:35:37
 * @version 3.0
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

	/**
	 * (���͸��� �ִ� ��ŭ)������ ����.
	 */
	@Override
	public void go(int distance) {
		// �� �Ÿ�
		double dWent = 0.0;
		// ���� ���͸���
		double dBattery = 0.0;
		dBattery = cBattery;
		
		// 1. �������� �Ѵ�. (�׳� ���ָ����� ��������� ������)
		cBattery -= distance/batteryE;
		
		// 2.1 ���� ���͸��� ���� ���
		if(dBattery == 0) {
			System.out.println("0% of battery. This car can't move.\n");
			setStatus("STOP");
		
		// 2.2 ������ �� ���͸��� ���� ���
		}else if(cBattery < 0) {
			// 2.2.1 ���� ���͸����� ���̳ʽ����� �Ǵ� ���� ���´�.
			cBattery = 0;
			
			// 2.2.2 ���� distance�� ����Ѵ�.
			dWent = batteryE * dBattery;	// �� �Ÿ�
			distance -= dWent;				// ���� �Ÿ�
			
			// 3.1 ���� �����̰� �ִ� ���
			if(getStatus().equals("GO") || getStatus().equals("BACK")) {
				// 3.1.1 ���� ���͸��� �� �� ���� ��ŭ ����.
				System.out.printf("This car went for %.2fkm.\n",dWent);
				// 3.1.2 ���͸��� �� �޸� �����.
				System.out.println("0% of battery. This car would stop soon. "
									+ "1, 2, 3...\n");
				setStatus("STOP");
			
			// 3.2 ���� �����ִ� ���	
			}else {
				// 3.2.1 ���� ���͸��� �� �� �ִ� ��ŭ ����.
				System.out.printf("This car went for %.2fkm.\n",dWent);
				setStatus("GO");
				// 3.2.2 ���͸��� �� �޸� �����.
				System.out.println("0% of battery. This car can't move.\n");
				setStatus("STOP");
			}
			
		// 2.3 ���� ��� �� ���͸��� 0%�� �Ǵ� ���		
		}else if(cBattery == 0) {
			// 2.3.1 ������ ����.
			setStatus("GO");
			System.out.printf("Go for %dkm.\n",distance);
			// 2.3.2 ���͸� ���� ��� �������� �� �����.
			System.out.println("Warning! Low percentage of battery.");
			System.out.println("0% of battery. This car would stop soon. "
								+ "1, 2, 3...\n");
			setStatus("STOP");
		
		// 2.4 ���� ��� �� ���͸��� 5%���ϰ� �Ǵ� ���	
		}else if(cBattery <= 5) {
			// 2.4.1 ������ ����.
			setStatus("GO");
			System.out.printf("Go for %dkm.\n",distance);
			// 2.4.2 ���͸� ���� ��� ��������.
			System.out.println("Warning! Low percentage of battery.\n");
		
		// 2.5 ���� ��� �Ŀ��� ���͸��� 5% �ʰ��� ���	
		}else {
			// 2.5.1 ������ ����.
			setStatus("GO");
			System.out.printf("Go for %dkm.\n",distance);
		}
	}

	/**
	 * (���͸��� �ִ� ��ŭ) �ڷ� ����.
	 */
	@Override
	public void back(int distance) {
		// �� �Ÿ�
		double dWent = 0.0;
		// ���� ���͸���
		double dBattery = 0.0;
		dBattery = cBattery;
				
		// 1. �������� �Ѵ�. (�׳� ���ָ����� ��������� ������)
		cBattery -= distance/batteryE;
				
		// 2.1 ���� ���͸��� ���� ���
		if(dBattery == 0) {
			System.out.println("0% of battery. This car can't move.\n");
			setStatus("STOP");
				
		// 2.2 ������ �� ���͸��� ���� ���
		}else if(cBattery < 0) {
			// 2.2.1 ���� ���͸����� ���̳ʽ����� �Ǵ� ���� ���´�.
			cBattery = 0;
					
			// 2.2.2 ���� distance�� ����Ѵ�.
			dWent = batteryE * dBattery;	// �� �Ÿ�
			distance -= dWent;				// ���� �Ÿ�
					
			// 3.1 ���� �����̰� �ִ� ���
			if(getStatus().equals("GO") || getStatus().equals("BACK")) {
				// 3.1.1 ���� ���͸��� �� �� ���� ��ŭ ����.
				System.out.printf("This car went backward for %.2fkm.\n",dWent);
				// 3.1.2 ���͸��� �� �޸� �����.
				System.out.println("0% of battery. This car would stop soon. "
									+ "1, 2, 3...\n");
				setStatus("STOP");
					
			// 3.2 ���� �����ִ� ���	
			}else {
				// 3.2.1 ���� ���͸��� �� �� �ִ� ��ŭ ����.
				System.out.printf("This car went backward for %.2fkm.\n",dWent);
				setStatus("BACK");
				// 3.2.2 ���͸��� �� �޸� �����.
				System.out.println("0% of battery. This car can't move.\n");
				setStatus("STOP");
			}
					
		// 2.3 ���� ��� �� ���͸��� 0%�� �Ǵ� ���		
		}else if(cBattery == 0) {
			// 2.3.1 �ڷ� ����.
			setStatus("BACK");
			System.out.printf("Go backward for %dkm.\n",distance);
			// 2.3.2 ���͸� ���� ��� �������� �� �����.
			System.out.println("Warning! Low percentage of battery.");
			System.out.println("0% of battery. This car would stop soon. "
								+ "1, 2, 3...\n");
			setStatus("STOP");
				
		// 2.4 ���� ��� �� ���͸��� 5%���ϰ� �Ǵ� ���	
		}else if(cBattery <= 5) {
			// 2.4.1 �ڷ� ����.
			setStatus("BACK");
			System.out.printf("Go backward for %dkm.\n",distance);
			// 2.4.2 ���͸� ���� ��� ��������.
			System.out.println("Warning! Low percentage of battery.\n");
				
		// 2.5 ���� ��� �Ŀ��� ���͸��� 5% �ʰ��� ���	
		}else {
			// 2.5.1 �ڷ� ����.
			setStatus("BACK");
			System.out.printf("Go backward for %dkm.\n",distance);
		}
	
	}
	
	public void chargeBattery(int per) {
		// ������ ���� �� ���͸��� ���� ���� ���
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
