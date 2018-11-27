
import java.io.*;
import javax.swing.*;

public class Principal {

    public static int DA[] = new int[1000];
    public static int Ant[] = new int[1000];
    public static boolean ExpA[] = new boolean[1000];
    public static String nome[] = new String[27];
    public static int N, Origem, Destino, i, j, C, NovaDA, Min;

    public static void nomeiaSecao() {
        nome[0] = "Entrada";
        nome[1] = "Corredor Principal 1,4";
        nome[2] = "Caixa 2 OU Eletrônicos: Televisores";
        nome[3] = "Caixa 1 OU Biscoitos";
        nome[4] = "Corredor 1";
        nome[5] = "Corredor 2";
        nome[6] = "Corredor 2 - Fim";
        nome[7] = "Corredor 3 - Fim";
        nome[8] = "Banheiro Masculino";
        nome[9] = "Hortifruti";
        nome[10] = "Banheiro Feminino";
        nome[11] = "Higiene e limpeza pessoal";
        nome[12] = "Corredor Principal 3,6";
        nome[13] = "Utilidades domesticas";
        nome[14] = "Saída de emergência";
        nome[15] = "Atendimento";
        nome[16] = "Campo e lazer";
        nome[17] = "Corredor 6 - Fim";
        nome[18] = "Corredor 5 - Fim";
        nome[19] = "Corredor 4 - Fim";
        nome[20] = "Caixa 4 - Rápido OU Mercearia Salgados";
        nome[21] = "Caixa 3 - Preferencial OU Enlatados";
        nome[22] = "Corredor Principal 3,4";
        nome[23] = "Perfumaria OU Eletrônicos - Computadores";
        nome[24] = "Higiene e Limpeza do lar OU Massas";
        nome[25] = "Pet-Shop OU Açougue";
        nome[26] = "Padaria OU Mercearia doce";
    }

    public static int calculaMenor(int D[][], int origem, int destino) {
        for (i = 0; i < N; i++) {
            ExpA[i] = false;
            DA[i] = 10000;
        }
        C = origem;
        DA[C] = 0;
        while ((C != destino) && (C != -1)) {
            for (i = 0; i < N; i++) { //Expansao de C    
                if ((D[C][i] != 0) && (!ExpA[i])) {
                    NovaDA = DA[C] + D[C][i];
                    if (NovaDA < DA[i]) {
                        DA[i] = NovaDA;
                        Ant[i] = C;
                    }
                }
            }
            ExpA[C] = true;
            Min = 10000;
            C = -1;
            for (i = 0; i < N; i++) {
                if ((!ExpA[i]) && (DA[i] < Min)) {
                    Min = DA[i];
                    C = i;
                }
            }
        }
        return C;
    }

    public static void mostraMenor(int origem, int destino, int c) {
        if (C == destino) {
            String saida = "### " + nome[origem] + " →→→ " + nome[destino] + " ###\n";
            saida = saida + nome[destino] + "\n";
            while (C != origem) {
                C = Ant[C];
                saida = saida + nome[C] + "\n";
            }
            JOptionPane.showMessageDialog(null, saida);
        } else {
            JOptionPane.showMessageDialog(null, "Nao existe caminho entre as seções");
        }
    }

    public static void mostraDistancia() {
        JOptionPane.showMessageDialog(null, "Distância percorrida: " + Min + " u.m.");
    }

    public static void main(String args[]) {
        
        N = 25;
        Min = 0;
        nomeiaSecao();

        int D[][] =
                //0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
                {{0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 3, 0, 0, 0, 0},
                {0, 4, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 3, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 3, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 3, 0, 0, 0, 0, 0, 0, 4},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 4, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 7, 0, 0, 0, 0, 0},
                {0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0},
                {0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 4, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 7, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 7},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 7, 0}};

        Origem = Integer.parseInt(JOptionPane.showInputDialog("Qual seção que você se localiza?\n"
                + "AÇOUGUE → 25\n"
                + "ATENDIMENTO → 15\n"
                + "BANHEIRO FEMININO → 10\n"
                + "BANHEIRO MASCULINO → 8\n"
                + "BISCOITOS digite → 3\n"
                + "CAMPO E LAZER → 16/n"
                + "CAIXA 1 → 3\n"
                + "CAIXA 2 → 2\n"
                + "CAIXA 3: PREFERENCIAL → 21\n"
                + "CAIXA 4: RÁPIDO → 20\n"
                + "ELETRÔNICOS: COMPUTADORES → 23\n"
                + "ELETRÔNICOS: TELEVISORES → 2\n"
                + "ENLATADOS → 21\n"
                + "ENTRADA → 0\n"
                + "HIGIENE E LIMPEZA DO LAR → 24\n"
                + "HIGIENE E LIMPEZA PESSOAL → 11\n"
                + "HORTIFRUTI → 9\n"
                + "MASSAS → 24\n"
                + "MERCEARIA DOCE → 26\n"
                + "MERCEARIA SALGADA → 20\n"
                + "PADARIA → 26\n"
                + "PERFUMARIA → 23\n"
                + "PET-SHOP → 25\n"
                + "SAÍDA DE EMERGÊNCIA → 14\n"
                + "UTILIDADES DOMESTICAS → 13\n"));
        
        Destino = Integer.parseInt(JOptionPane.showInputDialog("Qual seção você deseja ir mais rápido\n"
                + "AÇOUGUE → 25\n"
                + "ATENDIMENTO → 15\n"
                + "BANHEIRO FEMININO → 10\n"
                + "BANHEIRO MASCULINO → 8\n"
                + "BISCOITOS digite → 3\n"
                + "CAMPO E LAZER → 16/n"
                + "CAIXA 1 → 3\n"
                + "CAIXA 2 → 2\n"
                + "CAIXA 3: PREFERENCIAL → 21\n"
                + "CAIXA 4: RÁPIDO → 20\n"
                + "ELETRÔNICOS: COMPUTADORES → 23\n"
                + "ELETRÔNICOS: TELEVISORES → 2\n"
                + "ENLATADOS → 21\n"
                + "HIGIENE E LIMPEZA DO LAR → 24\n"
                + "HIGIENE E LIMPEZA PESSOAL → 11\n"
                + "HORTIFRUTI → 9\n"
                + "MASSAS → 24\n"
                + "MERCEARIA DOCE → 26\n"
                + "MERCEARIA SALGADA → 20\n"
                + "PADARIA → 26\n"
                + "PERFUMARIA → 23\n"
                + "PET-SHOP → 25\n"
                + "SAÍDA → 0\n"
                + "SAÍDA DE EMERGÊNCIA → 14\n"
                + "UTILIDADES DOMESTICAS → 13\n"));

        calculaMenor(D, Origem, Destino);
        mostraMenor(Origem,Destino,C);
        mostraDistancia();
        
    }
}
