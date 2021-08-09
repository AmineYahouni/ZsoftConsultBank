package com.example.ksoft.client.service;

import com.example.ksoft.client.model.Client;
import org.springframework.stereotype.Service;


public interface ClientService {

    Client createClient();

    Client save(Client client);

    Client findById(Long id);
}
