import java.util.ArrayList;
public class Solution2 {
        int size = 0;
        private ArrayList<Integer> listQueue = new ArrayList<Integer>();

        public void add(Integer data) {
            ++size;
            listQueue.add(data);
        }

        public Integer poll() {
            if (listQueue.size() == 0) {
                return null;
            } else {
                --size;
                return listQueue.remove(0);
            }
        }

        public int size() {
            return this.size;
        }

        public Integer peek() {
            if (listQueue.size() == 0) {
                return null;
            } else {
                return listQueue.get(0);
            }
        }

        public String show() {
            return listQueue.toString();
        }

        public void clear() {
            listQueue.clear();
        }

}
