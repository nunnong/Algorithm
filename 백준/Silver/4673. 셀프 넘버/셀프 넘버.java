
public class Main {
  public static void main(String[] args) {

    int[] list = new int[10000];

    // 셀프넘버 후보 배열 (1 ~ 9999)
    for (int i = 0; i < 10000; i++) {
      list[i] = i;
    }

    for (int i = 1; i < 10000; i++) {
      int ans = func(i);
      if (ans >= 10000)
        continue;
      list[ans] = 0;
    }

    for (int num : list) {
      if (num != 0) {
        System.out.println(num);
      }
    }
  }

  public static int func(int num) {
    int sum = num;
    while (num >= 10) {
      sum += (num % 10);
      num /= 10;
    }
    sum += num;

    return sum;
  }
}
