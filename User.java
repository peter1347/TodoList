import java.util.*;

public class User {
  private int arrsize = Main.ARRAYSIZE; // links all instances of the array slize
  private ArrayList<String>[] list = new ArrayList[arrsize];

  User() {
    //System.out.println("Constructor runs");
    //System.out.println(arrsize);
    for (int i = 0; i < arrsize; i++) {
      list[i] = new ArrayList<>();
    } // initalizes the arraylsit[]

  }

  public void resetList(){
     for (int i = 0; i < arrsize; i++) {
      list[i] = new ArrayList<>();
    } // initalizes the list
    System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"List Successfully reset"+ConsoleColors.RESET);
  }

  public void addTask(String task) {
    int counter = 0;
    outerloop: for (int i = 0; i < arrsize; i++) {
      //System.out.println(i);
      if (list[i].isEmpty()) {
        counter = i;
        break outerloop;
      }
    }
    list[counter].add(task);
  }

  public void addSubtask(String sub, int index) {
    list[index].add(sub);

  }

  public void removeTask(int index) {
    list[index] = new ArrayList<>();
  }

  public void removeSubtask(int taskIndex, int subtaskIndex) {
    list[taskIndex].remove(subtaskIndex);
  }

  public void displayList() {
    //System.out.println(Arrays.deepToString(list));
    for (int i = 0; i < arrsize - 1; i++) {
      if (list[i].isEmpty() == false) {
        System.out.print(ConsoleColors.CYAN_UNDERLINED);
        System.out.println(i+1+"."+list[i].get(0));
        System.out.print(ConsoleColors.RESET);
        for (int j = 1; j < list[i].size(); j++) {
          System.out.print("\t");
          System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT);
          System.out.println("*"+list[i].get(j));
          System.out.print(ConsoleColors.RESET);

        }
      }
    }
  }

  public ArrayList[] getList() {
    return list;
  }

  public void setList(ArrayList[] list) {
    this.list = list;
  }

}