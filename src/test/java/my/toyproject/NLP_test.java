package my.toyproject;


import my.toyproject.service.NlpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NLP_test {

    @Autowired
    NlpService nlpService;

    @Test
    public void test() throws IOException {
        nlpService.process();

    }
}
