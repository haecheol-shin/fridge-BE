package exProject.fridge.service;

import exProject.fridge.model.User;
import exProject.fridge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public boolean signup(User user) {
        if(userRepository.findAll().isEmpty()|| userRepository.findByUsername(user.getUsername()) == null) {
            userRepository.save(user); // username 중복 아니면 가입
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true) // SELECT 할 때 트랜잭션 시작, 서비스 종료 시에 트랜잭션 종료 ( 정합성 )
    public User login(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Transactional(readOnly = true)
    public boolean idCheck(User user) {
        if(userRepository.findByUsername(user.getUsername()) != null) return true;
        return false;
    }

}