
import java.util.Random;

/**
 * @author : Shahd Abdellatif & Inaya
 * @since : 04/05/2025
 * This program simulate a turn-based battle game between two characters.
 */
public class Character
{
    private  String name;
    private int health;
    private  int strength;
    private  int speed;

    private static final int  BASE_ATTACK=10;
    private static final int BASE_HEAL=5;
    private static final int MAX_HEALTH=50;

    /**
     * Constructs a new Character with the specified name, strength, and speed.
     * Initial health is set to the maximum value.
     * @param name
     * @param strength
     * @param speed
     */
    public Character(String name,int strength,int speed)
    {
        this.name=name;
        this.strength=strength;
        this.speed=speed;
        this.health=MAX_HEALTH;

    }

    /**
     * This method is called when the character attack.
     * Their is a 10% chance to increase the damage done.
     * @param c
     * @return
     */
    public  int attack(Character c)
    {

        int damage = BASE_ATTACK+strength;
        Random rnd=new Random();
        int randNum=rnd.nextInt(10)+1;
        if(randNum==1)
        {
            System.out.print("** Critical Hit!** ");
            damage += 5;
        }
        c.takeDamage(damage);
        return damage;
    }

    /**
     * This method is called when the character is taking damage.
     * @param x
     */
    public void takeDamage(int x)
    {
        health-=x;

    }
    /**
     * This method is called when the character is healed
     * @return
     */
    public int heal()
    {
        int heal=BASE_HEAL+(2*speed);
        int healthLost=MAX_HEALTH-health;

        if(heal>healthLost)
            heal=healthLost;
        health+=heal;
        return heal;
    }

    /**
     * This method returns the name of the character.
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * This method returns the strengths for the characters
     * @return
     */
    public int getStrength()
    {
        return strength;

    }

    /**
     * This method returns the set value of speed
     * @return
     */
    public int getSpeed()
    {
        return speed;
    }

    /**
     * This method returns the health for the character
     * @return
     */
    public int getHealth()
    {
        return health;
    }

    /**
     * This method is to display each character with its characteristics
     */
    public String toString()
    {
        return name+"[Strength: "+strength+", Speed: "+speed+" ]";
    }
}
