package entity;
public class Player extends Creature {

    private final int maxHealth;
    private final int restoreHealth;
    private int remainingHeal = 4;


    public Player(String name) {
        super(name);
        this.maxHealth = health;
        this.restoreHealth = (int) (maxHealth * 0.3);
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getRestoreHealth() {
        return restoreHealth;
    }

    public int getRemainingHeal() {
        return remainingHeal;
    }

    public void setRemainingHeal(int remainingHeal) {
        this.remainingHeal = remainingHeal;
    }

    public void heal() {
        if (health == maxHealth) {
            System.out.println("Ваша жизнь на максимуме.");
        } else if (health < maxHealth && remainingHeal > 0) {
            remainingHeal--;
            setHealth(health + restoreHealth);
            System.out.println("Вы вылечились на " + restoreHealth);
            if (health> maxHealth) {
                setHealth(maxHealth);
                System.out.println("Ваше здоровье стало " + maxHealth);
            }
        } else {
            System.out.println("Вы восстановили жизнь 4 раза. Попытки закончились.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Максимальное здоровье: " + maxHealth);
    }
}
