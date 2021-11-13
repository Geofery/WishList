public class Menu {
  private final String[] menuList = {"1. Play game", "2. Most picked hand", "3. BATTLE OF THE AI", "4. Quit"};
  UI ui = new UI();


  public void printMenu() {
    ui.printString("----------------------------------------");
    for (int i = 0; i < menuList.length; i++) {
      ui.printString(menuList[i]);
    }
    ui.printString("----------------------------------------");
  }




}
