import java.util.ArrayList;

public class 카카오코테_추석트래픽 {
    public static void main(String[] args) {

        String[] lines = {
                "2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"
        };

        ArrayList<Traffic2> traffic2s = new ArrayList<>();
        for (int i=0 ; i<lines.length ; i++) {
//            System.out.println((int)(Double.parseDouble(lines[i].substring(17, 23))*1000)+"");

            int end = Integer.parseInt(lines[i].substring(11, 13))*3600*1000 +
                    Integer.parseInt(lines[i].substring(14, 16))*60*1000 +
                    (int)(Double.parseDouble(lines[i].substring(17, 23))*1000);

            int proc = (int)(Double.parseDouble(lines[i].substring(24, lines[i].length()-1))*1000);
            int start = end - proc + 1;

            traffic2s.add(new Traffic2(start, end));
        }

        int max = 0;
        int cnt = 1;
        for (int i=0 ; i < traffic2s.size() ; i++) {
            for (int j=i+1 ; j < traffic2s.size() ; j++) {
                if (traffic2s.get(i).endTime + 1000 > traffic2s.get(j).startTime) {
                    cnt++;
                }
            }
            if (max<cnt) max = cnt;
            cnt = 1;
        }

        System.out.println(max+"");




    }
}

class Traffic2 {
    int startTime;
    int endTime;
    public Traffic2(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
