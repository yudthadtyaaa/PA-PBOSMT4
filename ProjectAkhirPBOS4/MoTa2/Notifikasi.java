package MoTa2;

public abstract class Notifikasi {
    public abstract void scene();
}

    class Intro extends Notifikasi{
        public void scene(){
            String ANSI_RED = "\u001B[31m";
            String ANSI_RESET = "\u001B[0m";
            System.out.println(ANSI_RED + "███████████████████████████████");
            System.out.println("█▄─▀█▀─▄█─▄▄─█─▄─▄─██▀▄─██▀▄▄▀█");
            System.out.println("██─█▄█─██─██─███─████─▀─███▀▄██");
            System.out.println("█▄▄▄█▄▄▄█▄▄▄▄██▄▄▄██▄▄█▄▄█▄▄▄▄█");
            System.out.println("███████████████████████████████" + ANSI_RESET);
        }
    }

    class Victory extends Notifikasi{
        public void scene(){
            String ANSI_GREEN = "\u001B[32m";
            String ANSI_RESET = "\u001B[0m";
            System.out.println(ANSI_GREEN + "░█░█░▀█▀░█▀▀░▀█▀░█▀█░█▀▄░█░█");
            System.out.println("░▀▄▀░░█░░█░░░░█░░█░█░█▀▄░░█░");
            System.out.println("░░▀░░▀▀▀░▀▀▀░░▀░░▀▀▀░▀░▀░░▀░" + ANSI_RESET);
        }
    }

    class Defeat extends Notifikasi{
        public void scene(){
            String ANSI_RED = "\u001B[31m";
            String ANSI_RESET = "\u001B[0m";
            System.out.println(ANSI_RED + "░█▀▄░█▀▀░█▀▀░█▀▀░█▀█░▀█▀");
            System.out.println("░█░█░█▀▀░█▀▀░█▀▀░█▀█░░█░");
            System.out.println("░▀▀░░▀▀▀░▀░░░▀▀▀░▀░▀░░▀░" + ANSI_RESET);
        }
    }
