뷰: 화면에  보여지는 리소스를 제공하는 역할을 담당
- HTML 페이지 출력, HTML 페이지를 직접 렌더링 해서 클라이언트에게 전송함
- MODEL(FULL OF HTML PAGES)를 만들고 클라에게 전송
- 이를 위한 기술에는 Thymeleaf, FreeMarker, JSP,+JSTl, Tiles 등이 있다.

- excel, pdf등의 문서 형태로 출력

- xml, json 등 특정 형식으로 포맷 변환

컨트롤러: 클라이언트의 요청을 전달 받아 로직 거친 후에 모델이 만들어지고, 이를 뷰로 전송
- 클라이언트가 보낸 요청 데이터를 컨트롤러가 수신한다.
- 비즈니스 로직 처리
- 모델 데이터에 처리한 결과값을 담는다.
- 컨트롤러에게 모델을 뷰에게 전달한다.
- 뷰가 응답 데이터를 만든다.


클라이언트가 요청을 전송하면 DispatcherServlet이라는 클래스에 먼저 요청이 전달된다.
DispatcherServlet은 클라이언트 요청과 매칭되는 Controller의 정보를 HandlerMapping 인터페이스에게 요청한다.
HandlerMapping 인터페이스는 클라이언트 요청과 매핑되는 Controller정보를 찾아 DispatcherServlet에게 리턴한다.
- 이 Controller정보에는 해당 Controller 안에 있는 Handler 매서드에 관한 정보도 가지고 있다. Handler 매서드는 Controller클래스 안에 구현된 요청 처리매서드를 의미한다. 즉 Controller정보라는 건 요청을 처리할 매서드 정보 또한 포함한다는 것
DispatcherServlet은 요청 처리 메서드를 직접 호출하지 않고 handelrAdapter라는 녀석에게 이를 호출하도록 위임
handelrAdapter는 DispatcherServlet으로부터 전달 받은 Controller정보를 바탕으로 해당 Controller의 handler 매서드를 호출한다.
Controller의 handler 매서드는 비즈니스 로직에 따라 요청을 처리하고 Controller가 결과값을 담은 Model 데이터와 view정보를 다시 handler 메서드를 호출했던 handelrAdapter에게 전달한다
handlerAdapter는 전달받은 Model 데이터와 view 정보를 다시 DispatcherServlet에게 전달한다.
DispatcherServlet은 전달받은 model과 view 정보 중 view 정보를 다시 viewResolver에게 전달하여 적절한 view 검색을 요청한다
viewResolver는 view 정보에 맞는 view를 찾아 이를 다시 리턴한다.
DispatcherServlet은 viewResolver에게 받은 view 객체를 통해 model을 넘겨주면서(view와 model을 합쳐서) 클라이언트에게 전할 응답데이터를 만들도록 view에게 요청한다
view는 응답 데이터를 생성해서 다시 DispatcherServlet에게 전달한다.
DispatcherServlet은 view한테 받은 응답 데이터를 클라이언트에게 전달하고 끝낸다.
