import java.util.Random;
import java.util.Scanner;

public class Guerreiro extends Personagem {

    public Guerreiro(String nome) {
        super(nome, 120, 20, 15,0, 1,0, 120, 45, 45);
        this.Habilidades.add("Berserker");
    }

    public Guerreiro(String nome, int vida, int ataque, int defesa, int moedas, int nivel, int xpAoMorrer, int vidaMaxima, int mana, int manaMaxima) {
        super(nome, vida, ataque, defesa, moedas, nivel, xpAoMorrer, vidaMaxima, mana, manaMaxima);
    }

    @Override
    public void atacar(Personagem inimigo) {
        System.out.println(this.getNome() + " Golpe de espada!");
        System.out.println("");
        inimigo.receberDano(this.getAtaque() + 5);
    }

    @Override
    public void usarHabilidadeAtiva(int habilidadeLista, Personagem inimigo) {
        String nomeHabilidade = Habilidades.get(habilidadeLista);

        switch (nomeHabilidade) {
            case "Berserker": // habilidade inicial
                if (this.getMana() >= 10) {
                    inimigo.receberDano(this.getAtaque() + 5);
                    this.setMana(this.getMana() - 10);
                    System.out.println(this.getNome() + " ativou o modo Berserker!");
                } else {
                    System.out.println("Mana insuficiente!");
                }
                break;

            case "Frenzy": // habilidade da loja
                if (this.getMana() >= 40) {
                    inimigo.receberDano(40);
                    this.setMana(this.getMana() - 40);
                    System.out.println(this.getNome() + "congelou o inimigo!");
                } else {
                    System.out.println("Mana insuficiente!");
                }
                break;

            case "Demon-Frenzy": // nivel 5
                if (this.getMana() >= 35) {
                    inimigo.receberDano(80);
                    this.setMana(this.getMana() - 35);
                    System.out.println("....!");
                } else {
                    System.out.println("Mana insuficiente!");
                }
                break;

            case "Excalibur": // nivel 5
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
        System.out.println("[1] Recuperação de Vida");
        System.out.println("[2] mtaura +20 ataque");

        int escolha = sc.nextInt();
        if (escolha == 1) {
            Passivas.add("REGEN_HP");
        } else {
            Passivas.add("MAIS_ATQ");
            this.setAtaque(this.getAtaque() + 20);
        }
    }

    @Override
    public void escolherHabilidadeNivel5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- ESCOLHA SUPREMA DE GUERREIRO ---");
        System.out.println("[1] Demon-Frenzy\n[2] Excalibur");
        int escolha = sc.nextInt();
        if (escolha == 1) {
            Habilidades.add("Demon-Frenzy");
        } else {
            Habilidades.add("Excalibur");
        }
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
