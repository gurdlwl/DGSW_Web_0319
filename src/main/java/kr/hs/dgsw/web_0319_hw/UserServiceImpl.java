package kr.hs.dgsw.web_0319_hw;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<User> userList;

    public UserServiceImpl(){
        this.userList = new ArrayList<>();
        this.userList.add(new User("user", "user1@dgsw.hs.kr", "u1"));
        this.userList.add(new User("user", "user2@dgsw.hs.kr", "u2"));
        this.userList.add(new User("user", "user3@dgsw.hs.kr", "u3"));
    }

    @Override
    public List<User> list(){
        return this.userList;
    }

    @Override
    public User view(String id) {
        for(int i=0; i< this.userList.size(); i++){
            User found = this.userList.get(i);
            if(found.getId().equals(id))
                return found;
        }
        return null;
    }

    public User find1(String name){
        Iterator<User> iterator=this.userList.iterator();
        while(iterator.hasNext()){
            User found = iterator.next();
            if(found.getName().equals(name))
                return found;
        }
        return null;
    }

    //Java 5+
    public User find2(String name){
        for(User found : this.userList) {
            if(found.getName().equals(name))
                return found;
        }
        return null;
    }
    //사용자가 많으면 너무 느려짐.

    //Java 8+
    //때문에 새로 고안해낸 방법, 써도 문제는 없지만 권장하지는 않는다.
    //findFirst : 순서가 중요한 경우에 사용. findAny보다 조금 느림.
    public User find3(String name){
        User found = this.userList.stream()
                .filter(user -> user.getName().equals(name))
                .findAny()
                .orElse(null);
        return found;
    }

    @Override
    public boolean add(User user){
        User check = this.view(user.getId());
        if(check == null){
            return this.userList.add(user);
        }
        return false;
    }

    @Override
    public User update(User user){
        User found = this.view(user.getId());
        if(found != null) {
            found.setEmail(user.getEmail());
            found.setName(user.getName());
        }
        return found;
    }

    @Override
    public boolean delete(String id){
        User found = this.view(id);
        return this.userList.remove(found);
    }
}
