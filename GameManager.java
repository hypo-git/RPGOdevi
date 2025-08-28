import CharacterManagement.*;

public class GameManager {
    Ork garrosh = new Ork("Garrosh", 2950, 195, 0.16, 0.09);
    Ejderha onyxia = new Ejderha("Onyxia", 4950, 195, 0.18, 0.05);

    public GameCharacter player;
    public GameCharacter target;
    public long delay;


    public GameCharacter createCharacter(int type, String name, double health, double power, double hitChance, double critChance){
        GameCharacter gameCharacter = null;
        //if 1: then it is warrior
        if (type == 1){
            gameCharacter = new Warrior(name, health, power, hitChance, critChance);
        } else if (type == 2) {
            //if 2: then it is a mage!
            gameCharacter = new Mage(name, health, power, hitChance, critChance);
        }

        return gameCharacter;
    }

    public void setPlayer(GameCharacter gameCharacter){
        this.player = gameCharacter;
    }

    public void startBattle(GameCharacter player, GameCharacter monster){
        Thread playerThread = new Thread(new BattleThread(player, monster, 1000));
        Thread monsterThread = new Thread(new BattleThread(monster, player, 1200));

        System.out.println("Savaş başlıyor...!");
        playerThread.start();
        monsterThread.start();

        try{
            playerThread.join();
            monsterThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (player.isDead() && monster.isDead()) {
            System.out.println("Çifte ölüm! Kimse kazanamadı.");
        } else if (player.isDead()) {
            System.out.println("Maalesef, oyuncu öldü!");
        } else {
            System.out.println("Tebrikler, canavar öldü!");
        }
    }
}
