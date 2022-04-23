/**
 * 
 */
package simCar;

/**
 * Car을 상속받은 가솔린 차 설계
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 19. 오후 4:03:48
 */
public class Gas extends Car {
	
	private boolean auto;
	private double cFuel;
	private double fuelSize;
	private double fuelE;
	private String fuelType;	// 가솔린 or 디젤
	

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
	 * (연료가 있는 만큼)앞으로 간다.
	 */
	@Override
	public void go(int distance) {
		// 간 거리
		double dWent = 0.0;
		// 원래 연료량
		double dFuel = 0.0;
				
		dFuel = cFuel;
				
		// 1. 연비계산을 한다. (가솔린차의 연비를 따랐다)
		cFuel -= distance/fuelE;
				
		// 2.1 연비계산 후 연료가 없는 경우
		if(cFuel < 0) {
			// 2.1.1 현재 연료량이 마이너스값이 되는 것을 막는다.
			cFuel = 0;
					
			// 2.1.2 남은 distance를 계산한다.
			dWent = fuelE * dFuel;	// 간 거리
			distance -= dWent;				// 남은 거리
					
			// 3.1 차가 움직이고 있는 경우
			if(getStatus().equals("GO") || getStatus().equals("BACK")) {
				// 3.1.1 남은 연료로 갈 수 있을 만큼 간다.
				System.out.printf("This car went for %.2fkm.\n",distance);
				// 3.1.2 연료가 다 달면 멈춘다.
				System.out.println("There's no fuel. This car would stop soon. "
											+ "1, 2, 3...\n");
				setStatus("STOP");
					
			// 3.2 차가 멈춰있던 경우	
			}else {
				// 3.2.1 남은 연료로 갈 수 있는 만큼 간다.
				System.out.printf("This car went for %.2fkm.\n",distance);
				setStatus("GO");
				// 3.2.2 연료가 다 달면 멈춘다.
				System.out.println("There's no fuel. This car can't move.\n");
				setStatus("STOP");
			}
					
		// 2.2 연료가 5L이하가 되는 경우		
		}else if(cFuel <= 5) {
			// 2.2.1 앞으로 간다.
			setStatus("GO");
			System.out.printf("Go for %dkm.\n",distance);
			// 2.2.2 경고를 내보낸다.
			System.out.println("Warning! Low amount of fuel.\n");
				
		// 2.3 연료가 충분한 경우	
		}else {
			// 2.3.1 앞으로 간다.
			setStatus("GO");
			System.out.printf("Go for %dkm.\n",distance);
		}
	}

	/**
	 * (연료가 있는 만큼) 뒤로 간다.
	 */
	@Override
	public void back(int distance) {
		// 간 거리
		double dWent = 0.0;
		// 원래 연료량
		double dFuel = 0.0;
						
		dFuel = cFuel;
						
		// 1. 연비계산을 한다. (가솔린차의 연비를 따랐다)
		cFuel -= distance/fuelE;
						
		// 2.1 연비계산 후 연료가 없는 경우
		if(cFuel < 0) {
			// 2.1.1 현재 연료량이 마이너스값이 되는 것을 막는다.
			cFuel = 0;
							
			// 2.1.2 남은 distance를 계산한다.
			dWent = fuelE * dFuel;	// 간 거리
			distance -= dWent;				// 남은 거리
							
			// 3.1 차가 움직이고 있는 경우
			if(getStatus().equals("GO") || getStatus().equals("BACK")) {
				// 3.1.1 남은 연료로 갈 수 있을 만큼 간다.
				System.out.printf("This car went backward for %.2fkm.\n",distance);
				// 3.1.2 연료가 다 달면 멈춘다.
				System.out.println("There's no fuel. This car would stop soon. "
													+ "1, 2, 3...\n");
				setStatus("STOP");
							
			// 3.2 차가 멈춰있던 경우	
			}else {
				// 3.2.1 남은 연료로 갈 수 있는 만큼 간다.
				System.out.printf("This car went backward for %.2fkm.\n",distance);
				setStatus("GO");
				// 3.2.2 연료가 다 달면 멈춘다.
				System.out.println("There's no fuel. This car can't move.\n");
				setStatus("STOP");
			}
							
		// 2.2 연료가 5L이하가 되는 경우		
		}else if(cFuel <= 5) {
			// 2.2.1 뒤로 간다.
			setStatus("GO");
			System.out.printf("Go backward for %dkm.\n",distance);
			// 2.2.2 경고를 내보낸다.
			System.out.println("Warning! Low amount of fuel.\n");
						
		// 2.3 연료가 충분한 경우	
		}else {
			// 2.3.1 뒤로 간다.
			setStatus("GO");
			System.out.printf("Go backward for %dkm.\n",distance);
		}
	}
	
	public void addFuel(int fuel) {
		//* total size보다 크면 
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
