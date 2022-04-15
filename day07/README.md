# Day 07

- 2022-04-15에 멀티캠퍼스 'AI 플랫폼을 이용한 WEB 서비스 만들기'라는 프로그램에서

  배운 내용을 기록.

- 사용 교재: '이것이 자바다 - 신용권의 Java 프로그래밍 정복 1' 



## 개요

**Chapter 06. 클래스** (p185)

- [6.1 객체지향 프로그래밍](#1.객체지향프로그래밍)
  - [객체 (Object)](#객체(Object))
  - [객체 간의 관계](#객체간의관계)
  - [객체 지향 프로그래밍의 특징](#객체지향프로그래밍의특징)
- [6.14 Getter와 Setter 메소드](#Getter)
- [코드](#코드)
  - [ch06](Package:ch06)
    - [Car.java](#1.Car.java)
    - App.java
    - App2.java
    - [Account.java](#2.Account.java)
    - BankApp.java




## 객체 지향 프로그래밍

#### 1. 객체 지향 프로그래밍 (OOP: Object-Oriented Programming)

- 부품에 해당하는 객체들을 먼저 만들고, 이것들을 하나씩 조립해서 완성된 프로그램을 만드는 기법.

  - 하나하나의 수리와 업그레이드가 쉽다.

  - 현실세계에 있는 것들의 프로그래밍이 쉽다.




- 유래

  - OOAD (Object-Oriented Analysis and Design)

    - UML(Unified Modeling Language): 도식화 방법

  - 1990년대 위의 개념과 방법이 있었지만 실제로 사용할 방법이 없어

    그다지 유명하지 않았다.

  - 1995년 이 개념과 방식을 이용한 OOP언어 Java가 만들어진 후 널리 쓰이고 있다.



- 객체 지향 프로그래밍의 과정
  1. 요구사항 정의
  
  2. OOAD (UML)
  
  3. OOP
  
     

#### 2. 객체 (Object)

- 물리적으로 존재하거나 추상적으로 생각할 수 있는 것 중에서 자신의 속성을 가지고 있고 다른 것과 식별 가능한 것.

  - 물리적 존재

    : 자동차, 자전거, 책, 사람 등

  - 보이지 않는, 실질적 존재

    : 학과, 강의, 주문, 은행계좌 등
    
    
  
- 속성(field) & 동작(method)

  - 사람

    - 속성: 이름, 나이
    - 동작: 웃다, 먹다

  - 자동차

    - 속성: 색상, 모델명

    - 동작: 달린다, 멈춘다

      

- 객체 모델링(Object Modeling)

  : 현실 세계의 객체를 소프트위어 객체로 설계하는 것.

  ​	(= 현실 세계의 객체의 속성과 동작은 파악하여 field와 method로 정의하는 과정)

​	

#### 3. 객체 간의 관계
  - 집합 관계
  - 사용 관계
  - 상속 관계



#### 4. 객체 지향 프로그래밍의 특징
  - Encapsulation (캡슐화)
    - 정보를 캡슐 속에 감춰서 외부에서 함부로 접근해 바꾸지 못 하게 한다.
    - private이 쓰임.

  - Inheritance (상속)
  - Polymorphism (다형성)
  - Abstraction (추상화)



## Getter와 Setter 메소드

- Getter와 Setter
  -  encapsulation된 정보에 접근하기 위해서 쓰인다.



## 코드

### Package: ch06

#### 1. Car.java

<img src="README.assets/Car UML.png" alt="Car.java UML" style="zoom: 130%;" align = "left" />

- ***Car.java*** : 자동차 객체를 생성하기 위한 틀

  - Attribute = field

  - Constructor (생성자)

  - Operation = method/function

    - *toString()*: 객체의 정보를 보여줌

      ```java
      	@Override
      	public String toString() {
      		return "Car [name=" + name + ", color=" + color + ",
                  	size=" + size + ", fsize=" + fsize + ", 
              		cfsize=" + cfsize + "]";
      	}
      
      	// Application에서 toString()의 쓰임새.
      	String result = c1.toString();
      	System.out.println(result);
      
      	// 또는
      	// toString()이 생략되어도 toString()으로 된다.
      	System.out.println(c1);		
      ```

      

- ***App.java***: *Car.java*의 application1

- ***App2.java***: *Car.java*의 application2.

  - 객체 생성 연습

    ```java
    public class App2 {
    	public static void main(String[] args) {
    		// 자동차 객체 생성
    		Car c1 = new Car();
    		System.out.println(c1.toString());
    
    		Car c2 = new Car("K1","red",1000,50,0);
    		System.out.println(c2.toString());
    	}
    }
    ```

  - Memory

    1. *new Car();*

       <img src="README.assets/App2 Memory image1-16500405339544.jpg" alt="App2 Memory Image1" style="zoom:40%;" />

    2. *new Car("K1","red",1000,50,0);*

       <img src="README.assets/App2 Memory image2-16500420860286.jpg" alt="App2 Memory Img2" style="zoom:40%;" />

    3. *Car c2 = new Car("K1","red",1000,50,0);*

       - Car에 할당된 메모리의 주소를 c2에 넣어 저장.

         <img src="README.assets/App2 Memory Image3-16500421134087.jpg" alt="App2 Memory Img3" style="zoom:40%;" />

    4. *System.out.println(c2.toString());*
       - c2의 주소를 기반으로 toString()을 작동해라.



---

#### 2. Account.java



<img src="README.assets/Account UML.png" alt="Account.java UML" style="zoom:130%;" />

- ***Account.java***: Bank account 객체 구현 틀
- ***BankApp.java***: *Account.java*의 application 

