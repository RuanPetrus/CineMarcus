/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cineMarcus;

import cineMarcus.json.GerenciadorJson;
import java.util.Collection;
import java.util.Map;
import org.json.JSONObject;
/*
    Classe responsável por controlar Sessão
*/
public class SessaoController extends GerenciadorJson<Sessao> {
    private static SessaoController instance;
    
    private SessaoController() {
        super("sessoes.json");
    }
    /*
        Retorna a única instância
    */
    public static SessaoController getInstance() {
        if (instance == null) {
            instance = new SessaoController();
        }
        
        return instance;
    }
    /*
        Gera uma lista de Sessões a partir de JSON
    */
    public Collection<Sessao> getSessoes() {
        return jsonTratado.values();
    }
    /*
        Gera um HashMap de Sessoes a partir de JSON
    */
    public Map getMapSessoes() {
        return jsonTratado;
    }
    
    /*
        Cria nova SESSAO a partir de json
    */
    @Override
    protected Sessao carregarObjeto(JSONObject json) {
        return new Sessao(json);
    }
    
}