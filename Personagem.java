public class Personagem {
    private String nome;
    private int pontosDeVida;
    private int ataque;
    private int defesa;


    // Constructor
    Personagem(String nome, int pontosDeVida, int ataque, int defesa) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    // Atacar
    public void atacar(Personagem inimigo) {
        System.out.println(this.nome + "atacou" + inimigo + "!");

        inimigo.receberDano(this.ataque);
    }

    // levar dano e diminuir hp ⬇️
    public void receberDano(int danoRecebido) {
        int danoFinal;
        if ((danoRecebido - this.defesa) < 0) {
            danoFinal = 0;
        } else {
            danoFinal = danoRecebido - this.defesa;
        }


        this.pontosDeVida -= danoFinal;

        System.out.println(this.nome + " perdeu " + danoFinal + " de vida.");
        System.out.println(this.nome + " ainda possui " + this.pontosDeVida + " restante");
    }

    public void exibirFicha() {
        System.out.println("------------------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("HP: " + this.pontosDeVida);
        System.out.println("ATK: " + this.ataque);
        System.out.println("DEF: " + this.defesa);
        System.out.println("------------------------");
        
    }

    // Getter
    public String getNome() {
        return nome;
    }

    public int getPontosDeVida() {
        if (pontosDeVida < 0) {
            System.out.println("O HP não pode ser negativo.");
        }
        return pontosDeVida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    // Setter
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPontosDeVida(int pontosDeVida) {
        if (pontosDeVida < 0) {
            System.out.println("O HP não pode ser negativo.");
        }
        this.pontosDeVida = pontosDeVida;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
}
