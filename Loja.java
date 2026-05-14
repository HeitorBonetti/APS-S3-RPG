import java.util.Scanner;

public class Loja {
    private int estoquePocaoVida;
    private int estoquePocaoMana;
    private int pocaoVida;
    private int pocaoMana;
    // ^^ usando para poder ser utilizado no inventario para exibir no main e conseguir usar a pocao


    public Loja(int estoquePocaoVida, int estoquePocaoMana) {
        this.estoquePocaoVida = 1;
        this.estoquePocaoMana = 1;
    }

    public int getEstoquePocaoVida() {
        return estoquePocaoVida;
    }

    public int getEstoquePocaoMana() {
        return estoquePocaoMana;
    }

    public int getPocaoVida() {
        return pocaoVida;
    }

    public int getPocaoMana() {
        return pocaoMana;
    }

    public void setPocaoVida(int pocaoVida) {
        this.pocaoVida = pocaoVida;
    }

    public void setPocaoMana(int pocaoMana) {
        this.pocaoMana = pocaoMana;
    }

    public void mostrarLoja(Personagem p) {
        Scanner scanner = new Scanner(System.in);
        boolean naLoja = true;

        while (naLoja) {
            System.out.println("--- LOJA MISTERIOSA ---");
            System.out.println("Saldo: " + p.getMoedas() + " moedas");
            System.out.println("[1] Poção de Vida (10 moedas)");
            System.out.println("[2] Poção de Mana (10 moedas)");
            System.out.println("[3] Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (estoquePocaoVida == 0) {
                        System.out.println("Item sem estoque! Volte mais tarde!");
                    }
                    if (estoquePocaoVida > 0) {
                        if (p.getMoedas() >= 10) {
                            p.setMoedas(p.getMoedas() - 10);
                            estoquePocaoVida--;
                            System.out.println("Você comprou uma Poção de Vida!");
                            p.setQntdPocoesVida(p.getQntdPocoesVida() + 1);
                        } else {
                            System.out.println("Saldo insuficiente!");
                        }
                    }
                    break;

                case 2:
                    if (estoquePocaoMana <= 0) {
                        System.out.println("Item sem estoque! Volte mais tarde!");
                    }
                    if (estoquePocaoMana > 0) {
                        if (p.getMoedas() >= 10) {
                            p.setMoedas(p.getMoedas() - 10);
                            estoquePocaoMana--;
                            System.out.println("Você comprou uma Poção de Mana!");
                            p.setQntdPocoesMana(p.getQntdPocoesMana() + 1);
                        } else {
                            System.out.println("Saldo insuficiente!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Até logo!");
                    naLoja = false;
                    break;
            }
        }
    }
}