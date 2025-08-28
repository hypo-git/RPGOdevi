package EquipmentModel;

public enum Shoulder implements Equippable {
    TUSKSOFMANNAROTH("Tusks of Mannoroth", EquipmentType.SHOULDERS, 19, 19, 0.19, 0.19),
    THEFIRSTSATYRSSPAULDERS("The First Satyr's Spaulders", EquipmentType.SHOULDERS, 19, 19, 0.19, 0.19),
    HUNTERT11SHOULDERPADS("Lightning-Charged Spaulders", EquipmentType.SHOULDERS, 16, 16, 0.11, 0.09),
    DEMONSTALKERSHOULDERGUARDS("Hunter Demon Stalker Shoulderguards", EquipmentType.SHOULDERS, 16, 16, .11, .09),
    PALADINJUDGEMENTSPAULDERS("Paladin Judgement Spaulders", EquipmentType.SHOULDERS, 13, 13, .09, .03),
    BURDENOFMORTALITY("Burden of Mortality", EquipmentType.SHOULDERS, 9, 9, 0.08, 0.02),
    FANBLADEPAULDRONS("Fanblade Pauldrons", EquipmentType.SHOULDERS, 9, 9, 0.07, 0.03),
    SCOURGELORDPAULDRONS("Scourgelord Pauldrons", EquipmentType.SHOULDERS, 11, 13, 0.06, 0.09),
    TEMPORALPAULDRONS("Temporal Pauldrons", EquipmentType.SHOULDERS, 9, 8, 0.04, 0.04)
    ;
    private final String shoulderName;
    private final EquipmentType equipmentType;
    private final double powerBonus;
    private final double healthBonus;
    private final double hitChanceBonus;
    private final double critChanceBonus;

    Shoulder(String shoulderName, EquipmentType equipmentType, double powerBonus, double healthBonus, double hitChanceBonus, double critChanceBonus) {
        this.shoulderName = shoulderName;
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
                "Shoulder Name=%s | Power=%.2f | Health= %.2f | Hit Chance= %.2f | Crit Chance=%.2f",
                shoulderName, powerBonus, healthBonus, hitChanceBonus, critChanceBonus
        );
    }
}
