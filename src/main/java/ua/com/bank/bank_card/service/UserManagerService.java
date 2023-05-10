package ua.com.bank.bank_card.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.bank.bank_card.entity.Users;
import ua.com.bank.bank_card.repository.UsersRepository;

@Service
public class UserManagerService implements UserDetailsService {

    private final UsersRepository usersRepository;


    @Autowired
    public UserManagerService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user1 = usersRepository.findByUsername(username);

        System.out.println(user1);

        if(user1==null){
            throw new UsernameNotFoundException("User not found!!!");
        }

        return user1;
    }
}
