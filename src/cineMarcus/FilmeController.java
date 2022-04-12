/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cineMarcus;

import cineMarcus.json.GerenciadorJson;
import java.util.Collection;
import java.util.Map;
import org.json.JSONObject;

/**
 *
 * @author ruan
 */
public class FilmeController extends GerenciadorJson<Filme> {
    private static FilmeController instance;
    
    private FilmeController() {
        super("filmes.json");
    }
    
    public static FilmeController getInstance() {
        if (instance == null) {
            instance = new FilmeController();
        }
        
        return instance;
    }
    
    public Collection<Filme> getFilmes() {
        return jsonTratado.values();
    }
    
    public Map getMapFilmes() {
        return jsonTratado;
    }
    
    
    @Override
    protected Filme carregarObjeto(JSONObject json) {
        return new Filme(json);
    }
    
}
