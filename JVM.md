#JVM(Java Virtual Machine)

## JRE(Java Runtime Enviroment)
  - JRE는 크게 자바 API와 JVM으로 구성된다

## JVM
  - 자바 어플리케이션을 어느 CPU나 OS에서도 실행할 수있게 지원하는 역할을 수행한다
  - 자바 코드를 컴파일하여 바이트 코드로 변환, 해당 운영체제가 이해하는 기계어로 실행한다.

### JVM의 구성
  - Class Loader
  - Execution Engine
  - Garbage Collector
  - Runtime Data Area
  - 크게 이 4가지로 나뉘어진다.


### 자바 어플리케이션의 실행과정, 클래스 로더
  1. 어플리케이션이 실행되면 JVM이 OS로부터 메모리를 할당 받음
    - JVM은 할당받은 메모리를 용도에 따라 영역을 구분하여 관리
  2. 자바 컴파일러(javac.exe)가 자바 소스코드(.java)를 읽어 바이트 코드(.class)로 변환
  3. Class Loader를 통해 바이트 코드를 JVM으로 로딩
  4. 로딩된 바이트 코드는 Execution Engine을 통해 해석됨
  5. 해석된 바이트 코드는 Runtime Data Areas에 배치되어 실행됨
    - 실행되는 과정에서 GC 같은 작업이 수행됨

### Execution Engine
  - Runtime Data Area에 할당된 바이트 코드를 실행시키는 주체코드를 실행하는 방식은 크게 2가지
    1. Interpreter : 바이트 코드를 해석하여 실행하는 역할을 수행, 다만 같은 메서도지만 여러번 호출될 때 매번 새로 수행해야 한다.
    2. JIT(Just In Time) Compiler
      - Interpreter의 단점(매번 수행) 해소
      - 반복되는 코드를 발견해 전체 바이트 코드를 컴파일하고 그것을 Native Code로 변경하여 사용
  - Garbage Collector : 더이상 참조되지 않는(즉 안 쓰이는) 객체를 모아 제거하는 역할 수행, 일반적으로 자동으로 실행되지만 수동으로 실행하기 위해 'System.gc()'를 사용할 수 있음(다만, 실행이 보장되지는 않음)
  ※ Native의 의미 : 자바에서 부모가 되는 C언어나 C++, 어셈블리어를 의미

### Garbage Collector
  - 앞으로 안 쓰는 객체의 메모리를 Garbage라고 부르고 이를 정해진 스케쥴에 따라 정리하는 것
  - Stop The World : GC 작동중에는 GC관련 쓰레드 제외 모든 쓰레들를 잠시 멈춤, '튜닝'을 한다고 하는 경우가 있는데 이는 이 GC로 인한 멈춤을 최소화하는 작업을 의미.
  - GC의 작동법 실행 타이밍, 내 앱에 맞는 설정값을 맞추는 코딩이 퍼포먼스 튜닝의 개념이다.

#### Garbage Collector의 종류
  - Serial GC
  - Parallel GC
  - CMS GC
  - G1 GC
  - Z GC

### Class Loader

    <img src="./Images/클래스로더2.PNG " width="700" height="600"></img><br/>

  - JVM으로 바이트 코드(.class)를 로드하고, 링크를 통해 배치하는 작업을 수행하는 모듈
  - 로드된 바이트 코드들을 엮어서 JVM의 메모리 영역인 Runtime Data Areas에 배치함
  - 클래스를 메모리에 올리는 로딩 기능은 한번에 메모리에 올리지 않고, 어플리케이션에서 필요한 경우 동적으로 메모리에 적재하게 됨
  - 클래스 파일의 로딩은 3단계 Loading → Linking → Initialization로 이루어 진다.

### Runtime Data Area
  - 어플리케이션이 동작하기 위해선 OS에서 할당 받은 메모리 공간을 의미
  - 크게 Method Area / Heap Area / Stack Area / PC Register / Native Method Stack

  <img src="./Images/런타임데이터에리3.PNG " width="700" height="600"></img><br/>

#### Method Area
  - static으로 선언된 변수들을 포함하여 Class 레벨의 모든 데이터가 이곳에 저장됨
  - JVM마다 <u>단 하나</u>의 Method Area가 존재(Why? 쓰레드마다 생성되는 영역이 존재하고 이와 구분하기 위해서)
  - Method Area에는 Runtime Constant Pool이라는 별도의 영역이 존재
    - 상수 자료형을 저장하여 참조하는 역할
  - 저장되는 정보의 종류
    - Field Info : 멤버 변수의 이름, 데이터 타입, 접근 제어자의 정보
    - Method Info : 메서드 이름, Return 타입, 매개변수, 접근 제어자의 정보
    - Type Info : Class인지 Interface인지 여부 저장, Type의 속성, 이름, Super Class의 이름
  - Heap과 마찬가지로 GC관리 대상이다.

