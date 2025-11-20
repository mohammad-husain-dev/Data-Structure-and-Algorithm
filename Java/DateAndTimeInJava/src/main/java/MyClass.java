import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class MyClass {

    public static void main(String[] args) {
        ///  finding no of days between two dates
//        LocalDate now = LocalDate.now();
//        LocalDate dob= LocalDate.of(1998, 8,7);
//
//        long days= ChronoUnit.DAYS.between(dob,now); /// using ChronoUnit.DAYS
//        Period period = Period.between(dob,now);
//        //System.out.println(period.getDays());
//
//        long months=ChronoUnit.MONTHS.between(dob,now);
//
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String date="08.07.1998";
////        LocalDate date1 = LocalDate.parse(date,formatter);
////        System.out.println(date1.getYear());
//
//        formatter= DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        LocalDate date2 = LocalDate.parse(date,formatter);
//        System.out.println(date2.getDayOfMonth() + " " + date2.getMonth()+" "+ date2.getYear());

//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        String date1="12-10-2015";
//        String date2="12-10-2025";
//
//        LocalDate d1=LocalDate.parse(date1, dtf);
//        LocalDate d2=LocalDate.parse(date2, dtf);
//
//        System.out.println("date1: "+d1);
//        System.out.println("date2: "+d2);
//
//        long days=Math.abs(ChronoUnit.DAYS.between(d1,d2));
//        System.out.println("days: "+days);
//          LocalDate dob = LocalDate.of(1998, 8,7);
//          LocalDate dod = dob.plusYears(70);
//          dod = dod.plusDays(10);
//          dod = dod.plusMonths(5);
//
//          System.out.println(dob);
//          System.out.println(dod);
//
//          long daysLived=ChronoUnit.DAYS.between(dob,dod);
//          System.out.println(daysLived);
//
//        LocalDateTime dobt = dob.atStartOfDay();
//        LocalDateTime dodt = dod.atStartOfDay();
//        long hoursLived=ChronoUnit.HOURS.between(dobt,dodt);
//        System.out.println(hoursLived);

        LocalTime localTime = LocalTime.of(15, 45);
        System.out.println(localTime);
//        LocalDate localDate = LocalDate.now();
//        LocalDateTime localDateTime = LocalDateTime.now();
    }
}
