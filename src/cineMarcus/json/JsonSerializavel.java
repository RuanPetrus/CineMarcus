/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

    /*
    * Classe baseada no trabalho de Ana Sofia Schweizer Silvestre, Davi Jesus de Almeida Paturi, Victor Hugo França Lisboa
    */

package cineMarcus.json;

import org.json.JSONObject;
/*
    Classe responsável por objetos JSON
*/
public interface JsonSerializavel {
    
    /**
     * @return id desse objeto 
     */
    public Integer getId();
    
    /**
     * Define o id desse objeto.
     * @param id novo id do objeto
     */
    public void setId(Integer id);
    
    /**
     * Transforma esse objeto em um objeto json.
     * @return objeto json que representa esse objeto
     */
    public JSONObject toJSON();
    
}
