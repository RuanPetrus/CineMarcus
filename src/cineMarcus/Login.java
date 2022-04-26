/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cineMarcus;

import cineMarcus.json.GerenciadorJson;
import cineMarcus.exceptions.InvalidPasswordException;
import cineMarcus.exceptions.InvalidUserException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;

/*
    Classe responsável por controlar pessoas
*/
public class Login extends GerenciadorJson<Pessoa> {
   
    private static Login instance;
    
    private Pessoa usuarioLogado;
    
    public Login() {
        super("logins.json");
    }
    /*
        Retorna a única instância
    */
    public static Login getInstance() {
        if (instance == null) {
            instance = new Login();
        }
        return instance;
    }
    /*
        Verifica se existe a conta com o nome
    */
    public boolean existeContaNome(String nomeInserido) {
        return valueCollection().stream().anyMatch(u -> u.getNomeDeUsuario().equals(nomeInserido));
    }
    /*
        Verifica se existe a conta com o email
    */
    public boolean existeContaEmail(String emailInserido) {
        return valueCollection().stream().anyMatch(u -> u.getEmail().equals(emailInserido));
    }
    
    /*
        Verifica se o login existe
    */
    public void validaLogin(String nomeOuEmailInserido, String senhaInserida) throws InvalidUserException, InvalidPasswordException {
        Optional<Pessoa> optionalUsuario = valueCollection().stream().filter(u -> u.getNomeDeUsuario().equals(nomeOuEmailInserido)).findFirst();
        
        if (optionalUsuario.isEmpty()) {
            optionalUsuario = valueCollection().stream().filter(u -> u.getEmail().equals(nomeOuEmailInserido)).findFirst();
            if (optionalUsuario.isEmpty()) {
                throw new InvalidUserException("Esse usuário não existe");
            }
        }
        Pessoa usuario = optionalUsuario.get();
        if (usuario.getSenha().equals(senhaInserida)) {
            this.setUsuarioLogado(usuario);
        } else {
            throw new InvalidPasswordException("Senha incorreta");
          }
    }
    
   
    public void setUsuarioLogado(Pessoa logado) {
        this.usuarioLogado = logado;
    }
   
    public Pessoa getUsuarioLogado() {
        return usuarioLogado;
    }
    
    /*
        Cria PESSOA a partir de JSON
    */
    @Override
    protected Pessoa carregarObjeto(JSONObject json) {
        TipoPessoa tipo = json.getEnum(TipoPessoa.class, "tipo");
        switch (tipo) {
            case CLIENTE -> {
                return new Cliente(json);
            }
            case ADMIN -> {
                return new Admin(json);
            }
            default -> Logger.getLogger(Login.class.getName()).log(Level.WARNING, "Tipo de usuario invalido");
        }
        return new Pessoa(json);
    }
}
