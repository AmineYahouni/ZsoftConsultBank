package com.example.ksoft.client.service;

import com.example.ksoft.client.model.Client;
import org.springframework.stereotype.Service;


public interface ClientService {

    /**
     * create the client for every single call.
     *
     * @return the new client .
     */
    Client createClient();

    /**
     * Update and save the client passed in param.
     *
     * @param client the client to merge or save.
     * @return the existing client , if no change, or the updated client.
     */
    Client save(Client client);

    /**
     * Get the client for the given id.
     * If the client does not exist, throw exception.
     *
     * @param id the id of client to find the information for.
     * @return the existing client , if found.
     */
    Client findById(Long id);
}
