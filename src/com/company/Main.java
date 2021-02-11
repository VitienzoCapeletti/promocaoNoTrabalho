package com.company;


import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        ArrayList<Funcionario> arrayList = new ArrayList<>();

        System.out.print("Quantos funcionários você gostaria de registrar? ");
        int numFuncionarios = sc.nextInt();
        System.out.println();


        for (int i = 0; i < numFuncionarios; i++) {
            System.out.println("FUNCIONÁRIO #" + (i + 1) + ":");
            System.out.print("Loggin: ");
            int id = sc.nextInt();
            System.out.print("Nome: ");
            String nome = sc.next();
            System.out.print("Salário: ");
            Double salario = sc.nextDouble();

            Funcionario funcionario = new Funcionario(id, nome, salario);

            arrayList.add(funcionario);

        }

        System.out.println();
        System.out.print("Digite o loggin do funcionário que receberá ajuste salarial: ");
        int aumentoId = sc.nextInt();
        Integer pos = posicao(arrayList, aumentoId);
        if (pos == null) {
            System.out.println("Este ID não existe! ");

        } else {
            System.out.println("Qual a porcentagem: ");
            double porcentagem = sc.nextDouble();
            arrayList.get(pos).ajusteSalario(porcentagem);
        }

        System.out.println();
        System.out.println("Lista de funcionários: ");
        for (Funcionario funcionario : arrayList) {
            System.out.println(funcionario);
        }


    }

    public static Integer posicao(ArrayList<Funcionario> arrayList, int id) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getId() == id) {
                return i;
            }

        }
        return null;
    }
}
