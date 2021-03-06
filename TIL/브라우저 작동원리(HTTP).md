# HTTP
  - Hypertext Transfer Protocol의 약자로 하이퍼 미디어 문서를 전송하기 위한 애플리케이션 레이어 프로토콜이다.
  - 기본 개념은 HTML문서와 같은 리소스를 가져올 수 있게 해주는 프로토콜.
  - 하나의 HTTP 문서는
  - 클라이언트가 서버에 어떠한 데이터를 요청할 때, 요청사항을 서버와 클라이언트가 간단하고 정확하게 이해할 수 있도록 작성하는데 이를 HTTP 메세지라고 한다.
  <img src="images/Fetching_a_page.png" width="450px" height="300px" title="HTTP 구"></img><br/>
  - HTTP 메세지는 요청(클->서)과 응답(서->클)로 나누어진다

### HTTP의 특성
- HTTP 형식을 통한 네트워크 웹 통신은 크게 2가지 특성을 가진다
  1. **Connectionless(비연결성)** : 클라이언트와 서버간에 한번 연결을 맺고 서버가 응답을 마치면 연결을 끊어버리는 특성
  - 웹에서 서버는 여러 고객(클라이언트)과 연결을 하는데 한번 연결을 지속하면 점차 서버에 부하가 증가하게 됨.
  - 리소스 절약 차원에서 비연결성을 가진다.
  - 클라이언트는 서버와 연결할 때마다 새로운 연결을 해야하기에 연결/해제 반복으로 인한 오버헤드라는 단점이 존재
  - KeepAlive라고 일정 주기로 서버와 패킷을 주고 받으며 서버와의 연결 가능여부를 체크하지만 이조차로 유지하기 위한 메모리 소모가 발생한다는 한계가 있음.
  2. **Stateless(무상태성)** : 비연결성으로 인해 서버가 클라이언트를 지속적으로 식별할 수가 없다는 특성
  - 패킷을 주고 받기 위해 매번 연결/해제가 반복되기에.
  - 이를 방지하고자 여러 방법이 마련되었다. 쿠키, 세션, 토큰(OAuth, JWT)


### HTTP 메세지
  - 클라이언트와 서버간에 데이터가 교환되는 방식을 뜻함
  - 요청과 응답 2가지로 나누어진다.
  - 시작줄(Start-line)에는 실행되어야 할 요청, 혹은 이 요청에 대한 수행 결과(성공 or 실패)가 기록된다.
  - HTTP 해더에는 이에 관한 설명이 담겨있다.
  - 요청과 관련된 내용(HTML 폼 컨텐츠 등)이 옵션으로 들어가거나 응답과 관련된 문서가 들어간다. 본분의 존재 유무 및 크기는 첫줄과 HTTP 해더에 명시된다.
  <img src="images/HTTPMsgStructure2.png" width="550px" height="300px" title="HTTP 메세지 구조"></img><br/>


#### 시작줄
  - 서버가 특정 기능을 수행하도록 요청하는 주요 내용을 담고 있다.
  1. HTTP 메서드가 쓰인다.(GET, PUT, POST 등) 또한 명사(HEAD, OPTIONS)를 사용해 서버가 수행할 동작을 나타낸다.
  2. 다음은 URL, 프로토콜, 포트 도메인의 절대경로 등이 온다. 추가적으로



#### Cookie
  - 클라이언트가 서버에 HTTP 요청을 제공할 때 서버는 응답 + Set-Cookie HTTP 헤더를 전송한다. 이후 클라이언트는 모든 요청과 함께 쿠키의 값을 쿠키요청해더의 형태로 서버에 반환한다. 이를 통해 쿠키에 저장된 사용자 정보를 통해 서버가 클라이언트의 인증을 유지하게 한다.
  - 구성요소
    - 이름: 각각의 쿠키를 구별하는 이름
    - 값: 쿠기가 갖고있는 값
    - 유효시간: 쿠키의 유지시간
    - 도메인: 쿠키를 전송할 도메인
    - 경로: 쿠키를 전송할 요청경로
  - 동작방식
   1. 클라이언트가 페이지를 요청
   2. 서버에서 쿠키를 생성
   3. HTTP 해더에 쿠키를 포함시켜 응답
   4. 쿠키 만료시점까지 클라이언트가 보관
   5. 만료 이내에 동일서버에 요청시 HTTP 해더에 쿠키 포함해 요청
   6. 서버에서 쿠키를 읽고 상태 정보 변경이 필요하면 쿠키 업데이트하여 응답 HTTP 해더에 포함시켜 응답

