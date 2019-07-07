/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.controller;

import edu.umss.storeservice.dto.ItemInstanceDto;
import edu.umss.storeservice.model.ItemInstance;
import edu.umss.storeservice.service.GenericService;
import edu.umss.storeservice.service.ItemInstanceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/iteminstances")
public class ItemInstanceController extends GenericController<ItemInstance, ItemInstanceDto> {

    private List<ItemInstanceDto> newList = new ArrayList<>();
    private ItemInstanceService service;

    public ItemInstanceController(ItemInstanceService service) {
        this.service = service;
    }

    @Override
    protected GenericService getService() {
        return service;
    }

    @Override
    protected List<ItemInstanceDto> getAll(String featured) {
        this.newList.clear();
        List<ItemInstanceDto> list = super.getAll(featured);
        for (ItemInstanceDto temp : list) {
            if (temp.getFeatured().equals(Boolean.parseBoolean(featured))) {
                this.newList.add(temp);
            }
        }
        return this.newList;
    }

    @Override
    protected ItemInstanceDto save(ItemInstanceDto element) {
        if (element.getFeatured()) {
            List<ItemInstanceDto> items = getAll("true");
            for (ItemInstanceDto temp : items) {
                if (temp.getFeatured().equals(Boolean.parseBoolean("true"))) {
                    System.out.print("there is already an item featured");
                }
            }
        }
        return super.save(element);
    }
}