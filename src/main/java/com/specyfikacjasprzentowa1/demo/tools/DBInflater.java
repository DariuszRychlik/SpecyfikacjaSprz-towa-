package com.specyfikacjasprzentowa1.demo.tools;

import com.specyfikacjasprzentowa1.demo.repositories.ComputerRepository;
import com.specyfikacjasprzentowa1.demo.repositories.MonitorRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DBInflater implements ApplicationListener<ContextRefreshedEvent> {

    public DBInflater(MonitorRepository monitorRepository, ComputerRepository computerRepository) {
        this.monitorRepository = monitorRepository;
        this.computerRepository = computerRepository;

    }
    private MonitorRepository monitorRepository;
    private ComputerRepository computerRepository;



@Override
public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
}

    private void initData() {




    }

}
