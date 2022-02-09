import com.alibaba.fastjson.JSON;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zhangguodong
 * @since 2022/1/11 15:58
 */
public class CheckInHoursCount {

    public static void main(String[] args) {
        // 步骤1：填写 token，防止过长，请自己裁剪

        String builder = "PS_DEVICEFEATURES=width:1792 height:1120 pixelratio:2 touch:0 geolocation:1 websockets:1 webworkers:1 datepicker:1 dtpicker:1 timepicker:1 dnd:1 sessionstorage:1 localstorage:1 history:1 canvas:1 svg:1 postmessage:1 hc:0 maf:0; cid_jiangyong_songguo7.com=TkdvemFURmhOVzR6WnpGNU9XOHpiak5u; access_token=eyJhbGciOiJIUzI1NiJ9.eyJnbG9iYWxfdXNlcl9pZCI6MTY2ODcsImdsb2JhbF91c2VyX25hbWUiOiLlp5zmtowiLCJleHAiOjE2NDQ0OTE2MzJ9.KOi00R1DNI01f3azp4M1Fj9k2bdvOh-rHqgWo0uEgZc; refresh_token=39FE5786D60740CA946961D3D3276659; ehrweb1-8000-PORTAL-PSJSESSIONID=icvT5Bqx_q1tY1ifSCit_Xhy_pHPBf71!-397584193; ExpirePage=http://ehr.songguo7.com/psc/HR92PRD/; PS_LOGINLIST=http://ehr.songguo7.com/HR92PRD; PS_TOKEN=qAAAAAQDAgEBAAAAvAIAAAAAAAAsAAAABABTaGRyAk4Acwg4AC4AMQAwABTdSJ2AD3GPGdX+FqYIuUAZWHa1YmgAAAAFAFNkYXRhXHicHYk7DkBQFESPT5QK+yC8kMcGRCmoNKISCgqVvVmc8e5kzsnk3kAY+J4nvz7ukoOdlZONh8s5mukYiXuhZWLRHCgNOUZJnX9asVAytRRzatG6f0Wj8gE62g2T; PS_TokenSite=http://ehr.songguo7.com/psc/HR92PRD/?ehrweb1-8000-PORTAL-PSJSESSIONID; SignOnDefault=; PS_LASTSITE=http://ehr.songguo7.com/psc/HR92PRD/; PS_TOKENEXPIRE=7_Feb_2022_11:15:08_GMT";

        // 步骤2： 填写 年、月
        String json = CheckInHoursCount.sendPost(builder, "2022", "01");
        if (json == null || "".equals(json)) {
            System.out.println("exception!!");
            return;
        }
        CheckInHoursCount checkIn = JSON.parseObject(json, CheckInHoursCount.class);
        CheckInHoursCount.countTime(checkIn);
    }

    List<Calendar> calendar;
    String         emplid;
    String         ffilename;
    String         name;

    public List<Calendar> getCalendar() {
        return calendar;
    }

    public void setCalendar(List<Calendar> calendar) {
        this.calendar = calendar;
    }

    public String getEmplid() {
        return emplid;
    }

    public void setEmplid(String emplid) {
        this.emplid = emplid;
    }

    public String getFfilename() {
        return ffilename;
    }

