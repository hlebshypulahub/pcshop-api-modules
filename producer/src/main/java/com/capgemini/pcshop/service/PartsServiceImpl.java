package com.capgemini.pcshop.service;

import com.capgemini.pcshop.data.Part;
import com.capgemini.pcshop.repository.PcPartsRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class PartsServiceImpl implements PartsService {

    final PcPartsRepository pcPartsRepository;

    public PartsServiceImpl(PcPartsRepository pcPartsRepository) {
        this.pcPartsRepository = pcPartsRepository;
    }

    @Override
    public Collection<Part> getParts() {
        return pcPartsRepository.findAllParts();
    }

    @Override
    public Part getPartById(int id) {
        return pcPartsRepository.findByPartId(id);
    }
}
