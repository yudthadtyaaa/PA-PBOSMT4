package MoTa2;

public class Action {
    public void action(){
        System.out.println("Hero beraksi");
    }
}

class Critical extends Action{
    @Override
    public void action(){
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        System.out.println(ANSI_RED + "CRITICAL DAMAGE" + ANSI_RESET);
    }
}

class Dodge extends Action{
    @Override
    public void action(){
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        System.out.println(ANSI_RED + "DODGE ATTACK" + ANSI_RESET);
    }
}

class Heal extends Action{
    @Override
    public void action(){
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_RESET = "\u001B[0m";
        System.out.println(ANSI_GREEN + "HEALING WOUND" + ANSI_RESET);
    }
}