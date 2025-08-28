package EquipmentModel;

public enum Bracer implements Equippable{
    ELEGANTBRACERSOFTHEOWL("Elegant Bracers of the Owl", EquipmentType.BRACERS, 16, 16, 0.13, 0.11),
    ELEGANTBRACERSOFTHEEAGLE("Elegant Bracers of the Eagle", EquipmentType.BRACERS, 16, 16, 0.13, 0.11),
    ELEGANTBRACERSOFTHEWHALE("Elegant Bracers of the Whale", EquipmentType.BRACERS, 16, 16, 0.13, 0.11),
    ELEGANTBRACERSOFTHESPIRIT("Elegant Bracers of the Spirit", EquipmentType.BRACERS, 16, 16, 0.13, 0.11),
    ELEGANTBRACERSOFTHESTAMINA("Elegant Bracers of the Stamina", EquipmentType.BRACERS, 16, 16, 0.13, 0.11),
    ELEGANTBRACERSOFTHEINTELLECT("Elegant Bracers of the Intellect", EquipmentType.BRACERS, 16, 16, 0.13, 0.11),
    ELEGANTBRACERSOFTHERESISTANCE("Elegant Bracers of the Resistance", EquipmentType.BRACERS, 16, 16, 0.13, 0.11),
    ELEGANTBRACERSOFTHEHEALING("Elegant Bracers of the Healing", EquipmentType.BRACERS, 16, 16, 0.13, 0.11)
    ;


    private final String bracerName;
    private final EquipmentType equipmentType;
    private final double powerBonus;
    private final double healthBonus;
    private final double hitChanceBonus;
    private final double critChanceBonus;

    Bracer(String bracerName, EquipmentType equipmentType, double powerBonus, double healthBonus, double hitChanceBonus, double critChanceBonus) {
        this.bracerName = bracerName;
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
                "Bracer Name=%s | Power=%.2f | Health= %.2f | Hit Chance= %.2f | Crit Chance=%.2f",
                bracerName, powerBonus, healthBonus, hitChanceBonus, critChanceBonus
        );
    }
}
