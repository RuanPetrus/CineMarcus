/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cineMarcus;

import cineMarcus.json.JsonSerializavel;
import org.json.JSONObject;
import cineMarcus.auxiliar.CompressorImagem;
import java.util.Base64;

/*
    Classe que representa o Filme
*/
public class Filme implements JsonSerializavel{
    
    // 

    private Integer id;
    private String nome;
    private String sinopse;
    private byte[] poster;
    private String genero;
    private Integer classificacao;
    
    public Filme(String nome, String sinopse, byte[] poster, String genero, Integer classificacao) {
        this.nome = nome;
        this.sinopse = sinopse;
        this.setPoster(poster);
        this.genero = genero;
        this.classificacao = classificacao;
    }
    /*
        Cria objeto FILME a partir do JSON
    */
    
    public Filme(JSONObject json) {
        id = json.getInt("id");
        nome = json.getString("nome");
        sinopse = json.getString("sinopse");
        genero = json.getString("genero");
        classificacao = json.getInt("classificacao");
        poster = Base64.getDecoder().decode(json.getString("poster"));
        
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setPoster(byte[] poster) {
        this.poster = CompressorImagem.comprimir(poster, 117, 150);
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setClassificacao(Integer classificacao) {
        this.classificacao = classificacao;
    }

    public String getNome() {
        return nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public byte[] getPoster() {
        return poster;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getClassificacao() {
        return classificacao;
    }
    

    @Override
    public Integer getId() {
        return this.id;    
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    /* 
        Tranforma instância em um JSON
    */      
    @Override
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        
        json.put("id", id);
        json.put("nome", nome);
        json.put("sinopse", sinopse);
        json.put("genero", genero);
        json.put("classificacao", classificacao);
        json.put("poster", new String(Base64.getEncoder().encode(poster)));
        
        return json;

    }
}
