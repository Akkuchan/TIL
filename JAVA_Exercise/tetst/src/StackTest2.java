import java.util.*;

public class StackTest2 {

    public static void main(String[] args) {
        String[] actions = new String[]{"B", "-1", "B", "A", "C", "-1", "-1", "D", "-1", "1", "E", "-1", "-1", "1"};
        String start = "A";
        ArrayList<Stack> output = browserStack(actions, start);
        System.out.println(output);
    }


    public static ArrayList<Stack> browserStack(String[] actions, String start) {
        //"B", "C", "-1", "D", "A", "-1", "1", "-1", "-1"
        Stack<String> prevStack = new Stack<>();
        Stack<String> current = new Stack<>();
        Stack<String> nextStack = new Stack<>();

        ArrayList<Stack> result = new ArrayList<>();

        // TODO:
        result.add(prevStack);
        result.add(current);
        result.add(nextStack);

        // 0. start를 현재 페이지로 넣기
        current.push(start);
        // 1. action은 배열, 배열의 값들을 꺼내서 하나씩 스택에 넣어야 함 -> 순환(iterator + 반복문 or stream + 반복문 or 인덱스따라 하나씩 반복문으로 꺼내기)
        //  Stream<String> strStream = Arrays.stream(actions);
        //  strStream.(스트림을 활용한 중간, 최종 연산의 단계가 필요X)

        //  두번째 페이지가 왔을 때
        for(int i=0; i<actions.length; i++){
            //  2. 만약 1이 입력되면(actions의 값이 1이면), 현재 페이지를 pop하고 pre로, next를 pop해 현재로
            //         2-1. next가 비었으면 아무것도 하지 않는다. 빈코드
            if(actions[i]=="1"){
                if(!nextStack.isEmpty()){
                    prevStack.push(current.pop());//현재 페이지를 pop하고 pre로
                    current.push(nextStack.pop());//next를 pop해 현재로
                }

            }

            // 3. 만약 -1이 입력되면(actions의 값이 -1이면), 현재 페이지를 pop해 next로 pre를 pop해 현재로
            //         3-1. next가 비었으면 아무것도 하지 않는다. 빈코드
            else if(actions[i]=="-1") {
                if(!prevStack.isEmpty()){
                    nextStack.push(current.pop());//현재 페이지를 pop해 next로
                    current.push(prevStack.pop());//pre를 pop해 현재로
                }

            }

            else {
                prevStack.push(current.pop());
                current.push(actions[i]);
                nextStack.clear();
            }

        }


        return result;
    }
}