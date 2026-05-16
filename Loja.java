import java.util.Scanner;

public class Loja {
    Scanner sc = new Scanner(System.in);

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

        if (p instanceof Mago) {
            System.out.print("\033[H\033[2J"); //Limpa Tela
            System.out.println("Deseja comprar 'Nevasca' por 100 moedas? 1 - Sim, 2 - Não");
            int opcao = sc.nextInt();
            sc.nextLine();
            if (opcao == 1 && p.getMoedas() >= 100) {
                p.setMoedas(p.getMoedas() - 100);
                p.getHabilidades().add("Nevasca");
                System.out.print("\033[H\033[2J"); //Limpa Tela
                System.out.println("Nevasca adquirida!");
                delay(1500);
            } else if (p.getMoedas() < 100) {
                System.out.print("\033[H\033[2J"); //Limpa Tela
                System.out.println("Saldo insuficiente!");
                delay(1500);
            }
        }
        else if (p instanceof Guerreiro) {
            System.out.print("\033[H\033[2J"); //Limpa Tela
            System.out.println("Deseja comprar 'Frenzy' por 100 moedas? 1 - Sim, 2 - Não");
            int opcao = sc.nextInt();
            sc.nextLine();
            if (opcao == 1 && p.getMoedas() >= 100) {
                p.setMoedas(p.getMoedas() - 100);
                p.getHabilidades().add("Frenzy");
                System.out.print("\033[H\033[2J"); //Limpa Tela
                System.out.println("Frenzy adquirida!");
                delay(1500);
            } else if (p.getMoedas() < 100) {
                System.out.print("\033[H\033[2J"); //Limpa Tela
                System.out.println("Saldo insuficiente!");
                delay(1500);
            }
        }
        else if (p instanceof Arqueiro) {
            System.out.print("\033[H\033[2J"); //Limpa Tela
            System.out.println("Deseja comprar 'Nullshot' por 100 moedas?" + " 1 - Sim, 2 - Nao");
            int opcao = sc.nextInt();
            sc.nextLine();
            if (opcao == 1 && p.getMoedas() >= 100) {
                p.setMoedas(p.getMoedas() - 100);
                p.getHabilidades().add("Nullshot");
                System.out.print("\033[H\033[2J"); //Limpa Tela
                System.out.println("Nullshot adquirida!");
                delay(1500);
            } else if (p.getMoedas() < 100) {
                System.out.print("\033[H\033[2J"); //Limpa Tela
                System.out.println("Saldo insuficiente!");
                delay(1500);
            }
        }
    }

    public void mostrarLoja(Personagem p) {
        boolean naLoja = true;

        while (naLoja) {
            System.out.print("\033[H\033[2J"); //Limpa Tela
            System.out.println("--- LOJA MISTERIOSA ---");
            System.out.println("Saldo: " + p.getMoedas() + " moedas");
            System.out.println("[1] Poção de Vida (10 moedas)");
            System.out.println("[2] Poção de Mana (10 moedas)");
            System.out.println("[3] Habilidade Especial");
            System.out.println("[4] Sair");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    if (estoquePocaoVida == 0) {
                        System.out.println("Item sem estoque! Volte mais tarde!");
                    }
                    if (estoquePocaoVida > 0) {
                        if (p.getMoedas() >= 10) {
                            p.setMoedas(p.getMoedas() - 10);
                            estoquePocaoVida--;
                            System.out.print("\033[H\033[2J"); //Limpa Tela
                            System.out.println("Você comprou uma Poção de Vida!");
                            p.setQntdPocoesVida(p.getQntdPocoesVida() + 1);
                            delay(1500);
                        } else {
                            System.out.print("\033[H\033[2J"); //Limpa Tela
                            System.out.println("Saldo insuficiente!");
                            delay(1500);
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
                            System.out.print("\033[H\033[2J"); //Limpa Tela
                            System.out.println("Você comprou uma Poção de Mana!");
                            p.setQntdPocoesMana(p.getQntdPocoesMana() + 1);
                            delay(1500);
                        } else {
                            System.out.print("\033[H\033[2J"); //Limpa Tela
                            System.out.println("Saldo insuficiente!");
                            delay(1500);
                        }
                    }
                    break;

                case 3:
                    System.out.print("\033[H\033[2J"); //Limpa Tela
                    this.oferecerHabilidadeEspecial(p);
                    break;

                case 4:
                    System.out.print("\033[H\033[2J"); //Limpa Tela
                    System.out.println("Até logo!");
                    delay(1500);
                    naLoja = false;
                    break;
            }
        }
    }

//MÉTODO PARA DAR UM DELAY ANTES DE DAR BREAK NO WHILE
static void delay(int ms) {
    try {
        Thread.sleep(ms);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }

}

}