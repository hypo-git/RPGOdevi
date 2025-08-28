package EquipmentModel;

public interface Equippable {
    EquipmentType getType();
    double getPowerBonus();
    double getHealthBonus();
    double getHitChanceBonus();
    double getCritChanceBonus();
}
