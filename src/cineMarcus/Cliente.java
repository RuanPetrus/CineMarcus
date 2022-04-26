/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cineMarcus;

import org.json.JSONObject;

/**
 *
 * @author ruan, bruno, ana
 */

/*
    Classe que herda de pessoa, mas que difere da classe ADMIN
*/
public class Cliente extends Pessoa{
    
    

    private float dinheiro;
    private Integer idade;
    
    
    public Cliente(float dinheiro, Integer idade, String email, String senha, String nomeDeUsuario) {
        super(email, senha, nomeDeUsuario);
        this.dinheiro = dinheiro;
        this.idade = idade;
    }
    /*
        Cria objeto CLIENTE a partir do JSON
    */
    public Cliente(JSONObject json) {
        super(json);
        this.dinheiro = (float) json.getFloat("dinheiro");
        this.idade = json.getInt("idade");
    }
    
    public void setDinheiro(float dinheiro) {
        this.dinheiro = dinheiro;
    }
    
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    
    public float getDinheiro() {
        return this.dinheiro;
    }
    
    public int getIdade() {
        return this.idade;
    }
    
    @Override
    public TipoPessoa getTipo() {
        return TipoPessoa.CLIENTE;
    }
    /* 
        Tranforma instância em um JSON
    */
    @Override
    public JSONObject toJSON() {
        JSONObject json = super.toJSON();
        json.put("dinheiro", this.dinheiro);
        json.put("idade", this.idade);
        
        return json;
    }
    
}
