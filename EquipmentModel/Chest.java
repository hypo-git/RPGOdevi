package EquipmentModel;

public enum Chest implements Equippable{
    WARLORDSIRONBRESTPLATE("Warlord's Iron-Breastplate", EquipmentType.CHEST, 99, 99, 0.01, 0.01),
    ORNATEMITHRILBREASTPLATE("Ornate Mithril Breastplate", EquipmentType.CHEST, 99, 99, 0.01, 0.01),
    HYDRALICKARMOR("Hydralick Armor", EquipmentType.CHEST, 99, 99, 0.01, 0.01),
    GLORIOUSCHESTPLATE("Glorious Chest Plate", EquipmentType.CHEST, 99, 99, .04, 0.01),
    LOFTYBREASTPLATE("Lofty Breastplate", EquipmentType.CHEST, 99, 99, 0.01, 0.01),
    VANGUARDBREASTPLATE("Vanguard Breastplate", EquipmentType.CHEST, 99,99, 0.01, 0.01)
    ;

    private final String chestName;
    private final EquipmentType equipmentType;
    private final double powerBonus;
    private final double healthBonus;
    private final double hitChanceBonus;
    private final double critChanceBonus;

    Chest(String chestName, EquipmentType equipmentType, double powerBonus, double healthBonus, double hitChanceBonus, double critChanceBonus) {
        this.chestName = chestName;
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
                "Chest Name=%s | Power=%.2f | Health= %.2f | Hit Chance= %.2f | Crit Chance=%.2f",
                chestName, powerBonus, healthBonus, hitChanceBonus, critChanceBonus
        );
    }
}
