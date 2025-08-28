import CharacterManagement.GameCharacter;

public class BattleThread implements Runnable{
    public GameCharacter player;
    public GameCharacter target;

    public long delay; //GCD

    public BattleThread(GameCharacter player, GameCharacter target, long delay){
        this.player = player;
        this.target = target;
        this.delay = delay;
    }

    @Override
    public void run() {
        while (!player.isDead() && !target.isDead()) {
            player.attack(target);
            try {
                Thread.sleep(delay);
            } catch (Exception e) {
                System.out.println("Hata (Thread): " + e.getMessage());;
            }
        }
    }
}
