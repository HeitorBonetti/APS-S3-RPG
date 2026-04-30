public class Mago extends Personagem {

    public Mago(String nome) {
        super(nome, 70, 30, 8);
    }

    public Mago(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa);
    }

    @Override
    public void atacar(Personagem inimigo) {
        System.out.println(this.getNome() + " Bola de Fogo!");
        System.out.println("");
        inimigo.receberDano(this.getAtaque() + 10);
    }

    public void exibirFicha() {
        System.out.println("------------------------");
        System.out.println("Classe: Mago");
        System.out.println("Nome: " + this.getNome());
        System.out.println("HP: " + this.getPontosDeVida());
        System.out.println("ATK: " + this.getAtaque());
        System.out.println("DEF: " + this.getDefesa());
        System.out.println("------------------------");
    }
}
