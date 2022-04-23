# Interface Practice

- Day10 - 2022-04-20
  - DB의 데이터 처리원리와 애플리케이션과의 상호작용 방법
  
  - Interface로 수정이 용이한 프로그램 만들기
    - [Interface 개념 정리](../)
  
  - [ArrayList와 HashMap 개념](../)
    
  - Group Workshop: TodoList ver.1
    - 다중 interface를 활용한 정보 처리 프로그램으로 TodoList를 만듦.
    
    


## 개요

1. Package: [p344](#p344)

   : 데이터 처리의 원리.

   - [UML](#UML)
   - [CustomerVO](#CustomerVO)
   - [OracleDAO](#OracleDAO)
   - [App](#App)
   - [Test](./p344/Test.java) : [ArrayList 개념](../)

2. Package: [p345](#p345)

   : Interface의 사용.

   - [UML](#p345)
   - CustomerVO
   - [DAO](#DAO): CRUD를 정의한 Interface
   - [OracleDAO](#OracleDAO345) : DAO interface 상속
   - [MariadbDAO](#MariadbDAO) : DAO interface 상속
   - [App](#App345)

3. Package: [p346](#p346)

   : HashMap을 사용하여 저장공간을 구현.

   - [UML](#p346)

   - CustomerVO
   - DAO: CRUD를 정의한 Interface
   - [OracleDAO](#OracleDAO346): DAO interface 상속
   - App
   - Test: [HashMap 개념](../)

4. Package: [ws](#ws) 

   : 다중 인터페이스를 활용한 TodoList 만들기.

   - [UML](#ws)
   - [TodoVO](#TodoVO)
   - DAO: CRUD를 정의한 Interface
   - [Search](#Search): Search method의 기능을 정의한 interface
   - [TodoDAO](#TodoDAO): DAO와 Search interface를 상속받아 HashMap에 접속
   - [App](#Appws)



---

## p344

- App에서 유저에게 받은 정보를 CustomerVO에 담아 OracleDAO에 보내면, Oracle이라는 

  데이터베이스(DB)에 받은 정보들을 보내는 프로그램을 구현한다.

  - 평소 우리가 회원가입할 때, 적는 정보들이 어떻게 저장되는지 원리를 생각해본다.

  - 한 사람이 아닌 여러사람의 정보를 한 번에 보낼 수 있기 때문에

    한번에 여러 CustomerVO가 OracleDAO에 보내질 수 있다.
  
- FILE

  - [CustomerVO](#CustomerVO)
  
  - [OracleDAO](#OracleDAO)
  
  - [App](#App)
  
    

### UML

<img src="README.assets/OracleDAO UML_First Ver(p344).png" alt="OracleDAO UML p344" style="zoom:110%;" />

​																															*DAO : Data Access Object

​																															*VO: Value Object

- 관계:

  - **Directe Association**: App이 OracleDAO를 필요로 하는 관계.
  - **Dependency**: OracleDAO는 Oracle에 의존.

---

### CustomerVO

- 고객의 정보를 담는 클래스
  - 정보를 담을 수 있도록 필드를 정의해준다.
  - 3가지 고객 정보 : ID, PW, 이름
- 데이터 전송의 매개체 역할

```java
public class CustomerVO {
	// 고객의 정보를 담을 수 있도록 필드 정의
	private String id;				// 아이디
	private String pwd;				// 패스워드
	private String name;			// 이름
	
    // Constructors
	public CustomerVO() {
	}
    
	public CustomerVO(String id, String pwd, String name) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}
    
	// Getters and Setters (생략버전)
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

	@Override
	public String toString() {
		return "CustomerVO [id=" + id + ", pwd=" + pwd + ", name=" + name + "]";
	}
}

```



### OracleDAO

- 데이터베이스 Oracle과 연동하는 클래스

  - DB에 정보를 넣는 방법을 배우지 않았기 때문에 그러한 행위들은 모두 화면에 쓰는 정도로 

    제한된다.

  - 기능:

    - *insert(CustomerVO c)*: 고객의 정보를 DB에 넣는다.

    - *delete(String id)*: DB에 있는 고객 정보 중 선택된 정보를 지운다.

    - *select(String id)*: 선택된 고객의 정보를 DB에서 꺼내 보여준다.

    - *select()*: DB에 있는 모든 정보들을 보여준다.

      - 다수의 CustomerVO 객체를 보낼때 -  *ArrayList<>* 사용
      
        (Array는 사이즈를 지정해야 하기 때문에 현업에서는 ArrayList<>로 대체됨)
      
      

- 어떤 프로그램이 누군가와 접속을 한다는 것은 상당히 복잡한 아키텍처로 되어있다.

  - Scanner를 통해서 화면에서 입력된 값을 가져오는 것, 등. 

    즉, **접속**을 하면 무조건 **close**해줘야 한다.

     - connect()
     - close()

  - ** [**접속** -> DB에 접속 후 정보 터치 -> **close** ] 라는 과정이 반드시 필요 (Open & close)

    

```Java
public class OracleDAO {
	
	/**
	 * 가상의 서버 접속 메소드
	 */
	public void connect() {
		System.out.println("Oracle Server Connected.....");
	}
	
	/**
	 * 가상의 서버 연결 끊기 메소드
	 */
	public void close() {
		System.out.println("Oracle Server Closed........");
	}
	
	/**
	 * 고객의 정보를 받아서 DB에 넣는다.
	 * @param c CustomerVO 객체 어느 한 고객의 정보(id, pw, name)
	 */
	public void insert(CustomerVO c) {	
		connect();
		System.out.println(c);
		System.out.println("Inserted.");
		close();
	}
	
	/**
	 * DB에 있을 고객의 아이디를 받아서 해당 정보들을 지운다.
	 * @param id 고객의 id
	 */
	public void delete(String id) {
		connect();
		System.out.println(id);
		System.out.println("Deleted.");
		close();
	}
	
	/**
	 * id에 해당하는 (현재는 가상의) pw와 name을 저장소에서 가져와서 
	 * CustomerVO객체에 넣는다.
	 * @param id 보고싶은 고객정보의 아이디
	 * @return 임의로 만든 가상의 고객 정보
	 */
	public CustomerVO select(String id) {
		connect();
		// 가상의 정보 생성
		String pwd = "pw01";
		String name = "james";
		CustomerVO c = new CustomerVO(id, pwd, name);	
		close();
		
		return c;
	}
```

```Java
import java.util.ArrayList;

/**
	 * 데이터베이스에 있는 모든 고객들의 (가상)정보를 보여준다.
	 * @return 고객정보 리스트
	 */
	 public ArrayList<CustomerVO> select(){
		 connect();
		// 여러가지 정보를 사이즈 제한 없이 담을 수 있는 ArrayList 만들기
		ArrayList<CustomerVO> list = new ArrayList<>();
		
		// List 안에 DB에 저장되어 있을거라고 생각되는 가상의 정보들을 만들어 집어넣는다.
		list.add(new CustomerVO("id01","pwd01","james"));
		list.add(new CustomerVO("id02","pwd02","kang"));
		list.add(new CustomerVO("id03","pwd03","kim"));
		close();
		
		return list;
	 }
```

*[ArrayList 설명](../)



### App

- 유저에게 정보를 받아서 CustomerVO에 담은 다음, Oracle에 보낸다.

- ```Java 
  OracleDAO dao = new OracleDAO();	
  ```
  
  - App은 OracleDAO가 필요하다 (Directed Association 관계)
  
    --> App 안에서 OracleDAO 객체를 생성.
  
    
  

```java
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		System.out.println("Start...");
		
		// OracleDAO 객체를 만든다.
		// *App과 OracleDAO를 이어주는 부분
		OracleDAO dao = new OracleDAO();	
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			// 메뉴
			System.out.println("Input cmd(i,d,s,a,q): ");		
			String cmd = sc.next();							
			
			// q: 메뉴에서 나간다.
			if(cmd.equals("q")) {				
				System.out.println("Quit");
				break;
			
			// i: 정보를 넣어서 보낸다.
			}else if(cmd.equals("i")) {
				System.out.println("Input Customer info.");
				
				System.out.println("Input Customer id: ");
				String id = sc.next();
				System.out.println("Input Customer password: ");
				String pwd = sc.next();
				System.out.println("Input Customer name: ");
				String name = sc.next();
				
				// 정보를 담음.
				CustomerVO c = new CustomerVO(id, pwd, name);
				// 정보를 보냄.
				dao.insert(c);
			
			// d: 정보를 지운다. (지웠다고 얘기해준다)
			}else if(cmd.equals("d")) {
				System.out.println("Input Customer id: ");
				String id = sc.next();
				
				dao.delete(id);
			
			// s: 정보를 불러낸다. (가상의 정보를 보내준다)
			}else if(cmd.equals("s")) {
				System.out.println("Input Customer id: ");
				String id = sc.next();
				
				CustomerVO c = dao.select(id);
				System.out.println(c);
				
			// a: DB에 있는 모든 정보를 불러낸다. (모든 가상의 정보를 보내준다)
			}else if(cmd.equals("a")) {
				ArrayList<CustomerVO> a = dao.select();
				
				for (CustomerVO c : a) {
					System.out.println(c);
				}
				
			}else {
				// i, d, s, q 외의 input이 들어왔을 때
				System.out.println("Select a menu.\n");
				continue;
			}
		}
		sc.close();
		System.out.println("End...");
	}
}
```



#### 현재의 App과 OracleDAO의 관계는 바람직하지 않다.

- App과 OracleDAO가 **분리되어 있지 않기 때문에** 어느 하나를 수정하려고 할 때,

  모든 시스템을 수정해야한다.

- 이렇게 DB에 의존하는 방식은 지양해야 한다. --> DB를 바꾸면, 다 바꿔야 함.

<img src="README.assets/OracleDAO UML_분리불가상태(p344).png" alt="OracleDAO의 상태 UML_분리불가상태 (p344)" style="zoom:110%;" />



==== >>> 그래서 두 클래스를 분리시키기 위해서 **인터페이스**가 필요하다.

​																																									[위로](#p344)

---

## p345

- P344에서 했던 프로그램에 **인터페이스 DAO**를 넣어 좀 더 융통성 있는 프로그램으로 만든다.

- DAO의 공통적인 기능을 정의한 인터페이스에 OracleDAO와 MariadbDAO를 퍼즐처럼 꼈다뺐다

  가능. ---> App.java에서 인터페이스 선언만 바꿔주면 된다.

  

- FILE

  - [CustomerVO](#CustomerVO)

  - [DAO](#DAO): Interface

  - [OracleDAO](#OracleDAO345) : DAO interface 상속

  - [MariadbDAO](#MariadbDAO) : DAO interface 상속

  - [App](#App345)

    

### UML

<img src="README.assets/Interface UML (p345).png" alt="README.assets/Interface UML (p345).png" style="zoom:110%;" />

- **Realization** : Interface 상속
  - DAO Interface - OracleDAO, MariadbDAO의 관계




### DAO

- OracleDAO와 MariadbDAO의 기능이 정의되어 있는 인터페이스

- Methods ([설명](#OracleDAO))

  - Default Methods
    - *connect()*
    - *close()*
  - Abstract Methods
    - *insert(CustomerVO c)*
    - *delete(String id)*
    - *select(String id): CustomerVO*
    - *select(): ArrayList< CustomerVO >*

  

```Java
import java.util.ArrayList;

public interface DAO {
	
	// 인터페이스는 하위 클래스에서 공통적으로 쓰일 일반 함수도 정의할 수 있다.
	// default 키워드 사용
	/**
	 * 가상의 서버 접속 메소드
	 */
	public default void connect() {
		System.out.println("Oracle Server Connected.....");
	}
	/**
	 * 가상의 서버 연결 끊기 메소드
	 */
	public default void close() {
		System.out.println("Oracle Server Closed........");
	}
	
	// 인터페이스에 Abstract keyword 없이 method header만 써도 추상메소드화함.
	public void insert(CustomerVO c);		
	public void delete(String id);
	public CustomerVO select(String id);
	public ArrayList<CustomerVO> select();
}
```



### OracleDAO345

- 데이터베이스 Oracle과 연동하는 클래스

- DAO interface를 상속.

  - ```java
    public class OracleDAO implements DAO
    ```

  - *Connect()*와 *close()*는 interface에서 쓰였다.

  - Interface에 정의된 Abstract Class들을 Override한다.

- 그 외 p344에 나온 [OracleDAO](#OracleDAO)의 코드내용과 똑같다.



```java
import java.util.ArrayList;

public class OracleDAO implements DAO {

	@Override
	public void insert(CustomerVO c) {
		connect();
		System.out.println("Oracle Inserted: " + c);
		close();
	}

	@Override
	public void delete(String id) {
		connect();
		System.out.println("Oracle Deleted: " + id);
		close();
	}

	@Override
	public CustomerVO select(String id) {
		System.out.println("Oracle Selected: " + id);
		connect();
		CustomerVO c = new CustomerVO("id01", "pwd01", "james");
		close();
		
		return c;
	}

	@Override
	public ArrayList<CustomerVO> select() {
		System.out.println("Oracle Selected ALL: ");
		connect();
		ArrayList<CustomerVO> list = new ArrayList<>();
		list.add(new CustomerVO("id01","pwd01","james"));
		list.add(new CustomerVO("id02","pwd02","kang"));
		list.add(new CustomerVO("id03","pwd03","kim"));
		close();
		
		return list;
	}
}
```



### MariadbDAO

- 데이터베이스 MariaDB와 연동하는 클래스

- DAO interface를 상속.

  - ```java
    public class MariadbDAO implements DAO
    ```

- 이하 OracleDAO와 같다.



### App345

* DAO 인터페이스에 맞게 설계된 app.

 * OracleDAO와 MariadbDAO 사이의 치환이 자유롭다.

   ```java
   // interface에 DAO class 연결
   DAO dao = new OracleDAO();
   ```

   ``` java
   // interface에 Mariadb 연결
   DAO dao = new MariadbDAO();	
   ```

 * 이하 p345의 [App](#App)과 같다.

   

#### 현재의 프로그램은 정보를 저장하지 못한다.

- 지금까지는 저장 공간이 없어서 가상의 정보만을 보여줬다.

- DB가 없는 관계로 **HashMap** 을 이용해 진짜 유저가 넣은 정보를 가지고 기능을 실행해보자.

  

   ​																																							[위로](#p345)

---

## p346

- DB가 없는 관계로 **[HashMap](../)**을 이용해 **저장공간**을 구현해보자.
- FILE
  - [CustomerVO](#CustomerVO) : p344와 같음
  - [DAO](#DAO) : p345와 같음
  - [OracleDAO](#OracleDAO346) : HashMap을 사용하여 저장공간을 구현.
  - [App](#App) : p344와 같음



### UML

- 저장공간이 OracleDB 대신 Map object로 대체되었다.

<img src="README.assets/HashMap을 이용한 OracleDAO UML(p346).png" alt="HashMap을 이용 OracleDAO UML (p346)" style="zoom:110%;" />



### OracleDAO346

- HashMap을 저장공간으로 사용하여 정보를 넣고 빼내는 DAO Class.
- 코드
  - Interface DAO를 상속.
  - **Field**: *HashMap<String, CustomerVO>* - 저장공간을 만들기 위해.
  - **Constructor**: HashMap을 생성하기 위해
  - **Overiding methods**
    -  Hashmap의 methods를 이용해 정보를 넣고 뺀다.
    - [기능](#OracleDAO)

```java
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class OracleDAO implements DAO {

	// 저장공간 탑재.
	HashMap<String, CustomerVO> map;	// 선언만 해서는 사용 못한다.
	
    // Constructor
	public OracleDAO() {
		map = new HashMap<String, CustomerVO>();	// HashMap 생성
	}
	
	@Override
	public void insert(CustomerVO c) {
		String key = c.getId();			// 받은 고객 정보의 id를 얻는다.
		map.put(key, c);				// 저장공간에 정보를 넣는다.
	}

	@Override
	public void delete(String id) {
		map.remove(id);
	}

	@Override
	public void update(CustomerVO c) {
		String key = c.getId();
		map.put(key, c);
	}
	
	@Override
	public CustomerVO select(String id) {
		CustomerVO c = null;			// 리턴할 객체를 생성한다.
		c = map.get(id);				// 받은 id의 정보를 객체에 넣어 리턴한다.
		return c;
	}

	/**
	 * 저장공간에 있는 모든 정보를 보여준다.
	 */
	@Override
	public ArrayList<CustomerVO> select() {
		ArrayList<CustomerVO> list = new ArrayList<>();	// 리턴할 객체를 생성.
		Collection<CustomerVO> col = map.values();
		Iterator<CustomerVO> it = col.iterator();		
		
		while(it.hasNext()) {							// Value가 있을 때까지
			CustomerVO cust = it.next();				// ArrayList에 넣고 리턴.
			list.add(cust);
		}
		return list;
	}
}
```



#### DAO Interface의 한계는 아직 남아있다

-  Interface에서 Abstract Method의 타입이 정해져 있기 때문에 그 외의 타입이 들어가는

  클래스와의 연동이 어렵다.

- ==> [Day11](../day11)

  

​																																									[위로](#p346)

---

## ws

- Group Workshop

  - day10에서 배운것을 토대로 **TodoList**를 Application을 구현해 보았다.

    

- **TodoList**

  - 다중 인터페이스를 활용한다.
  
  - 사용할 정보:
    - 리스트 번호: HashMap의 Key로 사용.
    - 날짜
    - 할 일
    - 완료 유무
  
  - 기능 구현:
    1. 유저에게 정보를 받아 저장한다.
    
    2. 유저가 원하는 정보를 지운다.
    
    3. 유저가 실행완료한 목록을 '완료'로 체크한다.
    
    4. 유저가 선택한 목록을 보여준다.
    
    5. 저장되어 있는 모든 목록을 보여준다.
    
    6. 유저의 선택에 따라서 실행완료 또는 실행필요 목록을 보여준다.
    
       
  
- FILE

  - [TodoVO](#TodoVO): 할일 리스트 정보를 담음.
  - [DAO](#DAO): CRUD의 기능을 담은 Interface (p345의 DAO와 같음)
  - [Search](#Search): Search의 기능을 담은 Interface
  - [TodoDAO](#TodoDAO): DAO와 Search 인터페이스를 상속 받아 CRUD의 메소드들을 Overried함
  - [App](#Appws): 유저와 상호작용하는 app

    

### UML

<img src="README.assets/TodoList UML image.png" alt="TodoList UML image" style="zoom:110%;" />

- TodoDAO는 DAO와 Search interface를 상속받는다.



### TodoVO

- TodoList에 필요한 정보를 담을 매개체 클래스

- 필드

  - String num: 리스트 번호

  - String when

  - String what

  - boolean done: true = 완료

    

```java
public class TodoVO {
    
	private String num;
	private String when;
	private String what;
	private boolean done;
	
	// Constructors
	public TodoVO() {
	}

	public TodoVO(String num, String when, String what) {
		this.num = num;
		this.when = when;
		this.what = what;
		this.done = false;
	}

    // Getters and Setters (생략버전)
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

	// toString()
	@Override
	public String toString() {
		return "TodoVO [num=" + num + ", when=" + when + ", what=" + what + ", "
				+ "done=" + done + "]";
	}
}
```



### Search

- Search의 기능을 정의한 interface.

- Abstract method *search()*를 정의하고 있다.

  - *search()*: 할 일 완료 유무에 따라 정보 리스트를 서치해서 리턴한다.

  - ```java
    public ArrayList<TodoVO> search(boolean done);
    ```

    

### TodoDAO

- 할 일 목록에 대한 저장공간 HashMap을 관리하는 클래스.

- DAO와 Search를 상속한다.

  - ```java
    public class TodoDAO implements DAO, Search
    ```

- **Field**

  - Map: key로 String 타입, value로 TodoVO 타입의 객체를 저장할 수 있는 Map

- **Constructor**

  - Map을 만든다.

- **Overrieding Methods**

  - *insert()*
  - *delete()*: 리스트 넘버(key)를 받아 정보를 지운다.
  - *update()*: 리스트 넘버를 받아 해당 정보의 완료유무를 '완료'로 바꾼다.
  - *select()*: 리스트 넘버로 선택받은 정보를 보여준다.
  - select() all: 저장된 모든 정보를 보여준다.
  - search(): [Search interface] 완료유무를 받아 해당 유무의 리스트를 모두 보여준다.

  

```java
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TodoDAO implements DAO, Search {

	Map<String, TodoVO> map;
	
	// Constructor
	public TodoDAO() {
		map = new HashMap<String, TodoVO>();
	}
	
	@Override
	public void insert(TodoVO d) {
		String key = d.getNum();
		map.put(key, d);
	}

	/**
	 * 유저가 선택한 리스트를 지운다.
	 * -> 실행완료한 목록들을 다 지우는 기능을 구현하고 싶다.
	 */
	@Override
	public void delete(String num) {
		map.remove(num);
	}

	/**
	 * 실행완료 목록을 '완료'로 체크한다.
	 */
	@Override
	public void update(String id) {
		TodoVO t = null;
		t = map.get(id);
		t.setDone(true);
	}
	
	/**
	 * 유저가 선택한 목록을 보여준다.
	 */
	@Override
	public TodoVO select(String id) {
		TodoVO t = null;
		t = map.get(id);
		return t;
	}

	/**
	 * 저장되어 있는 모든 목록을 보여준다.
	 */
	@Override
	public ArrayList<TodoVO> select() {
		Collection<TodoVO> col = map.values();
		Iterator<TodoVO> it = col.iterator();
		
		ArrayList<TodoVO> list = new ArrayList<>();
		while(it.hasNext()) {
			TodoVO cust = it.next();
			list.add(cust);
		}
		return list;
	}

    /**
	 * 유저가 선택한 완료유무에 따른 리스트 목록을 보여준다.
	 */
	@Override
	public ArrayList<TodoVO> search(boolean done) {
		ArrayList<TodoVO> list = new ArrayList<TodoVO>();
		
		Collection<TodoVO> col = map.values();
		Iterator<TodoVO> it = col.iterator();

		while(it.hasNext()) {
			TodoVO cust = it.next();
			if(cust.isDone() == done) {
				list.add(cust);
			}
		}
		return list;
	}
}
```



### Appws

- 유저와 상호작용할 TodoList app.

- TodoDAO와 Interface들을 통해 상호작용할 것.

  - TodoDAO와 Interface 선언

  - ```Java
    TodoDAO toDo = new TodoDAO();		// TodoDAO 객체 만들기
    DAO dao = toDo;						// DAO interface - TodoDAO
    Search search = toDo;				// Search interface - TodoDAO
    ```

  - *다량의 정보들을 처리할 땐 ArrayList를 쓰고 foreach로 유저한테 보여주는 것을 잊지 말자.

  

```java
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		System.out.println("Start...");
		
		TodoDAO toDo = new TodoDAO();
		DAO dao = toDo;
		Search search = toDo;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Input cmd(i,d,u,s,a,f,q): ");		
			String cmd = sc.next();							
			
			if(cmd.equals("q")) {				
				System.out.println("Quit");
				break;
			
			// i: 정보를 넣어서 보낸다.
			}else if(cmd.equals("i")) {
				System.out.println("Write a To-do list.");
				
				System.out.println("Write an order: ");
				String num = sc.next();
				System.out.println("Write when: ");
				String when = sc.next();
				System.out.println("Write what: ");
				String what = sc.next();
				
				// 정보를 담음.
				TodoVO d = new TodoVO(num, when, what);
				// 정보를 보냄.
				dao.insert(d);
			
			// d: 정보를 지운다.
			}else if(cmd.equals("d")) {
				System.out.println("Write the order: ");
				String num = sc.next();
				
				dao.delete(num);
			
			// u: 정보를 업데이트한다. True False
			}else if(cmd.equals("u")) {
				System.out.println("Opt done.");
				System.out.println("Inpute the order: ");
				String num = sc.next();
			
				// 정보를 바꿈.
				dao.update(num);
				
			// s: 정보를 불러낸다.	
			}else if(cmd.equals("s")) {
				System.out.println("Inpute the order: ");
				String num = sc.next();
				
				TodoVO o = dao.select(num);
				System.out.println(o);
				
			// a: DB에 있는 모든 정보를 불러낸다.
			}else if(cmd.equals("a")) {
				ArrayList<TodoVO> a = dao.select();
				
				for (TodoVO d : a) {
					System.out.println(d);
				}
			
			// f: Show ongoing lists or done lists
			}else if(cmd.equals("f")) {
				// search()의 결과물 ArrayList<TodoVo>를 받을 객체를 만든다.
				ArrayList<TodoVO> a = new ArrayList<TodoVO>();
				System.out.println("Done or Ongoing lists(true/false): ");
				String check = sc.next();
				boolean done = Boolean.parseBoolean(check);

				// 정보를 보내서 ArrayList에 담음.
				a = search.search(done);
				
				// ArrayList 안의 정보를 보여줌.
				for (TodoVO o : a) {
					System.out.println(o);
				}
				
			}else {
				// 메뉴 외의 input이 들어왔을 때
				System.out.println("Select a menu.\n");
				continue;
			}
		}
		sc.close();
		System.out.println("End...");
	}
}
```



#### Interface와 저장공간을 사용하여 TodoList를 구현해보았다.

- 부족한 점:
  - delete(): 완료된 모든 리스트를 지우고 싶다.
  - Exception이 발생될 수 있다.
  
- ==>> [Day11](../day11)

  ​																																							[위로](#ws)

----

[맨위로](#개요)
