public class Combat {
    private Player player;
    private Enemy enemy;

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
}