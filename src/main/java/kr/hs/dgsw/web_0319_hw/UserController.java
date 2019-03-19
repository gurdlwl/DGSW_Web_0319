package kr.hs.dgsw.web_0319_hw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    @ResponseBody //무조건 Json으로 변환해서 return. 안넣어도 지장은 없음.
    public List<User> list(){
        return this.userService.list();
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User view(
            @PathVariable String id
    ){
        return this.userService.view(id);
    }

    @PostMapping("/user")
    @ResponseBody
    public boolean add(@RequestBody User user){
        return this.userService.add(user);
    }

    @PutMapping("/user")
    @ResponseBody
    public User update(@RequestBody User user){
        return this.userService.update(user);
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public boolean delete(@RequestBody @PathVariable String id){
        return this.userService.delete(id);
    }
}

// CRUD Create Read   Update Delete
// SQL  Insert Select Update Delete
// HTTP POST   GET    PUT    DELETE
