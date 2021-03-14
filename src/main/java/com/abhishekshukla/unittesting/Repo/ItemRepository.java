package com.abhishekshukla.unittesting.Repo;

import com.abhishekshukla.unittesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item , Integer> {
}
