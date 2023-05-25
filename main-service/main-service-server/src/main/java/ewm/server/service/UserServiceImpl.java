package ewm.server.service;

import ewm.server.model.User;
import ewm.server.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Transactional
    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getUsers(Long[] ids, Integer from, Integer size) {
        Pageable request = PageRequest.of(from > 0 ? from / size : 0, size);
        return ids == null ? getAllUsers(request) : getUsersByIds(ids, request);
    }

    @Transactional
    @Override
    public void deleteUserById(Long userId) {
        userRepo.deleteById(userId);
    }

    private List<User> getUsersByIds(Long[] ids, Pageable request) {
        return userRepo.findAllByIdIn(ids, request).getContent();
    }

    private List<User> getAllUsers(Pageable request) {
        return userRepo.findAll(request).getContent();
    }
}
