package practical.exam.paper;

import java.util.Scanner;

public class ManagePhoneBook {
  static PhoneBook pb = new PhoneBook();
  static Scanner scanner = new Scanner(System.in);
  static String name, phone;

  static void menu() {
    System.out.println("PHONEBOOK MANAGEMENT SYSTEM");//PHONEBOOK MANAGEMENT SYSTEM(HỆ THỐNG QUẢN LÝ SỔ ĐIỆN THOẠI)
    System.out.println("1. Insert phone");//Insert phone(Chèn điện thoại)
    System.out.println("2. Remove phone");//Remove phone(xóa điện thoại)
    System.out.println("3. Update phone");//Update phone(Cập nhật số điện thoại)
    System.out.println("4. Search phone");//earch phone(tìm kiếm số điện thoại)
    System.out.println("5. Sort");//Sort(loại)
    System.out.println("6. Exit");//Exit(thoát)
  }

  public static void main(String[] args) {
    menu();
    while (true) {
        System.out.print("Please choose an option: ");//Please choose an option(vui lòng chọn một lựa chọn)
      switch (scanner.nextInt()) {
        case 1:
          insertPhone();
          break;
        case 2:
          removePhone();
        case 3:
          updatePhone();
          break;
        case 4:
          searchPhone();
          break;
        case 5:
          sortPhone();
          break;
        case 6:
          return;
      }
    }
  }

  private static void removePhone() {
    scanner.nextLine();
    System.out.print("Input name of person you want to remove: ");//Input name of person you want to remove(Nhập tên của người bạn muốn xóa)
    name = scanner.nextLine();
    pb.removePhone(name);
  }

  private static void searchPhone() {
    scanner.nextLine();
    System.out.print("Please input name of person you want to search the phone: ");//Please input name of person you want to search the phone(Vui lòng nhập tên người muốn tìm điện thoại)
    name = scanner.nextLine();
    pb.searchPhone(name);
  }

  private static void updatePhone() {
    boolean searched = false;
    scanner.nextLine();
    System.out.print("Input name of person you want to update: ");//Input name of person you want to update(Nhập tên của người bạn muốn cập nhật)
    name = scanner.nextLine();
    for (String s : pb.PhoneList) {
      if (name.equals(s.substring(0, s.indexOf(",")))) {
        searched = true;
        System.out.print("Input phone number you want to update: ");//Input phone number you want to update(Nhập số điện thoại muốn cập nhật)
        phone = scanner.nextLine();
        pb.updatePhone(name, phone);
        break;
      }
    }
    if (!searched) System.out.println("Not found person with name : " + name);//Not found person with name(Không tìm thấy người có tên)
  }

  private static void sortPhone() {
    pb.sort();
  }

  private static void insertPhone() {
    scanner.nextLine();
    System.out.print("Input name: ");//Input name(nhập tên)
    name = scanner.nextLine();
    System.out.print("Input phone: ");//Input Phone(nhập số điện thoại)
    phone = scanner.nextLine();
    pb.insertPhone(name, phone);
  }
}
