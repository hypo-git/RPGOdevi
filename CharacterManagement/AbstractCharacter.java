package CharacterManagement;

import EquipmentModel.EquipmentType;
import EquipmentModel.Equippable;

import java.util.EnumMap;
import java.util.Map;
import java.util.Random;

public abstract class AbstractCharacter implements GameCharacter {
    public static final Random RNG = new Random();
    public String characterName;
    private double health;
    private double power;
    private double hitChance;
    private double critChance;
    private double remainingHealth;
    public double damageTaken;

    private final Map<EquipmentType, Equippable> equipment = new EnumMap<>(EquipmentType.class);

    public AbstractCharacter(String characterName, double health, double power, double hitChance, double critChance) {
        this.characterName = characterName;
        this.health = health;
        this.power = power;
        this.hitChance = hitChance;
        this.critChance = critChance;
        this.remainingHealth = getTotalHealth();
        this.damageTaken = 0.0;
    }

    public void equip(Equippable item){
        equipment.put(item.getType(), item);
        remainingHealth = Math.min(remainingHealth + item.getHealthBonus(), getTotalHealth());
    }

    public void unequip(EquipmentType item){
        Equippable removed = equipment.remove(item);
        if (removed != null){
            remainingHealth = Math.max(0, remainingHealth - removed.getHealthBonus());
        }
    }

    public double getTotalHealth(){
        return health + equipment.values().stream()
                .mapToDouble(Equippable::getHealthBonus).sum();
    }

    public double getTotalPower(){
        return power + equipment.values().stream()
                .mapToDouble(Equippable::getPowerBonus).sum();
    }

    public double getTotalHitChance(){
        return hitChance + equipment.values().stream()
                .mapToDouble(Equippable::getHitChanceBonus).sum();
    }

    public double getTotalCritChance(){
        return critChance + equipment.values().stream()
                .mapToDouble(Equippable::getCritChanceBonus).sum();
    }

    public String getName(){
        return this.characterName;
    }

    public double attack(GameCharacter target){
        // saldırı kontrol
        double hitRoll = RNG.nextDouble();
        if (hitRoll >= getTotalHitChance()) {
            System.out.println("Saldıran(" + characterName + ") : Atak kaçtı! (" + hitRoll + " >= " + getTotalHitChance() + ")");
            return 0.0;
        }

        // kritik kontrol
        double damage = getTotalPower();
        double critRoll = RNG.nextDouble();
        boolean isCrit = critRoll < getTotalCritChance();
        if (isCrit) {
            damage *= 2;
            System.out.println("Saldıran(" + characterName + ") : Kritik hit! " + damage + " hasar verdi.");
        } else {
            System.out.println("Saldıran(" + characterName + ") : Normal hit. " + damage + " hasar verdi.");
        }

        target.takeDamage(damage);
        damageTaken += damage;

        System.out.println("Hedef(" + target.getName() + ") Kalan Can: " + target.getRemainingHealth());

        return damage;
    }


    public void takeDamage(double damage){
        remainingHealth -= damage;
        if (remainingHealth < 0){
            remainingHealth = 0;
        }
        System.out.println("Hedef, " + damage + " kadar zarar gördü!");
    }

    public double getRemainingHealth(){
        return remainingHealth;
    }

    public double getTotalDamageTaken(){
        return damageTaken;
    }

    public double getDamageTaken(){
        return damageTaken;
    }

    public boolean isDead(){
        return remainingHealth <= 0;
    }

    @Override
    public String toString() {
        return "Character{" +
                "characterName=" + characterName +
                ", health=" + getTotalHealth() +
                ", power=" + getTotalPower() +
                ", hitChance=" + getTotalHitChance() +
                ", critChange=" + getTotalCritChance() +
                ", equipment=" + equipment +
                '}';
    }
}
