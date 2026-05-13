public class Personagem {
    private String nome;
    private int pontosDeVida;
    private int ataque;
    private int defesa;
    private int moedas;
    private static final int EXPERIENCIA[] = {100, 200, 300, 400, 500};
    private int nivel = 1;
    private int xpAtual = 0;
    private int xpAoMorrer;

    // Constructor
    Personagem(String nome, int pontosDeVida, int ataque, int defesa, int moedas, int nivel, int xpAoMorrer) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.moedas = moedas;
        this.nivel = nivel;
        this.xpAoMorrer = xpAoMorrer;
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

    public void receberMoedas(Personagem inimigo) {
        if (inimigo.getNome().equals("Esqueleto")) {
            moedas += 5;
            System.out.println("Você derrotou o inimigo e ganhou " +  moedas + " moedas");
        }
        if (inimigo.getNome().equals("Goblin")) {
            moedas += 10;
            System.out.println("Você derrotou o inimigo e ganhou " +  moedas + " moedas");
        }
        if (inimigo.getNome().equals("Mímico")) {
            moedas += 15;
            System.out.println("Você derrotou o inimigo e ganhou " +  moedas + " moedas");
        }
    }

    private void evoluirNivel() {
        this.pontosDeVida += 5;
        this.ataque += 4;
        this.defesa += 2;
    }

    public void receberExp(int xp) {
        xpAtual += xp;
        while (nivel <= EXPERIENCIA.length && xpAtual >= EXPERIENCIA[nivel - 1]) {
            xpAtual -= EXPERIENCIA[nivel - 1];
            nivel++;
            System.out.println("Subiu de nível! " + "Agora você é nível " +  nivel);

            evoluirNivel();
        }
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

    public int getMoedas() {
        return moedas;
    }

    public int getNivel() {
        return nivel;
    }

    public int getXpAoMorrer() {
        return xpAoMorrer;
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

    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }
}