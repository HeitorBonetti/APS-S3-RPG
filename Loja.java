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

    public void oferecerHabilidadeEspecial(Personagem p) {
        Scanner sc = new Scanner(System.in);

        if (p instanceof Mago) {
            System.out.println("Deseja comprar 'Nevasca' por 100 moedas? 1 - Sim, 2 - Não");
            int opcao = sc.nextInt();
            sc.nextLine();
            if (opcao == 1 && p.getMoedas() >= 100) {
                p.setMoedas(p.getMoedas() - 100);
                p.getHabilidades().add("Nevasca");
                System.out.println("Nevasca adquirida!");
            } else if (p.getMoedas() < 100) {
                System.out.println("Saldo insuficiente!");
            }
        }
        else if (p instanceof Guerreiro) {
            System.out.println("Deseja comprar 'Frenzy' por 100 moedas? 1 - Sim, 2 - Não");
            int opcao = sc.nextInt();
            sc.nextLine();
            if (opcao == 1 && p.getMoedas() >= 100) {
                p.setMoedas(p.getMoedas() - 100);
                p.getHabilidades().add("Frenzy");
                System.out.println("Frenzy adquirida!");
            } else if (p.getMoedas() < 100) {
                System.out.println("Saldo insuficiente!");
            }
        }
        else if (p instanceof Arqueiro) {
            System.out.println("Deseja comprar 'Nullshot' por 100 moedas?" + " 1 - Sim, 2 - Nao");
            int opcao = sc.nextInt();
            sc.nextLine();
            if (opcao == 1 && p.getMoedas() >= 100) {
                p.setMoedas(p.getMoedas() - 100);
                p.getHabilidades().add("Nullshot");
                System.out.println("Nullshot adquirida!");
            } else if (p.getMoedas() < 100) {
                System.out.println("Saldo insuficiente!");
            }
        }
    }

    public void mostrarLoja(Personagem p) {
        Scanner scanner = new Scanner(System.in);
        boolean naLoja = true;

        while (naLoja) {
            System.out.println("--- LOJA MISTERIOSA ---");
            System.out.println("Saldo: " + p.getMoedas() + " moedas");
            System.out.println("[1] Poção de Vida (10 moedas)");
            System.out.println("[2] Poção de Mana (10 moedas)");
            System.out.println("[3] Habilidade Especial");
            System.out.println("[4] Sair");

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

                    this.oferecerHabilidadeEspecial(p);
                    break;

                case 4:
                    System.out.println("Até logo!");
                    naLoja = false;
                    break;
            }
        }
    }
}