import java.util.Random;

public class Arqueiro extends Personagem{

    public Arqueiro(String nome) {
        super(nome, 90, 22, 12);
    }

    public Arqueiro(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa);
    }

    @Override
    public void atacar(Personagem inimigo) {
        Random random = new Random();
        System.out.println(this.getNome() + " Flecha disparada!");
        System.out.println("");
        inimigo.receberDano(this.getAtaque() + random.nextInt(11));
    }

    public void exibirFicha() {
        System.out.println("------------------------");
        System.out.println("Classe: Arqueiro");
        System.out.println("Nome: " + this.getNome());
        System.out.println("HP: " + this.getPontosDeVida());
        System.out.println("ATK: " + this.getAtaque());
        System.out.println("DEF: " + this.getDefesa());
        System.out.println("------------------------");
    }
}
