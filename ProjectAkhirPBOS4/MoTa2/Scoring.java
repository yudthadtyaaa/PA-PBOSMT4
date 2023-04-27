package MoTa2;

public class Scoring implements Increment{
    private int score = 0;

    public void increment(int score){
        this.score = score + 1;
    }
    
    public int getScore(){
        return score;
    }

}
