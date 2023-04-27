package MoTa2;

import java.io.IOException;

public class clearScreen {
    public void cls() throws InterruptedException, IOException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
