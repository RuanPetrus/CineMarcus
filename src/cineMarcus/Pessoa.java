/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cineMarcus;

import cineMarcus.json.JsonSerializavel;
import org.json.JSONObject;

/**
 *
 * @author ruan
 */
/*
    Classe responsável por representar uma pessoa 
*/
public class Pessoa implements JsonSerializavel {    

    private Integer id;
    private String email; 
    private String senha;
    private String nomeDeUsuario;
    
    public Pessoa(String email, String senha, String nomeDeUsuario ) {
        this.email = email;
        this.senha = senha;
        this.nomeDeUsuario = nomeDeUsuario;
    }
    /*
        Cria PESSOA a partir de JSON
    */
    public Pessoa(JSONObject json) {
        id = json.getInt("id");
        nomeDeUsuario = json.getString("nomeDeUsuario");
        email = json.getString("email");
        senha = json.getString("senha");
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getSenha(){
        return senha;
    }

    public String getNomeDeUsuario() {
        return nomeDeUsuario;
    }
    
    public TipoPessoa getTipo() {
        return TipoPessoa.INDEFINIDO;
    }
    
    public void setUsuario(String user) {
        this.nomeDeUsuario=user;
    }
    
    public void setEmail(String email) {
        this.email=email;
    }
    
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    /*
        Gera objeto tipo JSON
    */
    @Override
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("nomeDeUsuario", nomeDeUsuario);
        json.put("email", email);
        json.put("senha", senha);
        json.put("tipo", getTipo());
        
        return json;

    }
}
