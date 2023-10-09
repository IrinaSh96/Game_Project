package service;

import entity.Creature;
import entity.Monster;
import entity.Player;


import java.util.Scanner;


public class GameService {
    public void start() {
        Monster monster = new Monster("Satanas");
        monster.displayInfo();
        Player player = new Player("Hero");
        player.displayInfo();
        System.out.println(player.getName() + " против " + monster.getName());

        while (true) {
            makeTurn(player, monster); // метод: ход игрока
            if (isDead(monster)) {     // метод: проверка на смерть монстра
                System.out.println(player.getName() + " победил!");
                break;
            }
            makeTurn(monster, player); // метод: ход монстра
            if (isDead(player)) {  // метод: проверка на смерть игрока
                System.out.println(monster.getName() + " победил!");

                break;
            }
        }
    }

    public boolean isDead(Creature creature) {
        if (creature.getHealth() <= 0) {

            return true;
        }
        return false;
    }

// метод ход игрока
    public void makeTurn(Player player, Monster monster) {
        System.out.println("\nХод Героя. Выберите действие: \n1. Аттаковать, \n2. Восстановить жизнь");
        Scanner scan1 = new Scanner(System.in);
        int command = scan1.nextInt();
        if (command == 1) {
            int modAttack = player.getAttack() - monster.getDefense() + 1; // Модификатор атаки
            if (modAttack <1)
                modAttack = 1;
            System.out.println(player.getName() + " у вас " + modAttack + " попыток");
            do {
                if (rollDice()) {
                    monster.setHealth(monster.getHealth() - player.getDamage());
                    //Если удар успешен, то берется произвольное значение из параметра Урон атакующего и вычитается из Здоровья защищающегося
                    System.out.println(player.getName() + ", вы нанесли " + monster.getName() + " урон");
                    break;
                } else {
                    System.out.println("Ход не удался, удачи в следующий раз");
                }
                modAttack--;
            } while (modAttack != 0);

        } else if (command == 2) {
            player.heal(); // метод: исцеление игрока
        } else {
            System.out.println("Вы пропускаете ход, такого действия нет");
        }
        monster.displayInfo();
        player.displayInfo();
    }

    //метод: ход монстра

    public void makeTurn(Creature firstCreature, Creature secondCreature) {
        System.out.println("Ход " + firstCreature.getName());
        int modAttack = firstCreature.getAttack() - secondCreature.getDefense() + 1;
        if (modAttack <1)
            modAttack = 1;
        System.out.println(firstCreature.getName() + " у вас " + modAttack + " попыток");
        do {
            if (rollDice()) {
                secondCreature.setHealth(secondCreature.getHealth() - firstCreature.getDamage());
                System.out.println(firstCreature.getName() + ", вы нанесли " + secondCreature.getName() + " урон");
                break;
            } else {
                System.out.println("Ход не удался, удачи в следующий раз");
            }
            modAttack--;
        } while (modAttack != 0);
        firstCreature.displayInfo();
        secondCreature.displayInfo();
    }
//Успех определяется броском N кубиков с цифрами от 1 до 6,
// где N - это Модификатор атаки. Всегда бросается хотя бы один кубик.
    public boolean rollDice() {
        int playCube = 1 + (int) (Math.random() * (5));
        if (playCube == 6 || playCube == 5) {
            return true;
        }
        return false;
    }


}
