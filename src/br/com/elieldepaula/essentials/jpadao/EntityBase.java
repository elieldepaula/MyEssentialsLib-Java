
package br.com.elieldepaula.essentials.jpadao;

import java.io.Serializable;

/**
 * Esta interface assegura que as entidades tenham o método getId().
 * 
 * @author Eliel de Paula <dev@elieldepaula.com.br>
 * @since 0.0.1 22/08/2016
 * @version 0.0.1
 */
public interface EntityBase {
    public Serializable getId();
}
