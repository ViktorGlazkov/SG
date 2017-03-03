package fighter;

import area.Area;
import area.AreaStatistic;

import java.util.Random;

public class Fighter {
    private String name;
    private int strength;
    private int dexterity;
    private int intuition;
    private int hp;
    private Area battleArea;

    public Fighter(String name, int strength, int dexterity, int intuition) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intuition = intuition;
        hp = 100;
    }

    public void setBattleArea(Area battleArea) {
        this.battleArea = battleArea;
    }

    public void hit(Fighter fighter) {
        Random random = new Random();
        double critCoef = intuition / 100.0;
        int damage;

        if(random.nextDouble() < critCoef) {
            damage = strength * 2;
            AreaStatistic.hit(this, damage);
            fighter.critical(damage);

        } else {
            damage = random.nextInt(strength) + 1;
            AreaStatistic.hit(this, damage);
            fighter.damage(damage);
        }
    }

    public void damage(int damage) {
        Random random = new Random();
        double dodgeCoef = dexterity / 100.0;
        int realDamage = 0;

        if(random.nextDouble() < dodgeCoef) {
            realDamage = damage;
            this.hp -= realDamage;
            AreaStatistic.damage(this, realDamage);

        } else {
            AreaStatistic.dodge(this);
        }
    }

    public void critical(int damage) {
        AreaStatistic.criticalDamage(this, damage);
        this.hp -= damage;
    }

    public Fighter regenerate() {
        this.hp = 100;
        return this;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public Area getBattleArea() {
        return battleArea;
    }

    @Override
    public String toString() {
        return "\033[37m" + this.getName() + " " + "\033[32m" + this.getHp() + "hp";
    }
}