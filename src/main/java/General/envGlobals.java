package General;

import java.util.ArrayList;
import java.util.List;


public class envGlobals {

    public static String fajrTimeBefore = "";
    public static String fajrTimeAfter = "";

    public static String dhuhrTimeBefore = "";
    public static String dhuhrTimeAfter = "";

    public static String asrTimeBefore = "";
    public static String asrTimeAfter = "";

    public static String magribTimeBefore = "";
    public static String magribTimeAfter = "";

    public static String ishaTimeBefore = "";
    public static String ishaTimeAfter = "";

    public static String hijriDateBefore = "";
    public static String hijriDateAfter = "";

    public static List<String> prayerTimes = new ArrayList<>();

//    public static String userLoginEmail = "ahsan.khan@venturedive.com";
//    public static String userLoginEmail = "javeria.ashraf@venturedive.com";
    public static String userLoginEmail = "ay.asfand+562@gmail.com";

//    public static String userLoginPassword = "street14@";
//    public static String userLoginPassword = "test123";
    public static String userLoginPassword = "12345";


    public static String dateToSet = "111922002019.00";
    public static String changeDateTimeCommand = "adb shell settings put global auto_time 0 && adb shell date "+dateToSet+" set && adb shell am broadcast -a android.intent.action.TIME_SET";
    public static String setCurrentDateTimeCommand = "adb shell settings put global auto_time 1 && adb shell am broadcast -a android.intent.action.TIME_SET";


    public final static String[] previousLahoreTimes = {"5:09 AM", "6:32 AM","11:48 AM","3:26 PM", "5:03 PM","06:27 PM","01:07 AM"};

    public static int logFajr = 3;
    public static int logDhuhr = 7;
    public static int logAsr = 9;
    public static int logMagrib = 11;
    public static int logIsha = 13;


    public static String[] monthNamesList = { "January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December" };


    public static String nov19IslamicDate = "22nd Rabi Al-Awwal 1441";
    public static String nov19IslamicMonths = "Rabi Al-Awwal 1441 - Rabi Al-Akhar 1441";
    public static String georgianMonth = "November 2019";
    public static String islamicMonth = "Rabi Al-Awwal 1441";
    public static String georgianMonths = "October 2019 - November 2019";


    public static String nov1stDate = "1";
    public static String nov1stIslamicDate = "4";

    public static String nov30Date = "30";
    public static String nov30IslamicDate = "3";


    // CalculationMethod before
    public static String alreadyMethod = "";

    //19th November prayerTimes for NewYork and Lahore (Android)
    public static String[] previousPrayerTimesNY = {"01:10 AM","02:15 PM","04:36 PM","05:29 AM","05:55 PM","06:47 AM","11:42 AM"};
    public static String[] previousPrayerTimesLHR = {"01:07 AM","03:26 PM","05:03 PM","05:09 AM","06:27 PM","06:32 AM","11:48 AM"};


    //Data to verify on calendar list for Android
    public static String[] eventMonths = {"Nov", "Apr", "May", "May", "Jul", "Jul","Jul"};
    public static String[] daysLeft = {"Today", "157 days left", "176 days left", "187 days left", "253 days left","254 days left"};
    public static String[] islamicDays = {"22nd Rabi Al-Awwal 1441", "First Day of Ramadan", "Lailat-ul-Qadr - First", "Eid-ul-Fitr", "Hajj Starting Day", "Arafa Day","Eid-ul-Adha"};
    public static String[] eventDates = {"19", "24", "13", "24", "29", "30","31"};
    public static String[] islamicDates = {"1st Ramadan, 1441", "20th Ramadan, 1441", "1st Shawwal, 1441", "8th Dhul-Hijjah, 1441", "9th Dhul-Hijjah, 1441","10th Dhul-Hijjah, 1441"};


    //Data to verify on calendar list on iOS
    public static String[] iOS_Dates = {"19  Nov", "24  Apr", "13  May", "24  May", "29  Jul", "30  Jul","31  Jul"};
    public static String[] iOS_Days = {"22 Rabi Al-Awwal, 1441","Today","First Day of Ramadan","1 Ramadan 1441","157  days left","Lailat-ul-Qadr - First","20 Ramadan 1441","176  days left","Eid-ul-Fitr","1 Shawwal 1441","187  days left","Hajj Starting Day","8 Dhul-Hijjah 1441","253  days left","Arafa Day","9 Dhul-Hijjah 1441","254  days left","Eid-ul-Adha","10 Dhul-Hijjah 1441","255  days left","29  Aug","Day of Aashoraa","10 Muharram 1442","284  days left"};

