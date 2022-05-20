# 스트림
- 스트림은 반복자 : 컬렉션(배열 포함)의 요소를 하나씩 참조해서 람다식으로 처리할 수 있는 반복자
- 스트림 이전에는 iterator를 생성하고 반복문을 사용하였다.
- 스트림을 통해 이전 보다 간결하게 반복을 할 수 있게 되었다.

## 스트림의 특징
- 람다식으로 요소 처리 코드를 제공한다.
  - 스트림이 제공하는 대부분의 요소 처리 메소드는 함수적 인터페이스 매개타입을 가진다.
  - 매개값으로 람다식 또는 메소드 참조를 대입할 수 있다.

 ※ 예시 코드
  ```java
  List<Student> list = Arrays.adList(
            new Student("홍길동", 90),
            new Student("김철수", 80),
            );
  stream.forEach(s->{
    String name = s.getName();
    int score = s.getScore();
  })
  ```

- 내부 반복자를 사용하므로 병렬처리가 쉽다.
  - 외부 반복자(iterator): 개발자가 코드로 직접 컬렉션 요소를 반복해 요청하고 가져오는 코드(.next())
  - 내부 반복자(Stream): 컬렉션 내부에서 요소들을 반복시키고 개발자는 요소당 처리해야할 코드만 제공하는 코드 패텅
    - 요소 처리 코드에만 집중하면 된다.
    - 멀티 코어 CPU를 최대한 활용하기 위해 요소들을 분배시켜 병렬 처리 작업을 할 수 있다.
    - 병렬처리: 한가지 작업을 n개의 서브 작업으로 나눌 수 있으며 이들을 분리도니 스레드에서 병렬적으로 처리 한 후 서브 작업의 결과물을 결합하는 방식


        <img src="./외부_내부_반복자.png" width="450px" height="300px" title="외부_내부_반복자" alt="repeator"></img><br/>


  ※ 예시 코드
  ```java
  List<Student> list = Arrays.adList(
            "가나다","라마바","사아자","차카타", "파하거"
            );

            //순차처리
            list.stream()
              .forEach(ParallelExample :: print);

            //병렬처리
            list.parallerlStream()
              .parallelStream
              .forEach(ParallelExample :: print);   


```

  - 스트림은 중간 처리와 최종 처리를 할 수 있다.
    - 중간처리: 요소들의 매핑, 필터링, 정렬
      Data(JCK)- 미가공 데이터
      |
      중간처리(map,sort, filttering..)- 데이터 가공
      |
      최종처리(aggregation 집계)- Reduction 수행
  - 최종처리: 반복문, 카운트, 평균, 총합  
  <img src="./중간최종연산.png" width="800px" height="400px" title="외부_내부_반복자" alt="repeator"></img><br/>






## 스트림의 종류
      <img src="./스트림 종류.jpg" width="800px" height="400px" title="스트림 종류" alt="stream type"></img><br/>






## 집계(Aggregate)
- 최정 처리 기능
    - 카운팅, 합계, 평균값, 최대값, 최소값 등 하나의 최종값을 산출한다
    - 대량의 데이터를 가공하여 축소하는 리덕션이라고 할 수 있다.

## 스트림이 제공하는 기본 집계함수
| 반환타입 | 메서드 | 설명 |
|---|:---:|---:|
| `long` | count() | 요소 개수 |
| `OptionalXXX` | findFirst() | 첫번째 요소 |
| `OptionalXXX`, `Optional<T>` | max(Comparator<T>), max() | 최대 요소 |
| `OptionalXXX`, `Optional<T>` | min(Comparator<T>), min() | 최소 요소 |
| `OptionalDouble` | average()| 요소 평균 |
| `int, long, double` | sum()| 요소 총합 |

## OptionalXXX 클래스
  - 자바 8부터 추가된 값을 저장하는 값 기반 클래스
  - java.util 패키지의 Optional, OptionalDouble, OptionalInt, OptionalLong 클래스를 의미
  - 저장된 값을 얻으려면 get(), getAsDouble(), getAsInt(), getAsLong()를 호출한다.

※ 예시 코드

