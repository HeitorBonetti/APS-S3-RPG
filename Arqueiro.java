import java.util.Random;
import java.util.Scanner;

public class Arqueiro extends Personagem{

    public Arqueiro(String nome) {
        super(nome, 90, 22, 12,0, 1,0, 90, 20, 20);
        this.Habilidades.add("Rj");
    }

    public Arqueiro(String nome, int vida, int ataque, int defesa, int moedas, int nivel, int xpAoMorrer, int vidaMaxima, int mana, int manaMaxima) {
        super(nome, vida, ataque, defesa, moedas, nivel, xpAoMorrer, vidaMaxima, mana, manaMaxima);
    }

    @Override
    public void atacar(Personagem inimigo) {
        Random random = new Random();
        System.out.println(this.getNome() + " Flecha disparada!");
        System.out.println("");
        inimigo.receberDano(this.getAtaque() + random.nextInt(11));
    }

    @Override
    public void usarHabilidadeAtiva(int habilidadeLista, Personagem inimigo) {
        String nomeHabilidade = Habilidades.get(habilidadeLista);

        switch (nomeHabilidade) {
            case "Rj": // habilidade inicial
                if (this.getMana() >= 10) {
                    Random random = new Random();
                    inimigo.receberDano(this.getAtaque() + random.nextInt(11));
                    this.setMana(this.getMana() - 10);
                    System.out.println(this.getNome() + " lançou Rj!");
                } else {
                    System.out.println("Mana insuficiente!");
                }
                break;

            case "Nullshot": // habilidade da loja
                if (this.getMana() >= 40) {
                    inimigo.receberDano(40);
                    this.setMana(this.getMana() - 40);
                    System.out.println(this.getNome() + "congelou o inimigo!");
                } else {
                    System.out.println("Mana insuficiente!");
                }
                break;

            case "All-Range": // nivel 5
                if (this.getMana() >= 35) {
                    inimigo.receberDano(80);
                    this.setMana(this.getMana() - 35);
                    System.out.println("....!");
                } else {
                    System.out.println("Mana insuficiente!");
                }
                break;

            case "Divine Arrow": // nivel 5
                if (this.getMana() >= 35) {
                    inimigo.receberDano(80);
                    this.setMana(this.getMana() - 35);
                    System.out.println("...!");
                } else {
                    System.out.println("Mana insuficiente!");
                }
                break;
        }
    }

    @Override
    public void escolherHabilidadeNivel3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n------ ESCOLHA UMA HABILIDADE PASSIVA ------");
        System.out.println("[1] Recuperação de Mana");
        System.out.println("[2] mtaura +20 mana maxima");

        int escolha = sc.nextInt();
        if (escolha == 1) {
            Passivas.add("REGEN_HP");
        } else {
            Passivas.add("REGEN_MANA");
            this.manaMaxima += 20;
        }
    }

    @Override
    public void escolherHabilidadeNivel5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- ESCOLHA SUPREMA DE GUERREIRO ---");
        System.out.println("[1] All-Range\n[2] Divine Arrow");
        int escolha = sc.nextInt();
        if (escolha == 1) {
            Habilidades.add("All-Range");
        } else {
            Habilidades.add("Divine Arrow");
        }
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
