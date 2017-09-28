package assignment1;

public class Main {


    public static void main(String args[]) throws IllegalPowerRankingException{
        CharacterDatabase data = new CharacterDatabase("data.dat");
        Character blackWidow = new Character("Blackwidow", "Is girl");
        data.add(blackWidow);
        return;
    }

}
