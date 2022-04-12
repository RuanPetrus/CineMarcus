/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cineMarcus.json;

import org.json.JSONObject;

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
