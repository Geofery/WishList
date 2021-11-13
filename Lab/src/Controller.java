public class Controller {

  public void mainMenu() {
    Menu menu = new Menu();

    int choice;
    boolean keepRunning;

    do {
      keepRunning = true;
      menu.showMainMenu(ui);
      choice = ui.getScanInt();
      switch (choice) {
        case 1 ->;
        case 2 ->;
        case 3 -> ;
        case 4 -> ;
        case 5 -> ;
        case 6 -> ;
        case 9 -> {
          ui.displayGreen("If in doubt, swim it out.....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.displayGreen("The wetter the better....");
          try {
            Thread.sleep(2500);
          } catch (Exception e) {
          }
          ui.errorRed("Water you sinking aboat");
          try {
            Thread.sleep(1000);
          } catch (Exception e) {
          }
          ui.displayGreen("We do it dirty in the deep end !!! :D");
          keepRunning = false;
        }
      }
    } while (keepRunning);
  }
}

