/**
 * 
 */
package simCar;

/**
 *
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 19. 오후 4:50:53
 */
public class Plug extends Car {

	private int batterySize;
	private double cBattery;
	private int batteryE;
	
	private double fuelSize;
	private double cFuel;
	private double fuelE;
	private String fuelType;
	
	private Boolean batteryMode;
	
	
	// Constructors
	public Plug() {
		
	}

	public Plug(String name, String color, String kind, String serial) {
		super(name, color, kind, serial);
		
	}
	
	public Plug(String name, String color, String kind, String serial, int battryE, 
			double fuelE) {
		super(name, color, kind, serial);
		this.batteryE = battryE;
		this.fuelE = fuelE;
		
		this.batterySize = 100;
		this.cBattery = 0;
		this.fuelSize = 100;
		this.cFuel = 0;
		this.fuelType = "Gas";
		this.batteryMode = true;
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
	 * @return the fuelType
	 */
	public String getFuelType() {
		return fuelType;
	}

	/**
	 * @param fuelType the fuelType to set
	 */
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
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
	 * @return the batteryMode
	 */
	public Boolean getBatteryMode() {
		return batteryMode;
	}

	
	@Override
	public void go(int distance) {
		double dWent = 0.0;
		double dBattery = 0.0;
		
		do {
			if(getBatteryMode() == true) {
				dBattery = cBattery;
				cBattery -= distance/batteryE;
				
				//* 배터리가 없을 때 or 부족할 때
				if(cBattery < 0) {
					System.out.println("0% of battery. It will be changed to the fuel mode.\n");
					this.batteryMode = false;
					cBattery = 0;
					// 남은 distance 계산
					dWent = batteryE * dBattery;
					distance -= dWent;
					
					continue;
							
				}else if(cBattery <= 5) {
					setStatus("GO");
					System.out.printf("Go %dkm.\n",distance);
					System.out.println("Warning! Low percentage of battery.\n");
					break;
				}
				
				setStatus("GO");
				System.out.printf("Go %dkm.\n",distance);
				break;
				
			}else {
				cFuel -= distance/fuelE;
				
				//* 연료가 없을 때 or 부족할 때
				if(cFuel <= 0) {
					cFuel = 0;
					if(getStatus().equals("GO") || getStatus().equals("BACK")) {
						System.out.println("There's no fuel. This car would stop soon. 1, 2, 3...\n");
						setStatus("STOP");
						break;
					}else {
						System.out.println("No fuel. This car can't move.\n");
						break;
					}
					
				}else if(cFuel <= 5) {
					setStatus("GO");
					System.out.printf("Go %dkm.\n",distance);
					System.out.println("Warning! Lack of fuel.\n");
					break;
				}
				
				setStatus("GO");
				System.out.printf("Go %dkm.\n",distance);
				break;
				}
		}while(true);
		
	}

	@Override
	public void back(int distance) {
		double dWent = 0.0;
		double dBattery = 0.0;
		
		do {
			if(getBatteryMode() == true) {
				dBattery = cBattery;
				cBattery -= distance/batteryE;
				
				//* 배터리가 없을 때 or 부족할 때
				if(cBattery < 0) {
					System.out.println("0% of battery. It will be changed to the fuel mode.\n");
					this.batteryMode = false;
					cBattery = 0;
					// 남은 distance 계산
					dWent = batteryE * dBattery;
					distance -= dWent;
					
					continue;
							
				}else if(cBattery <= 5) {
					setStatus("BACK");
					System.out.printf("Back %dkm.\n",distance);
					System.out.println("Warning! Low percentage of battery.\n");
					break;
				}
				
				setStatus("BACK");
				System.out.printf("Back %dkm.\n",distance);
				break;
				
			}else {
				cFuel -= distance/fuelE;
				
				//* 연료가 없을 때 or 부족할 때
				if(cFuel <= 0) {
					cFuel = 0;
					if(getStatus().equals("GO") || getStatus().equals("BACK")) {
						System.out.println("There's no fuel. This car would stop soon. 1, 2, 3...\n");
						setStatus("STOP");
						break;
					}else {
						System.out.println("No fuel. This car can't move.\n");
						break;
					}
					
				}else if(cFuel <= 5) {
					setStatus("BACK");
					System.out.printf("Back %dkm.\n",distance);
					System.out.println("Warning! Lack of fuel.\n");
					break;
				}
				
				setStatus("BACK");
				System.out.printf("Back %dkm.\n",distance);
				break;
				}
		}while(true);
		
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
	
	public void chargeBattery(int per) {
		//* total size보다 크면 
		if((cBattery += per) >= batterySize) {
			System.out.println("Battery is fully charged.");
			cBattery = 100;
		}else {
			cBattery += per;
		}
		
		// 배터리가 있으면 자동으로 electric mode로 변환 
		if(batteryMode = false) {
			batteryMode = true;
		}
	}

	
	@Override
	public String toString() {
		return "Plug [batterySize=" + batterySize + ", cBattery=" + cBattery + ", "
				+ "batteryE=" + batteryE + ", fuelSize="+ fuelSize + ", cFuel=" + cFuel 
				+ ", fuelE=" + fuelE + ", fuelType=" + fuelType + ", "
				+ "batteryMode=" + batteryMode + ",\n toString()=" + super.toString() + "]";
	}
	
	

}
