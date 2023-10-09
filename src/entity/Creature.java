package entity;

import util.RandomUtils;

public abstract class Creature {
    protected String name; // игрок или существо
    protected int attack; // атака
    protected int defense; // защита
    protected int minValue; // минимальное значение  M
    protected int maxValue; // максимальное значение N
    protected int damage; // урон (произвольное число от M-N)
    protected int health; // здоровье (произвольное значение от 1 до N)


    public Creature(String name) {
        this.name = name;
        this.attack = RandomUtils.getRandomValue();
        this.defense = RandomUtils.getRandomValue();
        this.minValue=40;
        this.maxValue=100;
        this.damage = getDamage();
        this.health = RandomUtils.getRandomValue(maxValue);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setProtect(int defense) {
        this.defense = defense;
    }

    public int getMinValueDamage() {
        return minValue;
    }

    public void setMinValueDamage(int minValueDamage) {
        this.minValue = minValueDamage;
    }

    public int getMaxValueDamage() {
        return maxValue;
    }


    public void setMaxValueDamage(int maxValueDamage) {
        this.maxValue = maxValueDamage;
    }

    public int getDamage() {
        return RandomUtils.getRandomValue(getMinValueDamage(), getMaxValueDamage());
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void displayInfo() {
        System.out.println("----------------\nСущество: " + getName() + "\n" +
                "Атака: " + getAttack() + "\n" +
                "Защита: " + getDefense() + "\n" +
                "Урон: " + getDamage() + "\n" +
                "Здоровье: " + getHealth());
    }


}
