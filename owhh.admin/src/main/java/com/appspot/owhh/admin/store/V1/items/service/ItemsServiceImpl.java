package com.appspot.owhh.admin.store.V1.items.service;

import com.appspot.owhh.admin.files.V1.files.service.FilesService;
import com.appspot.owhh.admin.store.V1.items.domain.Items;
import com.appspot.owhh.admin.store.V1.items.domain.ItemsList;
import com.appspot.owhh.admin.store.V1.items.repository.ItemsRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemsServiceImpl implements ItemsService {

    @NonNull
    private final ItemsRepository itemsRepository;

    @NonNull
    private final FilesService filesService;

    @Override
    public Items save(Items item) {
        return itemsRepository.save(item);
    }

    @Override
    public ItemsList get() {
        return new ItemsList(itemsRepository.findAll());
    }

    @Override
    public Optional<Items> findById(String id) {
        return itemsRepository.findById(id);
    }

    @Override
    public ItemsList findByGroupId(String groupId) {
        return new ItemsList(itemsRepository.findByGroupId(groupId));
    }

    @Override
    public void delete(String id) {
        itemsRepository.deleteById(id);
        filesService.deleteByDomainId(id);
    }
}
