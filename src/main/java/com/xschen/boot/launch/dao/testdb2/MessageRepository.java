package com.xschen.boot.launch.dao.testdb2;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xschen
 */


public interface MessageRepository extends JpaRepository<Message, Long> {
}