```java
    public static void main(String[] args{
      long count = Arrays.stream(new int[] {1,2,3,4,5})
        .filter(n->n%2==0)
        .count();
        System.out.println("2의 배수 개수: " + count)

      long sum = Arrays.stream(new int[] {1,2,3,4,5})
        .filter(n->n%2==0)
        .sum();
        System.out.println("2의 배수 합: " + count)

      int max = Arrays.stream(new int[] {1,2,3,4,5})
        .filter(n->n%2==0)
        .max()// max의 반환 타입은 OptionalInt이기에 최종 매서드(getAsInt)를 입력해준다.
        .getAsInt();
        System.out.println("2의 배수 최대값: " + max)

      int min = Arrays.stream(new int[] {1,2,3,4,5})
        .filter(n->n%2==0)
        .mix()//
        .getAsInt();
        System.out.println("2의 배수 최소값: " + mix)

      int first = Arrays.stream(new int[] {1,2,3,4,5})
        .filter(n->n%3==0)
        .findFirst()
        .getAsInt();
        System.out.println("3의 배수 최초값: " + mix)  
      })
  ```

## Optional 클래스
  - 값을 저장하는 값 기반 클래스
      - Optional, OptionalDouble, OptioanlInt, OptionalLong
      - 집계 메소드의 리턴 타입으로 사용되어 집계 값을 가지고 있음
  - 특징
      - 집계 값이 존재하지 않을 경우 디폴트 값을 설정할 수도 있다.
      - 집계 값을 처리하는 Comsumer를 등록할 수 있다.


      | 반환타입 | 메서드 | 설명 |
      |---|:---:|---:|
      | `boolean` | isPresent | 값이 저장되어 있는지 여부 |
      | `T` | orElse() | 값이 저장되어 있지 않을 경우 디폴트 값(T, double 등등)을 반환 |
      | `double` | orElse(double) |  |
      | `int` | orElse(int) |  |
      | `long` | orElse(long)|  |
      | `void` | ifPresent(Consumer)| 집계 값이 있을 경우 이를 Consumer에서 처리(람다식이나 메서드  처리) |
      |  | ifPresent(DoubleConsumer)|  |
      |  | ifPresent(IntConsumer)|  |
      |  | ifPresent(LongConsumer)|  |

    ```java
    import java.util.ArrayList;
    import java.util.List;

    public class OptionalExample {


    public static void main(String[] args{
      List<Integer> list = new ArrayList<>();

      double avg = list.stream(})
        .mapToInt(Integer :: intValue)// list가 가진 Integer타입의 요소에서 intvalue를 통해 int값을 갖는 스트림을 만들겠다
        .average()
        .getAsDouble();
      // 위 코드 실행시 NotSuchElementException 발생, 현재 스트림에는 아무런 값이 없기에 바로 값을 구할 수 없다(매서드 정의단계가 아닌 main 메서드에서 실제 실행하는 단계기 때문)

      OptionalDouble optional = list.stream(})// average()를 통해 반환된 OptionalDoubl를 직접 받는다
        .mapToInt(Integer :: intValue)// list가 가진 Integer타입의 요소에서 intvalue를 통해 int값을 갖는 스트림을 만들겠다
        .average();
          if(optional.isPresent()){//NoSuchElementException를 방지하기 위해 요소가 없을 경우 따로 처리
            System.out.println("방법1의 평균: " + optional.getAsDouble());
          }
          else{System.out.println("0.0");
          }
        //--------------------------------------------------------------------------
      double avg = list.stream()     
        .mapToInt(Integer :: intValue)
        .average()
        .orElse(0.0);

        System.out.println("방법2의 평균: " + avg);

        //--------------------------------------------------------------------------

      double avg = list.stream()     
        .mapToInt(Integer :: intValue)
        .average()
        .ifPresent(a -> System.out.println("방법3의 평균: " + avg));
        // a는 average()로 계산한 평균(value)을 의미, 즉 a가 존재하면 ()안의 람다식(Consumer)싱행

        System.out.println("방법3의 평균: " + avg);
    }
    ```  


  reduce() 메서드
  - 프로그램화해서 다양한 집계(리덕션) 결과물을 만들 수 있다.
  - 즉 특정한 값을 집계하는데 사용함.

  | 적용 인터페이스 | 리턴타입 | 메서드(매개변수) |
  |---|:---:|---:|
  | `Stream` | Optional<T> | reduce(BinaryOperator<T> accumulator) | 요소가 없다면 NoSuchElementException 발생한
  |  | T | reduce( T identity, BinaryOperator<T> accumulator) | 요소가 없다면 디폴트값인 T identity가 반환될 것
  | `IntStream` | OptionalInt | reduce(IntBinaryOperator<T> op)  |  同 |
  | `` | int | reduce(int Identity, IntBinaryOperator<T> op) | 同 |
  | `LongStream` | reduce(LongBinaryOperator<T> op) | 同 |
  | | long | reduce(long identity, LongBinaryOperator<T> op) | 同
  | `DoubleSteam` | OptionalDouble | reduce(DoubleBinaryOperator<T> op) |同
  |  | double | reduce(double identity, DoubleBinaryOperator<T> op) | 同

  매개변수
    - XXXBinaryOperator: 두 개의 매개값을 받아 연산 후 리턴하는 함수적 인터페이스
    - identity: 스트림에 요소가 전혀 없을 경우 리턴될 디폴트 값

  예제 코드: 학생들의 성적 총점
  ```java
  int sum = studentList.stream();
    .map(student :: getScore)
    .reduce((a, b) -> a+b)
    .get();
    // NoSuchElementException 발생 우려 존재(get()실행)
//--------------------------------
```java
  int sum = studentList.stream();
    .map(student :: getScore)
    .reduce(0, (a, b) -> a+b);
    // 디폴트 값으로 0을 넣어줌,NoSuchElementException 방지

  ```

## 수집 collect()
  - 최종 처리 기능으로 요소들을 수집 또는 그룹핑한다.  
    - 필터링 또는 매핑된 요소들로 구성된 새로운 컬렉션을 생성한다.

    - 요소들을 그룹핑하고 집계(리덕션)을 할 수 있다.

  ※ 필터링한 요소 수집
  | 리턴타입 | 메소드(매개변수) | 인터페이스 |
  |---|:---:|---:|
  | `R` | collect(Collector<T,A,R> collector) | Stream |
    collect()를 통해 요소를 어떤 컬렉션(List, Set, Map 등)에 저장할 것인지를 결정함

    - Collector의 타입 파라미터의 역
      - T : 수집할 요소
      - A : 누적기(accumulator)- T라는 요소를 Collection에 수집하는 기능 수행,
        ※ ?인 이유는 컬렉션 프레임(L,S,M)의 경우 각자 주어진 요소를 저장하는 소스코드가 내장해 있기에 구체적으로 명시하지 않는다는 의미.
      - R : 요소가 저장될 새로운 컬렉션- T 요소가 수집될 장소, 저장
      - 즉 T요소를 A누적기가 R에 저장

    - Collector의 구현 객체
      - Collectors 클래스의 정적 메소드를 이용
      정적 메소드 모음(collect()에 들어갈 매개변수(parmeter) 정리)
      | 리턴타입 | 메소드(매개변수) | 인터페이스 |
      |---|:---:|---:|
      | `Collector<T,?,Collection<T>>` | Collectors.toCollection(Supplier <T>) | Supplier가 제공하는 컬렉션에 요소를 수집하는 컬렉터를 반환한다. |
      | `Collector<T,?,ConcurrentMap<K,U>>` | Collectors.toConcurrentMap(...) | toConcurrentMap()는 멀티스레드 환경에서 쓰레드의 안전한 ConcurrentMap을 만들어 요소를 수집&반환한다. |
      | `Collector<T,?,List<T>>` | Collectors.toList() | List에 요소들을 수집하는 컬렉션을 반환 |
      | `Collector<T,?,Set<T>>` | Collectors.toSet(...) | Set에 요소들을 수집하는 컬렉션을 반환 |
      | `Collector<T,?,Map<T>>` | Collectors.toMap(...) | Map에 요소들을 수집하는 컬렉션을 반환 |


      - A(누적기)가 ?인 이유
        - List, Set, Map 컬렉션에 누적할 경우에는 별도의 A(누적기)가 필요 없다.

 ※ 예시 코드
  * 전체 학생 List에서 남학생들만 별도의 List로 생성
  ```java
  List<Student> maleList = totalList.stream()
      .filter(s->s,getSex()==Student.Sex.MALE)
      .collect(Collectors.toList());
  ```
  * 전체 학생 List에서 여학생 들만 별도 HashSet으로 생성
  ```java
  Set<Student> femaleSet = totalSet.stream()
      .filter(s->s,getSex()==Student.Sex.MALE)
      .collect(Collectors.toCollection(HashSet::new));
      //Collectors.toCollection(Supplier <T>
      //Supplier(HashSet::new)가 제공하는 컬렉션에 요소를 넣겠다는 의미

  ```    
