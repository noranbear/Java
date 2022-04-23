/**
 * 
 */
package simCar;

/**
 * Car�� ��ӹ��� ���ָ� �� ����
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 19. ���� 4:03:48
 */
public class Gas extends Car {
	
	private boolean auto;
	private double cFuel;
	private double fuelSize;
	private double fuelE;
	private String fuelType;	// ���ָ� or ����
	

	public Gas() {
		
	}

	public Gas(String name, String color, String kind, String serial) {
		super(name, color, kind, serial);
	}
	
	public Gas(String name, String color, String kind, String serial, double fuelE) {
		super(name, color, kind, serial);
		this.auto = true;
		this.cFuel = 0;
		this.fuelSize = 100;
		this.fuelE = fuelE;
		this.fuelType = "Gas";
	}

	
	/**
	 * @return the cFuel
	 */
	public double getcFuel() {
		return cFuel;
	}

	/**
	 * @param cFuel the cFuel to set
	 */
	public void setcFuel(double cFuel) {
		this.cFuel = cFuel;
	}

	/**
	 * @return the auto
	 */
	public boolean isAuto() {
		return auto;
	}

	/**
	 * @return the fuelSize
	 */
	public double getFuelSize() {
		return fuelSize;
	}

	/**
	 * @return the fuelE
	 */
	public double getFuelE() {
		return fuelE;
	}

	/**
	 * @return the fuelType
	 */
	public String getFuelType() {
		return fuelType;
	}

	/**
	 * (���ᰡ �ִ� ��ŭ)������ ����.
	 */
	@Override
	public void go(int distance) {
		// �� �Ÿ�
		double dWent = 0.0;
		// ���� ���ᷮ
		double dFuel = 0.0;
				
		dFuel = cFuel;
				
		// 1. �������� �Ѵ�. (���ָ����� ���� ������)
		cFuel -= distance/fuelE;
				
		// 2.1 ������ �� ���ᰡ ���� ���
		if(cFuel < 0) {
			// 2.1.1 ���� ���ᷮ�� ���̳ʽ����� �Ǵ� ���� ���´�.
			cFuel = 0;
					
			// 2.1.2 ���� distance�� ����Ѵ�.
			dWent = fuelE * dFuel;	// �� �Ÿ�
			distance -= dWent;				// ���� �Ÿ�
					
			// 3.1 ���� �����̰� �ִ� ���
			if(getStatus().equals("GO") || getStatus().equals("BACK")) {
				// 3.1.1 ���� ����� �� �� ���� ��ŭ ����.
				System.out.printf("This car went for %.2fkm.\n",distance);
				// 3.1.2 ���ᰡ �� �޸� �����.
				System.out.println("There's no fuel. This car would stop soon. "
											+ "1, 2, 3...\n");
				setStatus("STOP");
					
			// 3.2 ���� �����ִ� ���	
			}else {
				// 3.2.1 ���� ����� �� �� �ִ� ��ŭ ����.
				System.out.printf("This car went for %.2fkm.\n",distance);
				setStatus("GO");
				// 3.2.2 ���ᰡ �� �޸� �����.
				System.out.println("There's no fuel. This car can't move.\n");
				setStatus("STOP");
			}
					
		// 2.2 ���ᰡ 5L���ϰ� �Ǵ� ���		
		}else if(cFuel <= 5) {
			// 2.2.1 ������ ����.
			setStatus("GO");
			System.out.printf("Go for %dkm.\n",distance);
			// 2.2.2 ��� ��������.
			System.out.println("Warning! Low amount of fuel.\n");
				
		// 2.3 ���ᰡ ����� ���	
		}else {
			// 2.3.1 ������ ����.
			setStatus("GO");
			System.out.printf("Go for %dkm.\n",distance);
		}
	}

	/**
	 * (���ᰡ �ִ� ��ŭ) �ڷ� ����.
	 */
	@Override
	public void back(int distance) {
		// �� �Ÿ�
		double dWent = 0.0;
		// ���� ���ᷮ
		double dFuel = 0.0;
						
		dFuel = cFuel;
						
		// 1. �������� �Ѵ�. (���ָ����� ���� ������)
		cFuel -= distance/fuelE;
						
		// 2.1 ������ �� ���ᰡ ���� ���
		if(cFuel < 0) {
			// 2.1.1 ���� ���ᷮ�� ���̳ʽ����� �Ǵ� ���� ���´�.
			cFuel = 0;
							
			// 2.1.2 ���� distance�� ����Ѵ�.
			dWent = fuelE * dFuel;	// �� �Ÿ�
			distance -= dWent;				// ���� �Ÿ�
							
			// 3.1 ���� �����̰� �ִ� ���
			if(getStatus().equals("GO") || getStatus().equals("BACK")) {
				// 3.1.1 ���� ����� �� �� ���� ��ŭ ����.
				System.out.printf("This car went backward for %.2fkm.\n",distance);
				// 3.1.2 ���ᰡ �� �޸� �����.
				System.out.println("There's no fuel. This car would stop soon. "
													+ "1, 2, 3...\n");
				setStatus("STOP");
							
			// 3.2 ���� �����ִ� ���	
			}else {
				// 3.2.1 ���� ����� �� �� �ִ� ��ŭ ����.
				System.out.printf("This car went backward for %.2fkm.\n",distance);
				setStatus("GO");
				// 3.2.2 ���ᰡ �� �޸� �����.
				System.out.println("There's no fuel. This car can't move.\n");
				setStatus("STOP");
			}
							
		// 2.2 ���ᰡ 5L���ϰ� �Ǵ� ���		
		}else if(cFuel <= 5) {
			// 2.2.1 �ڷ� ����.
			setStatus("GO");
			System.out.printf("Go backward for %dkm.\n",distance);
			// 2.2.2 ��� ��������.
			System.out.println("Warning! Low amount of fuel.\n");
						
		// 2.3 ���ᰡ ����� ���	
		}else {
			// 2.3.1 �ڷ� ����.
			setStatus("GO");
			System.out.printf("Go backward for %dkm.\n",distance);
		}
	}
	
	public void addFuel(int fuel) {
		//* total size���� ũ�� 
		if((cFuel += fuel) >= fuelSize) {
			System.out.println("Battery is fully charged.");
			cFuel = 100;
		}else {
			cFuel += fuel;
		}
	}

	
	@Override
	public String toString() {
		return "Gas [auto=" + auto + ", cFuel=" + cFuel + ", fuelSize=" + fuelSize + ","
				+ " fuelE=" + fuelE + ", fuelType=" + fuelType + ", \n"
				+ "toString()=" + super.toString() + "]";
	}
	
	

}
