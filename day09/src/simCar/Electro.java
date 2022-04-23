/**
 * 
 */
package simCar;

/**
 * Car을 상속받은 전기차 설계
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 19. 오후 4:35:37
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
	 * (배터리가 있는 만큼)앞으로 간다.
	 */
	@Override
	public void go(int distance) {
		// 간 거리
		double dWent = 0.0;
		// 원래 배터리양
		double dBattery = 0.0;
		dBattery = cBattery;
		
		// 1. 연비계산을 한다. (그냥 가솔린차의 연비계산법을 따랐다)
		cBattery -= distance/batteryE;
		
		// 2.1 현재 배터리가 없는 경우
		if(dBattery == 0) {
			System.out.println("0% of battery. This car can't move.\n");
			setStatus("STOP");
		
		// 2.2 연비계산 후 배터리가 없는 경우
		}else if(cBattery < 0) {
			// 2.2.1 현재 배터리양이 마이너스값이 되는 것을 막는다.
			cBattery = 0;
			
			// 2.2.2 남은 distance를 계산한다.
			dWent = batteryE * dBattery;	// 간 거리
			distance -= dWent;				// 남은 거리
			
			// 3.1 차가 움직이고 있는 경우
			if(getStatus().equals("GO") || getStatus().equals("BACK")) {
				// 3.1.1 남은 배터리로 갈 수 있을 만큼 간다.
				System.out.printf("This car went for %.2fkm.\n",dWent);
				// 3.1.2 배터리가 다 달면 멈춘다.
				System.out.println("0% of battery. This car would stop soon. "
									+ "1, 2, 3...\n");
				setStatus("STOP");
			
			// 3.2 차가 멈춰있던 경우	
			}else {
				// 3.2.1 남은 배터리로 갈 수 있는 만큼 간다.
				System.out.printf("This car went for %.2fkm.\n",dWent);
				setStatus("GO");
				// 3.2.2 배터리가 다 달면 멈춘다.
				System.out.println("0% of battery. This car can't move.\n");
				setStatus("STOP");
			}
			
		// 2.3 연비 계산 후 배터리가 0%가 되는 경우		
		}else if(cBattery == 0) {
			// 2.3.1 앞으로 간다.
			setStatus("GO");
			System.out.printf("Go for %dkm.\n",distance);
			// 2.3.2 배터리 부족 경고를 내보내고 곧 멈춘다.
			System.out.println("Warning! Low percentage of battery.");
			System.out.println("0% of battery. This car would stop soon. "
								+ "1, 2, 3...\n");
			setStatus("STOP");
		
		// 2.4 연비 계산 후 배터리가 5%이하가 되는 경우	
		}else if(cBattery <= 5) {
			// 2.4.1 앞으로 간다.
			setStatus("GO");
			System.out.printf("Go for %dkm.\n",distance);
			// 2.4.2 배터리 부족 경고를 내보낸다.
			System.out.println("Warning! Low percentage of battery.\n");
		
		// 2.5 연비 계산 후에도 배터리가 5% 초과인 경우	
		}else {
			// 2.5.1 앞으로 간다.
			setStatus("GO");
			System.out.printf("Go for %dkm.\n",distance);
		}
	}

	/**
	 * (배터리가 있는 만큼) 뒤로 간다.
	 */
	@Override
	public void back(int distance) {
		// 간 거리
		double dWent = 0.0;
		// 원래 배터리양
		double dBattery = 0.0;
		dBattery = cBattery;
				
		// 1. 연비계산을 한다. (그냥 가솔린차의 연비계산법을 따랐다)
		cBattery -= distance/batteryE;
				
		// 2.1 현재 배터리가 없는 경우
		if(dBattery == 0) {
			System.out.println("0% of battery. This car can't move.\n");
			setStatus("STOP");
				
		// 2.2 연비계산 후 배터리가 없는 경우
		}else if(cBattery < 0) {
			// 2.2.1 현재 배터리양이 마이너스값이 되는 것을 막는다.
			cBattery = 0;
					
			// 2.2.2 남은 distance를 계산한다.
			dWent = batteryE * dBattery;	// 간 거리
			distance -= dWent;				// 남은 거리
					
			// 3.1 차가 움직이고 있는 경우
			if(getStatus().equals("GO") || getStatus().equals("BACK")) {
				// 3.1.1 남은 배터리로 갈 수 있을 만큼 간다.
				System.out.printf("This car went backward for %.2fkm.\n",dWent);
				// 3.1.2 배터리가 다 달면 멈춘다.
				System.out.println("0% of battery. This car would stop soon. "
									+ "1, 2, 3...\n");
				setStatus("STOP");
					
			// 3.2 차가 멈춰있던 경우	
			}else {
				// 3.2.1 남은 배터리로 갈 수 있는 만큼 간다.
				System.out.printf("This car went backward for %.2fkm.\n",dWent);
				setStatus("BACK");
				// 3.2.2 배터리가 다 달면 멈춘다.
				System.out.println("0% of battery. This car can't move.\n");
				setStatus("STOP");
			}
					
		// 2.3 연비 계산 후 배터리가 0%가 되는 경우		
		}else if(cBattery == 0) {
			// 2.3.1 뒤로 간다.
			setStatus("BACK");
			System.out.printf("Go backward for %dkm.\n",distance);
			// 2.3.2 배터리 부족 경고를 내보내고 곧 멈춘다.
			System.out.println("Warning! Low percentage of battery.");
			System.out.println("0% of battery. This car would stop soon. "
								+ "1, 2, 3...\n");
			setStatus("STOP");
				
		// 2.4 연비 계산 후 배터리가 5%이하가 되는 경우	
		}else if(cBattery <= 5) {
			// 2.4.1 뒤로 간다.
			setStatus("BACK");
			System.out.printf("Go backward for %dkm.\n",distance);
			// 2.4.2 배터리 부족 경고를 내보낸다.
			System.out.println("Warning! Low percentage of battery.\n");
				
		// 2.5 연비 계산 후에도 배터리가 5% 초과인 경우	
		}else {
			// 2.5.1 뒤로 간다.
			setStatus("BACK");
			System.out.printf("Go backward for %dkm.\n",distance);
		}
	
	}
	
	public void chargeBattery(int per) {
		// 충전한 양이 총 배터리의 양을 넘을 경우
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
