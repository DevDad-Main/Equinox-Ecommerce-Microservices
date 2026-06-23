package com.devdad.ecommerce.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.devdad.ecommerce.model.Notification;

/**
 * NotificationRepository
 */
public interface NotificationRepository extends MongoRepository<Notification, String> {

	
}
