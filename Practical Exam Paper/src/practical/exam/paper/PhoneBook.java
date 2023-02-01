package practical.exam.paper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PhoneBook extends Phone {

  ArrayList<String> PhoneList = new ArrayList();

  @Override
  void insertPhone(String name, String phone) {
    boolean timThay = false;
    for (String s : PhoneList) {
      if (s.contains(name)) {
        timThay = true;
        if (!s.contains(phone)) {
          s += " : " + phone;
        } else {
          System.out.println("Danh bạ này đã có sẵn");
        }
      }
    }
    if (!timThay) {
      PhoneList.add(name + "," + phone);
    }
  }

  @Override
  void removePhone(String name) {
    boolean searched = false;
    for (String s : PhoneList) {
      if (name.equals(s.substring(0, s.indexOf(",")))) {
        searched = true;
        PhoneList.remove(s);
        System.out.println("Removed");//remove(gỡ bỏ)
        break;
      }
    }
    if (!searched) System.out.println("Not found person with name: " + name);//Not found person with name(Không tìm thấy người có tên)
  }

  @Override
  void updatePhone(String name, String newPhone) {
    String s = name;
    s = s.substring(0, s.indexOf(",")); //bỏ số điện thoại cũ (chỉ giữ lại tên)
    PhoneList.set(PhoneList.indexOf(s), s + "," + newPhone); //đưa sdt mới vào
    System.out.println("Updated");//Updated(cập nhập)
  }

  @Override
  void searchPhone(String name) {
    boolean searched = false;
    for (String s : PhoneList) {
      if (s.contains(name)) {
        searched = true;
        System.out.println(s.toString());
        break;
      }
    }
    if (!searched) System.out.println("Not found person");//Not found person(không tìm thấy người)
  }

  @Override
  void sort() {
    if (PhoneList.size() == 0) System.out.println("PhoneList is empty");//PhoneList is empty(Danh sách điện thoại trống)
    else {
      //
      Collections.sort(PhoneList, new Comparator<String>() {
        @Override
        public int compare(String s, String t1) {
          return s.compareTo(t1);
        }
      });
      System.out.println("Sort Ascending by name:");//Sort Ascending by name(sắp xếp tăng dàn theo tên)
      for (String s : PhoneList) {
        System.out.println(s);
      }
      //
      Collections.sort(PhoneList, new Comparator<String>() {
        @Override
        public int compare(String s, String t1) {
          return t1.compareTo(s);
        }
      });
      System.out.println("Sort Descending by name:");//Sort Descending by name(sắp xếp giảm dần theo tên )
      for (String s : PhoneList) {
        System.out.println(s);
      }
    }
  }
}
