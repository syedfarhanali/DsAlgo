package algoexpert.arrays;

import util.Utils;

import java.util.ArrayList;
import java.util.List;

public class CalendarMatching {

    public static void main(String[] args) {

        List<StringMeeting> calendar1 = new ArrayList<>();
        StringMeeting s1 = new StringMeeting("9:00","10:30");
        StringMeeting s2 = new StringMeeting("12:00","13:00");
        StringMeeting s3 = new StringMeeting("16:00","18:00");
        calendar1.add(s1);
        calendar1.add(s2);
        calendar1.add(s3);

        List<StringMeeting> calendar2 = new ArrayList<>();
        StringMeeting s4 = new StringMeeting("10:00","11:30");
        StringMeeting s5 = new StringMeeting("12:30","14:30");
        StringMeeting s6 = new StringMeeting("14:30","15:00");
        StringMeeting s7 = new StringMeeting("16:00","17:00");
        calendar2.add(s4);
        calendar2.add(s5);
        calendar2.add(s6);
        calendar2.add(s7);

        StringMeeting bound1 = new StringMeeting("9:00","20:00");
        StringMeeting bound2 = new StringMeeting("10:00","18:30");

        int duration = 30;

        List<StringMeeting> result = calendarMatching(calendar1,bound1,calendar2,bound2,duration);

        System.out.println(result.size());

    }


    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {


        List<StringMeeting> c1 = updateMeeting(calendar1,dailyBounds1);
        List<StringMeeting> c2 = updateMeeting(calendar2,dailyBounds2);

        List<StringMeeting> mergedCalendar = mergeCalendarBasedOnStartTime(c1,c2);

        List<StringMeeting> flattenedCalendar = flattenCalanders(mergedCalendar);

        return getAvailableTimeSlots(flattenedCalendar,meetingDuration);

    }

    private static List<StringMeeting> getAvailableTimeSlots(List<StringMeeting> flattenedCalendar, int meetingDuration) {

        List<StringMeeting> result = new ArrayList<>();
        for(int i=1 ;i< flattenedCalendar.size();i++){
            Float prevEnd = flattenedCalendar.get(i-1).getaFloatEnd();
            Float currentStart = flattenedCalendar.get(i).getaFloatStart();
            if(timeToMinutes(flattenedCalendar.get(i).start)- timeToMinutes(flattenedCalendar.get(i-1).end) >= meetingDuration){
                result.add(new StringMeeting(convertFloatToString(prevEnd), convertFloatToString(currentStart)));
            }
        }
        return result;
    }

    private static List<StringMeeting> flattenCalanders(List<StringMeeting> mergedCalendar) {

        List<StringMeeting> result = new ArrayList<>();

        Float prevStart = mergedCalendar.get(0).getaFloatStart();
        Float prevEnd = mergedCalendar.get(0).getaFloatEnd();

        for (int i=1 ;i< mergedCalendar.size() ;i++) {

            Float start = mergedCalendar.get(i).getaFloatStart();
            Float end = mergedCalendar.get(i).getaFloatEnd();
            if(prevStart <= start && start <=prevEnd){
                if(end > prevEnd){
                    prevEnd = end;
                }
            }else{
                result.add(new StringMeeting(convertFloatToString(prevStart),convertFloatToString(prevEnd)));
                prevStart = start;
                prevEnd = end;
            }
        }
        result.add(new StringMeeting(convertFloatToString(prevStart),convertFloatToString(prevEnd)));
        return result;
    }

    private static List<StringMeeting> mergeCalendarBasedOnStartTime(List<StringMeeting> c1, List<StringMeeting> c2) {

        List<StringMeeting> result = new ArrayList<>();

        int calendar1Idx = 0;
        int calendar2Idx = 0;

        while(calendar1Idx < c1.size() && calendar2Idx < c2.size()){
            if(c1.get(calendar1Idx).lessThan(c2.get(calendar2Idx))){
                result.add(c1.get(calendar1Idx));
                calendar1Idx++;
            }else{
                result.add(c2.get(calendar2Idx));
                calendar2Idx++;
            }
        }

        while(calendar1Idx < c1.size()){
            result.add(c1.get(calendar1Idx));
            calendar1Idx++;
        }
        while(calendar2Idx < c2.size()){
            result.add(c2.get(calendar2Idx));
            calendar2Idx++;
        }

        return result;
    }

    private static List<StringMeeting> updateMeeting(List<StringMeeting> calendar, StringMeeting dailyBounds) {
        StringMeeting start = new StringMeeting("00:00",dailyBounds.start);
        StringMeeting end = new StringMeeting(dailyBounds.end,"23:59");
        calendar.add(0,start);
        calendar.add(end);
        return calendar;
    }

    public static String convertFloatToString(Float time){
        return String.format("%.02f", time).replace(".",":");
    }

    public static int timeToMinutes(String time){
        String[] timeArr = time.split(":");
        return (Integer.parseInt(timeArr[0]) * 60) + Integer.parseInt(timeArr[1]);
    }

    static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }

        public boolean lessThan(StringMeeting stringMeeting) {
            if(getaFloatStart() < stringMeeting.getaFloatStart()){
                return true;
            }
            return false;
        }

        public float getaFloatStart() {
            return Float.parseFloat(this.start.replace(":", "."));
        }
        public float getaFloatEnd() {
            return Float.parseFloat(this.end.replace(":", "."));
        }

    }
}
