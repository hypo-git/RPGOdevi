package EquipmentModel;

public enum Headpiece implements Equippable{

    SEVENTHLEGIONHEADPIECE("7th Legionnaire's Headpiece", EquipmentType.HEADPIECE, 9, 8, 0.11, 0.12),
    AZERITEHEADGEAR("AZ3-R1-T3 Gearspun Goggles", EquipmentType.HEADPIECE, 13, 11, 0.09, 0.06),
    ARACHNIDIANCIRCLET("Arachnidian Circlet", EquipmentType.HEADPIECE, 13, 11, 0.09, 0.02),
    REDDEFIASMASK("Red Defias Mask", EquipmentType.HEADPIECE, 11, 10, 0.08, 0.04),
    EYEOFREND("Eye of Rend", EquipmentType.HEADPIECE, 3, 5, 0.01, 0.01),
    DRAGONSTALKERHELM("Dragonstalker Helm", EquipmentType.HEADPIECE, 14, 11, 0.16, 0.11),
    LIONHEARTHELM("Lionheart Helm", EquipmentType.HEADPIECE, 13, 10, 0.16, 0.11),
    CRIMSONFELTHAT("Crimson Felt Hat", EquipmentType.HEADPIECE, 6, 4, 0.02, 0.03),
    BLOODFANGHOOD("Bloodfang Hood", EquipmentType.HEADPIECE, 16, 11, 0.16, 0.16),
    JUDGEMENTCROWN("Judgement Crown", EquipmentType.HEADPIECE, 19, 19, 0.19, 0.19),
    CROWNOFDESTRUCTION("Crown of Destruction", EquipmentType.HEADPIECE, 19, 19, 0.11, 0.11),
    NEMESISSKULLCAP("Nemesis Skullcap", EquipmentType.HEADPIECE, 14, 12, 0.10, 0.09);

    private final String headpieceName;
    private final EquipmentType equipmentType;
    private final double powerBonus;
    private final double healthBonus;
    private final double hitChanceBonus;
    private final double critChanceBonus;

    Headpiece(String headpieceName, EquipmentType equipmentType, double powerBonus, double healthBonus, double hitChanceBonus, double critChanceBonus) {
        this.headpieceName = headpieceName;
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

    public String getHeadpieceName() {
        return headpieceName;
    }


    @Override
    public String toString() {
        return String.format(
                "Headpiece Name=%s | Power=%.2f | Health= %.2f | Hit Chance= %.2f | Crit Chance=%.2f",
                headpieceName, powerBonus, healthBonus, hitChanceBonus, critChanceBonus
        );
    }
}
