package com.example.core.app11;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// 실무에서 이렇게 젤 많이 쓰나봐여
@Component
@RequiredArgsConstructor
public class Bean1 {
    final Bean2 bean2;

    public void some() {
        bean2.crud();
    }
}
