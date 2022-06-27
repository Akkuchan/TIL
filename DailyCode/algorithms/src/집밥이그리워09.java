import java.util.*;
public class 집밥이그리워09 {


    public static void main(String[] args) {
        ArrayList<String[]> output = missHouseMeal(new String[]{"eggroll", "kimchi", "fishSoup"});
        System.out.println(output);
    }






    public static ArrayList<String[]> missHouseMeal(String[] sideDishes) {
        // TODO:
        ArrayList<String[]> result = new ArrayList<String[]>();
        boolean[] added = new boolean[sideDishes.length];
        Arrays.sort(sideDishes);
        howmanyfood(-1, 3, new String[]{}, added, sideDishes, result);

        ArrayList<String[]> arrayList = new ArrayList<>();
       for(int j=0; j<result.size(); j++){
           if(!arrayList.contains(Arrays.stream(result.get(j)).toArray()))
            arrayList.add(result.get(j));
       }

       return arrayList;

    }
    //cnt: 한 쟁반에 반찬 몇개를 담을 것인지
    //index: 쟁반 인덱스0기반의 값을 다 채웠다면 다음 인덱스0은 다른 반찬이 와야함
    //tray; 반찬을 하나씩 담아 cnt 개수만큼 놓을 공간
    //sideDishes: tray에 놓을 반찬의 종류(메뉴판과 같은 개념)

    public static ArrayList<String[]> howmanyfood(int index, int cnt, String[] tray, boolean[] added, String[] sideDishes, ArrayList<String[]> result){
        if(index==2){
            result.add(tray);
            return result;
        }

        for(int i=index+1; i<sideDishes.length; i++){
                if(!added[i]) {
                    added[i] = true;
                    //하나씩 반찬을 넣어야 함.
                    //반찬을 넣을 공간이 필요
                    String[] addedTray = Arrays.copyOf(tray, tray.length + 1);
                    addedTray[addedTray.length - 1] = sideDishes[i];
                    howmanyfood(i, cnt - 1, addedTray, added, sideDishes, result);

                    added[i] = false;
                    howmanyfood(i, cnt - 1, addedTray, added, sideDishes, result);
                }

        }

        return result;
    }

}
