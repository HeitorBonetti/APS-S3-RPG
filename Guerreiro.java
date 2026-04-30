public class Guerreiro extends Personagem {

    public Guerreiro(String nome) {
        super(nome, 120, 20, 15);
    }

    public Guerreiro(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa);
    }

    @Override
    public void atacar(Personagem inimigo) {
        System.out.println(this.getNome() + " Golpe de espada!");
        System.out.println("");
        inimigo.receberDano(this.getAtaque() + 5);
    }

    public void exibirFicha() {
        System.out.println("------------------------");
        System.out.println("Classe: Guerreiro");
        System.out.println("Nome: " + this.getNome());
        System.out.println("HP: " + this.getPontosDeVida());
        System.out.println("ATK: " + this.getAtaque());
        System.out.println("DEF: " + this.getDefesa());
        System.out.println("------------------------");
        
    }
}
