import java.util.Random;

public class Combat {

    private Player player;
    private Enemy enemy;

    public Combat(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public static Combat fight(Player player, Enemy enemy) {
        return executeFight(player, enemy);
    }

    public static int calculateDamage(int force, int life) {
        Random random = new Random();
        return life - (force / random.nextInt(5) + 1);
    }

    public static Combat executeFight(Player player, Enemy enemy) {

        while (player.getLife() > 0 && enemy.getLife() > 0) {
            player.setLife(calculateDamage(enemy.getForce(), player.getLife()));
            enemy.setLife(calculateDamage(player.getForce(), enemy.getLife()));
        }

        return new Combat(player, enemy);
    }
}
