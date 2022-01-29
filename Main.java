import java.util.*;

class Main {
  public static final int ARRAYSIZE = 99999;
  public static final Scanner sc = new Scanner(System.in);
  public static final Scanner sc2 = new Scanner(System.in);

  public static void main(String[] args) {
    User user1 = new User();
    String prompt = "0.show list  1.create task  2.create subtask  3.delete task  4.delete subtask  -1.end program -2.reset list";
    outerloop: while (true) {
      user1.displayList();
      System.out.println(prompt);
      String input = sc.nextLine();
      switch (input.toLowerCase()) {

        case "-2":
          System.out.print(ConsoleColors.RED_BOLD);
          System.out.println("are you sure? deleted lists CANNOT be resotred (y/n)");
          System.out.print(ConsoleColors.RESET);
          String resetInput = sc.nextLine();
          if (resetInput.toLowerCase().equals("y")) {
            user1.resetList();
          }
          break;

        case "-1":
          break outerloop;

        case "0":
          user1.displayList();
          break;

        case "1":
          System.out.println("What is the name of the task to be added?");
          input = sc.nextLine();
          user1.addTask(input);
          break;

        case "2":
          System.out.println("Where do you want to add a subtask (enter number of task)");
          int pointer = sc2.nextInt();
          System.out.println("What is the name of the subtask to be added");
          input = sc.nextLine();
          user1.addSubtask(input, pointer - 1);
          break;

        case "3":
          System.out.println("What task do you want delete? (enter number of task");
          int pointer2 = sc2.nextInt();
          user1.removeTask(pointer2 - 1);
          break;

        case "4":
          System.out.println("What task do you want to remove a subtask from (enter number of task");
          int pointer3 = sc2.nextInt();
          System.out.println("Which subtask do you want to rmeove? (enter number of subtask)");
          int pointer4 = sc2.nextInt();
          user1.removeSubtask(pointer3 - 1, pointer4);
          break;

      }

    }

  }
}
