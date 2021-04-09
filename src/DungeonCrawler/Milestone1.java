package DungeonCrawler;

import java.util.Random;
import java.util.Scanner;

public class Milestone1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //name of enemies
        String[] enemies = {"Reptile Princess Slayer", "Talking Walls", "Marcie", "Jack Frost", "The Riddler"};

        // enemy's max health points
        int maxEnemyHP = 100;
        //enemy can damage player this much
        int enemyDamage = 35;
        //player's max health points
        int playerHP = 100;
        // player can damage enemy this much
        int playerDamage = 50;
        int numHealthBoost = 3;
        int healthBoost = 15;
        String[] battleWeapons = {"fist", "kicking", "flame thrower", "knife", "heat gun"};
        //int healthBoostChance = 25; // percent
        Random random = new Random();

        System.out.println("Welcome to a version of Dungeon Crawler!");
        System.out.println("What is your name?");
        String name = input.nextLine();
        boolean running = true;


        GAME:
        while (running) {
            System.out.println("\t-----------------------------------------");
            int enemyHP = random.nextInt(maxEnemyHP);
            String enemy = enemies[random.nextInt(enemies.length)];
            /*String enemy = enemies[random.nextInt(enemies.length)];
           - this chooses a random character
            */
            System.out.println("\t# " + enemy + " has appeared #\n");

            while (enemyHP > 0) {
                System.out.println("\t " + name + ", your HP is at " + playerHP);
                System.out.println("\t " + enemy + "'s HP is at " + enemyHP);
                System.out.println("\n\t What is your move? ");
                System.out.println("\t #1. Attack");
                System.out.println("\t #2. Drink Health Potion");
                System.out.println("\t #3. Surrender");
                String option = input.nextLine();
                if (option.equalsIgnoreCase("1")) {
                    System.out.println("\tAre you ready to fight?");
                    int damageToPlayer;
                    int damageToEnemy;
                    System.out.println("\tWhat weapon would you like to use?");
                    System.out.println("\t#1. fist \n #2. kicking \n #3. flame thrower \n #4. knife \n " +
                                        "#5. heat gun");
                    option = input.nextLine();
                    if(option.equalsIgnoreCase("1")){
                        System.out.println("\tYou chose " + battleWeapons[1] + " as your weapon");
                        damageToEnemy = 10;
                        damageToPlayer = random.nextInt(enemyDamage);
                        playerHP -= playerDamage;
                        enemyHP -= enemyDamage;
                        System.out.println("\t You strike the " + enemy + " for " + damageToEnemy + " damage.");
                        System.out.println("\t You received " + damageToPlayer + " in the fight.");
                    } else if(option.equalsIgnoreCase("2")){
                        System.out.println("You chose " + battleWeapons[2] + " as your weapon");
                        damageToEnemy = 15;
                        damageToPlayer = random.nextInt(enemyDamage);
                        playerHP -= playerDamage;
                        enemyHP -= enemyDamage;
                        System.out.println("\t You strike the " + enemy + " for " + damageToEnemy + " damage.");
                        System.out.println("\t You received " + damageToPlayer + " in the fight.");
                    } else if(option.equalsIgnoreCase("3")) {
                        System.out.println("You chose " + battleWeapons[3] + " as your weapon");
                        damageToEnemy = 20;
                        damageToPlayer = random.nextInt(enemyDamage);
                        playerHP -= playerDamage;
                        enemyHP -= enemyDamage;
                        System.out.println("\t You strike the " + enemy + " for " + damageToEnemy + " damage.");
                        System.out.println("\t You received " + damageToPlayer + " in the fight.");
                    } else if(option.equalsIgnoreCase("4")){
                        System.out.println("You chose " + battleWeapons[4] + " as your weapon");
                        damageToEnemy = 25;
                        damageToPlayer = random.nextInt(enemyDamage);
                        playerHP -= playerDamage;
                        enemyHP -= enemyDamage;
                        System.out.println("\t You strike the " + enemy + " for " + damageToEnemy + " damage.");
                        System.out.println("\t You received " + damageToPlayer + " in the fight.");
                    } else if(option.equalsIgnoreCase("5")){
                        System.out.println("You chose " + battleWeapons[5] + " as your weapon");
                        damageToEnemy = 30;
                        damageToPlayer = random.nextInt(enemyDamage);
                        playerHP -= playerDamage;
                        enemyHP -= enemyDamage;
                        System.out.println("\t You strike the " + enemy + " for " + damageToEnemy + " damage.");
                        System.out.println("\t You received " + damageToPlayer + " in the fight.");
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println();

//                    int damageToPlayer = random.nextInt(playerDamage);
//                    int damageToEnemy = random.nextInt(enemyDamage);




                    if(playerHP < 1){
                        System.out.println("\t You have run out of health points! ");
                        break;
                    }
                } else if (option.equalsIgnoreCase("2")) {
                    /*this subtracts from number of health boosts left
                    and adds boost to your health
                     */
                    if(numHealthBoost> 0 ){
                        playerHP += healthBoost;
                        numHealthBoost--;
                        System.out.println("\tYou have used a health boost! You now have " + numHealthBoost +
                        " left in your inventory.\n\t You now have " + playerHP + " HP." +
                        "\n\t" + enemy + " now has " + enemyHP + " HP");
                    }else{
                        System.out.println("\t You have run out of health boost!");
                    }

                } else if (option.equalsIgnoreCase("3")) {
                    System.out.println("\t You run away from the " + enemy + ".");
                    continue GAME;
                } else {
                    System.out.println("Not a a valid option.");
                }
            }

            if(playerHP < 1){
                System.out.println("\tYour HP is too low to continue with the game.");
                break;
            }
            System.out.println("\t-----------------------------------------");
            System.out.println(enemy + " was defeated by you, " + name + "! Congrats! ");
            System.out.println("\t you have " + playerHP + " left");
            /*
            if(random.nextInt(100) < healthBoostChance){
                numHealthBoost++;
                sout("The " + enenmy+ "has dropped a health boost");
                sout("You now have " + numHealthBoost + " health boosts left");
`````
            }
             */
            System.out.println("\t-----------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("#1 Go to the next dungeon.");
            System.out.println("#2 End your time at the dungeon.");
            String option = input.nextLine();
            while(!input.equals("1")&& !input.equals("2")){
                System.out.println("\tInvalid command");
                option = input.nextLine();

            }
            if(input.equals("1")){
                System.out.println("You are now going to the next room. Good luck");
            }else if(input.equals("2")){
                System.out.println("You have exit the dungeon. See you next time.");
                break;
            }

            System.out.println("\tThank you for playing");
            System.out.println("\tSee you next time!");
            return;
        }





    }
}