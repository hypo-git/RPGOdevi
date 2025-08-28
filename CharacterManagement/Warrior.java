package CharacterManagement;

public class Warrior extends AbstractCharacter{

    public Warrior(String name, double health, double power, double hitChance, double critChance){
        super(name, health, power, hitChance, critChance);
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
            // warrior crit damage = *2
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
}
