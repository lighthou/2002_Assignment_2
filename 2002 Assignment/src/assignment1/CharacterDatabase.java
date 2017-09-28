package assignment1;
import java.io.*;
import java.util.HashSet;


public class CharacterDatabase extends HashSet<Character> implements Serializable {
    private String fileName;

    public CharacterDatabase(String file) {
        fileName = file;
    }

    public void load() throws FileNotFoundException {
        try {
            FileInputStream f = new FileInputStream("C:\\" + fileName+".dat");
            ObjectInputStream charIn = new ObjectInputStream(f);
            HashSet<Character> hashSet = (CharacterDatabase) charIn.readObject();
            for (Character character : hashSet){
                this.add(character);
            }

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void save() {
        try{
            FileOutputStream f = new FileOutputStream("C:\\" + fileName+".dat");
            ObjectOutputStream charOut = new ObjectOutputStream(f);
            charOut.writeObject(this);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    @Override
    public boolean add(Character character) {
        try{
            this.add(character);
            System.out.println("ok");
            FileOutputStream f = new FileOutputStream("C:\\" + fileName+".dat");
            ObjectOutputStream charOut = new ObjectOutputStream(f);
            charOut.writeObject(this);
            //this.save();
            return true;
        } catch (IOException ioe){
            ioe.printStackTrace();
            return false;
        }
    }

    public void remove(Character character) {
        for (Character c : this){
            if (c.equals(character)){
                this.remove(c);
                this.save();
            }
        }
    }

    public Object search(Character character) {
        for (Character c : this){
            if (c.equals(character)){
                return c.clone();
            }
        }
        return null;
    }
}
