package ru.netology.doalayer.service;

import org.springframework.stereotype.Service;
import ru.netology.doalayer.repository.DataBaseRepository;

import java.util.List;

@Service
public class DataBaseService {

    private final DataBaseRepository dataBaseRepository;

    DataBaseService(DataBaseRepository dataBaseRepository) {
        this.dataBaseRepository = dataBaseRepository;
    }

    public List<String> getProductName(String name) {
        return dataBaseRepository.getProductName(name);
    }
}
