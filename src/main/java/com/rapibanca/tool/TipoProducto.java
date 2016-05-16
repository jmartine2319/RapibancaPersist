/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rapibanca.tool;

/**
 *Clase Enum para la identificacion de los productos
 * @author jmartine2319
 */
public enum TipoProducto {
    CUENTA_AHORROS(1),TARJETA_CREDITO(2);
    
    private int idProducto;

    private TipoProducto(int idProducto){
        this.idProducto=idProducto;
    }
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    
}
