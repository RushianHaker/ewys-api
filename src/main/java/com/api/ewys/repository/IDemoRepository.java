package com.api.ewys.repository;

import com.api.ewys.models.DemoModel;
import org.jetbrains.annotations.NotNull;

import java.util.List;


/**
 * Интерфейс IDemoRepository описывает методы работы с БД
 */
public interface IDemoRepository {

    /**
     * Отдает список карточек модели из БД
     */
    List<DemoModel> batchSelect(@NotNull List<String> names);


    /**
     * Сохраняет список карточек модели в БД
     */
    void batchInsert(@NotNull List<DemoModel> demoList);

}
