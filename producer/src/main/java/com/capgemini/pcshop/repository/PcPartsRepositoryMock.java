package com.capgemini.pcshop.repository;

import com.capgemini.pcshop.data.Part;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PcPartsRepositoryMock implements PcPartsRepository {

    List<Part> parts = new ArrayList<Part>() {{
        add(new Part(1, "Laptop", "48239523"));
        add(new Part(2, "Keyboard", "2382234"));
        add(new Part(3, "Mouse", "48239523"));
        add(new Part(4, "Headphones", "2382234"));
        add(new Part(5, "Monitor", "48239523"));
    }};

    @Override
    public List<Part> findAllParts() {
        return parts;
    }

    @Override
    public Part findByPartId(int partId) {
        return parts
                .stream()
                .filter(part -> part.getId() == partId)
                .findAny()
                .orElseThrow(() -> new ResourceNotFoundException("Part not exists, id: " + partId));
    }
}
