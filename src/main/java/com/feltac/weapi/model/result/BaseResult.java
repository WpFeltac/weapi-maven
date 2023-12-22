package com.feltac.weapi.model.result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BaseResult<T> {
    private Boolean success;
    private Optional<T> data;
    private List<String> errors;

    public BaseResult(Optional<T> result) {
        this.success = true;
        this.data = result;
        this.errors = new ArrayList<String>();
    }

    public BaseResult(String... errors){
        this.success = false;
        this.data = Optional.empty();
        this.errors = Arrays.asList(errors);
    }
}
