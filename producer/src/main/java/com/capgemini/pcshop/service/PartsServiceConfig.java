package com.capgemini.pcshop.service;

import com.capgemini.pcshop.repository.PcPartsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PartsServiceConfig {

    final PcPartsRepository pcPartsRepository;

    public PartsServiceConfig(PcPartsRepository pcPartsRepository) {
        this.pcPartsRepository = pcPartsRepository;
    }

    @Bean
    public PartsService partsService() {
        return new PartsServiceImpl(pcPartsRepository);
    }

}