#### Heap Area

  <img src="./Images/힙에어리어.PNG " width="700" height="600"></img><br/>
  - 객체를 저장하기 위한 메모리 영역
  - new 연산자로 생성되는 모든 Object와 Instance 변수, 그리고 배열을 저장
  - Heap 영역은 물리적으로 두 영역으로 구분할 수 있음(Young Generation, Old Generation)
      - Young Generation : 생명 주기가 짧은 객체를 GC 대상으로 하는 영역, Eden에 할당 후 Survivor 0과 1을 거쳐 오래 사용되는 객체를 Old Generation으로 이동시킴
      - Old Generation : 생명 주기가 긴 객체를 GC대상으로 하는 영역
  - GC 생명주기에 의해 지속적으로 메모리가 정리됨
    - Minor GC
    - Major GC
  - Mathod Area와 Heap Area는 여러 스레드들 간의 공유되는 메모, 둘다 한개 밖에 없기에 멀티 쓰레드를 지원한다는 의미


#### Stack Area
  <img src="./Images/스택에리아.PNG " width="700" height="600"></img><br/>
  - 각 스레드를 위한 분리된 Runtime Stack 영역
  - 메소드를 호출할 때 마다 Stack Frame으로 불리는 Entry가 Stack Area에 생성됨
  - 스레드의 역할이 종료되면 바로 소멸되는 특성의 데이터를 저장
  - 각종 형태의 변수나 임시 데이터, 스레드 또는 메소드의 정보 저장


#### PC Register
<img src="./Images/피씨레지스터.PNG " width="700" height="600"></img><br/>
  - PC란 Program Counter의 준말
  - 각 쓰레드가 시작될 때 생성되고, 현재 실행중인 상태 정보를 저장하는 영역
  - 쓰레드가 로직을 처리하면서 지속적으로 갱신됨
  - 쓰레드가 생성될 때마다 하나씩 존재함
  - 어떤 명령을 실행해야 할지에 대한 기록(현재 수행 중인 부분의 주소를 가짐 )


#### Native Method Stack
<img src="./Images/네이티브메서드스택.PNG " width="700" height="400"></img><br/>
  - 바이트 코드가 아닌 실제 실행할 수 있는 기계어로 작성된 프로그램을 실행시키는 영역
  - 또한 자바가 아닌 다른 언어로 작성된 코드를 위한 영역
  - Java Native Interface를 통해 바이트 코드로 전환하여 저장
  - 각 스레드 별로 생성됨

#### Java Native Interface
  - 자바가 타 언어와 상호작용하기 위한 인터페이스 제공
  - JVM이 Native Method를 적재하고 수행하도록 함
  - 사실상 C, C++만 지원함












### StackOverFlowError
  - 스택에 다음 메서드 호출을 위해 새 스택 프레임을 추가 할 공간이 더 이상 없을 때 스레드에서 발생하는 예외. JVM-Xss 옵션을 사용해 JVM 스택 크기를 늘려 이를 방지할 수 있다.


### OutOfMemoryError  
  - 실행 중인 쓰레드가 너무 많아 JVM Stack을 할당하기 위해 예약된 메모리 영역도 가득차 발생할 수 있다. StackOverFlowError와 다리 다른 방지 옵션이 JVM에 존재하지 않는다.











-------------------------------------------------------------------

- 자바 가상머신으로 클래스 로더를 통해 자바 클래스를 메모리로 로드하여 자바 API를 이용하여 실행한다.
- JVM은 스택 기반으로 운영되는데 자바 쓰레드가 생성되면 그 쓰레드를 위한 JVM스택을 생성하고 이를 Run-Time 스택(혹은 쓰레드 스택)이라고 한다.
- 어떤 클래스의 main메서드가 실행되기 위해 해당 클래스가 메모리에 올라온다.
- 이때 main쓰레드용 JVM 스택, 즉 쓰레드 스택이 만들어진다.
- 쓰레드 하나 당 하나의 스택이 생성되게 된다.
- 메인 메서드가 실행되기 전에 이 스택에 main용 스택 프레임이 push되어 올라간다
- 이후 A(), B() 메서드가 하나씩 메인 스택위에 순서대로 쌓이고 끝날 때 하나씩 사라진다.
- 결국 마지막에 main 쓰레드도 종료되기 직전에 JVM 스택도 해제된다.
- JVM 스택에 저장된 데이터는 해당 스레드에서 사용할 수 있으며 나머지 스레드에서는 사용할 수 없다. 이것이 메소드 안에 선언된 로컬 데이터가 스레드로부터 안전하다고 말할 수 있는 이유이다.
- 객체는 사용자의 new 연산자에 의해 메모리 힙에 객체가 생성되고 JVM의 GC에 의해 자동으로 힙 메모리에서 삭제된다.
