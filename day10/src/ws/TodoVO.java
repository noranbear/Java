/**
 * 
 */
package ws;

/**
 *
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. ¿ÀÈÄ 4:48:26
 */
public class TodoVO {
	private String num;
	private String when;
	private String what;
	private boolean done;
	
	public TodoVO() {
	}

	public TodoVO(String num, String when, String what) {
		this.num = num;
		this.when = when;
		this.what = what;
		this.done = false;
	}

	/**
	 * @return the num
	 */
	public String getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(String num) {
		this.num = num;
	}

	/**
	 * @return the when
	 */
	public String getWhen() {
		return when;
	}

	/**
	 * @param when the when to set
	 */
	public void setWhen(String when) {
		this.when = when;
	}

	/**
	 * @return the what
	 */
	public String getWhat() {
		return what;
	}

	/**
	 * @param what the what to set
	 */
	public void setWhat(String what) {
		this.what = what;
	}

	/**
	 * @return the done
	 */
	public boolean isDone() {
		return done;
	}

	/**
	 * @param done the done to set
	 */
	public void setDone(boolean done) {
		this.done = done;
	}

	
	@Override
	public String toString() {
		return "TodoVO [num=" + num + ", when=" + when + ", what=" + what + ", "
				+ "done=" + done + "]";
	}
	
	
	
	
	
}
