package org.example.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class MyXMlMessage {
    private Long offerId;
    private String description;
}
