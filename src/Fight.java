import java.util.Random;

public class Fight {

    public static Combat execute(Combat combat) {
        while (combat.getPlayer().getLife() > 0 && combat.getEnemy().getLife() > 0) {
            combat.getPlayer().setLife(calculateDamage(combat.getEnemy().getForce(), combat.getPlayer().getLife()));
            combat.getEnemy().setLife(calculateDamage(combat.getPlayer().getForce(), combat.getEnemy().getLife()));
        }

        return new Combat(combat.getPlayer(),combat.getEnemy());
    }

    public static int calculateDamage(int force, int life) {
        Random random = new Random();
        return life - (force / random.nextInt(5) + 1);
    }
}
