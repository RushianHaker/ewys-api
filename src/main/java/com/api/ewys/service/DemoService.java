package com.api.ewys.service;

import com.api.ewys.models.DemoModel;
import com.api.ewys.repository.IDemoRepository;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс DemoService - общий метод для работы с контроллерами
 */

@AllArgsConstructor
@Service
public class DemoService {
    protected final IDemoRepository demoRepository;

    /**
     * Отдает список карточек модели из БД
     */
    @NotNull
    public List<DemoModel> allDemoInfoListByNames(@NotNull List<String> names) {
        if(names.isEmpty()) return new ArrayList<>();
        return demoRepository.batchSelect(names);
    }

    /**
     * Сохраняет список карточек модели в БД
     */
    public void saveDemoInfoList(@NotNull List<DemoModel> demoList) {
        if(demoList.isEmpty()) return;

        demoRepository.batchInsert(demoList);
    }
}