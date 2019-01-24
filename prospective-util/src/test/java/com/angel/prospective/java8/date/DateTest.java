package com.angel.prospective.java8.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author wanbf
 * @date 2019/1/4 13:57
 */
public class DateTest {
    @Test
    public void test01() throws InterruptedException, ExecutionException {
        // 构建时间格式化实例
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 构建一个时间任务
        Callable<Date> task = () -> sdf.parse("2018-04-27");

        // 构建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<Date>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(pool.submit(task));
        }
        for (Future<Date> future : list) {
            System.out.println(future.get());
        }
        pool.shutdown();
    }

    @Test
    public void test03() throws InterruptedException, ExecutionException{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Callable<LocalDate> task = () -> {
            LocalDate date = LocalDate.parse("2018-04-28", dtf);
            return date;
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<LocalDate>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(pool.submit(task));
        }

        for (Future<LocalDate> future : list) {
            System.out.println(future.get());
        }
        pool.shutdown();
    }

    @Test
    public void test04(){
        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalTime time = LocalTime.now();
        System.out.println("\n"+time);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("\n"+dateTime);
    }

    @Test
    public void test02() throws InstantiationException, IllegalAccessException{
        // now
        LocalDate date = LocalDate.now();
        System.out.println(date);

        // of
        LocalDate date2 = LocalDate.of(2018, 04, 29);
        System.out.println("\n"+date2);

        // plusDays,plusWeeks,plusMonths,plusYears
        LocalDateTime time = LocalDateTime.now();
        LocalDateTime time2 = time.plusDays(3);
        LocalDateTime time3 = time2.plusWeeks(3);
        LocalDateTime time4 = time3.plusMonths(3);
        LocalDateTime time5 = time4.plusYears(3);
        System.out.println("\n"+time);
        System.out.println(time2);
        System.out.println(time3);
        System.out.println(time4);
        System.out.println(time5);

        // plus, minus
        LocalDate date3 = LocalDate.now();
        LocalDate plus = date3.plus(Period.of(01, 04, 0));
        LocalDate minus = date3.minus(Duration.ZERO);
        System.out.println("\n"+plus);
        System.out.println(minus);

        // withDayOfMonth,withDayOfYear,withMonth,withYear
        LocalDate date4 = LocalDate.now();
        LocalDate dayOfMonth = date4.withDayOfMonth(11);
        LocalDate dayOfYear = date4.withDayOfYear(20);
        LocalDate month = date4.withMonth(3);
        LocalDate year = date4.withYear(2019);
        System.out.println("\n"+dayOfMonth);
        System.out.println(dayOfYear);
        System.out.println(month);
        System.out.println(year);

        // getDayOfMonth，getDayOfYear，getDayOfWeek，getMonth，getMonthValue，getYear
        LocalDate date5 = LocalDate.now();
        int dayOfMonth2 = date5.getDayOfMonth();
        int dayOfYear2 = date5.getDayOfYear();
        DayOfWeek dayOfWeek = date5.getDayOfWeek();
        Month month2 = date5.getMonth();
        int monthValue = date5.getMonthValue();
        int year2 = date5.getYear();
        System.out.println("\n"+dayOfMonth2);
        System.out.println(dayOfYear2);
        System.out.println(dayOfWeek);
        System.out.println(month2);
        System.out.println(monthValue);
        System.out.println(year2);

        // until
        LocalDate date6 = LocalDate.now();
        Period until = date6.until(LocalDate.now());
        System.out.println("\n"+until);

        // isBefore, isAfter
        LocalDate date7 = LocalDate.now();
        LocalDate date8 = LocalDate.of(2019, 05, 22);
        boolean before = date7.isBefore(date8);
        boolean after = date7.isAfter(date8);
        System.out.println("\n"+before);
        System.out.println(after);

        // isLeapYear
        LocalDate date9 = LocalDate.now();
        boolean year3 = date9.isLeapYear();
        System.out.println("\n"+year3);
    }

}
