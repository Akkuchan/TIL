import java.util.*;

public class StackTest {
    public static ArrayList<Stack> browserStack(String[] actions, String start) {
        //"B", "C", "-1", "D", "A", "-1", "1", "-1", "-1"
        Stack<String> prevStack = new Stack<>();
        Stack<String> nextStack = new Stack<>();
        Stack<String> current = new Stack<>();
        ArrayList<Stack> result = new ArrayList<>();

        // TODO:
        result.add(prevStack);
        result.add(current);
        result.add(nextStack);

        current.push(start);
//        ArrayList<String> process = new ArrayList<>();
//        for(String pages : actions){process.add(pages);}// String 요소(pages)를 뽑아 리스트에 담기
        ArrayList<String> process = new ArrayList<>(Arrays.asList(actions));// 위의 두줄 한줄로 처리
        Iterator<String> proIter = process.iterator();// 요소(pages)를 받아 순환하기 위한 이터레이터 생성
        // 새 페이지 오면() , 1. 커렌트 값을 pre로 옮기고 2. 새페이지를 커렌트로
        while (proIter.hasNext()) {
            String element = proIter.next();
            Character ele = element.charAt(0);//isUpperCase()를 사용하기 위한 과정
            //str.matches("[A-Z]")로 전체 과정 대체 가능

            if (element == "1") {
                if(nextStack.size()!=0){//nextStack.isEmpty()와 동일
                    prevStack.push(current.pop());//현재 스택의 값을 없애면서 이전 스택에 넣기
                    current.push(nextStack.pop());
                }// 다음 스택의 맨위값 없애면서 그 값 현재 스택에 넣기
            } else if (element == "-1") {
                if(prevStack.size()!=0){//prevStack.isEmpty()와 동일
                    nextStack.push(current.pop());//현재 스택의 값을 없애면서 다음 스택에 넣기
                    current.push(prevStack.pop());
                }//이전 스택의 맨위값 없애면서 현재로 넣기
            }
            else if(!Character.isUpperCase(ele)) {// 대문자가 오지 않는 다면
                result.clear();
                current.push("false");
                result.add(current);
            }

            else //*if (element instanceof String)/* {// 새로운 페이지가 오면
            { prevStack.push(current.pop());// 현재 스택의 값을 없애면서 이전스택에 넣기
                current.push(element);//새로운 페이지는 (비어있는)현재 스택으로
                nextStack.clear();// 다음 스택은 비워주기
            }

        }
        return result;
    }
}
