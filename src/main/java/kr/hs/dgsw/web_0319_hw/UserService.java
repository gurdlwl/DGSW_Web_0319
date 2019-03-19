package kr.hs.dgsw.web_0319_hw;

import java.util.List;

public interface UserService {
    List<User> list();
    User view(String id);
    boolean add(User user);
    User update(User user);
    boolean delete(String id);
}
