package MoTa2;

public class Character {
    private String roleHero;
    private String namaHero;
    private int warnaHero;

    public Character(String namaHero, int warnaHero, String roleHero){
        this.roleHero = roleHero;
        this.namaHero = namaHero;
        this.warnaHero = warnaHero;
    }

    public String getRole(){
        return roleHero;
    }

    public String getNama(){
        return namaHero;
    }

    public int getWarna(){
        return warnaHero;
    }
}

class Hero extends Character{
    public int ATK;
    public Hero(String namaHero, int warnaHero, String roleHero, int ATK){
        super(namaHero, warnaHero, roleHero);
        this.ATK = ATK;
    }

    public int getATK(){
        return ATK;
    }

    public void setATK(int ATK){
        this.ATK = ATK;
    }
}
