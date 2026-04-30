import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    static Personagem p = null;
    static Personagem inimigo = null;
    
public static void main(String[] args) {
        Principal();
}
    
//MENU PRINCIPAL DO JOGO
static void Principal() {
    while (true) {
        System.out.print("\033[H\033[2J"); //Limpa Tela
        System.out.println("Selecione sua Ação!"); 
        System.out.println("[1] Criar Personagem"); 
        System.out.println("[2] Ver Ficha");
        System.out.println("[3] Jogar");
        System.out.println("[4] Sair do Jogo");  
        int opcao = sc.nextInt();
        sc.nextLine();

        switch(opcao) {
            case 1:
                Adicionar();
                break;

            case 2:
                Exibir();
                break;

            case 3:
            if (p == null) {
                System.out.print("\033[H\033[2J");
                System.out.println("Você precisa criar um personagem primeiro!");
                delay(1500);
                break;
            }
            Jogar();
            break;

            case 4:
                if (Sair()) {
                 return;   
                }
                break;

            default:
                System.out.println("Ação Inválida");
                delay(1500);
                break;
        }
    }
}

//MENU PARA ESCOLHER A CLASSE DO PERSONAGEM
static void Adicionar() {
    if (p != null) {
        while (true) {
            if (p == null) return;
            System.out.print("\033[H\033[2J"); //Limpa Tela
            System.out.println("Já existe um personagem criado!");
            System.out.println("[1] Verificar Ficha");
            System.out.println("[2] Excluir");
            System.out.println("[3] Voltar");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao) {
                case 1:
                    System.out.print("\033[H\033[2J"); //Limpa Tela
                    p.exibirFicha();
                    System.out.println("Pressione ENTER para voltar:");
                    sc.nextLine();
                    break;
                
                case 2:
                    ExcluirPersonagem();
                    break;
                    
                case 3:
                    return;

                default:
                System.out.print("\033[H\033[2J"); //Limpa Tela
                System.out.println("Opção inválida!");
                delay(1500);
                break;
            }
        } 
    }
    
    if (p == null) {
        System.out.print("\033[H\033[2J"); //Limpa Tela
        System.out.println("Escolha sua classe! "); 
        System.out.println("[1] Guerreiro"); 
        System.out.println("[2] Mago");
        System.out.println("[3] Arqueiro");
        System.out.println("[4] Voltar");
        int opcao = sc.nextInt();
        sc.nextLine();
    
        String classe = null;
    
        switch (opcao) {
            case 1:
                classe = "Guerreiro";
                break;
    
            case 2:
                classe = "Mago";
                break;
    
            case 3:
                classe = "Arqueiro";
                break;
    
            case 4:
                return;
    
            default:
                System.out.print("\033[H\033[2J"); //Limpa Tela
                System.out.println("Opção inválida!");
                delay(1500);
                return;
        }
        escolhaPersonagem(classe);
    }

}

//MENU QUE CRIA O OBJETO PERSONAGEM
static void escolhaPersonagem(String classe) {
    System.out.print("\033[H\033[2J");
    System.out.println("Você escolheu " + classe);
    System.out.println("[A] Pré Definido");
    System.out.println("[B] Customizável");
    String opcao = sc.nextLine();
    switch(opcao) {
        case "A":
            System.out.print("\033[H\033[2J"); //Limpa Tela
            System.out.println("Digite o nome do seu " + classe + ": ");
            String nome = sc.nextLine();

        switch (classe) {
            case "Guerreiro":
                p = new Guerreiro(nome);
                break;

            case "Mago":
                p = new Mago(nome);
                break;

            case "Arqueiro":
                p = new Arqueiro(nome);
                break;
        }
            
            System.out.print("\033[H\033[2J"); //Limpa Tela
            System.out.println("Personagem criado com sucesso!");
            delay(1500);
            break;

        case "B":
            Custom(classe);
            break;
    }
}

