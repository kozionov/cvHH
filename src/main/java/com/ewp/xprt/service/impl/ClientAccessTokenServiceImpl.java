package com.ewp.xprt.service.impl;

import com.ewp.xprt.model.ClientAccessToken;
import com.ewp.xprt.repository.interfaces.ClientAccessTokenRepository;
import com.ewp.xprt.service.interfaces.ClientAccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientAccessTokenServiceImpl implements ClientAccessTokenService {
    private ClientAccessTokenRepository clientAccessTokenRepository;

    @Autowired
    public ClientAccessTokenServiceImpl(ClientAccessTokenRepository clientAccessTokenRepository) {
        this.clientAccessTokenRepository = clientAccessTokenRepository;
    }

    @Override
    public ClientAccessToken get(Long id) {
        return clientAccessTokenRepository.getOne(id);
    }

    @Override
    public ClientAccessToken add(ClientAccessToken entity) {
        return clientAccessTokenRepository.saveAndFlush(entity);
    }

    @Override
    public List<ClientAccessToken> getAll() {
        return clientAccessTokenRepository.findAll();
    }

    @Override
    public void update(ClientAccessToken entity) {
        clientAccessTokenRepository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        clientAccessTokenRepository.deleteById(id);
    }

    @Override
    public void delete(ClientAccessToken entity) {
        clientAccessTokenRepository.delete(entity);
    }
}
