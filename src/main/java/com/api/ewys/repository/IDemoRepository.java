package com.api.ewys.repository;

import com.api.ewys.models.DemoModel;
import org.jetbrains.annotations.NotNull;

import java.util.List;


/**
 * Интерфейс IDemoRepository описывает методы работы с БД
 */
public interface IDemoRepository {

    /**
     * Отображает список карточек модели в БД
     */
    List<DemoModel> getDemoInfoList();

    /**
     * Отображает карточку модели в БД по id
     */
    DemoModel getDemoInfoById(long id);

    /**
     * Отдает список карточек модели из БД по списку имен
     */
    List<DemoModel> getDemoInfoListByNames(@NotNull List<String> names);

    /**
     * Сохраняет список карточек модели в БД
     */
    void batchInsert(@NotNull List<DemoModel> demoList);
}
