package de.virtuos.empresa.security;

import de.virtuos.empresa.model.db.EmpresaUser;
import de.virtuos.empresa.repository.EmpresaUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private EmpresaUserRepository empresaUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        EmpresaUser empresaUser = empresaUserRepository.findByUsername(username);
        if (empresaUser == null) throw new UsernameNotFoundException(username);
        return UserDetailsImpl.build(empresaUser);
    }

}
