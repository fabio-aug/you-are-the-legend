import java.util.Random;

public class Combat {
    private  Player player;
    private final Enemy enemy;

    public Combat(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public Player getPlayer() {
        return player;
    }

    public static Combat execute(Combat combat) {
        Player player = combat.getPlayer();
        Enemy enemy = combat.getEnemy();

        while (player.getLife() > 0 && enemy.getLife() > 0) {
            player.setLife(calculateDamage(enemy.getForce(), player.getLife()));// Enemy ataca
            showMessageCombat("enemy");

            enemy.setLife(calculateDamage(player.getForce(), enemy.getLife())); // PLayer ataca
            showMessageCombat("player");
        }

        if (combat.getEnemy().getLife() <= 0) return new Combat(combat.getPlayer(), null);

        return new Combat(combat.getPlayer(), combat.getEnemy());
    }

    private static int calculateDamage(int force, int life) {
        Random random = new Random();
        return life - (force / random.nextInt(5) + 1); // Balancear game
    }

    private static void showMessageCombat(String whoHit) {
        Random random = new Random();
        int rand = random.nextInt(5) + 1;
        switch (rand) {
            case 1:
                Interface.phrase1(whoHit);
                break;
            case 2:
                Interface.phrase2(whoHit);
                break;
            case 3:
                Interface.phrase3(whoHit);
                break;
            case 4:
                Interface.phrase4(whoHit);
                break;
            case 5:
                Interface.phrase5(whoHit);
                break;
            default:
                break;
        }
    }
}