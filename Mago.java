import java.util.Scanner;

public class Mago extends Personagem {

    public Mago(String nome) {
        super(nome, 70, 30, 8, 0, 1, 0, 70, 100, 100);
        this.Habilidades.add("Ray Blast");
    }

    public Mago(String nome, int vida, int ataque, int defesa, int moedas, int nivel, int xpAoMorrer, int vidaMaxima, int mana, int manaMaxima) {
        super(nome, vida, ataque, defesa, moedas, nivel, xpAoMorrer, vidaMaxima, mana, manaMaxima);
    }

    @Override
    public void atacar(Personagem inimigo) {
        System.out.println(this.getNome() + " Bola de Fogo!");
        System.out.println("");
        inimigo.receberDano(this.getAtaque() + 10);
    }

    @Override
    public void usarHabilidadeAtiva(int habilidadeLista, Personagem inimigo) {
        String nomeHabilidade = Habilidades.get(habilidadeLista);

        switch (nomeHabilidade) {
            case "Ray Blast": // habilidade inicial
                if (this.getMana() >= 10) {
                    inimigo.receberDano(this.getAtaque() + 15);
                    this.setMana(this.getMana() - 10);
                    System.out.println(this.getNome() + " utilizou Ray Blast!");
                } else {
                    System.out.println("Mana insuficiente!");
                }
                break;

            case "Nevasca": // habilidade da loja
                if (this.getMana() >= 40) {
                    inimigo.receberDano(40);
                    this.setMana(this.getMana() - 40);
                    System.out.println(this.getNome() + "congelou o inimigo!");
                } else {
                    System.out.println("Mana insuficiente!");
                }
                break;

            case "Devastation": // nivel 5
                if (this.getMana() >= 35) {
                    inimigo.receberDano(80);
                    this.setMana(this.getMana() - 35);
                    System.out.println("DEVASTATION!");
                } else {
                    System.out.println("Mana insuficiente!");
                }
                break;

            case "Destruction": // nivel 5
                if (this.getMana() >= 35) {
                    inimigo.receberDano(80);
                    this.setMana(this.getMana() - 35);
                    System.out.println("DESTRUCTION!");
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
            Passivas.add("REGEN_MANA");
        } else {
            Passivas.add("REGEN_MANA");
            this.manaMaxima += 20;
        }
    }

    @Override
    public void escolherHabilidadeNivel5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- HABILIDADE SUPREMA ---");
        System.out.println("[1] Devastation\n[2] Destruction");
        int escolha = sc.nextInt();
        if (escolha == 1) {
            Habilidades.add("Devastation");
        } else {
            Habilidades.add("Destruction");
        }
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
