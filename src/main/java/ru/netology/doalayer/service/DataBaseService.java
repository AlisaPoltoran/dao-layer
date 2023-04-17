package ru.netology.doalayer.service;

import org.springframework.stereotype.Service;
import ru.netology.doalayer.repository.DataBaseRepository;

@Service
public class DataBaseService {

    private final DataBaseRepository dataBaseRepository;

    DataBaseService (DataBaseRepository dataBaseRepository) {
        this.dataBaseRepository = dataBaseRepository;
    }

    public String getProductName(String name) {
        return dataBaseRepository.getProductName(name);
    }
}
