package de.virtuos.empresa.security;

import de.virtuos.empresa.entity.EmpresaUser;
import de.virtuos.empresa.repository.EmpresaUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmpresaUserDetailsService implements UserDetailsService {

    @Resource
    private EmpresaUserRepository empresaUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        EmpresaUser empresaUser = empresaUserRepository.findByUsername(username);
        if (empresaUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return toUserDetails(empresaUser);
    }

    private UserDetails toUserDetails(EmpresaUser empresaUser) {
        return User.withUsername(empresaUser.getUsername())
                .password(empresaUser.getPassword())
                .roles(empresaUser.convertRolesToArray()).build();
    }

}
