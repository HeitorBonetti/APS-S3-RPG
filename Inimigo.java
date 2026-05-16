public class Inimigo extends Personagem {

    public Inimigo(String nome, int pontosDeVida, int ataque, int defesa, int moedas, int nivel, int xpAoMorrer, int vidaMaxima, int mana, int manaMaxima) {
        super(nome, pontosDeVida, ataque, defesa, moedas, nivel, xpAoMorrer, vidaMaxima, mana, manaMaxima);
    }

    @Override
    public void defender(Personagem p) {
        System.out.println(this.getNome() + " defendeu o ataque de " + p.getNome());
        setMana(this.getMana() + 1);
    }

    @Override    
    public void atacar(Personagem p) {
    System.out.println(this.getNome() + " Atacou");
    System.out.println("");
    p.receberDano(this.getAtaque());
    }

    @Override
    public void especial(Personagem p) {
        int danoFinal;
        System.out.println(this.getNome() + " super ataque em " + p.getNome() + "!");

        danoFinal = this.getAtaque() * 2;
        p.setPontosDeVida(p.getPontosDeVida() - danoFinal);
        System.out.println(p.getNome() + " perdeu " + danoFinal + " de vida.");
        System.out.println(p.getNome() + " ainda possui " + p.getPontosDeVida() + " restante");
    }

    public static class Goblin extends Inimigo {
        public Goblin() {
            super("Goblin", 60, 15, 5, 10, 2, 200, 60, 30, 30);
        }
    }

    public static class Mimico extends Inimigo {
        public Mimico() {
            super("Mímico", 80, 30, 7, 15, 3, 300, 80, 90, 90);
        }
    }

    public static class Esqueleto extends Inimigo {
        public Esqueleto() {
            super("Esqueleto", 30, 20, 3, 5, 1, 100, 30, 15, 15);
        }
    }
}