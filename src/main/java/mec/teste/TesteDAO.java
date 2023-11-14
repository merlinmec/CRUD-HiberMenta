package mec.teste;

import mec.dao.ContatoDAO;
import mec.model.Contato;
import mec.util.HibernateUtil;

import java.util.List;
import java.util.Scanner;

public class TesteDAO {

    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();

        ContatoDAO contatoDAO = new ContatoDAO(HibernateUtil.getSessionFactory());

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Insira os dados do contato a ser criado:");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();

            Contato contato = new Contato();
            contato.setNome(nome);
            contato.setEmail(email);
            contato.setTelefone(telefone);

            contatoDAO.createContato(contato);
            System.out.println("Contato criado!");

            List<Contato> contatos = contatoDAO.listContatos();
            System.out.println("Lista de contatos:");
            for (Contato c : contatos) {
                System.out.println(c);
            }

            System.out.println("Insira o ID para ser excluído:");
            int contatoId = scanner.nextInt();

            contatoDAO.deleteContato(contatoId);
            System.out.println("Contato deletado!");
        } finally {
            scanner.close();
        }

        HibernateUtil.closeSessionFactory();
    }
}