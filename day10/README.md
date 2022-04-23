# DAY10

- **2022-04-20 수업 내용**

  - DB의 데이터 처리 애플리케이션

  - [Interface](#Interface)

  - [ArrayList](#ArrayList)

  - [HashMap](#HashMap)

  - WS: [TodoList ver.1](./src)

    - 다중 interface를 활용한 정보 처리 프로그램으로 TodoList를 만듦.
  
    
## Package

0. [README.md](./src)
1. [p344](./src/p344): 데이터 처리의 원리
   - ArrayList
2. [p345](./src/p345): Interface 사용
3. [p346](./src/p346): HashMap을 사용하여 저장공간 구현
   - HashMap
4. [ws](./src/ws): TodoList를 만들면서 개념 활용



## TB

- 이것이 자바다 - 신용권의 Java 프로그래밍 정복1
  - 8장. 인터페이스 (Interface) - p344




---

## Interface

- UML
- 인터페이스의 역할
- 인터페이스의 구현
- 인터페이스의 사용
- 타입변환과 다형성

---



### UML

- 'User'라는 단어는 클래스 네임으론 지양하자 - 예약어이다.

- 관계

  - 점선 - DirectedAssociation (Loose Coupling)

  - 실선 - Dependency (Tight coupling) 

  - 클래스  상속 - Generalinze

  - 인터페이스 상속 - Realization

    

<img src="README.assets/Interface UML (p345).png" alt="Interface UML Example Image" style="zoom:120%;" />

​																															*VO: Value Obj.

​																															*DAO: Data Access Obj.

### 인터페이스

- 기능만이 정의 되어 있는 껍데기.

  - 객체에 필요한 기능만 정의되어 있다.

  - 그 기능의 내용은 개발코드에 쓰여 있다.

    

### 인터페이스의 역할

- **객체**(APP)**와 개발 코드**(oracleDAO)**가 서로 연동하는 접점**

- App과 DAO는 둘 다 인터페이스에 맞게 설계된다 

  -> app과 dao는 만난적도 없지만 같은 규격을 보면 설계되었기 때문에 

  ​	서로 퍼즐처럼 맞아 떨어진다.

  

- 인터페이스가 있으면 시스템이 바뀌어도 객체나 개발코드 한 부분만 바꿀 수 있기 때문에

  잘 만들어놓으면 시스템이 상당히 유연해진다 

  - Oracle에서 Mariadb로 바뀔 때, DAO만 바꿔주면 된다.

- 전체적으로 시스템이 엮여 있을 때는 모든 것을 다 바꿔야하기 때문에 

  interface는 거의 필요불가결의 것이다.

  

### 인터페이스의 구현

- 선언

  - **상수** - 많이 들어가진 않음
    
    - ```public static final``` (일반 변수 사용 x) - 값을 저장하는 '필드'가 아님.
    
  - ***Abstract Method (추상 메소드) **- 주로  
    
    - 개발 정의 (```abstract``` keyword 생략)
    
  - **Default Method (디폴트 메소드)** - 주로 
    
    - 자바8에 새롭게 추가된 기능. (원래는 안됐지만- 인터페이스는 기능만 있어야 했어서)
    - ```default``` keyword 사용 - access modifier 아님
    
  - 정적 메소드(Static) - skip

    

- 사용 

  - 개발코드 클래스를 만들어서 인터페이스를 상속받고 추상메소드들을 재정의한다. 

    (in OracleDAO)

  - 실제 클래스에서 implements 인터페이스명을 씀

    - ```OracleDAO implements DAO```

  - 인터페이스에서 쓰여진 추상메소드 헤더를 정확히 따라서 작성
  
    

### 타입변환과 다형성 (Polymorphism)

- 다형성이라는 것이 자연스럽게 표현되고 있다.

- OracleDAO와 MariadbDAO처럼 바꿔 끼어넣어서 Interface의 함수를 Override하면 됨.

- **다중 Interface**: 자바 상속은 하나 밖에 안 되지만 인터페이스는 기능을 정의한 것이기 때문에 

  여러가지 인터페이스 상속가능 



### [**Interface Practice**](./day10/src/README.md)



​																																						[위로](#UML)

## ArrayList

- Collection API(Application Programming Interface)에 속한 클래스

- Array를 대체한다.

- Array와 달리 **사이즈를 자동으로 조절**해준다.

  

### ArrayList의 사용

  - ArrayList의 선언

    ```java
    ArrayList<Type> listName = new ArrayList<Type>();
    ```

    - 뒷부분의 type을 <> 이렇게 빈칸으로 나둬도 된다.

  - Import

    ```java
    import java.util.ArrayList;
    ```

  - Values 넣기

    - *add(Type e)*: 객체만 들어감 (String, Integer, etc.)

      ```java
      listName.add(valueOfType);
      ```

      - *add(new Type(value))*
      - *add(value)*

  - Value 보기

    - for loop를 사용하여 보여준다. 그 중에서도 **foreach**가 많이 쓰인다.

      ```java
      for(Type listValueName : ListName){
          System.out.println(listValueName);
      }
      ```



#### Test

```java
import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args) {
		// 예전 방식 = 배열 : 사이즈를 항상 지정해야 하는 문제
//		CustomerVO cs[] = new CustomerVO[5];
		
		// ArrayList: 사이즈 자동 조절
		ArrayList<CustomerVO> list = new ArrayList<CustomerVO>();
		list.add(new CustomerVO("id01","pwd01","james"));
		list.add(new CustomerVO("id02","pwd02","kang"));
		list.add(new CustomerVO("id03","pwd03","kim"));
		
		// 화면에 보여주기 foreach
		for (CustomerVO cus : list) {
			System.out.println(cus);
		}
	}
}

```

​																																	Java API doc: [ArrayList](https://docs.oracle.com/javase/8/docs/api/index.html)

​																																									[위로](#ArrayList)

---

## HashMap

### Map 

- **Key**와 **Value**로 정보를 저장한다. 

  - ArrayList - value, value, value, value ...

  - Map - (key, value), (key, value), (key, value) ...

    

### Key와 Value

  - Type으로는 **객체**만이 들어간다.

  - key는 value마다 고유해야 한다.

    - HashMap에 넣은 순간, key는 수정이 불가하다.

      

### HashMap의 선언

  ```Java
  HashMap<KeyType, ValueType> map = new HashMap<KeyType, ValueType>();
  ```

  

### Methods

  - *put(key, value)*: Map에 value를 집어넣는다.

  - delete(key): Map에서 key의 value를 삭제한다.

  - get(key): Map에서 key로 value를 가져온다

  - values(): Map안에 있는 정보를 Collection으로 리턴한다.

    

### Map에 있는 모든 정보를 꺼내는 방법

  1. ArrayList를 생성한다.
  2. While loop를 사용해서 map에 있는 모든 values를 list에 담는다.
  3. foreach로 list를 보여준다.

  ```java
  Collection<CustomerVO> col = map.values();
  Iterator<CustomerVO> it = col.iterator();
  		
  ArrayList<CustomerVO> list = new ArrayList<>();
  while(it.hasNext()) {
  	CustomerVO cust = it.next();
  	list.add(cust);
  }
  		
  for (CustomerVO cu : list) {
  	System.out.println(cu);
  }
  ```



- 참고: [Test.java](./src/p346/Test.java)


​																																	Java API Doc: [HashMap](https://docs.oracle.com/javase/8/docs/api/index.html)

​																																									[위로](#HashMap)

---

[맨위로](#Package)