//MENU PARA CUSTOMIZAR UM PERSONAGEM
static void Custom(String classe) {
    int vida;
    int ataque;
    int defesa;
    
    System.out.print("\033[H\033[2J"); //Limpa Tela
    System.out.print("Digite o nome: ");
    String nome = sc.nextLine();

    while (true) {
        System.out.print("\033[H\033[2J"); //Limpa Tela
        System.out.print("Digite a vida: ");
        vida = sc.nextInt();
        if (vida > 0) {
            break;
        } else {
            System.out.println("A vida não pode ser 0 ou negativa.");
            delay(1500);
            continue;
        }  
    }
    
    while (true) {
        System.out.print("\033[H\033[2J"); //Limpa Tela
        System.out.print("Digite o ataque: ");
        ataque = sc.nextInt();
        if (ataque > 0) {
            break;
        } else {
            System.out.println("O ataque não pode ser 0 ou negativo.");
            delay(1500);
            continue;
        } 
    }

    while (true) {
        System.out.print("\033[H\033[2J"); //Limpa Tela
        System.out.print("Digite a defesa: ");
        defesa = sc.nextInt();
        if (defesa >= 0) {
            break;
        } else {
            System.out.println("A defesa não pode ser negativa.");
            delay(1500);
            continue;
        }   
    }
    sc.nextLine();
    
    switch (classe) {
        case "Guerreiro":
            p = new Guerreiro(nome, vida, ataque, defesa);
            break;

        case "Mago":
            p = new Mago(nome, vida, ataque, defesa);
            break;

        case "Arqueiro":
            p = new Arqueiro(nome, vida, ataque, defesa);
            break;
    }
    
    System.out.print("\033[H\033[2J"); //Limpa Tela
    System.out.println("Personagem criado com sucesso!");
    delay(1500);
}
    
//MENU PARA EXIBIR A FICHA DO PERSONAGEM
static void Exibir() {
    System.out.print("\033[H\033[2J"); //Limpa Tela
    if (p == null) {
        System.out.println("Nenhum personagem foi criado ainda.");
        System.out.println("");
    } else {
        System.out.print("\033[H\033[2J"); //Limpa Tela
        p.exibirFicha();
    }
    System.out.println("Pressione ENTER para voltar:");
    sc.nextLine();
}

//MENU PARA ESCOLHER COM QUAL DAS CLASSES IRÁ JOGAR
static void Jogar() {
    while (true) {
        System.out.print("\033[H\033[2J"); //Limpa Tela
        if (p == null) {
            System.out.println("Voltando ao menu...");
            delay(1500);
            break;
        }
        else {
            System.out.print("\033[H\033[2J"); //Limpa Tela
            System.out.println("Escolha com qual das classes você irá jogar: ");
            if (p != null) p.exibirFicha();

            System.out.println(""); 
            System.out.println("[1] Guerreiro"); 
            System.out.println("[2] Mago");
            System.out.println("[3] Arqueiro");
            System.out.println("[4] Voltar");
            int opcao = sc.nextInt();
            sc.nextLine();

        switch(opcao) {
            case 1:
                if (!(p instanceof Guerreiro)) {
                    System.out.print("\033[H\033[2J"); //Limpa Tela
                    System.out.println("Você não tem um Guerreiro!");
                    delay(1500);
                    break;
                } else {
                    menuPersonagem();
                }
                break;
                
            case 2:
                if (!(p instanceof Mago)) {
                    System.out.print("\033[H\033[2J"); //Limpa Tela
                    System.out.println("Você não tem um Mago!");
                    delay(1500);
                    break;
                } else {
                    menuPersonagem();
                }
                break;
                
            case 3:
                if (!(p instanceof Arqueiro)) {
                    System.out.print("\033[H\033[2J"); //Limpa Tela
                    System.out.println("Você não tem um Arqueiro!");
                    delay(1500);
                    break;
                } else {
                    menuPersonagem();
                }
                break;
                
            case 4:
                return;

            default:
                System.out.print("\033[H\033[2J"); //Limpa Tela
                System.out.println("Opção inválida!");
                delay(1500);
                break;
        }
        } 
    }
}

//MENU PARA ESCOLHER A AÇÃO DO PERSONAGEM
static void menuPersonagem() {
    while (true) {
        if (p == null) return;

        System.out.print("\033[H\033[2J");
        System.out.println("Você escolheu " + p.getClass().getSimpleName());
        System.out.println("[A] Andar");
        System.out.println("[B] ...");
        System.out.println("[C] Voltar");
        String opcao = sc.nextLine();
        switch(opcao) {
            case "A":
                int sorte = random.nextInt(2);

                if (sorte == 1) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Você está a caminho do reino!");
                    delay(1500);
                    continue;
                } else {
                    combate();
                }
                break;

            case "B":
                return;

            case "C":
                return;
        }
    }
}
    
