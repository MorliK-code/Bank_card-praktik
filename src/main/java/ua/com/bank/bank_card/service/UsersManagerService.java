package ua.com.bank.bank_card.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.bank.bank_card.entity.Users;
import ua.com.bank.bank_card.repository.ClientRepository;
import ua.com.bank.bank_card.repository.UsersRepository;

@Service
public class UsersManagerService implements UserDetailsService {

    private final UsersRepository usersRepository;
    private final ClientRepository clientRepository;


    @Autowired
    public UsersManagerService(UsersRepository usersRepository, ClientRepository clientRepository) {
        this.usersRepository = usersRepository;
        this.clientRepository = clientRepository;
    }

    public boolean getLogicByUser(String username){
//            boolean logic = false;
//            if(usersRepository.findAllByUsername(username).isEmpty()) logic=true;
        return (!usersRepository.findAllByUsername(username).isEmpty()) ? true : false;
    }

    public Users saveNewUserToDB(Users user){
//        Users users1= usersRepository.save(users);
        return  usersRepository.save(user);
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
