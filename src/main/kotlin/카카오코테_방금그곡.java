import java.util.ArrayList;

public class 카카오코테_방금그곡 {
    public static void main(String[] args) {

        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
//        int size = musicinfos.length/4;
        ArrayList<Infos> infos = new ArrayList<>();

        for (int i=0; i< musicinfos.length; i++) {
            int[] time = new int[2];
            String title = "";
            String melody = "";
            int cnt = 0;
            String[] music = musicinfos[i].split(",");
            for (int j=0; j<4; j++) {
                if (cnt==0 || cnt==1) {
                    String[] a = music[cnt].split(":");
                    time[cnt] = Integer.parseInt(a[0])*60 + Integer.parseInt(a[1]);
                } else if (cnt==2) {
                    title = music[j];
                } else {
                    melody = music[j];
                }
                cnt++;
            }
            int a = time[1] - time[0];
            infos.add(new Infos(a, title, melody));
        }

//        for (Infos e: infos) {
//            System.out.println(e.time+", "+e.title+", "+e.melody);
//        }

        // todo : 답지 보자
        String _m = m;
        for (Infos e : infos) {
//            for ()
        }


    }


}

class Infos {
    int time = 0;
    String title = "";
    String melody = "";

    Infos(int time, String title, String melody) {
        this.time = time;
        this.title = title;
        this.melody = melody;
    }
}
