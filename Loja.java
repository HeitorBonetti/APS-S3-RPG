import java.util.Scanner;

public class Loja {
    private int estoqueItem;

    public Loja(int estoqueItem) {
        this.estoqueItem = 1;
    }

    public int getEstoqueItem() {
        return estoqueItem;
    }

    public void setEstoqueItem(int estoqueItem) {
        this.estoqueItem = estoqueItem;
    }

    public void mostrarLoja(Personagem p) {
        Scanner scanner = new Scanner(System.in);
        boolean naLoja = true;

        while (naLoja) {
            System.out.println("--- LOJA MISTERIOSA ---");
            System.out.println("Saldo: " + p.getMoedas() + " moedas");
            System.out.println("[1] Katana (10 moedas)");
            System.out.println("[2] Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (estoqueItem > 0) {
                        if (p.getMoedas() >= 10) {
                            p.setMoedas(p.getMoedas() - 10);
                            estoqueItem--;
                            System.out.println("Você comprou uma Katana!");
                        } else {
                            System.out.println("Saldo insuficiente!");
                        }
                    }
                    break;

                case 2:
                    System.out.println("Até logo!");
                    naLoja = false;
                    break;
            }
        }
    }
}