package pl.jdomanski.util.thymelaf;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DecoupledLogicSetup {
	// == fields == 
	private final SpringResourceTemplateResolver templateResolver;

	// == constructors ==
	@Autowired
	public DecoupledLogicSetup(SpringResourceTemplateResolver templateResolver) {
		this.templateResolver = templateResolver;
	}
	
	// == init ==
	@PostConstruct
	public void init() {
		templateResolver.setUseDecoupledLogic(true);
		log.info("Decoupled template logic enabled");
	}
	
	
}
