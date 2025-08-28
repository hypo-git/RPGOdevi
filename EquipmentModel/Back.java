package EquipmentModel;

public enum Back implements Equippable{
    SHROUDOFRESOLVE("Ashjra'kamas, Shroud of Resolve", EquipmentType.BACK, 16, 16, 0.13, 0.11),
    REAPANDSOW("Reap and Sow", EquipmentType.BACK, 3, 5, 0.02, 0.03),
    DOORWAYTONOWHERE("Doorway to Nowhere", EquipmentType.BACK, 5, 6, 0.01, 0.01),
    BREATHOFYULON("Xing-Ho, Breath of Yu'lon", EquipmentType.BACK, 9, 8, 0.02, 0.03),
    FURYOFXUEN("Fen-Yu, Fury of Xuen", EquipmentType.BACK, 9, 8, 0.02, 0.03),
    FORTITUDEOFNIUZAO("Qian-Ying, Fortitude of Niuzao", EquipmentType.BACK, 9, 8, 0.02, 0.03),
    KINDNESSOFCHIJI("Jina-Kang, Kindness of Chi-Ji", EquipmentType.BACK, 9, 8, 0.02, 0.03)
    ;

    private final String backName;
    private final EquipmentType equipmentType;
    private final double powerBonus;
    private final double healthBonus;
    private final double hitChanceBonus;
    private final double critChanceBonus;

    Back(String backName, EquipmentType equipmentType, double powerBonus, double healthBonus, double hitChanceBonus, double critChanceBonus) {
        this.backName = backName;
        this.equipmentType = equipmentType;
        this.powerBonus = powerBonus;
        this.healthBonus = healthBonus;
        this.hitChanceBonus = hitChanceBonus;
        this.critChanceBonus = critChanceBonus;
    }
    @Override
    public EquipmentType getType() {
        return equipmentType;
    }

    @Override
    public double getPowerBonus() {
        return powerBonus;
    }

    @Override
    public double getHealthBonus() {
        return healthBonus;
    }

    @Override
    public double getHitChanceBonus() {
        return hitChanceBonus;
    }

    @Override
    public double getCritChanceBonus() {
        return critChanceBonus;
    }

    @Override
    public String toString() {
        return String.format(
                "Back Name=%s | Power=%.2f | Health= %.2f | Hit Chance= %.2f | Crit Chance=%.2f",
                backName, powerBonus, healthBonus, hitChanceBonus, critChanceBonus
        );
    }
}
