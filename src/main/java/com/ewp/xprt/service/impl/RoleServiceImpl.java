package com.ewp.xprt.service.impl;

import com.ewp.xprt.model.Role;
import com.ewp.xprt.repository.interfaces.RoleRepository;
import com.ewp.xprt.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role get(Long id) {
        return roleRepository.getOne(id);
    }

    @Override
    public Role add(Role entity) {
        System.out.println("i'm here RoleServiceImpl method add");
        return roleRepository.saveAndFlush(entity);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public void update(Role entity) {
        roleRepository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public void delete(Role entity) {
        roleRepository.delete(entity);
    }
}
