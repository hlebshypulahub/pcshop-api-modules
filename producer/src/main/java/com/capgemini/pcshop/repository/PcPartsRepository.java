package com.capgemini.pcshop.repository;

import com.capgemini.pcshop.data.Part;

import java.util.List;

/*TODO: add implementation by mocking some elements. Generated or few manually created*/
public interface PcPartsRepository {

    List<Part> findAllParts();

    Part findByPartId(int partId);

    List<Part> save(List<Part> parts);
}
