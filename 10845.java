import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>(); // LinkedList 대신 ArrayDeque 사용 (빠름)

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.startsWith("push")) {
                int num = Integer.parseInt(command.split(" ")[1]);
                queue.addLast(num);
            } 
            else if (command.equals("pop")) {
                if (queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.pollFirst()).append("\n");
            } 
            else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            } 
            else if (command.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append("\n");
            } 
            else if (command.equals("front")) {
                if (queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.peekFirst()).append("\n");
            } 
            else if (command.equals("back")) {
                if (queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.peekLast()).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