    //Time to adjust
    public static String[] adjustedTime = {"1 minute","0 minute","-1 minute"};
    public static String[] re_adjustedTime = {"0 minute","0 minute","0 minute"};

    //Weekly times
    public final static String[] prayersTimeToday = {"01:07 AM","03:26 PM","05:03 PM","05:09 AM","06:27 PM","06:32 AM","11:48 AM"};
    public final static String[] prayersTimeYES1 = {"01:05 AM","03:26 PM","05:03 PM","05:08 AM","06:28 PM","06:31 AM","11:48 AM"};
    public final static String[] prayersTimeYES2 = {"01:06 AM","03:27 PM","05:04 PM","05:08 AM","06:28 PM","06:30 AM","11:48 AM"};
    public final static String[] prayersTimeYES3 = {"01:05 AM","03:27 PM","05:05 PM","05:07 AM","06:28 PM","06:29 AM","11:48 AM"};


    public final static String[] prayersTimeTOM1 = {"01:07 AM","03:25 PM","05:03 PM","05:10 AM","06:27 PM","06:33 AM","11:48 AM"};
    public final static String[] prayersTimeTOM2 = {"01:08 AM","03:25 PM","05:02 PM","05:11 AM","06:27 PM","06:34 AM","11:49 AM"};
    public final static String[] prayersTimeTOM3 = {"01:08 AM","03:24 PM","05:02 PM","05:11 AM","06:26 PM","06:35 AM","11:49 AM"};


    public final static String[][] prayerTimesForWeekYES = {prayersTimeToday,prayersTimeYES1,prayersTimeYES2,prayersTimeYES3};
    public final static String[][] prayersTimesForWeekTOM = {prayersTimeTOM1,prayersTimeTOM2,prayersTimeTOM3};


    //For Verification of Monthly PrayerTimes of Lahore
    public final static String[] prayersTime_1stNovLHR = {"03:37 PM","05:15 PM","05:25 AM","06:09 PM","1","11:47 AM","4","Fri"};
    public final static String[] prayersTime_30thNovLHR = {"03:22 PM","05:00 PM","05:47 AM","05:56 PM","11:51 AM","3","30","Sat"};

    public final static int for1stNov = 1;
    public final static int for30thNov = 31;


    public final static String islamicMonthOnMonthlyCard = "Rabi Al-Awwal 1441 - Rabi Al-Akhar 1441";
    public final static String cityOnMonthlyCard = "Prayer Times in Lahore";
    public final static String angleOnMonthlyCard = "Union of Islamic Organisations of France (UOIF)";


    //For iOS
    public static int iOslogFajr = 1;
    public static int iOslogDhuhr = 2;
    public static int iOslogAsr = 3;
    public static int iOslogMagrib = 4;
    public static int iOslogIsha = 5;



    public static String geoMonth = "November, 2019";
    public static String islamicMonthOnCalendar = "Rabi Al-Awwal - 1441 - Rabi Al-Akhar - 1441";









    //Weekly prayer times (Lahore) for iOS
    public final static String[] iOSprayersTimeToday = {"11:48 AM","1:07 AM","3:26 PM","5:03 PM","5:09 AM","6:27 PM","6:32 AM"};
    public final static String[] iOSprayersTimeYES1 = {"11:48 AM","1:05 AM","3:26 PM","5:03 PM","5:08 AM","6:28 PM","6:31 AM"};
    public final static String[] iOSprayersTimeYES2 = {"11:48 AM","1:06 AM","3:27 PM","5:04 PM","5:08 AM","6:28 PM","6:30 AM"};
    public final static String[] iOSprayersTimeYES3 = {"11:48 AM","1:05 AM","3:27 PM","5:05 PM","5:07 AM","6:28 PM","6:29 AM"};

    public final static String[] iOSprayersTimeTOM1 = {"11:48 AM","1:07 AM","3:25 PM","5:03 PM","5:10 AM","6:27 PM","6:33 AM"};
    public final static String[] iOSprayersTimeTOM2 = {"11:49 AM","1:08 AM","3:25 PM","5:02 PM","5:11 AM","6:27 PM","6:34 AM"};
    public final static String[] iOSprayersTimeTOM3 = {"11:49 AM","1:08 AM","3:24 PM","5:02 PM","5:11 AM","6:26 PM","6:35 AM"};


    //19th November prayerTimes for NewYork and Lahore (iOS)
    public static String[] iOSpreviousPrayerTimesNY = {"11:42 AM","1:10 AM","2:15 PM","4:36 PM","5:29 AM","5:55 PM","6:47 AM"};
    public static String[] iOSpreviousPrayerTimesLHR = {"11:48 AM","1:07 AM","3:26 PM","5:03 PM","5:09 AM","6:27 PM","6:32 AM"};


}

