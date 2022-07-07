package com.capgemini.pcshop.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PcPartsRepositoryConfig {

    @Bean
    public PcPartsRepository pcPartsRepository() {
        return new PcPartsRepositoryGeode();
    }
}
