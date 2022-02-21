import java.util.Random;

public class Combat {
    private Player player;
    private final Mob enemy;

    public Combat(Player player, Mob enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public Mob getEnemy() {
        return enemy;
    }

    public Player getPlayer() {
        return player;
    }

    public static Combat execute(Combat combat) {
        Player player = combat.getPlayer();
        Mob enemy = combat.getEnemy();

        Random random = new Random();
        Interface.nameEnemy(enemy.toString());

        while (player.getLife() > 0 && enemy.getLife() > 0) {
            if (random.nextBoolean()) {
                player.setLife(calculateDamage(enemy.getForce(), player.getLife()));
                if (player.getLife() == 0) break;
                showMessageCombat("enemy");
            } else {
                Interface.missAttack(true);
            }

            if (random.nextBoolean()) {
                enemy.setLife(calculateDamage(player.getForce(), enemy.getLife()));
                if (enemy.getLife() == 0) break;
                showMessageCombat("player");
            } else {
                Interface.missAttack(false);
            }
        }

        if (combat.getEnemy().getLife() <= 0 && combat.getEnemy().getName().equals("Omicron \uD83E\uDDA0")) {
            Interface.youWin(player.toString());
        } else if (combat.getEnemy().getLife() <= 0) {
            return new Combat(combat.getPlayer(), null);
        }

        combat.getPlayer().setLife(0);
        Interface.youLose();
        return new Combat(combat.getPlayer(), combat.getEnemy());
    }

    private static int calculateDamage(int force, int life) {
        return life - force;
    }

    private static void showMessageCombat(String whoHit) {
        Random random = new Random();
        int rand = random.nextInt(5) + 1;

        if (rand == 1) Interface.phrase1(whoHit);
        if (rand == 2) Interface.phrase2(whoHit);
        if (rand == 3) Interface.phrase3(whoHit);
        if (rand == 4) Interface.phrase4(whoHit);
        if (rand == 5) Interface.phrase5(whoHit);
    }
}