package com.rapibanca.tool;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public enum EnumProperties {
	INSTANCE;
	private final java.util.Properties properties;
	
	/**
	 * Metodo constructor para cargar la ruta del properties
	 */
	private EnumProperties(){
		properties = new java.util.Properties();
		try {
			//Reader reader = new InputStreamReader(new FileInputStream("metainfo.properties"), "UTF-8");
                    InputStream inputStream = getClass().getClassLoader().getResourceAsStream("metainfo.properties");
                    Reader reader = new InputStreamReader(inputStream, "UTF-8");
                    
			properties.load(reader);
		} catch (IOException e) {
			//TODO crear la excepcion propia
			System.out.println ("ERROR LECTURA PROPERTIES");
		}
	}
	/**
	 * Metodo para obtener el valor del enum
	 * @param key
	 * @return
	 */
	public String getProperty(String key){
		return 	properties.getProperty(key);
	}
}
