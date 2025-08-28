

import CharacterManagement.AbstractCharacter;
import EquipmentModel.*;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static GameManager manager = new GameManager();
    public static void main(String[] args) {



        while(true){
            System.out.println("====RPG Savaş Oyunu====");
            System.out.println("1- Yeni Karakter Oluştur\n2- Savaşa Gir\n3- Karakter Bilgilerini Görüntüle\n4- Oyunu Sonlandır");
            int userInput = input.nextInt();
            input.nextLine();
            switch (userInput){
                case 1:
                    createCharacterMenu();
                    break;
                case 2:
                    if (manager.player == null){
                        System.out.println("Önce karakter oluşturmanız gerekiyor!");
                        break;
                    }

                    System.out.println("Hangi canavarla savaşmak istersiniz?");
                    System.out.println("1- Ork");
                    System.out.println("2- Ejderha");
                    int choice = getIntUserInput("Seçiminiz: ");

                    switch (choice){
                        case 1 -> manager.startBattle(manager.player, manager.garrosh);
                        case 2 -> manager.startBattle(manager.player, manager.onyxia);
                        default -> System.out.println("Geçersiz Seçim!");
                    }

                    break;
                case 3:
                    if (manager.player == null){
                        System.out.println("Önce karakter oluşturmanız gerekiyor!");
                        break;
                    }
                    System.out.println(manager.player.toString());
                    break;
                case 4:
                    System.out.println("Oyundan çıkılıyor!...");
                    System.exit(0);
                    break;
            }

        }

    }

    public static void createCharacterMenu() {
        double healthMinValue = 200;
        double healthMaxValue = 2000;
        double powerMinValue = 100;
        double powerMaxValue = 399;
        double hitCritMinValue = 0.01;
        double hitCritMaxValue = 0.09;
        int type = getIntUserInput("Karakter tipini seçiniz: \n1- Savaşçı\n2- Büyücü");
        String name = getStringUserInput("Karakterinizin adını giriniz: ");
        double health = getHealthUserInput("Ne kadar cana sahip olmak istersiniz? " + healthMinValue + " - " + healthMaxValue+  " arası bir değer giriniz!", healthMinValue, healthMaxValue);
        double power = getPowerUserInput("Ne kadar güce sahip olmak istersiniz? " + powerMinValue + " - " + powerMaxValue+  " arası bir değer giriniz!", powerMinValue, powerMaxValue);
        double hitChance = getHitCritValue("Hit için ne kadar şanslı olmak istersiniz?" + hitCritMinValue + " - " + hitCritMaxValue + " arası bir değer giriniz!", hitCritMinValue, hitCritMaxValue);
        double critChance = getHitCritValue("Kritikal hit için ne kadar şanslı olmak istersiniz?" + hitCritMinValue + " - " + hitCritMaxValue + " arası bir değer giriniz!", hitCritMinValue, hitCritMaxValue);
        AbstractCharacter player = (AbstractCharacter) manager.createCharacter(type, name, health, power, hitChance, critChance);
        manager.setPlayer(player);
        System.out.println("Karakter oluşturuldu! Ekipman takmak ister misiniz? Süper seçenekler var!");
        equipMenu(player);
    }

    private static double getHitCritValue(String message, double hitCritMinValue, double hitCritMaxValue) {
        double userValue;
        while (true) {
            System.out.println(message);
            userValue = input.nextDouble();
            input.nextLine();
            if (userValue >= hitCritMinValue && userValue <= hitCritMaxValue) break;
            System.out.println("Geçerli bir değer giriniz!");
        }
        return userValue;
    }

    private static double getPowerUserInput(String message, double powerMinValue, double powerMaxValue) {
        double userValue;
        while (true) {
            System.out.println(message);
            userValue = input.nextDouble();
            input.nextLine();
            if (userValue >= powerMinValue && userValue <= powerMaxValue) break;
            System.out.println("Geçerli bir değer giriniz!");
        }
        return userValue;
    }

    public static String getStringUserInput(String message){
        System.out.println(message);
        return input.nextLine();
    }

    public static int getIntUserInput(String message){
        System.out.println(message);
        int userInput = input.nextInt();
        input.nextLine();
        return userInput;
    }

    public static double getHealthUserInput(String message, double healthMinValue, double healthMaxValue){
        double userValue;
        while (true) {
            System.out.println(message);
            userValue = input.nextDouble();
            input.nextLine();
            if (userValue >= healthMinValue && userValue <= healthMaxValue) break;
            System.out.println("Geçerli bir değer giriniz!");
        }
        return userValue;
    }

    public static void equipMenu(AbstractCharacter player) {
        Scanner input = new Scanner(System.in);
        for (EquipmentType type : EquipmentType.values()) {
            System.out.println("\n" + type + " için mevcut ekipmanlar:");
            Equippable[] items = getItemsForType(type);
            for (int i = 0; i < items.length; i++) {
                System.out.println((i+1) + "- " + items[i]);
            }

            int choice = -1;
            while (choice < 1 || choice > items.length) {
                System.out.println("Seçiminiz:");
                choice = input.nextInt();
                input.nextLine();
                if (choice < 1 || choice > items.length) {
                    System.out.println("Geçerli bir seçim yapın!");
                }
            }

            player.equip(items[choice - 1]);
            System.out.println(items[choice - 1] + " takıldı!");
        }

        System.out.println("\nTüm ekipmanlar takıldı! Şimdi savaşa hazırsınız!");
        System.out.println("Toplam Canınız: " + player.getTotalHealth());
        System.out.println("Toplam Gücünüz: " + player.getTotalPower());
    }

    public static Equippable[] getItemsForType(EquipmentType type) {
        return switch (type) {
            case CHEST -> Chest.values();
            case WEAPONS -> Weapon.values();
            case HEADPIECE -> Headpiece.values();
            case SHOULDERS -> Shoulder.values();
            case BACK -> Back.values();
            case BRACERS -> Bracer.values();
            case GLOVES -> Glove.values();
        };
    }





}
