public class Guerreiro extends Personagem {

    public Guerreiro(String nome) {
        super(nome, 120, 20, 15,0, 1,0, 120);
    }

    public Guerreiro(String nome, int vida, int ataque, int defesa, int moedas, int nivel, int xpAoMorrer, int vidaMaxima) {
        super(nome, vida, ataque, defesa, moedas, nivel, xpAoMorrer, vidaMaxima);
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
