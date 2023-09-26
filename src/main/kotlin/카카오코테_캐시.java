import java.util.LinkedList;
import java.util.Queue;

public class 카카오코테_캐시 {
    public int solution(int cacheSize, String[] cities) {

        int result = 0;
        try {

            Queue<String> queue = new LinkedList<>();   // 큐 사용

            for (int i = 0; i < cities.length; i++) {
                cities[i] = cities[i].toUpperCase();
                if (queue.remove(cities[i])) {  // 캐시에 저장되어 있는게 있어서 지웠음
                    result += 1;
                } else {
                    if (queue.size() > cacheSize) queue.poll();
                    result += 5;
                }

                queue.add(cities[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
}
