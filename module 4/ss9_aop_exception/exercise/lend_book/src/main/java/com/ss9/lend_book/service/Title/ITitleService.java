package com.ss9.lend_book.service.Title;

import com.ss9.lend_book.model.Title;
import com.ss9.lend_book.service.IGeneralService;

public interface ITitleService extends IGeneralService<Title> {

    void decreaseCount(Integer titleId);
}
