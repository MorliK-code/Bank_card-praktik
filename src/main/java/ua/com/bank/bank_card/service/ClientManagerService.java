package ua.com.bank.bank_card.service;

import org.springframework.stereotype.Service;
import ua.com.bank.bank_card.entity.Client;
import ua.com.bank.bank_card.repository.ClientRepository;

@Service
public class ClientManagerService {
    private final ClientRepository clientRepository;

    public ClientManagerService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void saveNewClientToDB(Client client){
        clientRepository.save(client);
    }
}
