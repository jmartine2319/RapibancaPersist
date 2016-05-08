/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rapibanca.test;

import com.rapibanca.dao.ClienteRapibancaDAO;
import com.rapibanca.dao.ProductosRapibancaDAO;
import com.rapibanca.entities.ClienteRapibanca;
import com.rapibanca.entities.ProductosRapibanca;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author MariaCamila
 */
public class TestPersist {
    
    public static void main(String arg[])
    {
        ClienteRapibanca clienteRapibanca = new ClienteRapibanca();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        
         ProductosRapibanca productoRapibanca = new ProductosRapibanca();
        
        try{
            
          ProductosRapibancaDAO productosRapibancaDAO = new ProductosRapibancaDAO();
          
        clienteRapibanca.setDireccionResidencia("Carrera 58 No. 152-70");
        clienteRapibanca.setEmail("kmicuellar10@gmail.com");
        java.util.Date fechaVinculacion = format.parse("2016/05/07");
        java.sql.Date sqlfechaVinculacion = new java.sql.Date(fechaVinculacion.getTime());
        clienteRapibanca.setFechaVinculacion(sqlfechaVinculacion);
        clienteRapibanca.setIdUsuario("kmicuellar10");
        clienteRapibanca.setNombreCliente("Doña Camila");
        clienteRapibanca.setNumeroDocumento(new BigDecimal(3456));
        clienteRapibanca.setPassword("julio");
        clienteRapibanca.setTelefono(BigInteger.valueOf(12345));
        clienteRapibanca.setTipoDocumento(BigInteger.valueOf(1));
          
          productoRapibanca.setDescripcionProducto("Cuenta de ahorros");
          Date fechaCancelacion = format.parse("2016/05/07");
          productoRapibanca.setFechaCancelacion(fechaCancelacion);
          Date fechaCreacion = format.parse("2016/05/07");
          productoRapibanca.setFechaCreacion(fechaCreacion);
          productoRapibanca.setIdProducto(new BigDecimal(456));
          productoRapibanca.setNumDocumentoClienteFk(clienteRapibanca);
          short penaliza = 1;
          productoRapibanca.setPenalizacion(penaliza);
          productoRapibanca.setSaldoProducto(BigInteger.valueOf(200000));
          productosRapibancaDAO.persist(productoRapibanca);
          
          //productoRapibanca.setIdPromocionFk(clienteRapibanca.getNumeroDocumento());
        /*clienteRapibanca.setDireccionResidencia("Carrera 58 No. 152-70");
                       clienteRapibanca.setEmail("kmicuellar10@gmail.com");
                       java.util.Date fechaVinculacion = format.parse("2016/05/07");
                       java.sql.Date sqlfechaVinculacion = new java.sql.Date(fechaVinculacion.getTime());
                       clienteRapibanca.setFechaVinculacion(sqlfechaVinculacion);
                       clienteRapibanca.setIdUsuario("kmicuellar10");
                       clienteRapibanca.setNombreCliente("Doña Camila");
                       clienteRapibanca.setNumeroDocumento(new BigDecimal(3456));
                       clienteRapibanca.setPassword("julio");
                       clienteRapibanca.setTelefono(BigInteger.valueOf(12345));
                       clienteRapibanca.setTipoDocumento(BigInteger.valueOf(1));
        
        ClienteRapibancaDAO clienteRapibancaDAO = new ClienteRapibancaDAO();
        clienteRapibancaDAO.persist(clienteRapibanca);*/
        
        
    }
        catch(Exception e){
            e.printStackTrace();
        }
}

}