import java.util.ArrayList;

public class Solution { private ArrayList<Integer> listStack = new ArrayList<Integer>();
    int size = 0;

    public void push(Integer data) {
        listStack.add(data);
        ++size;
    }

    public Integer pop() {
        if (listStack.size()==0) {
            return null;
        } else {
            --size;
            return listStack.remove(listStack.size() - 1);
        }
    }

    public int size() {
        return this.size;
    }

    public Integer peek() {
        if (listStack.size()==0) {
            return null;
        } else {
            return listStack.get(listStack.size() - 1);
        }
    }

    public String show() {
        return listStack.toString();
    }

    public void clear() {
        listStack.clear();
        size = 0;
    }
}
