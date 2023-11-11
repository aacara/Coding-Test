package 백준.문자열;

import java.util.Scanner;

public class J13223_소금폭탄_fail {
  static String[] strArr;
  static int hourFrom, hourTo, hour;
  static int minuteFrom, minuteTo, minute;
  static int secondFrom, secondTo, second;
  static String stringHour, stringMinute, stringSecond;
  static boolean isMinus;
  
  public static void main(String[] args) {
   input();
  second = subtraction(secondFrom, secondTo, false);
  if (isMinus) {
    minuteTo -= 1;
    if (minuteTo == -1) {
      minuteTo = 59;
    }
  }
  minute = subtraction(minuteFrom, minuteTo, false);
  if (isMinus) {
    hourTo -= 1;
    if (hourTo == -1) {
      hourTo = 23;
    }
  }
  hour = subtraction(hourFrom, hourTo, true);

  
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

  static int subtraction(int from, int to, boolean isHour) {
    int result;
    if (from <= to) { 
      isMinus = false;
      result = to - from;
      if (isHour && result == 0) {
        result = 24;
      }
    } else {
      isMinus = true;
      result = 60 + (to - from);
      if (isHour) {
      result -= 36;
    }
    }
    
    return result;
  }

}
