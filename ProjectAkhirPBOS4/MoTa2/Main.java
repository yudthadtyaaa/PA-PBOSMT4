package MoTa2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)throws IOException, InterruptedException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        ArrayList<Character> listHero = new ArrayList<>();
        ArrayList<Hero> atkHero = new ArrayList<>();

        Intro intro = new Intro();
        intro.scene();
        System.out.println("█Tekan enter untuk masuk menu!!!█");

        try {
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        clearScreen cls = new clearScreen();
        cls.cls();
        mainMenu(listHero, atkHero);
    }

    static void ubahHero(ArrayList<Character> listHero, ArrayList<Hero> atkHero) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        Character hero = listHero.get(0);
        Hero hrx = atkHero.get(0);
        System.out.println("ATK: " + hrx.getATK());
        String ANSI_RESET = "\u001B[0m";
        if(hero.getWarna() == 1){
            String ANSI_RED = "\u001B[31m";
            System.out.println("Nickname : " + ANSI_RED + hero.getNama() + ANSI_RESET);
        } else if(hero.getWarna() == 2){
            String ANSI_GREEN = "\u001B[32m";
            System.out.println("Nickname : " + ANSI_GREEN + hero.getNama() + ANSI_RESET);
        } else{
            String ANSI_BLUE = "\u001B[34m";
            System.out.println("Nickname : " + ANSI_BLUE + hero.getNama() + ANSI_RESET);
        }
        System.out.println("Role : " + hero.getRole());
        
        System.out.println("Pilih yang ingin di ubah!");
        System.out.println("[1] Nickname");
        System.out.println("[2] Warna");
        System.out.println("[3] Role");
        System.out.println("[4] Damage (Developer Settings)");

        try {
            int select = Integer.parseInt(br.readLine());
            if(select == 1){
                // Character hero = listHero.get(0);
                System.out.println("Masukkan nickname baru : ");
                String namaHeroU = br.readLine();
                int warnaHeroU = hero.getWarna();
                String roleHeroU = hero.getRole();
        
                Character heroUpd = new Character(namaHeroU, warnaHeroU, roleHeroU);
                listHero.set(0, heroUpd);
            } else if(select == 2){
                // Character hero = listHero.get(0);
                System.out.println("Pilih warna baru: [1] [2] [3]");
                int warnaHeroU = Integer.parseInt(br.readLine());
                String namaHeroU = hero.getNama();
                String roleHeroU = hero.getRole();
                Character heroUpd = new Character(namaHeroU, warnaHeroU, roleHeroU);
                listHero.set(0, heroUpd);
            } else if(select == 3){
                System.out.println("[1] Fighter");
                System.out.println("Damage : 1.1x");
                System.out.println("Critical chance : 25%");
                System.out.println("=============================\n");
                System.out.println("[2] Assassin");
                System.out.println("Damage : 1.2x");
                System.out.println("Dodge chance : 50%");
                System.out.println("=============================\n");
                System.out.println("[3] Mage");
                System.out.println("Health : 1.1");
                System.out.println("Kemampuan : menyembuhkan diri");
                System.out.println("=============================\n");
                System.out.println("Tentukan role hero: ");
                select = Integer.parseInt(br.readLine());
                if(select == 1){
                    // Character hero = listHero.get(0);
                    String roleHeroU = "Fighter";
                    int warnaHeroU = hero.getWarna();
                    String namaHeroU = hero.getNama();
                    Character hr1 = new Character(namaHeroU, warnaHeroU, roleHeroU);
                    listHero.set(0, hr1);
                } else if(select == 2){
                    // Character hero = listHero.get(0);
                    String roleHeroU = "Assassin";
                    int warnaHeroU = hero.getWarna();
                    String namaHeroU = hero.getNama();
                    Character hr2 = new Character(namaHeroU, warnaHeroU, roleHeroU);
                    listHero.set(0, hr2);
                } else if(select == 3){
                    // Character hero = listHero.get(0);
                    String roleHeroU = "Mage";
                    int warnaHeroU = hero.getWarna();
                    String namaHeroU = hero.getNama();
                    Character hr3 = new Character(namaHeroU, warnaHeroU, roleHeroU);
                    listHero.set(0, hr3);
                } else{
                    System.out.println("Pilihan tidak tersedia silahkan coba lagi!");
                    ubahHero(listHero, atkHero);
                }
            } else if(select == 4){
                // Character hero = listHero.get(0);
                String namaHero = hero.getNama();
                int warnaHero = hero.getWarna();
                String roleHero = hero.getRole();
                int ATK = 30;
                Hero listATK = new Hero(namaHero, warnaHero, roleHero, ATK);
                // Hero hrx = atkHero.get(0);
                System.out.println("ATK: " + hrx.getATK());
                System.out.println("Masukkan ATK terbaru: ");
                int ATKbaru = Integer.parseInt(br.readLine());
                hrx.setATK(ATKbaru);
                mainMenu(listHero, atkHero);
            } else{
                System.out.println("Pilihan tidak tersedia");
                mainMenu(listHero, atkHero);
            }
        } catch (NumberFormatException e) {
            System.out.println("Input salah silahkan coba lagi!");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan silahkan coba lagi!");
        }
    }

    static void lihatHero(ArrayList<Character> listHero, ArrayList<Hero> atkHero) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        if(listHero.size() == 0){
            System.out.println("Silahkan membuat hero untuk melanjutkan bermain!");
            buatHero(listHero, atkHero);
        } else{
            Character hero = listHero.get(0);
            Hero hrx = atkHero.get(0);
            Scoring scoring = new Scoring();
            System.out.println("Monster terkalahkan: " + scoring.getScore());
            System.out.println("ATK: " + hrx.getATK());
            String ANSI_RESET = "\u001B[0m";
            if(hero.getWarna() == 1){
                String ANSI_RED = "\u001B[31m";
                System.out.println("Nickname : " + ANSI_RED + hero.getNama() + ANSI_RESET);
            } else if(hero.getWarna() == 2){
                String ANSI_GREEN = "\u001B[32m";
                System.out.println("Nickname : " + ANSI_GREEN + hero.getNama() + ANSI_RESET);
            } else{
                String ANSI_BLUE = "\u001B[34m";
                System.out.println("Nickname : " + ANSI_BLUE + hero.getNama() + ANSI_RESET);
            }
            System.out.println("Role : " + hero.getRole());
            mainMenu(listHero, atkHero);
        }
    }

    static void buatHero(ArrayList<Character> listHero, ArrayList<Hero> atkHero) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        if(listHero.size() == 0){
            System.out.println("Membuat hero baru");
            System.out.println("[1] Buat hero");
            System.out.println("[9] Kembali");
            int select = Integer.parseInt(br.readLine());
            if(select == 1){
                ;
            } else if(select == 9){
                mainMenu(listHero, atkHero);
            } else{
                System.out.println("Pilihan tidak tersedia!");
                mainMenu(listHero, atkHero);
            }

            
            System.out.println("Masukkan nickname: ");
            String namaHero = br.readLine();
            
            System.out.println("Pilih warna hero: [1]Merah [2]Hijau [3]Biru");
            int warnaHero = Integer.parseInt(br.readLine());
            if(warnaHero > 3){
                System.out.println("Tidak ada dalam pilihan");
                buatHero(listHero, atkHero);
            }
            System.out.println("[1] Fighter");
            System.out.println("Special abilities");
            System.out.println("Critical chance : 25%");
            System.out.println("=============================\n");
            System.out.println("[2] Assassin");
            System.out.println("Special abilities");
            System.out.println("Dodge chance : 75%");
            System.out.println("=============================\n");
            System.out.println("[3] Mage");
            System.out.println("Special abilities");
            System.out.println("Heal HP");
            System.out.println("=============================\n");
            System.out.println("Tentukan role hero: ");
            select = Integer.parseInt(br.readLine());
            if(select == 1){
                String roleHero = "Fighter";
                Character hr1 = new Character(namaHero, warnaHero, roleHero);
                listHero.add(hr1);
                int ATK = 30;
                Hero hrx = new Hero(namaHero, warnaHero, roleHero, ATK);
                atkHero.add(hrx);
            } else if(select == 2){
                String roleHero = "Assassin";
                Character hr2 = new Character(namaHero, warnaHero, roleHero);
                listHero.add(hr2);
                int ATK = 30;
                Hero hrx = new Hero(namaHero, warnaHero, roleHero, ATK);
                atkHero.add(hrx);
            } else if(select == 3){
                String roleHero = "Mage";
                Character hr3 = new Character(namaHero, warnaHero, roleHero);
                listHero.add(hr3);
                int ATK = 30;
                Hero hrx = new Hero(namaHero, warnaHero, roleHero, ATK);
                atkHero.add(hrx);
            } else{
                System.out.println("Pilihan tidak tersedia silahkan coba lagi!");
                buatHero(listHero, atkHero); 
            }
        } else{
            System.out.println("Anda sudah membuat hero!");
            System.out.println("Apakah ingin membuat hero baru?");
            System.out.println("[1] Ya");
            System.out.println("[2] Tidak");
            int select  = Integer.parseInt(br.readLine());
            if(select == 1){
                listHero.remove(0);
                buatHero(listHero, atkHero);
            } else if(select == 2){
                mainMenu(listHero, atkHero);
            }
        }

        mainMenu(listHero, atkHero);
    }

    static void mainMenu(ArrayList<Character> listHero, ArrayList<Hero> atkHero) throws IOException{

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        clearScreen cls = new clearScreen();

        while(true){
            Scoring scoring = new Scoring();
            System.out.println("[1] Mulai baru");
            System.out.println("[2] Mulai game");
            System.out.println("[3] Lihat hero");
            System.out.println("[4] Mengubah hero");
            System.out.println("[5] Keluar");
            System.out.println("Pilih Menu: ");

            try{
                int select = Integer.parseInt(br.readLine());
                if(select == 1){
                    buatHero(listHero, atkHero);
                    cls.cls();
                } else if(select == 2){
                    try{
                    bermain Bermain = new bermain();
                    cls.cls();
                    Bermain.action(listHero, atkHero);
                    } catch (NullPointerException e){
                        System.out.println("Objek kosong! Silakan buat hero terlebih dahulu.");
                        cls.cls();
                    } catch (Exception e){
                        System.out.println("Terjadi kesalahan saat memulai game. Silakan coba lagi.");
                        cls.cls();
                    }
                } else if(select == 3){
                    lihatHero(listHero, atkHero);
                    cls.cls();
                    break;
                } else if(select == 4){
                    ubahHero(listHero, atkHero);
                    cls.cls();
                    break;
                } else if(select == 5){
                    System.out.println("SAYONARA !!!");
                    System.exit(0);
                } else{
                    System.out.println("Menu tidak tersedia!");
                }
            } catch (NumberFormatException e){
                System.out.println("Input salah silahkan coba lagi!");
            } catch (IOException e){
                System.out.println("Terjadi kesalahan silahkan coba lagi!");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
