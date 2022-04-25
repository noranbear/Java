

# Multi-thread Practiceand Connecting Java to DB

- DAY13 - 2022-04-26
  - [Multi-thread 개념](../)
  - Java Application와 Database의 연결
  - CURD 프로그램 구축



## 개요

1. **Multi-thread**
   
   - package: [p576](#MainApp)
     - [MainApp]((#MainApp)) : 싱글 스레드
     - [MyThread1](#MyThread1): 스레드 생성 (Thread 클래스)
     - [MyThread2](#MyThread2): 스레드 생성 (Runnable 인터페이스)
     - [MainThread](#MainThread): 멀티 스레드 
     - [MainThread2](#MainThread2): Anonymous 클래스를 이용한 스레드 생성
   
2. **Linking Java Application to DB**
   
   - package: [cust](#cust)
     - [InsertCust](#InsertCust): JDBC CURD: Creat
     
     - UpdateCust: InsertCust와 JDBC 부분이 같고 sql문만 달라진다.
     
     - DeleteCust: InsertCust와 JDBC 부분이 같고 sql문만 달라진다.
     
       

## Package: p576

- Thread practice



### MainApp

- 프로그램 안에 main이라는 프로세스를 실행한다.
- **의도**: ''프로세스''를 보여준다.
- **결과**: 1초의 간격을 두고 0에서 300까지 찍힌다.
- **Method**
  - *Thread.sleep(Time in milieSec)*
    - Thread라는 클래스의 sleep 메소드
    - 실행되는 스레드의 실행에 시간차를 설정한다. 

```java
public class MainApp {

	public static void main(String[] args) {
		System.out.println("Start");
        // 1. 0에서 300까지 화면에 띄워라.
		int i = 0;
		while(i <= 300) {
			System.out.println(i);
			i++;
			
			try {
				Thread.sleep(1000);			 // 스레드가 실행될 때, 
                							 // 1초 후에 실행하라. (1초 동안 쉬어라)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("End");
	}

}
```



### MyThread1

- While loop가 돌아갈 첫 번째 스레드를 만든다. 이 스레드는 이후 MainThread app에서 쓰인다.
- **의도**: Thread class를 사용하여 멀티 스레드 안에서 돌아갈 첫번째 스레드를 만든다.
- Thread class를 상속한다; ```extends Thread```
  - *run()*을 Override한다.
- **Method**
  - *run()*:  콘솔에 0에서 100까지 1초의 차이를 두고 하나 씩 차례대로 찍힌다.

```java
public class MyThread1 extends Thread {

	@Override
	public void run() {
        // 1. 0에서 100을 콘솔에 띄운다.
		int i = 0;
		while(i <=100) {
			i++;
			// 음악파일을 하나 받는 것같은
			System.out.println("MyThread1 "+ i);
			try {
				Thread.sleep(1000);			// 속도제어: 1초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
	}
}
```



### MyThread2

- While loop가 돌아갈 두번째 스레드를 만든다. 이 스레드는 이후 MainThread app에서 쓰인다.
- **의도**: Runnable Interface를 사용하여 멀티 스레드 안에서 돌아갈 두번째 스레드를 만든다.
- Runnable Interface를 상속한다; ```implements Runnable```
  - *run()*을 Override한다.
- **Method**
  - *run()*:  콘솔에 0에서 100까지 1초의 차이를 두고 하나 씩 차례대로 찍힌다.

```java
public class MyThread2 implements Runnable{

	@Override
	public void run() {
		int i = 0;
		while(i <=100) {
			i++;
			// 음악파일을 하나 받는 것같은
			System.out.println("MyThread2 "+ i);
			try {
				Thread.sleep(1500);			// 속도제어: 1.5초
                							// 네트워크가 좀 더 느린 경우를 정의
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
	}
}
```



### MainThread

- MyThread1와 MyThread2를 메인 스레드 안에서 실행시켜 멀티 스레드를 구현한다.

- **의도**: 멀티 스레드를 보여준다.

- **Method**

  - *start()*:  해당 스레드를 시작한다.

- **결과**: 메인 스레드가 실행되면서 "Start"와 "End"가 찍히고 MyThread1과 MyThread2가 

  ​			같이 돌아간다. MyThread2가 좀더 느리므로 숫자가 비교적 느리게 찍히는 것을 

  ​			확인할 수 있다.

  - **보통의 프로그램은 처음부터 끝까지 차례대로 실행되는 반면,

    스레드는 처음부터 끝까지 한 번에 실행된다.
  
  - 그렇기 때문에 "End"가 위에 찍혔다고 메인 스레드가 끝난 것이 아니다.

```java
public class MainThread {

	public static void main(String[] args) {
		// 메인스레드
		System.out.println("Start...................................");
		MyThread1 t1 = new MyThread1();		// 클래스 Thread 상속
		// 첫번째 파일 다운로드
		t1.start();
		
		// 두번째 파일 다운로드
		MyThread2 t2 = new MyThread2();		//인터페이스 Runnable 상속
		Thread tt2 = new Thread(t2);
		tt2.start();
		
		// 스레드는 다 실행되고 end가 찍히지만 
        // 메인스레드는 그 안에 있는 스레드가 끝나기 전까지는 끝나지 않는다.
		System.out.println("End...................................");
	}
}
```



### MainThread2

- 메인 스레드 안에 서로 다른 방법을 사용하여 스레드 3개를 만든다.
- **의도**: Anonymous class를 이용한 다양한 스레드 생성 방법을 알아본다.

- **스레드 생성 방법1**: Thread 객체 생성시, argument에 Runnable 인터페이스의 *run()*을 

  즉석으로 정의한다.

```java
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int i = 0;
				while(i <=100) {
					i++;
					// 음악파일을 하나 받는 것같은
					System.out.println("MyThread1 "+ i);
					try {
						Thread.sleep(1000);			// 속도제어: 1초
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}
		});

		t1.start();									// 스레드 실행
		
```



- **스레드 생성 방법2** - 인터페이스 생성 방식
  - Runnable 인터페이스를 즉석 정의 후 Thread 객체를 만들어서 실행.

```java
		
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				int i = 0;
				while(i <=100) {
					i++;
					// 음악파일을 하나 받는 것같은
					System.out.println("MyThread3 "+ i);
					try {
						Thread.sleep(500);			// 속도제어: 0.5초
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}
		};
		// Thread 객체 생성
		// Thread3
		Thread t3 = new Thread(r1);
		t3.start();
		
		
		System.out.println("End...................");

```



- 자바의 기본 개념 강의는 여기로 끝.

​																																									[위로](#MainApp)

---

## Package: cust

- Linking Java Application to DB
- JDBC(Java Database Connectivity) Program을 만든다.
- CRUD 프로그래밍



### InsertCust

- Database에 연결하고 CRUD: Create(INSERT)를 구축해 연결된 MySQL shopdb schema에

  데이터를 넣는다.

  1. 변수선언
     - Connection
     - PreparedStatement
     - String sql : sql문
  2. MySQL JDBC Driver Loading
     - Class.forName("Driver"); 	- DBMS 마다 다른 드라이버 장착
  3. MySQL connect
     - url, id, pw 만들기
     - con = DriverManager.getConnection(url,Id,pw);     - 접속시도
  4. SQL을 이용한 요청
     - ps = con.prepareStatement(sql);		- sql과 ps를 연결
     - setString(key, value); 를 사용해 sql문에 데이터 넣기
     - ps.executeUpdate();         - 데이터 보내기
  5. *MySQL close : 안 하면 DB 과부화로 터짐
     - Try and Catch 구문 마지막의 finally: Exception이 발생되든 안되는 무조건적으로 실행됨.
     - connection과 PreparedStatement가 null이 아닐 경우, 꼭 close() 해주자.

```java
// API Library: java.sql 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertCust {

	public static void main(String[] args) {
		
		// 1. 변수선언
        // DB와 접속, 어느 DB와 접속할지는 아직 모른다
		Connection con = null;				
		PreparedStatement ps = null;
        // SQL문장이 들어감
        // DBMS에서와 달리 ;을 찍지 않음
        // 물음표안에 데이터를 넣으면 자동으로 전송
		String sql = "INSERT INTO CUST VALUES (?,?,?)";		
													
		// 2. MySQL JDBC Driver Loading
		try {
            // mySQL에 접속하겠다. (드라이버 교체만 하면 해당 DB접속가능-유연)
			Class.forName("com.mysql.cj.jdbc.Driver");	
			System.out.println("MySQL JDBC Driver Loading...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		
		// 3. MySQL Connect
		String url = "jdbc:mysql://192.168.25.45:3306/shopdb?	serverTimezone=Asia/Seoul";			
		// protocol//IPv4주소:portNum/Schema정보?serverTimezone - root로 접속 불가
		// 내컴퓨터 127.0.0.1 - root로도 접속가능  	
        
        // 보안상의 문제로 root로 접속할 수가 없어 root와 같은 권리를 가진 
        // admin1을 만들어서 접속.
		String mId = "admin1";				
		String mPwd = "111111";
		try {
            // 접속을 시도한다. 
			con = DriverManager.getConnection(url,mId,mPwd);		
			System.out.println("MySQL Server Connected...");
		} catch (SQLException e) {									
		  	// -> 서버가 죽어있거나 컴터가 꺼져있거나 네트워크 연결 문제 등등
			e.printStackTrace();
		}
		
		// 4. SQL을 이용한 요청
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "id05");	//sql문의 ?에 값넣기
			ps.setString(2,	"pwd05");
			ps.setString(3,	"이말숙");
			// 요청 결과를 확인
			int result = ps.executeUpdate();	// 정보 보내기
            // result = 1 => 한 건이 result 됐다
			System.out.println(result);			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		// 5. MySQL Close	
		}finally {		// 문제가 생겨도 안생겨도 무조건 실행됨
			// Close 반드시!!!!!
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}	
	}

}
```

​																																								[위로](#InsertCust)



[맨위로](#개요)

-----------

