import java.util.ArrayList;
import java.util.List;

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
    private int qntdPocoes = 0;
    private int qntdPocoesVida = 0;
    private int qntdPocoesMana = 0;
    private int vidaMaxima;
    protected int mana;
    protected int manaMaxima;
    protected List<String> Habilidades = new ArrayList<>();
    protected List<String> Passivas = new ArrayList<>();

    // Constructor
    Personagem(String nome, int pontosDeVida, int ataque, int defesa, int moedas, int nivel, int xpAoMorrer, int vidaMaxima, int mana, int manaMaxima) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.moedas = moedas;
        this.nivel = nivel;
        this.xpAoMorrer = xpAoMorrer;
        this.vidaMaxima = vidaMaxima;
        this.mana = mana;
        this.manaMaxima = manaMaxima;
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
        this.vidaMaxima += 5;
        this.ataque += 4;
        this.defesa += 2;
    }

    public void receberExp(int xp) {
        xpAtual += xp;
        while (nivel <= EXPERIENCIA.length && xpAtual >= EXPERIENCIA[nivel - 1]) {
            xpAtual -= EXPERIENCIA[nivel - 1];
            nivel++;
            System.out.println("Subiu de nível! " + "Agora você é nível " + nivel);

            evoluirNivel();
            if (this.nivel == 3) {
                this.escolherHabilidadeNivel3();
            } else if (this.nivel == 5) {
                this.escolherHabilidadeNivel5();
            }
        }
    }

    public void curar(int quantidade) {
        this.pontosDeVida += quantidade;
        if (this.pontosDeVida > this.vidaMaxima) {
            this.pontosDeVida = this.vidaMaxima;
        }
        System.out.println("HP atual: " + this.pontosDeVida + "/" + this.vidaMaxima);
    }

    public void recuperarMana(int quantidade) {
        this.mana += quantidade;
        if (this.mana > this.manaMaxima) {
            this.mana = this.manaMaxima;
        }
    }

    // usar habilidade ativa
    public void usarHabilidadeAtiva(int habilidadeLista, Personagem inimigo) {
        inimigo.receberDano(this.ataque);
    }

    public void escolherHabilidadeNivel3() {
    }

    public void escolherHabilidadeNivel5() {
    }

    public void passivasTurno() {
        if (Passivas.contains("REGEN_MANA")) {
            this.setMana(this.getMana() + 5);
            System.out.println("[PASSIVA] +5 Mana");
        }

        if (Passivas.contains("REGEN_HP")) {
            this.curar(3);
            System.out.println("[PASSIVA] +3 HP");
        }

        // opcional
        if (Passivas.contains("MAIS_ATQ")) {
            this.setAtaque(this.getAtaque() + 2);
        }

        if (Passivas.contains("MAIS_DEF")) {
            this.setDefesa(this.getDefesa() + 2);
            System.out.println("[PASSIVA] +2 DEF");
        }

        if (this.mana > this.manaMaxima) {
            this.mana = this.manaMaxima;
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

    public int getQntdPocoesVida() {
        return qntdPocoesVida;
    }

    public int getQntdPocoesMana() {
        return qntdPocoesMana;
    }

    public List<String> getHabilidades() {
        return Habilidades;
    }

    public List<String> getPassivas() {
        return Passivas;
    }

    public int getMana() {
        return mana;
    }

    public int getManaMaxima() {
        return manaMaxima;
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

    public void setQntdPocoesVida(int qntdPocoesVida) {
        this.qntdPocoesVida = qntdPocoesVida;
    }

    public void setQntdPocoesMana(int qntdPocoesMana) {
        this.qntdPocoesMana = qntdPocoesMana;
    }

    public void setHabilidades(List<String> habilidades) {
        Habilidades = habilidades;
    }

    public void setPassivas(List<String> passivas) {
        Passivas = passivas;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setManaMaxima(int manaMaxima) {
        this.manaMaxima = manaMaxima;
    }
}