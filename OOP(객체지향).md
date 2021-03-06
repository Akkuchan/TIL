## 추상화
  - 객체들이 가진 공통적인 속성과 기능을 추출하여 정의하는 것.
  - 추상화 기존 클래스들의 공통적인 요소를 ㅃ뽑아서 상위 클래스를 만들어 내는 것.

### 추상화의 장점
  - 공통 속성 및 기능을 하나로 묶어 코드의 중복을 줄일 수 있다.

### 추상 제어자 abstract
  - 메서드에 abstract 제어자를 붙여 추상 메서드를 만들 수 있다.
  - 추상 메서드는 이것이 포함된 클래스를 상속받는 자식 클래스가 추상 메서드를 구현하기 위함이다.
  - 추상 메서드는 선언부만 존재하고 구현부는 작성되어 있지 않다.
  - 문법 : abstract 반환타입 메소드 이름;

  ※ 예제 코드
  ```java
  abstract void abstractmethod();
  ```

### 추상 클래스
    - 하나 이상의 추상 메서드를 포함하는 클래스를 가리켜 추상 클래스라고 한다.
    - 주로 OOP의 다형성을 이용해 하위 객체들이 공통 기능(메서드)을 구현하도록 만드는데 의미가 있다.
    - 즉 반드시 사용해야하는 메서드를 추상 클래스로 선언, 이를 상속받는 모든 클래스에서 재정의(오버라이딩)하도록 강제한 것
    - 추상 클래스를 상속받는 하위 클래스는 추상 메서드 오버라이딩 이후에 인스턴스화가 가능하다
    - 문법 : abstract class 클래스이름 {  ...
    abstract 반환타입 메소드이름();
    ...
      }

    ※ 예제 코드
    ```java
abstract class Animal { abstract void cry(); }
class Cat extends Animal { void cry() { System.out.println("냐옹냐옹!"); } }
class Dog extends Animal { void cry() { System.out.println("멍멍!"); } }

public class Polymorphism02 {
    public static void main(String[] args) {
        // Animal a = new Animal(); // 추상 클래스는 인스턴스를 생성할 수 없음.
        Cat c = new Cat();
        Dog d = new Dog();
        c.cry();
        d.cry();
    }
}
```

## 인터페이스
  - 여러 추상 클래스를 상속할 경우(다중상속) 내부 메서드들간의 충돌(특히 추상 메서드명 충돌)로 인한 위험 有
  - 추상 클래스 다중 상속의 문제점을 보완한 상속 기법
  - 인터페이스는 추상메서드와 달리 생성자, 필드, 일반 메서드가 존재할 수 없다.( 더 높은 수준의 추상화)
  - 오직 추상메서드와 상수만을 포함 때문에 충돌 위험이 적다
  - → 다른 클래스를 작성할 때 기본이 되는 틀을 제공하고 클래스들 간의 중간 매개 역할까지 담당하는 추상 클래스의 역할을 수행

### 인터페이스 선언
  - 클래스를 선언하는 방법과 동일, 단 상수와 추상 메서드만 선언한다.
  - 또한 모든 필드는 public static final, 메서드는 public abstract로 선언되어야 한다.(공통적용이기에 생략이 가능)
  - 문법 : 접근제어자 interface 인터페이스이름 {
    public static final 타입 상수이름 = 값;
    ...
    public abstract 메소드이름(매개변수목록);
    ...
}
  -

### 인터페이스 구현
  - 문법 : class 클래스이름 implements 인터페이스이름 { ... }

### 인터페이스 and 클래스 상속 동시 구현
  - 인터페이스를 상속할 때는 implements를 이용하기 때문에 인터페이스들의 다중 상속 과 클래스와 인터페이스의 다중상속 모두 가능하다.(단 클래스는 한가지만 상속가능)
  - 인터페이스는 인터페이스끼리만 상속이 가능하다.
  ※ 예제 코드
  ``` java
  interface Animal { public abstract void cry(); }
    interface Pet { public abstract void play(); }

  class Cat implements Animal, Pet {
        public void cry() {
            System.out.println("냐옹냐옹!");
        }
        public void play() {
            System.out.println("쥐 잡기 놀이하자~!");
        }
    }
  ```

###  인터페이스의 장점
  1. 대규모 프로젝트 개발 시 일관되고 정형화된 개발을 위한 표준화가 가능합니다.
    - 모든 클래스가 동일한 메서드를 가지고 있기에 가능(표준화)
  2. 클래스의 작성과 인터페이스의 구현을 동시에 진행할 수 있으므로, 개발 시간을 단축할 수 있습니다.
    - 피상속 클래스를 작성하며 코드의 중복을 줄일 수 있다는 의미
  3. 클래스와 클래스 간의 관계를 인터페이스로 연결하면, 클래스마다 독립적인 프로그래밍이 가능합니다.
    - 인터페이스가 클래스간의 연결 요인이 되어 하나의 큰 클래스를 구현할 필요가 없다.
