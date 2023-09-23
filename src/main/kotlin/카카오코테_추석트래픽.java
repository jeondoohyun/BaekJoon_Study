import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class 카카오코테_추석트래픽 {
    public static void main(String[] args) {

        // String[] 초기화는 중괄호 쓸것
        String[] lines = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        };

        int answer = 0;
        List<Traffic> t_list = new ArrayList();
        for(int i = 0; i < lines.length; i++) {
            int end =(int) ((Integer.parseInt(lines[i].substring(11,13)) * 3600
                    + Integer.parseInt(lines[i].substring(14,16)) * 60) * 1000
                    + Double.parseDouble(lines[i].substring(17,23)) * 1000);

            // 처리시간 t
            int treat_time = (int)(Double.parseDouble(lines[i].substring(24, lines[i].length() - 1)) * 1000);
            int start = end - treat_time + 1;
            t_list.add(new Traffic(start, end));
        }
        int max = 1;
        int cnt;
        for(int i = 0; i < t_list.size(); i++) {
            cnt = 1;
            for(int j = i + 1; j < t_list.size(); j++){
                if(t_list.get(i).end + 1000 > t_list.get(j).start)
                    cnt++;
            }
            if(max < cnt)
                max = cnt;
        }
        answer = max;

        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(answer+"");
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Traffic {
    int start;
    int end;
    Traffic(int start, int end){
        this.start = start;
        this.end = end;
    }
}