#### 세션
  - 쿠키가 브라우저에 저장되기에 자칫 보안위협에 취약하다. 세션은 이 사용자 정보를 서버단에 저장하는 구조로 진행된다.
  - 서버에서 세션 ID를 클라이언트마다 부여하고 서버 접속 후 브라우저가 종료될 때까지 인증이 유지됨. 인증 기간을 정할 수도 있음.
  - 하지만 이 또한 보안 위협은 존재한다. 또한 서버에 저장하면서 서버 메모리가 소모되고 접속자가 많을 수록 서버 과부하가 심해진다.
  - 동작방식
    1. 클라이언트가 서버 접속 시 세션ID 발급
    2. 세션ID에 대해 쿠키를 사용해 저장(이 때 쿠키 이름은 JSESSIONID이다.)
    3. 클라이언트가 서버에 다시 접속하면 이 쿠키를 이용해 세션ID값을 서버에 전달하여 인증 유지
  - 주요 특징
    1. 각 클라이언트마다 ID부여
    2. ID별로 클라이언트들을 구분해 개별 서비스 가능
    3. 쿠키보다 보안은 우수
    4. 서버 메모리 차지
  - 보통 로그인과 같은 보안상 중요작업에 사용된다.

## 응답 상태코드
- 클라이언트가 서버에 요청을 하면, 서버는 요청에 대한 처리 상태를 숫자로 반환.
  - 100 - 109: 메시지 정보
  - 200 - 206: 요청 성공
  - 300 - 305: 리다이렉션
  - 400 - 415: 클라이언트 에러
  - 500 - 505: 서버에러



### Protocal
  - 어원은 그리스어 proto+kollen(맨 처음 + 붙이다)에서 왔다. 어떤 사실이나 법률 관계를 증명하는 문서의 효력을 증명하기 위해 문서 첨부하는 용지를 의미했음
  - 외교문서, 의전을 뜻하기도 하며 여러 문화, 언어, 인종 등을 가지고 있는 여러나라가 함께 살아가기 위해 지켜야 하는 약속을 공식화한 것의 의미를 가진다.
  - 여기서 나라가 이것이 데이터 통신 규약의 개념으로 활용되어 "각각의 프로그램, DB, 파일 서비스 등을 가지고 있는 컴퓨터 네트워크가 데이터를 주고 받기 위해 지켜야 하는 약속을 공식화한 것"을 의미하게 되었다.
  - 대표적 프로토콜로는 HTML, HTTP+Secure, + ftp(이메일용) + rtsp(실시간 스트리밍), SSH등이 있다.

#### Protocol의 기능
  - 데이터를 네트워크 상에서 전송하는 과정에 있어 하나의 데이터를 통으로 전달하는 것은 효율이 떨어지게 된다. 이를 해결하고자 데이터를 부분으로 나누어 전송하게 되는데 이렇게 분해된 일부 데이터를 **패킷**(분해된 각각의 데이터)라고 부른다.
  - 여러 패킷들은 기준에 따라 나누어지고 각 패킷을 구분하기 위해 패킷의 정보를 헤더에 기록한다. 데이터를 네트워크로 전송할 수 있도록 포장하는 작업을 **캡슐화**라고 한다.
  - 네트워크로 데이터를 전송할 때 데이터를 주는 쪽과 받는 쪽(웹에서는 클라이언트와 서버)이 서로 정확한 시간과 규모에 맞춘 통신이 가능하도록 조절하는 것을 **연결 제어(Flow Control)**이라고 한다.
  - 데이터가 이동하고나서 각 전송 단계의 변화가 주는 쪽과 받는 쪽이 동일하게 이루어지도록 일치시키는 개념이 **동기화(Synchronization)**이다.
  - 모든 패킷이 전송되고 나서 각 포장된 패킷을 분해하는 작업이 이루어지는데 각 패킷을 순서를 가지고 있고 이 순서에 맞추어 절차가 진행되도록 순서를 맞추는 것을 **순서제어(sequance Control)**이라고 한다.
  - 전송과정에서 발행한 문제를 관리하는 것을 **주소 설정**이라고 한다.
  - 위에 단계처럼 여러 단계를 거쳐 프로토콜이 진행되지만 필요에 따라 원하는 기능을 넣어가며 프로토콜을 만들어낼 수 있다.

#### Protocol의 구성요소
    - Syntax(형식):데이터를 어떻게 구성할 것인가, 어떻게 해석할 것인가?
    - Semeantic(의미):데이터를 어떻게 제어할 것인가, 어떻게 오류를 처리할 것인가
    - Timing(순서):통신하는 속도와 속도의 조절, 데이터 전송의 순서 관리


#### Protocol의 활용
  - 프로토콜은 여러방면에서 활용되는 개념이다.
  - 대표적으로 TCP와 UDP에서 활용된다.
  - 네트워크 7단계중 4단계인 Transfer layer단계에서 TCP와 UDP로 구분되는데
  | TCP | UDP |
  |---|---|
  | 신뢰성 | 속도 |
  | 이메일 | 실시간 스트리밍 |
  | 파일전송 | 전화 |
