package com.RestaurantTable.Repository;

import com.RestaurantTable.entity.RestaurantTable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable ,Long> {

   // Sort sort = Sort.by(Sort.Direction.ASC,"Id");
    List<RestaurantTable> findByStatus(String status , Sort sort);
}
