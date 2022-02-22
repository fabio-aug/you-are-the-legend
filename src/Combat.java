import java.util.Random;

public class Combat {
    private static Player player;
    private static Mob enemy;

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

    public static Combat execute() {
        Random random = new Random();
        Interface.nameEnemy(enemy.toString());

        while (player.getLife() > 0 && enemy.getLife() > 0) {
            if (random.nextBoolean()) {
                player.setLife(calculateDamage(enemy.getForce(), player.getLife()));
                showMessageCombat("enemy");
                if (player.getLife() <= 0) break;
            } else {
                Interface.missAttack(true);
            }

            if (random.nextBoolean()) {
                enemy.setLife(calculateDamage(player.getForce(), enemy.getLife()));
                showMessageCombat("player");
                if (enemy.getLife() <= 0) break;
            } else {
                Interface.missAttack(false);
            }
        }

        if (enemy.getLife() <= 0 && enemy.getName().equals("Omicron \uD83E\uDDA0")) {
            Interface.youWin(player.toString());
        } else if (enemy.getLife() <= 0) {
            return new Combat(player, null);
        }

        player.setLife(0);
        Interface.youLose();
        return new Combat(player, enemy);
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