package com.geektech;




import java.util.Random;

public class Main {

    public static String[] heroesNames = {"Liu Kang", "Jax", "Kung Lao"};
    public static int[] heroesHealth = {280, 280, 280};
    public static int[] heroesDamage = {20, 15, 25};
    public static String healerName = "Chen";  ///
    public static int healerHealth = 530;        ///// Основное Домашнее Задание!!!
    public static int healerAbility = 50;      ///
    public static String bossName = "Shao Kahn";
    public static int bossHealth = 900;
    public static int bossDamage = 50;
    public static int roundNumber = 0;
    public static String superDamageHero = "";
    public static String healed = "";   // Основное Домашнее Задание!!!

    public static void printStatistics() {
        System.out.println(bossName + " = health [" + bossHealth + "] | damage [" + bossDamage + "]");

        for(int i = 0; i < heroesNames.length; ++i) {
            String var10001 = heroesNames[i];
            System.out.println(var10001 + " = health [" + heroesHealth[i] + "] | damage [" + heroesDamage[i] + "]");
        }
        // Основное Домашнее Задание!!!
        System.out.println(healerName + " = health [" + healerHealth + "] | heal power [" + healerAbility + "]");
    }

    public static boolean isGameFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!! Mortal Kombat finished ");
            return true;
        } else {
            boolean allHeroesDead = true;
            int[] var1 = heroesHealth;
            int var2 = var1.length;

            for(int var4 = 0; var4 < var2; ++var4) {
                int heroHealth = var1[var4];
                if (heroHealth > 0) {
                    allHeroesDead = false;
                    break;
                }
            }   // Основное Домашнее Задание!!!
            if (healerHealth > 0){
                allHeroesDead = false;
            }

            if (allHeroesDead) {
                System.out.println(bossName + " Won!!!Mortal Kombat finished");
            }

            return allHeroesDead;
        }
    }

    public static void round() {
        ++roundNumber;
        System.out.println("______Round " + roundNumber + "______");
        bossDamage();
        superDamageHero = getHeroForDamageBossDefence();
        heroesDamage();
        healerAbility();  // Основное Домашнее Задание!!!
        healed = getHeroToHeal();  // Основное Домашнее Задание!!!
        printStatistics();
    }

    // Основное Домашнее Задание!!!
    public static void healerAbility() {

        Random random = new Random();
        int x = random.nextInt(5) + 2;

        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && heroesHealth[i] < 100 && healerHealth > 0) {
                if (healed == heroesNames[i]) {
                    heroesHealth[i] += healerAbility * x;
                    System.out.println("Healed = " + healed + " " + healerAbility * x);
                }
            }
        }
    }
    // Основное Домашнее Задание!!!
    public static String getHeroToHeal() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesNames.length);
        return heroesNames[randomIndex];
    }

    public static void bossDamage() {
        for(int i = 0; i < heroesHealth.length; ++i) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                heroesHealth[i] -= bossDamage;
            }
        }      // Основное Домашнее Задание!!!
        if (healerHealth > 0 && bossHealth > 0){
                healerHealth -= bossDamage;
            }
        // Основное Домашнее Задание!!!
        if (healerHealth < 0){
            healerHealth = 0;
        }


    }

    public static void heroesDamage() {
        Random random = new Random();
        int coeff = random.nextInt(9) + 2;

        for(int i = 0; i < heroesDamage.length; ++i) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                if (superDamageHero == heroesNames[i]) {
                    bossHealth -= heroesDamage[i] * coeff;
                    System.out.println("Super damage hero = " + superDamageHero + " " + heroesDamage[i] * coeff);
                } else {
                    bossHealth -= heroesDamage[i];
                }
            }

            if (heroesHealth[i] < 0) {
                heroesHealth[i] = 0;
            }

            if (bossHealth < 0) {
                bossHealth = 0;
            }
        }

    }

    public static String getHeroForDamageBossDefence() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesNames.length);
        return heroesNames[randomIndex];
    }

    public static void main(String[] args) {
        printStatistics();
        System.out.println("_____Mortal Kombat started____");

        while(!isGameFinished()) {
            round();
        }
    }

}
