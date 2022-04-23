/**
 * 
 */
package simCar;

/**
 *
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 19. 오후 4:03:48
 */
public class Gas extends Car {
	
	private boolean auto;
	private double cFuel;
	private double fuelSize;
	private double fuelE;
	private String fuelType;
	

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

	
	@Override
	public void go(int distance) {
		cFuel -= distance/fuelE;
		
		//* 연료가 없을 때 or 부족할 때
		if(cFuel <= 0) {
			if(getStatus().equals("GO") || getStatus().equals("BACK")) {
				System.out.println("There's no fuel. This car would stop soon. 1, 2, 3...\n");
				setStatus("STOP");
			}else {
				System.out.println("No fuel. This car can't move.\n");
			}
			
		}else if(cFuel <= 5) {
			setStatus("GO");
			System.out.printf("Go %dkm.\n",distance);
			System.out.println("Warning! Lack of fuel.\n");
			
		}else {
			setStatus("GO");	
			System.out.printf("Go %dkm.\n",distance);
		}
		
	}

	@Override
	public void back(int distance) {
		cFuel -= distance/fuelE;
		
		//* 연료가 없을 때 or 부족할 때
		if(cFuel <= 0) {
			if(getStatus().equals("GO") || getStatus().equals("BACK")) {
				System.out.println("There's no fuel. This car would stop soon. 1, 2, 3...\n");
				setStatus("STOP");
			}else {
				System.out.println("No fuel. This car can't move.\n");
			}
			
		}else if(cFuel <= 5) {
			setStatus("BACK");
			System.out.printf("Back %dkm.\n",distance);
			System.out.println("Warning! Lack of fuel.\n");
			
		}else {
			setStatus("BACK");	
			System.out.printf("Back %dkm.\n",distance);
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
