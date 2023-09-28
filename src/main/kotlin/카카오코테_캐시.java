import java.util.LinkedList;
import java.util.Queue;

public class 카카오코테_캐시 {
    public int solution(int cacheSize, String[] cities) {

        int result = 0;
        try {

            Queue<String> queue = new LinkedList<>();   // 캐시에 저장된 데이터

            for (int i = 0; i < cities.length; i++) {
                cities[i] = cities[i].toUpperCase();
                if (queue.remove(cities[i])) {  // 캐시에 저장되어 있는게 있어서 지웠음
                    result += 1;
                } else {
                    if (queue.size() > cacheSize) queue.poll(); // 큐가 꽉차서 큐 교체
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
