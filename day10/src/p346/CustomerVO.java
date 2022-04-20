/**
 * 
 */
package p346;

/**
 * 고객 정보를 담는 클래스 (데이터 전송의 매개체 역할)
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. 오전 11:15:37
 */
public class CustomerVO {
	// 정보를 담을 수 있도록 필드 정의
	private String id;
	private String pwd;
	private String name;
	
	
	public CustomerVO() {
	}

	public CustomerVO(String id, String pwd, String name) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}

	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "CustomerVO [id=" + id + ", pwd=" + pwd + ", name=" + name + "]";
	}
	
	
}
