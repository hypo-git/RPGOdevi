package EquipmentModel;

public enum Weapon implements Equippable {
    ASHBRINGER("Ashbringer", EquipmentType.WEAPONS, 99, 99, 0.19, 0.19),
    FROSTMOURNE("Frostmourne", EquipmentType.WEAPONS, 99, 99, 0.19, 0.19),
    ATIESH("Atiesh", EquipmentType.WEAPONS, 99, 99, 0.19, 0.19),
    THEBLACKHAND("The Black Hand", EquipmentType.WEAPONS, 99, 99, 0.19, 0.19),
    THEBLADEFIST("The Bladefist", EquipmentType.WEAPONS,99, 99, 0.19, 0.19),
    DOOMHAMMER("Doomhammer", EquipmentType.WEAPONS, 99, 99, 0.19, 0.19),
    DRAGONWRATH("Dragonwrath, Tarecgosa's Rest", EquipmentType.WEAPONS, 99, 99, 0.19, 0.19),
    FANGSOFTHEFATHER("Fangs of the Father", EquipmentType.WEAPONS, 99, 99, 0.19, 0.19),
    FELOMELORN("Felo'melorn", EquipmentType.WEAPONS, 99, 99, 0.19, 0.19),
    VALANYR("Val'anyr, Hammer of Ancient Kings", EquipmentType.WEAPONS, 99, 99, 0.19, 0.19),
    AZZINOTH("The Twin Blades of Azzinoth", EquipmentType.WEAPONS, 99, 99, 0.19, 0.19),
    GOREHOWL("Gorehowl", EquipmentType.WEAPONS, 99, 99, 0.19, 0.19);

    private final String weaponName;
    private final EquipmentType equipmentType;
    private final double powerBonus;
    private final double healthBonus;
    private final double hitChanceBonus;
    private final double critChanceBonus;

    Weapon(String weaponName, EquipmentType equipmentType, double powerBonus, double healthBonus, double hitChanceBonus, double critChanceBonus) {
        this.weaponName = weaponName;
        this.equipmentType = equipmentType;
        this.powerBonus = powerBonus;
        this.healthBonus = healthBonus;
        this.hitChanceBonus = hitChanceBonus;
        this.critChanceBonus = critChanceBonus;
    }

    public String getWeaponName() {
        return weaponName;
    }

    @Override
    public EquipmentType getType() {
        return this.equipmentType;
    }

    public double getHitChanceBonus() {
        return this.hitChanceBonus;
    }

    public double getCritChanceBonus() {
        return this.critChanceBonus;
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
    public String toString() {
        return String.format(
                "Weapon Name=%s | Power=%.2f | Health= %.2f | Hit Chance= %.2f | Crit Chance=%.2f",
                weaponName, powerBonus, healthBonus, hitChanceBonus, critChanceBonus
        );
    }
}
