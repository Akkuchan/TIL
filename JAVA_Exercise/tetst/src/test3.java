public class test3 {

    public static void main(String[] args) {
        int bufferSize = 4;
        int capacities = 10;
        int[] documents = new int[]{7,8,9,6};

        int output = QueueTest2.queuePrinter(bufferSize, capacities, documents);
          System.out.println(output);
    }
}
