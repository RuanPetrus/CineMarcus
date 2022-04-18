/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cineMarcus;

import org.json.JSONObject;


public class Admin extends Pessoa{

   

    final private String nomeCompleto;
    final private String cpf;
    
    public Admin(String nomeCompleto, String cpf, String email, String senha, String nomeDeUsuario) {
        super(email, senha, nomeDeUsuario);
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
    }

    public Admin(JSONObject json) {
        super(json);
        nomeCompleto = json.getString("nomeCompleto");
        cpf = json.getString("cpf");
    }
    
     public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }
    
    @Override
    public TipoPessoa getTipo(){
        return TipoPessoa.ADMIN;
    }
    
    @Override
    public JSONObject toJSON() {
        JSONObject json = super.toJSON();
        json.put("cpf", this.cpf);
        json.put("nomeCompleto", this.nomeCompleto);
        
        return json;
    }
}
