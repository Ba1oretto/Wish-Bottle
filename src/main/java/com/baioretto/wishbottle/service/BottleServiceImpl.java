package com.baioretto.wishbottle.service;

import com.baioretto.wishbottle.bean.PriorityBottle;
import com.baioretto.wishbottle.bean.R;
import com.baioretto.wishbottle.mapper.BottleMapper;
import org.springframework.stereotype.Service;

import java.util.Random;

import static com.baioretto.wishbottle.Container.BOTTLE_LIST;

@Service
public class BottleServiceImpl implements BottleService {
    private final BottleMapper bottleMapper;
    private int visitCount = 0;

    public BottleServiceImpl(BottleMapper bottleMapper) {
        this.bottleMapper = bottleMapper;
    }

    @Override
    public R getRandomlyBottle() {
        if (bottleMapper.count() == 0) return R.ok();
        else if (BOTTLE_LIST.isEmpty()) reload();
        return R.ok(BOTTLE_LIST.get(new Random().nextInt(BOTTLE_LIST.size())).getBottle());
    }

    @Override
    public R getRandomlyBottle$private() {
        int postCount = bottleMapper.count();
        if (postCount == 0) return R.ok();
        else if (BOTTLE_LIST.isEmpty()) reload();

        PriorityBottle container = BOTTLE_LIST.get(new Random().nextInt(BOTTLE_LIST.size()));

        if (System.currentTimeMillis() - container.getLastVisit() >= 3600000L) {
            container.setLastVisit(System.currentTimeMillis());
        } else if (visitCount++ < postCount) getRandomlyBottle$private();
        else return R.ok();

        return R.ok(container.getBottle());
    }

    @Override
    public R reload() {
        BOTTLE_LIST.clear();
        handleListUpdate();
        return R.ok();
    }

    public void handleListUpdate() {
        if (bottleMapper.count() == 0) return;
        bottleMapper.getAll().forEach(bottle -> BOTTLE_LIST.add(PriorityBottle.create(bottle)));
    }
}
