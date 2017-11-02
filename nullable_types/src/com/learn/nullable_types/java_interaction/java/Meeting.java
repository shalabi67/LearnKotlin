package com.learn.nullable_types.java_interaction.java;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Meeting {
    private String title;

    @Nullable
    public String getTitle() {
        return title;
    }
    public String getTitleCanBeNull() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }
    public void setTitleCanBeNull(String title) {
        this.title = title;
    }
}
