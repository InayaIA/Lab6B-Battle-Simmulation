import java.util.Random;
import java.util.Scanner;

public class BattleSimmulator {
    public static void main(String[] args) {
        Character c1 = new Character("Gandolf the Grey ",3, 2);
        Character c2 = new Character("Dobby the Elf ", 2, 3); 

        Random rand = new Random();
        Scanner kbd = new Scanner(System.in);

        System.out.println("It's a dual to the death. Let's welcome our opponents: " + "\n" 
        + c1 + "\n" + "            AND \n" + c2);

        System.out.println("Let the battle commence! " + "\n" + "***************************************");
        kbd.nextLine();

        while (c1.getHealth() > 0 && c2.getHealth() > 0)
        {
        // Character 1's turn
            if (rand.nextInt(100) < 70)
            { // 70% chance to attack
                int damg = c1.attack(c2);
                System.out.println(c1.getName() + " ATTACKS! They inflict " + damg + " damage!");
            }
            else
            {
                int healed = c1.heal();
                System.out.println(c1.getName() + " HEALS. They gained " + healed + " health.");
            }

            // Character 2's turn
            if (c2.getHealth() > 0)
            {
                if (rand.nextInt(100) < 70) 
                {
                    int damg = c2.attack(c1);
                    System.out.println(c2.getName() + " ATTACKS! They inflict " + damg + " damage!");
                }
                else 
                {
                    int healed = c2.heal();
                    System.out.println(c2.getName() + " HEALS. They gained " + healed + " health.");
                }
            }
            System.out.println("-------------------");
            System.out.println("Current Status: \n" + c1.getName() + "health remaining: " +
            c1.getHealth() + "\n" + c2.getName() + "health remaning: " + c2.getHealth() + "\n");
            kbd.nextLine();
        }

        System.out.println("********************************");
        System.out.println("The battle has ended.");
        

        if (c1.getHealth() > 0 && c2.getHealth() <= 0)
        {
            System.out.println(c1.getName() + " has emegerd victorious!");
        }
        else if (c2.getHealth() > 0 && c1.getHealth() <= 0)
        {
            System.out.println(c2.getName() + " is triumphant this eve!");
        }
        else
        {
            System.out.println("Sadly, the dual has left them both dead.");
        }
    }
}
