import java.util.*;

public class 카카오코테_셔틀버스 {
    public static void main(String[] args) {
        
        int n = 10; // 셔틀 운행횟수
        int t = 60; // 셔틀 운행 간격
        int m = 45;  // 버스탑승 제한수

        // 크루들 대기열 도착시간
        String[] timetable = {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (String e : timetable) {
            String[] tmp = e.split(":");
            int hour = Integer.parseInt(tmp[0])*60;   // 08 String이여도 Integer로 변환하면 8*60 가능해짐
            int min = Integer.parseInt(tmp[1]);
            queue.add(hour+min);
        }

        // 540분이면 09:00
        int bus_time = 540-t;   // for문 시작시 더해주기때문에 한번 빼주고 시작한다.
        int answer = 0;
        int cnt = 0;    // 탑승객수
        int lastPassTime = 0; // 마지막탑승객 탑승 시간

        // 1. 가장 늦게 버스를 탈수 있는 시간을 고르는거기 때문에 버스에 자리가 있다면 마지막 버스오는 시간대에 서있으면 되고
        // 2. cnt가 m과 같아졌다면(인원이 꽉찼다면) 마지막 탑승객의 시간보다 1분 먼저 서있으면됨.
        /** 마지막버스 시간대를 알아야함, 마지막탑승객 시간 알아야함*/
        Loop1 :
        for (int i=0; i<n; i++) {
            cnt = 0;
            bus_time += t;  // 버스주기를 더해줘서 마지막 버스 시간 알수있음
            while (cnt < m) {
                if (!queue.isEmpty()) {
                    if (queue.peek() <= bus_time) {
                        lastPassTime = queue.poll();    // 마지막으로 탄 사람 시간 체크
                    } else {
                        break;
                    }
                } else {
                    break;
                }
                cnt++;  // 마지막버스까지 cnt가 m숫자와 같아졌다면 자리가 없다는뜻
            }
        }

        System.out.println("lastPassTime : " + lastPassTime+", cnt : "+cnt+", bustime :"+bus_time);

        if (cnt == m) {
            answer = lastPassTime-1;
        } else {   // i) cnt < m
            answer = bus_time;
        }

        String re = String.format("%02d", answer/60)+":"+String.format("%02d", answer%60);

        System.out.println(re);






    }
}
