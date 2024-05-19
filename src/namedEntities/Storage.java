package namedEntities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Esta clase funciona como un almacenamiento de elementos de tipo
 * <code>T</code> que se pueden acceder a través de una etiqueta.
 * 
 * @param <T> Tipo de los elementos almacenados.
 */
public class Storage<T> {
    protected HashMap<String, T> storage;

    public Storage() {
        this.storage = new HashMap<>();
    }

    /**
     * Agrega un elemento nuevo elemento al almacenamiento.
     * 
     * @param label Etiqueta del elemento.
     * @param value Elemento a almacenar.
     * 
     * @apiNote Si la etiqueta ya existe, el valor se reemplaza en lugar de
     *          agregar un nuevo elemento.
     */
    public void addElement(String label, T value) {
        if (this.storage.containsKey(label)) {
            remplaceValue(label, value);
        } else {
            this.storage.put(label, value);
        }
    }

    /**
     * Verifica si la etiqueta existe en el almacenamiento con un elemento asociado.
     * 
     * @param label Etiqueta a verificar.
     * @return <code>true</code> si la etiqueta ya existe, <code>false</code> en
     *         caso contrario.
     */
    public boolean containsLabel(String label) {
        return this.storage.containsKey(label);
    }

    /**
     * Obtiene todas las etiquetas almacenadas.
     * 
     * @return Conjunto de etiquetas.
     */
    public Set<String> getAllLabels() {
        return this.storage.keySet();
    }

    /**
     * Obtiene el valor asociado a una etiqueta.
     * 
     * @param label
     * @return Valor asociado a la etiqueta.
     * 
     * @apiNote Si la etiqueta no existe, se retorna <code>null</code>.
     */
    public T getValue(String label) {
        return this.storage.get(label);
    }

    /**
     * Obtiene todos los valores almacenados.
     * 
     * @return Lista con todos los valores almacenados.
     * 
     * @apiNote La lista es una copia de los valores almacenados, por lo que
     *          modificarla no afecta al almacenamiento.
     */
    public List<T> getAllValues() {
        return new ArrayList<T>(storage.values());
    }

    /**
     * Reemplaza el valor asociado a una etiqueta.
     * 
     * @param label Etiqueta del valor a reemplazar.
     * @param value Nuevo valor.
     */
    public void remplaceValue(String label, T value) {
        this.storage.replace(label, value);
    }
}
