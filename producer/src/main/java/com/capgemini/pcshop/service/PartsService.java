package com.capgemini.pcshop.service;

import com.capgemini.pcshop.data.Part;

import java.util.Collection;

public interface PartsService {
    Collection<Part> getParts();

    Part getPartById(int id);
}
