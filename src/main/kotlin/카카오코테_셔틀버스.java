import java.util.*;

public class 카카오코테_셔틀버스 {
    public static void main(String[] args) {
        int n = 1;
        int t = 1;
        int m = 5;
        String[] timetable = {"09:10", "09:09", "08:00"};
        int bus_time = 540;

        ArrayList<Integer> arr_time = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (String e : timetable) {
            int hour = Integer.parseInt(e.substring(0,2))*60;   // 08 String이여도 Integer로 변환하면 8*60 가능해짐
            int min = Integer.parseInt(e.substring(3,5));
//            System.out.println("hour : " + hour+", min : "+min);
//            arr_time.add(hour+min);
            queue.add(hour+min);
        }

//        for(int i=0; i<timetable.length; i++) {
//            System.out.println(queue.peek());            //remove()를 사용하셔도 됩니다.
//        }


        // 540분이면 09:00
        int answer = 0;
        int cnt = 0;

        // 마지막 버스에 탑승 가능한지 확인하고 못타면 바로 전버스 확인. 뒤부터 확인할것.

        for (int i=n; i>0 ; i--) {

        }
//        for (int i=0; i<n; i++) {
//            while (cnt < m) {
//                if (!queue.isEmpty()) {
//                    if (queue.peek() <= bus_time) {
//                        queue.poll();
//                    }
//                }
//                cnt++;
//            }
//            bus_time = bus_time + t;
//        }




    }
}
