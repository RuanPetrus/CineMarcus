/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cineMarcus;

import cineMarcus.exceptions.InvalidPasswordException;
import cineMarcus.exceptions.InvalidUserException;

/**
 *
 * @author ruan
 */
public class TesteCore {
    private static Login login;
    private static FilmeController filmeController;
    private static SessaoController sessaoController;
    
    public static void main (String[] argv) {
        login = Login.getInstance();
        
        //createUser();
        createFilme();
        String nome1 = "Ruan Petrus";
        String nome2 = "Joao Carlos";
        String senha1 = "1234";
        String senha2 = "12312312";
        
        try{
            login.validaLogin(nome1, senha1);
            System.out.println("Usuario Logado");
            System.out.println(login.getUsuarioLogado().getEmail());

        } catch (InvalidUserException | InvalidPasswordException ex) {
            System.out.println("Ivalid Login");
        }
        
        filmeController = FilmeController.getInstance();
        sessaoController = SessaoController.getInstance();
        
        
        
    }
    
    public static void showUsers() {
        
    }
    
    public static void createFilme() {
        String nome = "007";
        String sinopse = "James Bond muito Pica";
        String genero = "Acao";
        Integer classificacao = 16;
        byte[] poster = "imagem".getBytes();
        
        Filme filme = new Filme(nome, sinopse, poster, genero,classificacao);
        
        filmeController.add(filme);
        
    }
    
    public static void createUser() {
        float dinheiro = 10;
        int idade = 10;
        String email = "xastroboyx11@gmail.com";
        String senha = "1234";
        String nomeDeUsuario = "Ruan Petrus";
        Pessoa novoUsuario = new Cliente(dinheiro, idade, email, senha, nomeDeUsuario);
        login.add(novoUsuario);
        
        System.out.println("Usuario criado com sucesso");
    }
}
