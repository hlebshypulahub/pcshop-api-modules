package com.capgemini.pcshop.service;

import com.capgemini.pcshop.data.Part;

import java.util.Collection;
import java.util.List;

public interface PartsService {
    Collection<Part> getParts();

    Part getPartById(int id);

    List<Part> save(List<Part> parts);
}