    public void setFfilename(String ffilename) {
        this.ffilename = ffilename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Calendar {

        List<Week> weeks;
        String     month;
        String     year;
        String     MainColor;
        String     first;
        String     second;

        public List<Week> getWeeks() {
            return weeks;
        }

        public void setWeeks(List<Week> weeks) {
            this.weeks = weeks;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getMainColor() {
            return MainColor;
        }

        public void setMainColor(String mainColor) {
            MainColor = mainColor;
        }

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getSecond() {
            return second;
        }

        public void setSecond(String second) {
            this.second = second;
        }
    }

    public static class Week {

        List<Day> mon;
        List<Day> tues;
        List<Day> wed;
        List<Day> thur;
        List<Day> fri;
        List<Day> sat;
        List<Day> sun;

        public List<Day> getMon() {
            return mon;
        }

        public void setMon(List<Day> mon) {
            this.mon = mon;
        }

        public List<Day> getTues() {
            return tues;
        }

        public void setTues(List<Day> tues) {
            this.tues = tues;
        }

        public List<Day> getWed() {
            return wed;
        }

        public void setWed(List<Day> wed) {
            this.wed = wed;
        }

        public List<Day> getThur() {
            return thur;
        }

        public void setThur(List<Day> thur) {
            this.thur = thur;
        }

        public List<Day> getFri() {
            return fri;
        }

        public void setFri(List<Day> fri) {
            this.fri = fri;
        }

        public List<Day> getSat() {
            return sat;
        }

        public void setSat(List<Day> sat) {
            this.sat = sat;
        }

        public List<Day> getSun() {
            return sun;
        }

        public void setSun(List<Day> sun) {
            this.sun = sun;
        }
    }

    public static class Day {

        List<OnceCheck> cardtimeList;
        String          date;
        String          shifttime;
        String          checkable;
        String          num;
        String          position;
        String          cardtime;

        String day;

        public List<OnceCheck> getCardtimeList() {
            return cardtimeList;
        }

        public void setCardtimeList(List<OnceCheck> cardtimeList) {
            this.cardtimeList = cardtimeList;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getShifttime() {
            return shifttime;
        }

        public void setShifttime(String shifttime) {
            this.shifttime = shifttime;
        }

        public String getCheckable() {
            return checkable;
        }

        public void setCheckable(String checkable) {
            this.checkable = checkable;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getCardtime() {
            return cardtime;
        }

        public void setCardtime(String cardtime) {
            this.cardtime = cardtime;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

    }

    public static class OnceCheck {

        String cardTimeDescr;

        public String getCardTimeDescr() {
            return cardTimeDescr;
        }

        public void setCardTimeDescr(String cardTimeDescr) {
            this.cardTimeDescr = cardTimeDescr;
        }

    }

    public static void countTime(CheckInHoursCount checkInHoursCount) {
        for (Calendar month : checkInHoursCount.getCalendar()) {
            double workDay = 0d;
            double workHours = 0d;
            for (Week week : month.getWeeks()) {
                double[] d = countOneDayWorkHour(week.getMon().get(0));
                workDay += d[0];
                workHours += d[1];
                d = countOneDayWorkHour(week.getTues().get(0));
                workDay += d[0];
                workHours += d[1];
                d = countOneDayWorkHour(week.getWed().get(0));
                workDay += d[0];
                workHours += d[1];
                d = countOneDayWorkHour(week.getThur().get(0));
                workDay += d[0];
                workHours += d[1];
                d = countOneDayWorkHour(week.getFri().get(0));
                workDay += d[0];
                workHours += d[1];
                d = countOneDayWorkHour(week.getSat().get(0));
                workDay += d[0];
                workHours += d[1];
                d = countOneDayWorkHour(week.getSun().get(0));
                workDay += d[0];
                workHours += d[1];
            }
            double avgWorkHour = new BigDecimal(workHours / workDay).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            System.out.println("月份：" + month.getMonth() + " 平均工时：" + avgWorkHour);
        }
    }

    public static double[] countOneDayWorkHour(Day day) {
        if (day.getCardtime() == null || !day.getShifttime().contains("总部班次"))
            return new double[]{0, 0};

        // 打卡时间：2021-11-04 09:35(上班卡);2021-11-04 20:25(下班卡)
        String[] split = day.getCardtime().split(";");
        if (!split[0].contains("("))
            return new double[]{0, 0};
        String startTime = split[0].substring(split[0].indexOf("：") + 1, split[0].indexOf("("));
        String endTime = split[1].substring(0, split[1].indexOf("("));
        double workHours = getDistance(string2date(startTime), string2date(endTime), 60 * 60 * 1000);
        System.out.println(startTime + " ～ " + endTime + " = " + workHours);
        return new double[]{1, workHours};
    }

    public static Date string2date(String dateTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            return sdf.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static double getDistance(Date start, Date end, double unit) {
        // milliseconds
        long time1 = start.getTime();
        long time2 = end.getTime();

        long diff;
        if (time1 < time2) {
            diff = time2 - time1;
        } else {
            diff = time1 - time2;
        }
        return new BigDecimal((float) diff / unit).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    public static String sendPost(String token, String year, String month) {
        year = year == null ? "2022" : year;
        month = month == null ? "01" : month;
        String uri = "http://ehr.songguo7.com/psc/HR92PRD/EMPLOYEE/HRMS/s/WEBLIB_FP_PORTA.FP_ABSENCE_IS.FieldFormula." +
                "IScript_AbsenceCalendarData?year=" + year + "&month=" + month + "&emplid=";
        try {
            URL url = new URL(null, uri, new sun.net.www.protocol.https.Handler());
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

            //添加请求头
            con.setRequestMethod("POST");
            con.setRequestProperty("Connection", "keep-alive");
            con.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");
            con.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36");
            con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            con.setRequestProperty("Origin", "http://ehr.songguo7.com");
            con.setRequestProperty("Referer", "http://ehr.songguo7.com/psc/HR92PRD/EMPLOYEE/HRMS/s/WEBLIB_FP_PORTA.FP_ABSENCE_IS.FieldFormula.IScript_AbsenceCalendar?emplid=&target=SELF_INFO");
            con.setRequestProperty("Cookie", token);
            con.connect();
            if (con.getResponseCode() == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {// 循环读取流
                    sb.append(line);
                }
                br.close();// 关闭流
//                System.out.println(sb);
                return sb.toString();
            } else {
                System.out.println(con.getResponseCode());
            }
            con.disconnect();// 断开连接
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}