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

/*
*   Classe Responsável por controlar filmes
*/
public class FilmeController extends GerenciadorJson<Filme> {
    private static FilmeController instance;
    
    private FilmeController() {
        super("filmes.json");
    }
    
    /*
        Retorna a única instância de filmes
    */
    public static FilmeController getInstance() {
        if (instance == null) {
            instance = new FilmeController();
        }
        
        return instance;
    }
    /*
        Retorna Filmes de forma iterados
    */
    public Collection<Filme> getFilmes() {
        return jsonTratado.values();
    }
    /*
        Retorna um HashMap de Filmes
    */
    public Map getMapFilmes() {
        return jsonTratado;
    }
    
    /*
        Cria um FILME a partir do JSON
    */
    @Override
    protected Filme carregarObjeto(JSONObject json) {
        return new Filme(json);
    }
    
}
