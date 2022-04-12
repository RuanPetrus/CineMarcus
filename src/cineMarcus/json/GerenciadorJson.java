/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cineMarcus.json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public abstract class GerenciadorJson<T extends JsonSerializavel> {
    
    /**
     * Caminho do arquivo json.
     */
    private final String arquivo;
    
    /**
     * Contador de IDs dos objetos.
     */
    private int contadorId = 1;
    
    /**
     * Map onde os objetos são salvos.
     * Os objetos são salvos chaveados por um ID inteiro.
     */
    protected Map<Integer, T> jsonTratado = new HashMap<>();
    
    /**
     * Construtor do gerenciador json
     * @param arquivo caminho para o arquivo json
     */
    public GerenciadorJson(String arquivo) {
        this.arquivo = arquivo;
        carregaJson();
    }
    
    /**
     * Salva os dados do Map no arquivo json.
     */
    public void salvarJson () {
        try (FileWriter escreve = new FileWriter(arquivo)) {
            JSONObject json = new JSONObject();

            json.put("contadorId", contadorId);
            json.put("dados",
                    jsonTratado
                            .entrySet()
                            .parallelStream()
                            .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue().toJSON())));
            
            escreve.write(json.toString(4));
        } catch(IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Carrega os dados do arquivo json para o Map.
     */
    protected final void carregaJson() {
        try {
            BufferedReader br = Files.newBufferedReader(FileSystems.getDefault().getPath(arquivo), StandardCharsets.UTF_8);
            JSONTokener tokener = new JSONTokener(br);
            JSONObject obj = new JSONObject(tokener);
            
            contadorId = obj.optInt("contadorId", 1);
            JSONObject dados = obj.optJSONObject("dados");
            if (dados != null) {
                jsonTratado = dados
                        .keySet()
                        .parallelStream()
                        .collect(Collectors.toMap(key -> Integer.parseInt(key), key -> carregarObjeto(dados.getJSONObject(key))));
            } else {
                jsonTratado = new HashMap<>();
            }
        } catch(FileNotFoundException | JSONException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            salvarJson(); // Salva o JSON vazio
        } catch(IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @return Collection coleção dos objetos armazenados no json
     */
    public Collection<T> valueCollection() {
        return jsonTratado.values();
    }
    
    /**
     * Retorna um objeto do Map de acordo com o id fornecido.
     * @param id id do objeto
     * @return objeto com o id fornecido
     */
    public T get(int id) {
        return jsonTratado.get(id);
    }
    
    /**
     * Adiciona um objeto ao Map de acordo com o id.
     * Se o objeto não tiver um id, define o id de acordo com o contador.
     * @param valor objeto a ser adicionado ao Map
     * @param salvar quando verdadeiro, salva o arquivo json
     * @return objeto adicionado
     */
    public T add(T valor, boolean salvar) {
        if (valor.getId() == null) {
            valor.setId(contadorId);
            contadorId++;
        }
        
        jsonTratado.put(valor.getId(), valor);
        if (salvar) {
            salvarJson();
        }
        
        return valor;
    }
    
    /**
     * Alternativa ao metodo add, com valor salvar padrão como true.
     * @param valor objeto a ser adicionado ao Map
     * @return objeto adicionado
     */
    public T add(T valor) {
        return add(valor, true);
    }
    
    /**
     * Remove um objeto do Map de acordo com o id.
     * @param key id do objeto
     */
    public void remove(int key) {
        jsonTratado.remove(key);
        salvarJson();
    }
    
    /**
     * Remove um objeto do Map.
     * @param valor objeto a ser removido
     */
    public void remove(T valor) {
        remove(valor.getId());
    }
    
    /**
     * Transforma um objeto json na classe gerenciada.
     * @param json objeto json
     * @return instancia da classe gerenciada
     */
    abstract protected T carregarObjeto(JSONObject json);
    
}
