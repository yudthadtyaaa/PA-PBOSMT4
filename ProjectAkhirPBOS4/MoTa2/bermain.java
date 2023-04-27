package MoTa2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class bermain {
    public static void main(String[] args)throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
    }

    static void action(ArrayList<Character> listHero, ArrayList<Hero> atkHero) throws IOException{

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        int hp = 100;
        int hp_musuh = 100;

        Character hero = listHero.get(0);
        String nama = hero.getNama();
        int warna = hero.getWarna();
        String role = hero.getRole();

        String ANSI_RESET = "\u001B[0m";

        if(warna == 1){
            String ANSI_RED = "\u001B[31m";
            System.out.println(ANSI_RED + "  ▐█" + ANSI_RESET + "          ░▄▄▄▄░");
            System.out.println(ANSI_RED + "  █ ▄" + ANSI_RESET + "          ▀▀▄██►");
            System.out.println(ANSI_RED + " ▐█▀" + ANSI_RESET + "          ▀▀███►");
            System.out.println(ANSI_RED + " ▌ ▌" + ANSI_RESET + "          ░▀███►░█►");
            System.out.println(ANSI_RED + "▐▄ ▐▄" + ANSI_RESET + "          ▒▄████▀▀");
        } else if(warna == 2){
            String ANSI_GREEN = "\u001B[32m";
            System.out.println(ANSI_GREEN + "  ▐█" + ANSI_RESET + "          ░▄▄▄▄░");
            System.out.println(ANSI_GREEN + "  █ ▄" + ANSI_RESET + "          ▀▀▄██►");
            System.out.println(ANSI_GREEN + " ▐█▀" + ANSI_RESET + "          ▀▀███►");
            System.out.println(ANSI_GREEN + " ▌ ▌" + ANSI_RESET + "          ░▀███►░█►");
            System.out.println(ANSI_GREEN + "▐▄ ▐▄" + ANSI_RESET + "          ▒▄████▀▀");
        } else{
            String ANSI_BLUE = "\u001B[34m";
            System.out.println(ANSI_BLUE + "  ▐█" + ANSI_RESET + "          ░▄▄▄▄░");
            System.out.println(ANSI_BLUE + "  █ ▄" + ANSI_RESET + "          ▀▀▄██►");
            System.out.println(ANSI_BLUE + " ▐█▀" + ANSI_RESET + "          ▀▀███►");
            System.out.println(ANSI_BLUE + " ▌ ▌" + ANSI_RESET + "          ░▀███►░█►");
            System.out.println(ANSI_BLUE + "▐▄ ▐▄" + ANSI_RESET + "          ▒▄████▀▀");
        }

        System.out.print(nama);
        System.out.println("      Monster");
        if(role == "Fighter"){
            System.out.println("Role kamu adalah " + role + ", gunakan special abilities untuk mendapat critical damage!");
        } else if(role == "Assassin"){
            System.out.println("Role kamu adalah " + role + ", gunakan special abilities untuk menghindari attack musuh!");
        } else{
            System.out.println("Role kamu adalah " + role + ", gunakan special abilities untuk menyembuhkan diri!");
        }
        System.out.println("Tekan enter untuk mulai main !!!");

        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < 100; i++){
            if(hp <= 0){
                Defeat defeat = new Defeat();
                defeat.scene();
                break;
            } else if(hp_musuh <= 0){
                Scoring scoring = new Scoring();
                scoring.increment(1);
                System.out.println("POINT +" + scoring.getScore());
                Victory victory = new Victory();
                victory.scene();
                break;
            } else{
                System.out.println("\n");
                System.out.println("HP:" + hp);
                System.out.println("HP musuh:" + hp_musuh);
                System.out.println("ACTION");
                System.out.println("[1] Attack");
                System.out.println("[2] Abilities");
                int select = Integer.parseInt(br.readLine());
                if(select  == 1){
                    Hero hrx = atkHero.get(0);
                    int maxHero = hrx.getATK();
                    int damage = (int)Math.floor(Math.random() * (maxHero - 10 + 1) + 10);
                    System.out.println("Damage: " + damage);
                    hp_musuh -= damage;
                    int maxMusuh = 20;
                    int damageMusuh = (int)Math.floor(Math.random() * (maxMusuh - 5 + 1) + 5);
                    System.out.println("Damage musuh: " + damageMusuh);
                    hp -= damageMusuh;
                }else if(select == 2){
                    if(role == "Fighter"){
                        // Probabilitas dodge (25%)
                        double probability = 0.25;
                        Random random = new Random();
                        boolean value = random.nextDouble() < probability;
                        if(value == false){
                            int maxHero = 30;
                            int damage = (int)Math.floor(Math.random() * (maxHero - 10 + 1) + 10);
                            hp_musuh -= damage;
                            System.out.println("Damage: " + damage);
                            int maxMusuh = 20;
                            int damageMusuh = (int)Math.floor(Math.random() * (maxMusuh - 5 + 1) + 5);
                            hp -= damageMusuh;
                            System.out.println("Attack: " + damageMusuh);
                        } else{
                            Critical criticalDMG = new Critical();
                            criticalDMG.action();
                            int maxHero = 65;
                            int damage = (int)Math.floor(Math.random() * (maxHero - 30 + 1) + 30);
                            hp_musuh -= damage;
                            System.out.println("Damage: " + damage);
                            int maxMusuh = 20;
                            int damageMusuh = (int)Math.floor(Math.random() * (maxMusuh - 5 + 1) + 5);
                            hp -= damageMusuh;
                            System.out.println("Attack: " + damageMusuh);
                        }
                    } else if(role == "Assassin"){
                        // Probabilitas dodge (75%)
                        double probability = 0.75;
                        Random random = new Random();
                        boolean value = random.nextDouble() < probability;
                        if(value == false){
                            int maxMusuh = 20;
                            int damageMusuh = (int)Math.floor(Math.random() * (maxMusuh - 5 + 1) + 5);
                            hp -= damageMusuh;
                            System.out.println("Attack: " + damageMusuh);
                        } else{
                            Dodge dodging = new Dodge();
                            dodging.action();
                        }
                    } else{
                        int heal = 25;
                        int cek_hp = heal + hp;
                        if(cek_hp > 100){
                            System.out.println("HP anda sudah penuh!");
                            int maxMusuh = 20;
                            int damageMusuh = (int)Math.floor(Math.random() * (maxMusuh - 5 + 1) + 5);
                            hp -= damageMusuh;
                            System.out.println("Attack: " + damageMusuh);
                        } else if(cek_hp == 100){
                            hp += heal;
                            System.out.println("+" + heal);
                            Heal healing = new Heal();
                            healing.action();
                            int maxMusuh = 20;
                            int damageMusuh = (int)Math.floor(Math.random() * (maxMusuh - 5 + 1) + 5);
                            hp -= damageMusuh;
                            System.out.println("Attack: " + damageMusuh);
                        } else{
                            hp += heal;
                            System.out.println("+" + heal);
                            Heal healing = new Heal();
                            healing.action();
                            int maxMusuh = 20;
                            int damageMusuh = (int)Math.floor(Math.random() * (maxMusuh - 5 + 1) + 5);
                            hp -= damageMusuh;
                            System.out.println("Attack: " + damageMusuh);
                        }
                    }
                }
            }
        }
    }
}
