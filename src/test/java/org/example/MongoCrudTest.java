package org.example;

import org.example.bean.ChatMessages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@SpringBootTest
public class MongoCrudTest {
    @Autowired
    private MongoTemplate mongoTemplate;

//    @Test
//    public void testInsert(){
//         mongoTemplate.insert(new ChatMessages(1L,"聊天记录"));
//    }

    @Test
    public void testInsert2(){//增
        ChatMessages chatMessages = new ChatMessages();
        chatMessages.setContent("聊天记录列表");
        mongoTemplate.insert(chatMessages);
    }

    @Test
    public void testFindById(){//查
        ChatMessages chatMessages = mongoTemplate.findById("68d684d61a1aaf0eeaff82a7", ChatMessages.class);
        System.out.println(chatMessages);
    }

    @Test
    public void testUpdate(){//改
        Criteria criteria = Criteria.where("_id").is("68d684d61a1aaf0eeaff82a7");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content","新的聊天记录列表");

        //修改
        mongoTemplate.upsert(query,update,ChatMessages.class);
    }

    @Test
    public void testDelete(){//删
        Criteria criteria = Criteria.where("_id").is("68d684d61a1aaf0eeaff82a7");
        Query query = new Query(criteria);
        mongoTemplate.remove(query,ChatMessages.class);
    }
}
