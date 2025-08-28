package EquipmentModel;

public enum Glove implements Equippable{
    HERBALISTSGLOVES("Herbalist's Gloves", EquipmentType.GLOVES, 1, 1, 0.01, 0.01),
    GUARDIANGLOVES("Guardian's Gloves", EquipmentType.GLOVES, 1, 1, 0.01, 0.01),
    ;

    private final String gloveName;
    private final EquipmentType equipmentType;
    private final double powerBonus;
    private final double healthBonus;
    private final double hitChanceBonus;
    private final double critChanceBonus;

    Glove(String gloveName, EquipmentType equipmentType, double powerBonus, double healthBonus, double hitChanceBonus, double critChanceBonus) {
        this.gloveName = gloveName;
        this.equipmentType = equipmentType;
        this.powerBonus = powerBonus;
        this.healthBonus = healthBonus;
        this.hitChanceBonus = hitChanceBonus;
        this.critChanceBonus = critChanceBonus;
    }

    @Override
    public EquipmentType getType() {
        return this.equipmentType;
    }

    @Override
    public double getPowerBonus() {
        return this.powerBonus;
    }

    @Override
    public double getHealthBonus() {
        return this.healthBonus;
    }

    @Override
    public double getHitChanceBonus() {
        return this.hitChanceBonus;
    }

    @Override
    public double getCritChanceBonus() {
        return this.critChanceBonus;
    }

    @Override
    public String toString() {
        return String.format(
                "Glove Name=%s | Power=%.2f | Health= %.2f | Hit Chance= %.2f | Crit Chance=%.2f",
                gloveName, powerBonus, healthBonus, hitChanceBonus, critChanceBonus
        );
    }
}
