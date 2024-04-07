package com.example.CRUDassignment.items;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author shauna
 */
@Service
public class ItemsService {

    @Autowired
    private ItemsRepository repo;
  

    public Items getItemById(long id) {
        return repo.getReferenceById(id);
    }

    public List<Items> getAllItems() {
        List<Items> itemList = repo.findAll();
        return itemList;
    }

    public void deleteItemById(long itemId) {
        repo.deleteById(itemId);
    }

    public void saveItem(Items item) {
        repo.save(item);
    }

}
