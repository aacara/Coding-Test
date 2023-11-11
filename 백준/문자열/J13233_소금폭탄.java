package 백준.문자열;

import java.util.Scanner;

// 시분초에 대한 경우의 수를 일일이 생각하려하다보니 복잡해서
// 초로 변환 후 계산하기로 함

public class J13233_소금폭탄 {
  static String[] strArr;
  static int totalSecondsFrom, totalSecondsTo, totalSecondsDiff;
  static int hourFrom, hourTo, hour;
  static int minuteFrom, minuteTo, minute;
  static int secondFrom, secondTo, second;
  static String stringHour, stringMinute, stringSecond;
  static boolean isMinus;
  
  public static void main(String[] args) {
   input();
   changeToTotalSeconds();
   subtraction();
   int hour = totalSecondsDiff / (60*60);
   totalSecondsDiff %= (60*60);
   int minute = totalSecondsDiff / 60;
   totalSecondsDiff %= (60);
   int second = totalSecondsDiff;

  
  stringHour = String.format("%02d", hour);
  stringMinute = String.format("%02d", minute);
  stringSecond = String.format("%02d", second);
  System.out.println(stringHour + ":" + stringMinute + ":" + stringSecond);
  }

  static void input() {
    Scanner scanner = new Scanner(System.in);
    String hourMinuteSecondFrom = scanner.nextLine();
    strArr = hourMinuteSecondFrom.split(":");
    hourFrom = Integer.parseInt(strArr[0]);
    minuteFrom = Integer.parseInt(strArr[1]);
    secondFrom = Integer.parseInt(strArr[2]);

    hourMinuteSecondFrom = scanner.nextLine();
    strArr = hourMinuteSecondFrom.split(":");
    hourTo = Integer.parseInt(strArr[0]);
    minuteTo = Integer.parseInt(strArr[1]);
    secondTo = Integer.parseInt(strArr[2]);

    scanner.close();
  }

  static void changeToTotalSeconds() {
    totalSecondsFrom = secondFrom + minuteFrom*60 + hourFrom*60*60;
    totalSecondsTo = secondTo + minuteTo*60 + hourTo*60*60;
  }

  static void subtraction() {
    totalSecondsDiff = totalSecondsTo - totalSecondsFrom;
    if (totalSecondsFrom >= totalSecondsTo) {
      totalSecondsDiff += 24*60*60;
    }
  }

}

