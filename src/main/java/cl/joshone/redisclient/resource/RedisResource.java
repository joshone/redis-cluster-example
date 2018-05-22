package cl.joshone.redisclient.resource;

import cl.joshone.redisclient.model.Person;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/rest/hello")
@RestController
public class RedisResource {

    @Autowired
    private RedissonClient redissonClient;
    

    @GetMapping("/add")
    public String hello() {

    	RMapCache<String, Object> map = redissonClient.getMapCache("test");
        map.put(UUID.randomUUID().toString().toUpperCase(), new Person("jose", "28", ""));
        map.put(UUID.randomUUID().toString().toUpperCase(), new Person("carmen", "31", ""));
        map.put(UUID.randomUUID().toString().toUpperCase(), new Person("ana", "40", ""));

        return "Hello Youtube";
    }


    @RequestMapping(value="/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<RMapCache <String, Object >> all() {

    	RMapCache<String, Object> map = redissonClient.getMapCache("test");
        return new ResponseEntity<RMapCache <String, Object >>(map, HttpStatus.OK);
    }
}

