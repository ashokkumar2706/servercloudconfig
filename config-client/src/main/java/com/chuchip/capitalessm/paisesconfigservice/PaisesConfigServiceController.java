package com.chuchip.capitalessm.paisesconfigservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chuchip.capitalessm.paisesconfigservice.bean.BeanConfiguration;

@RestController
//@ConfigurationProperties("capitales-datos")

public class PaisesConfigServiceController {
	
	@Value("${valores.valor_fijo}")
	String valorFijo;
	
	@Value("${valores.valor_funcion}") 
	String valorFuncion;
	
	@Autowired
	private Configuration configuration;

	@Autowired
	private ConfigurationData configurationData;

	@GetMapping("/limites")
	public BeanConfiguration getConfiguracion()
	{
		return new BeanConfiguration(configuration.getDato1(),
				configuration.getDato2(),valorFijo,valorFuncion);
	}
	
	
	@GetMapping("/refrescado")
	public BeanConfiguration getConfiguracionRefrescada(@Value("${valores.valor_funcion}") String valorFuncion)
	{
		return new BeanConfiguration(configuration.getDato1(),
				configuration.getDato2(),valorFijo,valorFuncion);
	}
	@GetMapping("/datos")
	public ConfigurationData retrieveDatosFromConfigurations() {
		return configurationData;
	}
	
}