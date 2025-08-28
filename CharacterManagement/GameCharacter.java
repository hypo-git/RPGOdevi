package CharacterManagement;

import EquipmentModel.EquipmentType;
import EquipmentModel.Equippable;

public interface GameCharacter {
    String getName();
    double getTotalHealth();
    double getTotalPower();
    double getTotalHitChance();
    double getTotalCritChance();
    double getRemainingHealth();
    double getTotalDamageTaken();
    boolean isDead();

    void equip(Equippable item);
    void unequip(EquipmentType type);
    double attack(GameCharacter target);
    //double heal();
    void takeDamage(double damage);
}
