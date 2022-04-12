/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cineMarcus;

import cineMarcus.json.GerenciadorJson;
import java.util.Collection;
import java.util.Map;
import org.json.JSONObject;

public class SessaoController extends GerenciadorJson<Sessao> {
    private static SessaoController instance;
    
    private SessaoController() {
        super("sessoes.json");
    }
    
    public static SessaoController getInstance() {
        if (instance == null) {
            instance = new SessaoController();
        }
        
        return instance;
    }
    
    public Collection<Sessao> getSessoes() {
        return jsonTratado.values();
    }
    
    public Map getMapSessoes() {
        return jsonTratado;
    }
    
    
    @Override
    protected Sessao carregarObjeto(JSONObject json) {
        return new Sessao(json);
    }
    
}