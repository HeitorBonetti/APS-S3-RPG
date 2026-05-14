import java.util.Scanner;

public class Inventario {

    Scanner scanner = new Scanner(System.in);

    public void checarInventario(Personagem p) {
        System.out.println("Você possui: " + p.getMoedas() + " moedas");
        System.out.println("Você possui: " + p.getQntdPocoesVida() + " poções de vida");
        System.out.println("Você possui: " + p.getQntdPocoesMana() + " poções de mana");
    }

    public void utilizarPocao(Personagem p) {
        System.out.println("Deseja utilizar uma das poções disponíveis em seu inventário?" + " A - Vida, B - Mana, C - Voltar");
        String opcao = scanner.nextLine();
        switch (opcao) {
            case "A":
                if (p.getQntdPocoesVida() > 0) {
                    p.setQntdPocoesVida(p.getQntdPocoesVida() - 1);
                    p.curar(25);
                    System.out.println("Você usou uma poção! " + " +25 HP!");
                } else {
                    System.out.println("Você não tem nenhuma poção de vida!");
                }
                break;

                // PLACEHOLDER pro uso da pocao de mana
//            case "B":
//                if (p.getQntdPocoesMana() > 0) {
//                    p.setQntdPocoesMana(p.getQntdPocoesMana() - 1);
//                    p.recuperarMana(25);
//                    System.out.println("Você usou uma poção! " + " +25 Mana!");
//                } else {
//                    System.out.println("Você não tem nenhuma poção de mana!");
//                }
//                break;

            case "C":
                System.out.println("Continue sua jornada");
                break;
        }
    }
}