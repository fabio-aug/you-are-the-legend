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
                Interface.missAttack(false);
            }

            if (random.nextBoolean()) {
                enemy.setLife(calculateDamage(player.getForce(), enemy.getLife()));
                showMessageCombat("player");
                if (enemy.getLife() <= 0) break;
            } else {
                Interface.missAttack(true);
            }
        }

        if (enemy.getLife() <= 0) {
            return new Combat(player, null);
        } else {
            player.setLife(0);
            return new Combat(player, enemy);
        }
    }

    private static int calculateDamage(int force, int life) {
        return life - force;
    }

    private static void showMessageCombat(String whoHit) {
        Random random = new Random();
        int rand = random.nextInt(5);

        Interface.combatPhrase(whoHit, rand);
    }
}