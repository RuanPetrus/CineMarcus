/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cineMarcus;

import org.json.JSONObject;

/**
 *
 * @author ruan
 */
public class Cliente extends Pessoa{

    private float dinheiro;
    final private Integer idade;
    
    public Cliente(float dinheiro, Integer idade, String email, String senha, String nomeDeUsuario) {
        super(email, senha, nomeDeUsuario);
        this.dinheiro = dinheiro;
        this.idade = idade;
    }
    
    public Cliente(JSONObject json) {
        super(json);
        this.dinheiro = (float) json.getFloat("dinheiro");
        this.idade = json.getInt("idade");
    }
    
    public void setDinheiro(float dinheiro) {
        this.dinheiro = dinheiro;
    }
    
    public float getDinheiro() {
        return this.dinheiro;
    }
    
    @Override
    public TipoPessoa getTipo() {
        return TipoPessoa.CLIENTE;
    }
    
    @Override
    public JSONObject toJSON() {
        JSONObject json = super.toJSON();
        json.put("dinheiro", this.dinheiro);
        json.put("idade", this.idade);
        
        return json;
    }
    
}
