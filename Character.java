import java.util.Random;
/**
 * @author: Shahd Abdellatif & Inaya
 * @since : 04/05/2025
 *
 */
public class Character
{
    private  String name;
    private  int health;
    private  int strength;
    private  int speed;

    private static final int  BASE_ATTACK=10;
    private static final int BASE_HEAL=5;
    private static final int MAX_HEALTH=50;

    public Character(String name,int strength,int speed)
    {
        this.name=name;
        this.strength=strength;
        this.speed=speed;
        this.health=MAX_HEALTH;

    }
    public  int attack(Character c)
    {
        
        int damage = BASE_ATTACK+strength;
        Random rnd=new Random();
        int randNum=rnd.nextInt(10)+1;
        if(randNum==1)
            damage+=5;
        c.takeDamage(damage);
        return damage;
    }
    public void takeDamage(int x)
    {
        health-=x;

    }

    public int heal()
    {
        int heal=BASE_HEAL+(2*speed);
        int healthLost=MAX_HEALTH-health;

        if(heal>healthLost)
            heal=healthLost;
        health+=heal;
        return heal;
    }

    public String getName()
    {
        return name;
    }

    public int getStrength()
    {
        return strength;

    }

    public int getSpeed()
    {
        return speed;
    }

    public int getHealth()
    {
        return health;
    }

    public String toString()
    {
        return name+"[Strength: "+strength+", Speed: "+speed+"]";
    }
}