//COMBATE COM INIMIGOS
static void combate() {
    int escolhaInimigo = random.nextInt(3);
    if (escolhaInimigo == 1) {
    inimigo = new Personagem("Goblin", 60, 15, 5);
    } else if (escolhaInimigo == 2) {
        inimigo = new Personagem("Mímico", 80, 30, 7);
    } else
        inimigo = new Personagem("Esqueleto", 30, 20, 3);

    while (true) {
        System.out.print("\033[H\033[2J"); //Limpa Tela
        System.out.println("Você encontrou um " + inimigo.getNome() + "!");
        System.out.println("");
        System.out.println("O que deseja fazer?");
        System.out.println("[1] Atacar"); 
        System.out.println("[2] Esquivar");
        int opcao_escolha = sc.nextInt();
        sc.nextLine();
            
        int escolha;
        switch(opcao_escolha) {
            case 1:
                escolha = random.nextInt(2);
                    if (escolha == 1) {
                        System.out.print("\033[H\033[2J"); //Limpa Tela
                        p.atacar(inimigo);
                        sc.nextLine();
                        if (inimigo.getPontosDeVida() <= 0) {
                            System.out.print("\033[H\033[2J");
                            System.out.println(inimigo.getNome() + " derrotado!");
                            inimigo = null;
                            delay(1500);
                            return;
                        } else {
                            continue;
                        } 

                    } else {
                        int dano = inimigo.getAtaque();
                        System.out.print("\033[H\033[2J");
                        System.out.println("Você errou o ataque!");
                        System.out.println("");
                        p.receberDano(dano);
                        sc.nextLine();
                        if (p.getPontosDeVida() <= 0) {
                            System.out.print("\033[H\033[2J");
                            System.out.println("Você perdeu!");
                            p = null;
                            delay(1500);
                            return;   
                        }
                        continue;
                    }
                
            case 2:
                escolha = random.nextInt(2);
                    if (escolha == 1) {
                        System.out.print("\033[H\033[2J");
                        System.out.println("Ataque esquivado com sucesso!");
                        sc.nextLine();
                        continue;
                    } else {
                        int dano = inimigo.getAtaque();
                        System.out.print("\033[H\033[2J");
                        System.out.println("Falha na esquiva!");
                        System.out.println("");
                        p.receberDano(dano);
                        sc.nextLine();
                        if (p.getPontosDeVida() <= 0) {
                            System.out.print("\033[H\033[2J");
                            System.out.println("Você perdeu!");
                            p = null;
                            delay(1500);
                            return;
                        }
                        continue;
                    }
        }
    }
}

                
//MENU PARA SAIR DO JOGO
static boolean Sair() {
    while (true) {
        System.out.print("\033[H\033[2J"); //Limpa Tela
        System.out.println("Tem certeza que deseja sair do jogo?");
        System.out.println("[1] Sim"); 
        System.out.println("[2] Não");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch(opcao) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                System.out.print("\033[H\033[2J"); //Limpa Tela
                System.out.println("Opção inválida!");
                delay(1500);
                break;
        }
    }
}

//MENU PARA EXCLUIR PERSONAGEM
static void ExcluirPersonagem() {
    while (true) {
        System.out.print("\033[H\033[2J"); //Limpa Tela
        System.out.println("Tem certeza que deseja excluir seu personagem?");
        System.out.println("[1] Sim"); 
        System.out.println("[2] Não");
        int opcao = sc.nextInt();
        sc.nextLine();
    
        switch(opcao) {
            case 1:
                p = null;
                System.out.print("\033[H\033[2J"); //Limpa Tela
                System.out.println("Excluindo...");
                delay(1500);
                System.out.println("Personagem Excluido com sucesso!");
                delay(1500);
                return;
            case 2:
                return;
            default:
                System.out.print("\033[H\033[2J"); //Limpa Tela
                System.out.println("Opção inválida!");
                delay(1500);
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