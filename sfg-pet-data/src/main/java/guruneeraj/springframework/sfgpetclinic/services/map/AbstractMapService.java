package guruneeraj.springframework.sfgpetclinic.services.map;

import guruneeraj.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long,T> map = new HashMap<>();

    Set<T> findAll(){
       return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T entry){
        if(null != entry ){
          if(entry.getId()==null){
              entry.setId(getNextId());
          }
            map.put(entry.getId(), entry);
        } else {
            throw new RuntimeException("Object can't be null");
        }
        return entry;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T obj){
        map.entrySet().removeIf(entry -> entry.getValue().equals(obj));
    }

    private Long getNextId(){
        Long id = 1L;
       if(!map.keySet().isEmpty())
           id = Collections.max(map.keySet()) + 2;
       return id;
    }
}

